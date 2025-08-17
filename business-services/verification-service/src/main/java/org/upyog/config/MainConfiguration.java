package org.upyog.config;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;

import org.egov.tracer.config.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.*;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Import({TracerConfiguration.class})
public class MainConfiguration {

    @Value("${app.timezone}")
    private String timeZone;

	// User Config
	@Value("${egov.user.host}")
	private String userHost;
	
	@Value("${egov.user.search.path}")
	private String userSearchEndpoint;
    
    @PostConstruct
    public void initialize() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

    @Bean
    public ObjectMapper objectMapper(){
    return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setTimeZone(TimeZone.getTimeZone(timeZone));
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter(@Lazy ObjectMapper objectMapper) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
	return converter;
}
}
