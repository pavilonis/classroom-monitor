
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rfModuleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rfModuleInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descrDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doorDeviceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doorStateInfo" type="{http://soap.ws.ts1000.tesa.es/}doorStateInfo" minOccurs="0"/&gt;
 *         &lt;element name="doorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hubName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lockResponse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="lqi" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://soap.ws.ts1000.tesa.es/}rfStatusType" minOccurs="0"/&gt;
 *         &lt;element name="statusBytes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tSleep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rfModuleInfo", propOrder = {
    "descrDevice",
    "doorDeviceType",
    "doorName",
    "doorStateInfo",
    "doorVersion",
    "hubName",
    "lockResponse",
    "lqi",
    "macAddress",
    "signal",
    "status",
    "statusBytes",
    "version",
    "tSleep"
})
public class RfModuleInfo {

    protected String descrDevice;
    protected String doorDeviceType;
    protected String doorName;
    protected DoorStateInfo doorStateInfo;
    protected String doorVersion;
    protected String hubName;
    protected Boolean lockResponse;
    protected Integer lqi;
    protected String macAddress;
    protected Integer signal;
    @XmlSchemaType(name = "string")
    protected RfStatusType status;
    protected String statusBytes;
    protected String version;
    protected Integer tSleep;

    /**
     * Gets the value of the descrDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDevice() {
        return descrDevice;
    }

    /**
     * Sets the value of the descrDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDevice(String value) {
        this.descrDevice = value;
    }

    /**
     * Gets the value of the doorDeviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoorDeviceType() {
        return doorDeviceType;
    }

    /**
     * Sets the value of the doorDeviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoorDeviceType(String value) {
        this.doorDeviceType = value;
    }

    /**
     * Gets the value of the doorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoorName() {
        return doorName;
    }

    /**
     * Sets the value of the doorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoorName(String value) {
        this.doorName = value;
    }

    /**
     * Gets the value of the doorStateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DoorStateInfo }
     *     
     */
    public DoorStateInfo getDoorStateInfo() {
        return doorStateInfo;
    }

    /**
     * Sets the value of the doorStateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoorStateInfo }
     *     
     */
    public void setDoorStateInfo(DoorStateInfo value) {
        this.doorStateInfo = value;
    }

    /**
     * Gets the value of the doorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoorVersion() {
        return doorVersion;
    }

    /**
     * Sets the value of the doorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoorVersion(String value) {
        this.doorVersion = value;
    }

    /**
     * Gets the value of the hubName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubName() {
        return hubName;
    }

    /**
     * Sets the value of the hubName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubName(String value) {
        this.hubName = value;
    }

    /**
     * Gets the value of the lockResponse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLockResponse() {
        return lockResponse;
    }

    /**
     * Sets the value of the lockResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLockResponse(Boolean value) {
        this.lockResponse = value;
    }

    /**
     * Gets the value of the lqi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLqi() {
        return lqi;
    }

    /**
     * Sets the value of the lqi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLqi(Integer value) {
        this.lqi = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the signal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSignal() {
        return signal;
    }

    /**
     * Sets the value of the signal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSignal(Integer value) {
        this.signal = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link RfStatusType }
     *     
     */
    public RfStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link RfStatusType }
     *     
     */
    public void setStatus(RfStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusBytes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusBytes() {
        return statusBytes;
    }

    /**
     * Sets the value of the statusBytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusBytes(String value) {
        this.statusBytes = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the tSleep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTSleep() {
        return tSleep;
    }

    /**
     * Sets the value of the tSleep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTSleep(Integer value) {
        this.tSleep = value;
    }

}
