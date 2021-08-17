package lt.pavilonis.classroommonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Locale;

@SpringBootApplication
@EnableScheduling
@PropertySource(value = {"file:${propertiesLocation:app.properties}"}, encoding = "UTF-8")
public class Spring {

   public static ConfigurableApplicationContext CONTEXT;

   public static void main(String[] args) {
      CONTEXT = SpringApplication.run(Spring.class, args);
      JavaFxApp.launch(JavaFxApp.class);
   }

   @Bean
   public MessageSource messageSource() {
      var messages = new ReloadableResourceBundleMessageSource();
      messages.setUseCodeAsDefaultMessage(true);
      messages.setBasename("classpath:lang/messages");
      messages.setCacheSeconds(0);
      messages.setDefaultEncoding("UTF-8");
      messages.setDefaultLocale(new Locale("lt"));
      return messages;
   }

   public static String getStringProperty(String name) {
      return CONTEXT.getEnvironment()
            .getProperty(name);
   }

   public static int getIntProperty(String name) {
      String result = getStringProperty(name);
      return Integer.parseInt(result);
   }

   public static <T> T getBean(Class<T> clazz) {
      return CONTEXT.getBean(clazz);
   }
}
