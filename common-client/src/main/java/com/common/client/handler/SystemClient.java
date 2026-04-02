package com.common.client.handler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.common.api.constant.CommonConstant;
import com.common.api.model.response.SystemResponse;
import com.common.client.config.CommonClientConfig;

import java.util.List;

/**
 * The Interface SystemClient.
 */
@FeignClient(name = "SystemClient", url = "${common.base.url}",
        configuration = CommonClientConfig.class)
public interface SystemClient {


    /*
    *//**
        * Gets the all.
        *
        * @param systemName the system name
        * @return the all
        */

    @RequestMapping(value = CommonConstant.RequestUrl.System.SYSTEM_ROOT_CONTEXT_URL,
            method = RequestMethod.GET)
    public List<SystemResponse> getAll(
            @RequestParam(value = "name", required = false) String systemName,
            @RequestParam(name = "capability", required = false) String capabilityCode,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);

    /**
     * Gets the by uuid.
     *
     * @param systemUuid the system uuid
     * @return the by uuid
     */
    @RequestMapping(value = CommonConstant.RequestUrl.System.SYSTEM_ROOT_CONTEXT_URL
            + CommonConstant.RequestUrl.System.SYSTEM_UUID_URL, method = RequestMethod.GET)
    public SystemResponse getByUuid(@PathVariable(value = "system_uuid") String systemUuid,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);



}
