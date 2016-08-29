package org.nov0.persistance.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation is to determine size of primitive type variable that is
 * represented in table. If Bean's field is not annotated with this annotation,
 * than default values are applied to columns.
 * 
 * @author Novislav Sekulic
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Size {

	public int value();

}
