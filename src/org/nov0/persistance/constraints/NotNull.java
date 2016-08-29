package org.nov0.persistance.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Setting values to not be null.
 * 
 * @author Novislav Sekulic
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface NotNull {

}
