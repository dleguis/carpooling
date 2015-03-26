package edu.fst.m2.ipii.carpooling.transverse.constraints.impl;

import edu.fst.m2.ipii.carpooling.transverse.constraints.FieldMatch;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Dimitri on 29/11/14.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    /**
     * The first field name.
     */
    private String firstFieldName;

    /** The second field name. */
    private String secondFieldName;

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
     * Annotation)
     */
    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
	firstFieldName = constraintAnnotation.first();
	secondFieldName = constraintAnnotation.second();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
     * javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
	try {
	    final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
	    final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

	    return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
	} catch (final Exception ignore) {
	    // ignore
	}
	return true;
    }
}
