package org.nov0.persistance.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used for determine ID in table. Filed annotated with this annotation will be:
 * <br>
 * * Primary key, <br>
 * * Auto incremented and <br>
 * * Not Null
 * 
 * @author Novislav Sekulic
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Id {

}
