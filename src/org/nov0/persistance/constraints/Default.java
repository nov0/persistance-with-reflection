package org.nov0.persistance.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation is used for setting default column value. You must provide
 * String value to this annotation.<p>@Default("45") will be 45 default value
 * for number type or "45" for string or char type.</p>
 * 
 * @author Novislav Sekulic
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Default {

	public String value();

}
