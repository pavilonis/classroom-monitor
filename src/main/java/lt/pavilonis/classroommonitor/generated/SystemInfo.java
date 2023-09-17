package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for systemInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="systemInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="platformVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="portAgentCommunication" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="portAgentRegistration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="portEncodingService" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="portPMS" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="siteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="siteNameShort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="systemTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="systemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemInfo", propOrder = {
    "dataVersion",
    "platformVersion",
    "portAgentCommunication",
    "portAgentRegistration",
    "portEncodingService",
    "portPMS",
    "siteId",
    "siteName",
    "siteNameShort",
    "systemTime",
    "systemType"
})
public class SystemInfo {

    protected String dataVersion;
    protected String platformVersion;
    protected Integer portAgentCommunication;
    protected Integer portAgentRegistration;
    protected Integer portEncodingService;
    protected Integer portPMS;
    protected String siteId;
    protected String siteName;
    protected String siteNameShort;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar systemTime;
    protected String systemType;

    /**
     * Gets the value of the dataVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataVersion() {
        return dataVersion;
    }

    /**
     * Sets the value of the dataVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataVersion(String value) {
        this.dataVersion = value;
    }

    /**
     * Gets the value of the platformVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformVersion() {
        return platformVersion;
    }

    /**
     * Sets the value of the platformVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformVersion(String value) {
        this.platformVersion = value;
    }

    /**
     * Gets the value of the portAgentCommunication property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortAgentCommunication() {
        return portAgentCommunication;
    }

    /**
     * Sets the value of the portAgentCommunication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortAgentCommunication(Integer value) {
        this.portAgentCommunication = value;
    }

    /**
     * Gets the value of the portAgentRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortAgentRegistration() {
        return portAgentRegistration;
    }

    /**
     * Sets the value of the portAgentRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortAgentRegistration(Integer value) {
        this.portAgentRegistration = value;
    }

    /**
     * Gets the value of the portEncodingService property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortEncodingService() {
        return portEncodingService;
    }

    /**
     * Sets the value of the portEncodingService property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortEncodingService(Integer value) {
        this.portEncodingService = value;
    }

    /**
     * Gets the value of the portPMS property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortPMS() {
        return portPMS;
    }

    /**
     * Sets the value of the portPMS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortPMS(Integer value) {
        this.portPMS = value;
    }

    /**
     * Gets the value of the siteId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * Sets the value of the siteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteId(String value) {
        this.siteId = value;
    }

    /**
     * Gets the value of the siteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * Sets the value of the siteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteName(String value) {
        this.siteName = value;
    }

    /**
     * Gets the value of the siteNameShort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteNameShort() {
        return siteNameShort;
    }

    /**
     * Sets the value of the siteNameShort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteNameShort(String value) {
        this.siteNameShort = value;
    }

    /**
     * Gets the value of the systemTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSystemTime() {
        return systemTime;
    }

    /**
     * Sets the value of the systemTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSystemTime(XMLGregorianCalendar value) {
        this.systemTime = value;
    }

    /**
     * Gets the value of the systemType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * Sets the value of the systemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemType(String value) {
        this.systemType = value;
    }

}
