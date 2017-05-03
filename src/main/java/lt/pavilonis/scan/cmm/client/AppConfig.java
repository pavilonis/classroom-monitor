package lt.pavilonis.scan.cmm.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;
import java.util.Locale;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
@EnableScheduling
@ComponentScan({"lt.pavilonis.scan", "resources"})
@PropertySource(value = {"file:${propertiesLocation:app.properties}"}, encoding = "UTF-8")
public class AppConfig {

   @Value("${api.auth.username}")
   private String apiUsername;

   @Value("${api.auth.password}")
   private String apiPassword;

   @Bean
   public RestTemplate getRestTemplate() {
      RestTemplate rest = new RestTemplate();
      rest.setInterceptors(Collections.singletonList(authenticatingInterceptor()));
      rest.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
      return rest;
   }

   @Bean
   public ReloadableResourceBundleMessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setUseCodeAsDefaultMessage(true);
      messageSource.setBasename("classpath:lang/messages");
      messageSource.setCacheSeconds(0);
      messageSource.setDefaultEncoding("UTF-8");
      Locale.setDefault(new Locale("lt", "LT"));
      return messageSource;
   }

   private ClientHttpRequestInterceptor authenticatingInterceptor() {
      return (request, body, execution) -> {
         String creds = apiUsername + ":" + apiPassword;
         byte[] base64credsBytes = Base64.getEncoder().encode(creds.getBytes());

         HttpHeaders headers = request.getHeaders();
         headers.add("Authorization", "Basic " + new String(base64credsBytes));
         headers.setAccept(Collections.singletonList(APPLICATION_JSON));
         return execution.execute(request, body);
      };
   }
}
