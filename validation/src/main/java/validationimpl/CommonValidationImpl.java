package validationimpl;

import common.AmountValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommonValidationImpl implements ConstraintValidator<AmountValidation, Double> {
    @Override
    public boolean isValid(Double s, ConstraintValidatorContext constraintValidatorContext) {
        String text = Double.toString(Math.abs(s));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;
        return decimalPlaces == 2;
    }
}
