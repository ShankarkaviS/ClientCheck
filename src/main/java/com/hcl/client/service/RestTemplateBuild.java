package com.hcl.client.service;




import org.hibernate.annotations.Loader;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBuild {

	@Bean
	@Loader
	public RestTemplate restTeamplate(RestTemplateBuilder rtb)
	{
		return rtb.build();
	}
	
}
