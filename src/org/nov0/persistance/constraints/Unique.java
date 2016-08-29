package org.nov0.persistance.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used for setting unique value of column in database.
 * <h1>Use:</h1><p>@Unique<br>private int jmbg;
 * </p>
 * 
 * @author Novislav Sekulic
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Unique {

}
