package common;

import validationimpl.CommonValidationImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CommonValidationImpl.class)
public @interface AmountValidation {
    String message() default "Invalid Amount";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
