package com.common.rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.cloud.p7.auth.properties.AuthProperties;


/**
 * The Class MessageUtil.
 */
@Component
@PropertySource(value="classpath:message.properties",ignoreResourceNotFound=true)
public class MessageUtil {

    /** The auth properties. */
    @Autowired
    private AuthProperties authProperties;

    /** The attribute unique. */
    @Value("${attribute.unique.message}")
    private String attributeUnique;

    /** The attribute unique code. */
    @Value("${attribute.unique.code}")
    private String attributeUniqueCode;

    /** The attribute invalid. */
    @Value("${attribute.invalid.message}")
    private String attributeInvalid;

    /** The attribute invalid code. */
    @Value("${attribute.invalid.code}")
    private String attributeInvalidCode;

    /** The attribute not null. */
    @Value("${attribute.not.null.message}")
    private String attributeNotNull;

    /** The attribute not null code. */
    @Value("${attribute.not.null.code}")
    private String attributeNotNullCode;

    /** The attribute already used. */
    @Value("${attribute.already.used.message}")
    private String attributeAlreadyUsed;

    /** The attribute already used code. */
    @Value("${attribute.already.used.code}")
    private String attributeAlreadyUsedCode;

    /** The attribute already exist. */
    @Value("${attribute.already.used.message}")
    private String attributeAlreadyExist;

    /** The system not found message. */
    @Value("${attribute.system.not.found.message}")
    private String systemNotFoundMessage;

    /** The system capability not found message. */
    @Value("${attribute.system.capability.not.found.message}")
    private String systemCapabilityNotFoundMessage;


    /** The system name not valid message. */
    @Value("${attribute.name.invalid.message}")
    private String systemNameNotValidMessage;

    /** The system description not valid message. */
    @Value("${attribute.description.invalid.message}")
    private String systemDescriptionNotValidMessage;


    /**
     * Gets the system name not valid message.
     *
     * @param attribute the attribute
     * @param specialCharacter the special character
     * @param length the length
     * @return the system name not valid message
     */
    public String getSystemNameNotValidMessage(String attribute, String specialCharacter,
            String length) {
        return systemNameNotValidMessage.replace("{{ATTRIBUTE}}", attribute)
                .replace("{{VALUE1}}", specialCharacter).replace("{{VALUE2}}", length);
    }

    /**
     * Gets the system description not valid message.
     *
     * @param attribute the attribute
     * @param specialCharacter the special character
     * @param length the length
     * @return the system description not valid message
     */
    public String getSystemDescriptionNotValidMessage(String attribute, String specialCharacter,
            String length) {
        return systemDescriptionNotValidMessage.replace("{{ATTRIBUTE}}", attribute)
                .replace("{{VALUE1}}", specialCharacter).replace("{{VALUE2}}", length);
    }

    /**
     * Gets the system capability not found message.
     *
     * @param value the value
     * @return the system capability not found message
     */
    public String getSystemCapabilityNotFoundMessage(String value) {
        return systemCapabilityNotFoundMessage.replace("{{ATTRIBUTE}}", value);
    }

    /**
     * Gets the system not found message.
     *
     * @param value the value
     * @return the system not found message
     */
    public String getSystemNotFoundMessage(String value) {
        return systemNotFoundMessage.replace("{{ATTRIBUTE}}", value);
    }

    /**
     * Gets the attribute unique.
     *
     * @param attribute the attribute
     * @return the attribute unique
     */
    public String getAttributeUnique(String attribute) {
        return attributeUnique.replace("{{ATTRIBUTE}}", attribute);
    }

    /**
     * Gets the attribute unique code.
     *
     * @return the attribute unique code
     */
    public Integer getAttributeUniqueCode() {
        return Integer.parseInt(authProperties.errorCodePrefix + attributeUniqueCode);
    }

    /**
     * Gets the attribute invalid.
     *
     * @param attribute the attribute
     * @param value the value
     * @return the attribute invalid
     */
    public String getAttributeInvalid(String attribute, String value) {
        return attributeInvalid.replace("{{ATTRIBUTE}}", attribute).replace("{{VALUE}}", value);
    }

    /**
     * Gets the attribute invalid code.
     *
     * @return the attribute invalid code
     */
    public Integer getAttributeInvalidCode() {
        return Integer.parseInt(authProperties.errorCodePrefix + attributeInvalidCode);
    }

    /**
     * Gets the attribute not null.
     *
     * @param attribute the attribute
     * @return the attribute not null
     */
    public String getAttributeNotNull(String attribute) {
        return attributeNotNull.replace("{{ATTRIBUTE}}", attribute);
    }

    /**
     * Gets the attribute not null code.
     *
     * @return the attribute not null code
     */
    public Integer getAttributeNotNullCode() {
        return Integer.parseInt(authProperties.errorCodePrefix + attributeNotNullCode);
    }

    /**
     * Gets the attribute already used.
     *
     * @param attribute the attribute
     * @param value the value
     * @return the attribute already used
     */
    public String getAttributeAlreadyUsed(String attribute, String value) {
        return attributeAlreadyUsed.replace("{{ATTRIBUTE}}", attribute).replace("{{VALUE}}", value);
    }

    /**
     * Gets the attribute already used code.
     *
     * @return the attribute already used code
     */
    public Integer getAttributeAlreadyUsedCode() {
        return Integer.parseInt(authProperties.errorCodePrefix + attributeAlreadyUsedCode);
    }


    /**
     * Gets the attribute already exist.
     *
     * @param attribute the attribute
     * @param value the value
     * @return the attribute already exist
     */
    public String getAttributeAlreadyExist(String attribute, String value) {
        return attributeAlreadyExist.replace("{{ATTRIBUTE}}", attribute).replace("{{VALUE}}",
                value);
    }

}
