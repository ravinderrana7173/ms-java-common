package com.common.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.common.exception.ObjectNotFoundException;
import com.cloud.api.common.exception.RequestValidationException;
import com.cloud.api.common.util.ValidatorUtils;
import com.common.api.constant.CommonConstant;
import com.common.api.constant.CommonConstant.ValidationConstatnt;
import com.common.api.model.request.SystemRequest;
import com.common.rest.entity.CapabilityEntity;
import com.common.rest.entity.SystemEntity;
import com.common.rest.repository.CapabilityRepository;
import com.common.rest.repository.SystemRepository;
import com.common.rest.util.MessageUtil;

import java.util.List;

import lombok.extern.slf4j.Slf4j;


/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@Slf4j
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class SystemValidator extends BaseValidator {

    /** The message util. */
    @Autowired
    MessageUtil messageUtil;

    /** The system repository. */
    @Autowired
    private SystemRepository systemRepository;

    /** The capability repository. */
    @Autowired
    private CapabilityRepository capabilityRepository;

    /**
     * Validate system uuid.
     *
     * @param systemUuid the system uuid
     */
    public void validateSystemUuid(String systemUuid) {

        validateAttributeIsUuid(CommonConstant.SystemAttributes.SYSTEM_UUID, systemUuid);

        SystemEntity systemEntity = systemRepository.findBySystemUuid(systemUuid);

        if (systemEntity == null) {
            log.error("[validateSystemUuid] System Uuid {} is not valid.", systemUuid);
            throw new ObjectNotFoundException(messageUtil.getSystemNotFoundMessage(systemUuid));
        }
        log.info("[validateSystemUuid] System Uuid {} validated successfully.", systemUuid);

    }


    /**
     * Validate attribute is unique.
     *
     * @param fieldName the field name
     * @param fieldValue the field value
     */
    private void validateAttributeIsUnique(String fieldName, String fieldValue) {
        SystemEntity systemEntity = systemRepository.findBySystemName(fieldValue);
        if (systemEntity == null) {
            log.info("[validateAttributeIsUnique] with systemName {} validated successfully.",
                    fieldValue);

        } else {
            log.error("[validateAttributeIsUnique] systemName {} already exist in DB.", fieldValue);
            throw new RequestValidationException(messageUtil.getAttributeAlreadyExist(
                    CommonConstant.SystemAttributes.NAME, fieldValue));
        }
    }
    
    
    
    

    /**
     * Validate system name.
     *
     * @param systemName the system name
     */
    private void validateSystemName(String systemName) {
        log.info("[validateSystemName] with systemName {}.", systemName);
         validateAttributeIsUnique(CommonConstant.SystemAttributes.SYSTEM_NAME, systemName);
        if (!validateName(systemName, ValidationConstatnt.SYSTEM_NAME_LENGTH)) {
            throw new RequestValidationException(messageUtil.getSystemNameNotValidMessage(
                    CommonConstant.SystemAttributes.SYSTEM_NAME,
                    ValidationConstatnt.SYSTEM_NAME_SPECIAL_CHARACTERS,
                    ValidationConstatnt.SYSTEM_NAME_LENGTH));
        }
        log.info("[validateSystemName] with systemName {} validated successfully..", systemName);
    }
    
    private void validateUpdateSystemName(String systemName) {
        log.info("[validateSystemName] with systemName {}.", systemName);
        // validateAttributeIsUnique(CommonConstant.SystemAttributes.SYSTEM_NAME, systemName);
        if (!validateName(systemName, ValidationConstatnt.SYSTEM_NAME_LENGTH)) {
            throw new RequestValidationException(messageUtil.getSystemNameNotValidMessage(
                    CommonConstant.SystemAttributes.SYSTEM_NAME,
                    ValidationConstatnt.SYSTEM_NAME_SPECIAL_CHARACTERS,
                    ValidationConstatnt.SYSTEM_NAME_LENGTH));
        }
        log.info("[validateSystemName] with systemName {} validated successfully..", systemName);
    }


    /**
     * Validate system description.
     *
     * @param systemdesc the systemdesc
     */
    private void validateSystemDescription(String systemdesc) {
        log.info("[validateSystemDescription] with systemdesc {}.", systemdesc);
        if (!validateDescription(systemdesc, ValidationConstatnt.SYSTEM_DESCRIPTION_LENGTH)) {
            throw new RequestValidationException(messageUtil.getSystemDescriptionNotValidMessage(
                    CommonConstant.SystemAttributes.SYSTEM_DESCRIPTION,
                    ValidationConstatnt.SYSTEM_DESC_SPECIAL_CHARACTERS,
                    ValidationConstatnt.SYSTEM_DESCRIPTION_LENGTH));
        }
        log.info("[validateSystemDescription] with systemdesc {} validated successfully.",
                systemdesc);
    }

    /**
     * Validate system capabilities.
     *
     * @param systemCapabilityCodes the system capability codes
     */
    private void validateSystemCapabilities(List<String> systemCapabilityCodes) {
        for (String capabilityCode : systemCapabilityCodes) {
            if(capabilityCode != null && !capabilityCode.trim().isEmpty())
            {

            CapabilityEntity capabilityEntity =
                    capabilityRepository.findByCapabilityCode(capabilityCode);

            if (capabilityEntity == null) {
                log.error("[validateSystemUuid] System Capability {} is not valid.",
                        capabilityCode);
                throw new ObjectNotFoundException(
                        messageUtil.getSystemCapabilityNotFoundMessage(capabilityCode));
            }
            log.info("[validateSystemCapabilities] validated successfully.");
            }
        }
    }

    /**
     * Validate system request.
     *
     * @param systemRequest the system request
     */
    public void validateSystemRequest(final SystemRequest systemRequest) {
        validateAttributeIsMandatory(CommonConstant.SystemAttributes.SYSTEM_NAME,
                systemRequest.getName());
        validateSystemName(systemRequest.getName());
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getDescription())) {
            validateSystemDescription(systemRequest.getDescription());
        }
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getCapabilityCodes())) {
            validateSystemCapabilities(systemRequest.getCapabilityCodes());
        }

    }

    /**
     * Validate update system request.
     *
     * @param systemRequest the system request
     * @param systemUuid the system uuid
     */
    public void validateUpdateSystemRequest(final SystemRequest systemRequest, String systemUuid) {
        validateSystemUuid(systemUuid);
        validateEmptySystemItems(systemRequest);
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getName())) {
            validateUpdateSystemName(systemRequest.getName());
            SystemEntity systemEntity = systemRepository.findBySystemUuid(systemUuid);
            if (systemEntity != null) {
                if (systemRequest.getName() != null) {
                    if (!systemRequest.getName().equals(systemEntity.getSystemName())) {
                        validateAttributeIsUnique(CommonConstant.SystemAttributes.SYSTEM_NAME,
                                systemRequest.getName());
                    }
                }
            }


        }
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getDescription())) {
            validateSystemDescription(systemRequest.getDescription());
        }
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getCapabilityCodes())) {
            validateSystemCapabilities(systemRequest.getCapabilityCodes());
        }
    }

    
    public void validateEmptySystemItems(SystemRequest systemRequest) {
        if (systemRequest.getName() != null && systemRequest.getName().trim().isEmpty()) {
            throw new RequestValidationException(messageUtil.getAttributeNotNull(
                    CommonConstant.SystemAttributes.SYSTEM_NAME));
        }
    }


}
