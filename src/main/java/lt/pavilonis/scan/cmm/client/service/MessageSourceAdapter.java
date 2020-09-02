package lt.pavilonis.scan.cmm.client.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceAdapter {

   private final MessageSource messageSource;

   public MessageSourceAdapter(MessageSource messageSource) {
      this.messageSource = messageSource;
   }

   public String get(Object object, String propertyName) {
      String main;

      if (object instanceof String) {
         main = (String) object;

      } else if (object instanceof Class) {
         Class<?> clazz = (Class<?>) object;

         main = clazz.isAnonymousClass()
               ? "ANONYMOUS"
               : clazz.getSimpleName();

      } else {
         main = object.getClass().getSimpleName();
      }
      return get(main + "." + propertyName);
   }

   public String get(String code) {
      return messageSource.getMessage(code, null, null);
   }
}
