package com.dollamu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		List<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON);
		list.add(new MediaType("application", "*+json"));
		list.add(MediaType.TEXT_PLAIN);//添加普通文本格式的响应
		
		converter.setSupportedMediaTypes(list);
		
		RestTemplate template = new RestTemplate(factory);
		
		template.getMessageConverters().add(converter);
		
		return template;
	}

	@Bean
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(5000);// ms
		factory.setConnectTimeout(15000);// ms
		return factory;
	}
}
