
package com.common.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import feign.Logger.Level;

@EnableFeignClients(basePackages = "com.common.client.handler")
public class CommonClientConfig {
	/**
	 * Feign logger level.
	 *
	 * @return the logger. level
	 */
	@Bean
	Level feignLoggerLevel() {
		return Level.BASIC;
	}

}
