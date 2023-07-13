package com.bestcodingstager.slang.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.validation.Constraint;

@Constraint(validatedBy = WordIdValidator.class) 
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented  
public @interface WordId {
	String message() default "{WordId.NewWord.wordId}";  
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};  
}
