package lt.pavilonis.classroommonitor.config;

import lt.pavilonis.classroommonitor.generated.WirelessDoorsService;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HttpsURLConnection;

@Configuration
public class SoapConfig {

   @Value("${soap.endpoint.url}")
   private String soapEndpointUrl;

   @Bean
   public WirelessDoorsService doorsService() {
      // Install the all-trusting host verifier
      HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

      var factory = new JaxWsProxyFactoryBean();
      factory.setAddress(soapEndpointUrl);
      WirelessDoorsService service = factory.create(WirelessDoorsService.class);
      disableCommonNameCheck(service);
      return service;
   }

   private void disableCommonNameCheck(WirelessDoorsService service) {
      var tlsParams = new TLSClientParameters();
      tlsParams.setDisableCNCheck(true);

      Client client = ClientProxy.getClient(service);
      HTTPConduit http = (HTTPConduit) client.getConduit();
      http.setTlsClientParameters(tlsParams);
   }
}
