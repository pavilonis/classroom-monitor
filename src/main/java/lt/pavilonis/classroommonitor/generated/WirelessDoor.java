
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessDoor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessDoor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="batteryLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="doorId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="doorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doorStateInfo" type="{http://soap.ws.ts1000.tesa.es/}doorStateInfo" minOccurs="0"/&gt;
 *         &lt;element name="doorType" type="{http://soap.ws.ts1000.tesa.es/}doorType" minOccurs="0"/&gt;
 *         &lt;element name="doorVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hubIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hubName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hubServiceWSDL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hubVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lockdownAreaId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="lockdownState" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="notSupportedDoor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="rfMacAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rfSignal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="rfState" type="{http://soap.ws.ts1000.tesa.es/}rfStatusType" minOccurs="0"/&gt;
 *         &lt;element name="rfVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="updateRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessDoor", propOrder = {
    "batteryLevel",
    "doorId",
    "doorName",
    "doorStateInfo",
    "doorType",
    "doorVersion",
    "groupName",
    "hubIPAddress",
    "hubName",
    "hubServiceWSDL",
    "hubVersion",
    "lockdownAreaId",
    "lockdownState",
    "notSupportedDoor",
    "rfMacAddress",
    "rfSignal",
    "rfState",
    "rfVersion",
    "updateRequired"
})
public class WirelessDoor {

    protected Integer batteryLevel;
    protected Integer doorId;
    protected String doorName;
    protected DoorStateInfo doorStateInfo;
    @XmlSchemaType(name = "string")
    protected DoorType doorType;
    protected String doorVersion;
    protected String groupName;
    protected String hubIPAddress;
    protected String hubName;
    protected String hubServiceWSDL;
    protected String hubVersion;
    protected Integer lockdownAreaId;
    protected Integer lockdownState;
    protected Boolean notSupportedDoor;
    protected String rfMacAddress;
    protected Integer rfSignal;
    @XmlSchemaType(name = "string")
    protected RfStatusType rfState;
    protected String rfVersion;
    protected Boolean updateRequired;

    /**
     * Gets the value of the batteryLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Sets the value of the batteryLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBatteryLevel(Integer value) {
        this.batteryLevel = value;
    }

    /**
     * Gets the value of the doorId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDoorId() {
        return doorId;
    }

    /**
     * Sets the value of the doorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDoorId(Integer value) {
        this.doorId = value;
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
     * Gets the value of the doorType property.
     * 
     * @return
     *     possible object is
     *     {@link DoorType }
     *     
     */
    public DoorType getDoorType() {
        return doorType;
    }

    /**
     * Sets the value of the doorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoorType }
     *     
     */
    public void setDoorType(DoorType value) {
        this.doorType = value;
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
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the hubIPAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubIPAddress() {
        return hubIPAddress;
    }

    /**
     * Sets the value of the hubIPAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubIPAddress(String value) {
        this.hubIPAddress = value;
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
     * Gets the value of the hubServiceWSDL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubServiceWSDL() {
        return hubServiceWSDL;
    }

    /**
     * Sets the value of the hubServiceWSDL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubServiceWSDL(String value) {
        this.hubServiceWSDL = value;
    }

    /**
     * Gets the value of the hubVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHubVersion() {
        return hubVersion;
    }

    /**
     * Sets the value of the hubVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHubVersion(String value) {
        this.hubVersion = value;
    }

    /**
     * Gets the value of the lockdownAreaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLockdownAreaId() {
        return lockdownAreaId;
    }

    /**
     * Sets the value of the lockdownAreaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLockdownAreaId(Integer value) {
        this.lockdownAreaId = value;
    }

    /**
     * Gets the value of the lockdownState property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLockdownState() {
        return lockdownState;
    }

    /**
     * Sets the value of the lockdownState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLockdownState(Integer value) {
        this.lockdownState = value;
    }

    /**
     * Gets the value of the notSupportedDoor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotSupportedDoor() {
        return notSupportedDoor;
    }

    /**
     * Sets the value of the notSupportedDoor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotSupportedDoor(Boolean value) {
        this.notSupportedDoor = value;
    }

    /**
     * Gets the value of the rfMacAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfMacAddress() {
        return rfMacAddress;
    }

    /**
     * Sets the value of the rfMacAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfMacAddress(String value) {
        this.rfMacAddress = value;
    }

    /**
     * Gets the value of the rfSignal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRfSignal() {
        return rfSignal;
    }

    /**
     * Sets the value of the rfSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRfSignal(Integer value) {
        this.rfSignal = value;
    }

    /**
     * Gets the value of the rfState property.
     * 
     * @return
     *     possible object is
     *     {@link RfStatusType }
     *     
     */
    public RfStatusType getRfState() {
        return rfState;
    }

    /**
     * Sets the value of the rfState property.
     * 
     * @param value
     *     allowed object is
     *     {@link RfStatusType }
     *     
     */
    public void setRfState(RfStatusType value) {
        this.rfState = value;
    }

    /**
     * Gets the value of the rfVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfVersion() {
        return rfVersion;
    }

    /**
     * Sets the value of the rfVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfVersion(String value) {
        this.rfVersion = value;
    }

    /**
     * Gets the value of the updateRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUpdateRequired() {
        return updateRequired;
    }

    /**
     * Sets the value of the updateRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdateRequired(Boolean value) {
        this.updateRequired = value;
    }

}
