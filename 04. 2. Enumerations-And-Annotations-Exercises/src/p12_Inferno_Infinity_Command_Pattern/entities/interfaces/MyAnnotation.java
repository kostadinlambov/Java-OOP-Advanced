package p12_Inferno_Infinity_Command_Pattern.entities.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String author() default "Pesho";

    String revision() default "3";

    String description() default "Used for Java OOP Advanced course - Enumerations and Annotations.";

    String[] reviewers() default {"Pesho", "Pesho"};
}
