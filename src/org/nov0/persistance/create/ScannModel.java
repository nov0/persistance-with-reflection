package org.nov0.persistance.create;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.nov0.persistance.constraints.Default;
import org.nov0.persistance.constraints.Id;
import org.nov0.persistance.constraints.NotNull;
import org.nov0.persistance.constraints.Size;
import org.nov0.persistance.constraints.Unique;

/**
 * @author Novislav Sekulic
 *
 */
public class ScannModel {

	/**
	 * Method for determine query for creating table on given object.
	 * 
	 * @param model
	 * @return
	 */
	public static String getModelQuery(Class<?> modelClass) {

		String tableName = getTableName(modelClass);
		String fields = getColumns(modelClass);

		return tableName + fields;
	}

	/**
	 * Method for getting fields name and types for creating table query.
	 * 
	 * @param model
	 * @return
	 */
	private static String getColumns(Class<?> model) {

		String fieldsName = "(\n";
		String fieldType = "";

		Field[] fields = model.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			String currentField = "";

			currentField += fields[i].getName() + " ";

			fieldType = getType(fields[i]);

			currentField += fieldType;

			Annotation[] annotations = fields[i].getDeclaredAnnotations();

			if (annotations.length > 0) {
				for (Annotation annotation : annotations) {
					currentField = getConstraints(annotation, fieldType, currentField);
				}
			}

			if (i == fields.length - 1) {
				fieldsName += currentField + " \n";
			} else {
				fieldsName += currentField + ",\n";
			}
		}

		return fieldsName + ");";

	}

	/**
	 * Method for getting name of a class. The name of the class will be name of
	 * the table.
	 * 
	 * @param model
	 * @return simple name of given class
	 */
	private static String getTableName(Class<?> model) {
		String tableName = model.getSimpleName().toLowerCase();

		// checking if last letter is s, if it is then add "es" to name of table
		// if not than add "s"
		if (tableName.substring(tableName.length() - 1).equals("s")) {
			tableName += "es";
		} else {
			tableName += "s";
		}

		return "CREATE TABLE " + tableName;
	}

	/**
	 * Trying to determine types of columns. Not all types are implemented, only some
	 * primitive types. Default field of String is VARCHAR(255) and for char is
	 * CHAR(1). Default value can be overridden by annotation @Size(value).
	 * 
	 * @param field
	 * @return type of field
	 */
	private static String getType(Field field) {

		String fieldType = "";

		Class<?> type = field.getType();

		if (type == int.class || type == short.class || type == byte.class || type == long.class) {
			fieldType = "INT";
		} else if (type == double.class || type == float.class) {
			fieldType = "DOUBLE";
		} else if (type == char.class) {
			fieldType = "CHAR(1)";
		} else if (type == String.class) {
			fieldType = "VARCHAR(255)";
		}

		return fieldType;
	}

	/**
	 * Getting constraints from annotated fields.
	 * 
	 * @param annotation
	 * @param fieldType
	 * @param currentField
	 * @return
	 */
	private static String getConstraints(Annotation annotation, String fieldType, String currentField) {
		String constraints = "";

		if (annotation instanceof Size) {
			Size annotationSize = (Size) annotation;
			if (fieldType.equals("INT")) {
				currentField = currentField.replace("INT", "INT(" + annotationSize.value() + ")");
			} else if (fieldType.equals("DOUBLE")) {
				currentField = currentField.replace("DOUBE", "DOUBLE(" + annotationSize.value() + ")");
			} else if (fieldType.equals("VARCHAR(255)")) {
				currentField = currentField.replace("VARCHAR(255)", "VARCHAR(" + annotationSize.value() + ")");
			} else if (fieldType.equals("CHAR(1)")) {
				currentField = currentField.replace("CHAR(1)", "CHAR(" + annotationSize.value() + ")");
			}
		} else if (annotation instanceof Id) {
			constraints = " NOT NULL AUTO_INCREMENT PRIMARY KEY";
		} else if (annotation instanceof NotNull) {
			constraints = " NOT NULL";
		} else if (annotation instanceof Unique) {
			constraints = " UNIQUE";
		} else if (annotation instanceof Default) {
			Default annotationDefault = (Default) annotation;
			constraints = " DEFAULT ";
			constraints += fieldType.equals("INT") || fieldType.equals("DOUBLE") ? annotationDefault.value()
					: "'" + annotationDefault.value() + "'";
		}

		return currentField + constraints;
	}

}
