package lt.pavilonis.scan.cmm.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
@EnableScheduling
@ComponentScan({"lt.pavilonis.scan", "resources"})
@PropertySource(value = {"file:${propertiesLocation:app.properties}"}, encoding = "UTF-8")
public class AppConfig {

   private final String username;
   private final String password;

   public AppConfig(@Value("${api.auth.username}") String username, @Value("${api.auth.password}") String password) {
      this.username = username;
      this.password = password;
   }

   @Bean
   public RestTemplate getRestTemplate() {
      var rest = new RestTemplate();
      rest.setInterceptors(List.of(authenticatingInterceptor()));
      rest.setMessageConverters(List.of(new MappingJackson2HttpMessageConverter()));
      return rest;
   }

   @Bean
   public ReloadableResourceBundleMessageSource messageSource() {
      var messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setUseCodeAsDefaultMessage(true);
      messageSource.setBasename("classpath:lang/messages");
      messageSource.setCacheSeconds(0);
      messageSource.setDefaultEncoding("UTF-8");
      Locale.setDefault(new Locale("lt", "LT"));
      return messageSource;
   }

   private ClientHttpRequestInterceptor authenticatingInterceptor() {
      return (request, body, execution) -> {
         HttpHeaders headers = request.getHeaders();
         headers.setBasicAuth(username, password);
         headers.setAccept(Collections.singletonList(APPLICATION_JSON));
         return execution.execute(request, body);
      };
   }

   /**
    * Needed for Spring @Value annotations to work
    */
   @Bean
   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }
}
