package com.springboot.template.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info; 


@OpenAPIDefinition(
		info= @Info(
				title ="REST TEMPLATE API",
				description = "Description Template"
				)
//		security = @SecurityRequirement(name="basicAuth")
		)
//@SecurityScheme(name ="basicAuth",
//in = SecuritySchemeIn.HEADER,
//type=SecuritySchemeType.HTTP,
//bearerFormat = "JWT",
//scheme = "bearer",
//description = "This is BasicAith")
public class SwaggerConfig{
	
}