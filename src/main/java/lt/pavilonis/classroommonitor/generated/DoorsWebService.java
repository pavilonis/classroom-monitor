package lt.pavilonis.classroommonitor.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-01-15T19:04:39.947+02:00
 * Generated source version: 3.5.5
 *
 */
@WebServiceClient(name = "DoorsWebService",
                  wsdlLocation = "file:/C:/Users/artur/workspace/classroom-monitor/src/main/resources/soap/DoorsWebService.wsdl",
                  targetNamespace = "http://soap.ws.ts1000.tesa.es/")
public class DoorsWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.ws.ts1000.tesa.es/", "DoorsWebService");
    public final static QName WirelessDoorsServicePort = new QName("http://soap.ws.ts1000.tesa.es/", "WirelessDoorsServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/artur/workspace/classroom-monitor/src/main/resources/soap/DoorsWebService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DoorsWebService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/artur/workspace/classroom-monitor/src/main/resources/soap/DoorsWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DoorsWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DoorsWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DoorsWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public DoorsWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DoorsWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DoorsWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }


    /**
     *
     * @return
     *     returns WirelessDoorsService
     */
    @WebEndpoint(name = "WirelessDoorsServicePort")
    public WirelessDoorsService getWirelessDoorsServicePort() {
        return super.getPort(WirelessDoorsServicePort, WirelessDoorsService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WirelessDoorsService
     */
    @WebEndpoint(name = "WirelessDoorsServicePort")
    public WirelessDoorsService getWirelessDoorsServicePort(WebServiceFeature... features) {
        return super.getPort(WirelessDoorsServicePort, WirelessDoorsService.class, features);
    }

}