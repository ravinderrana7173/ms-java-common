package com.common.rest.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.api.common.exception.RequestValidationException;
import com.cloud.api.common.util.ValidatorUtil;
import com.cloud.api.common.util.ValidatorUtils;
import com.common.rest.util.MessageUtil;

/**
 * The Class CommonValidator.
 */
@Component
public class BaseValidator {

    /** The message util. */
    @Autowired
    protected MessageUtil messageUtil;

    /**
     * Validate attribute is mandatory.
     *
     * @param fieldName the field name
     * @param fieldValue the field value
     */
    public void validateAttributeIsMandatory(Object fieldName, Object fieldValue) {
        if (ValidatorUtils.isNullOrEmpty(fieldValue)) {
            throw new RequestValidationException(
                    messageUtil.getAttributeNotNull((String) fieldName));
        }

    }

    /**
     * Validate name format.
     *
     * @param fieldName the field name
     * @param name the name
     */
    protected void validateNameFormat(String fieldName, String name) {
        if (!validateName(name)) {
            throw new RequestValidationException(messageUtil.getAttributeInvalid(fieldName, name));
        }
    }

    /**
     * Validate code format.
     *
     * @param fieldName the field name
     * @param name the name
     */
    protected void validateCodeFormat(String fieldName, String name) {
        if (!validateCode(name)) {
            throw new RequestValidationException(messageUtil.getAttributeInvalid(fieldName, name));
        }
    }


    /**
     * Validate attribute is uuid.
     *
     * @param fieldName the field name
     * @param uuId the uu id
     */
    protected void validateAttributeIsUuid(String fieldName, String uuId) {
        if (!ValidatorUtils.isValidUuid(uuId)) {
            throw new RequestValidationException(messageUtil.getAttributeInvalid(fieldName, uuId));
        }
    }

    /**
     * Validate contact no format.
     *
     * @param fieldName the field name
     * @param contactNo the contact no
     */
    protected void validateContactNoFormat(String fieldName, String contactNo) {
        if (!ValidatorUtil.isValidContactNo(contactNo)) {
            throw new RequestValidationException(
                    messageUtil.getAttributeInvalid(fieldName, contactNo));
        }
    }

    /**
     * Validate zip code format.
     *
     * @param fieldName the field name
     * @param zipCode the zip code
     */
    protected void validateZipCodeFormat(String fieldName, String zipCode) {
        if (!ValidatorUtil.isValidZipCodeFormat(zipCode)) {
            throw new RequestValidationException(
                    messageUtil.getAttributeInvalid(fieldName, zipCode));
        }
    }

    /**
     * Validate email format.
     *
     * @param fieldName the field name
     * @param email the email
     */
    protected void validateEmailFormat(String fieldName, String email) {
        if (!ValidatorUtil.validateEmail(email)) {
            throw new RequestValidationException(messageUtil.getAttributeInvalid(fieldName, email));
        }
    }

    /**
     * Validate illegal chars.
     *
     * @param fieldName the field name
     * @param fieldVal the field val
     */
    protected void validateIllegalChars(String fieldName, String fieldVal) {
        if (ValidatorUtil.validateStringContainsIllegalsChars(fieldVal)) {
            throw new RequestValidationException(
                    messageUtil.getAttributeInvalid(fieldName, fieldVal));
        }
    }

    /**
     * Validate name.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean validateName(final String name) {
        String namePattern = "^[-a-zA-Z0-9_ ]+";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name.trim());
        return matcher.matches();
    }

    /**
     * Validate code.
     *
     * @param name the name
     * @return true, if successful
     */
    private boolean validateCode(final String name) {
        String namePattern = "^[-a-zA-Z0-9_]+";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name.trim());
        return matcher.matches();
    }

    /**
     * Checks if is empty or whitespace or null.
     *
     * @param obj the obj
     * @return true, if is empty or whitespace or null
     */
    public static boolean isEmptyOrWhitespaceOrNull(String obj) {

        return ((obj != null && obj.trim().isEmpty()) || obj == null);
    }

    /**
     * Validate numeric value.
     *
     * @param value the value
     * @return true, if successful
     */
    public static boolean validateNumericValue(final String value) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Validate alphabets.
     *
     * @param value the value
     * @return true, if successful
     */
    public static boolean validateAlphabets(final String value) {
        Pattern pattern = Pattern.compile("^[-a-zA-Z ]+");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Validate name.
     *
     * @param name the name
     * @param length the length
     * @return true, if successful
     */
    public boolean validateName(String name, String length) {
        return name.matches("[A-Za-z0-9\\-\\_\\/\\s]{1," + length + "}");
    }

    /**
     * Validate description.
     *
     * @param name the name
     * @param length the length
     * @return true, if successful
     */
    public boolean validateDescription(String name, String length) {
        return name.matches("[^<>]{1," + length + "}");
    }

}
