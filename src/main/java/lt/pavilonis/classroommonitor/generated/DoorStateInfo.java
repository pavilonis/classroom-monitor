
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doorStateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doorStateInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="batteryPercentage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="batteryStatus" type="{http://soap.ws.ts1000.tesa.es/}batteryStatusType" minOccurs="0"/&gt;
 *         &lt;element name="cabinetState" type="{http://soap.ws.ts1000.tesa.es/}cabinetStateInfo" minOccurs="0"/&gt;
 *         &lt;element name="emergency" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="mode" type="{http://soap.ws.ts1000.tesa.es/}blockModeType" minOccurs="0"/&gt;
 *         &lt;element name="physicalState" type="{http://soap.ws.ts1000.tesa.es/}physicalStateType" minOccurs="0"/&gt;
 *         &lt;element name="privacy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="state" type="{http://soap.ws.ts1000.tesa.es/}stateType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doorStateInfo", propOrder = {
    "batteryPercentage",
    "batteryStatus",
    "cabinetState",
    "emergency",
    "mode",
    "physicalState",
    "privacy",
    "state"
})
public class DoorStateInfo {

    protected Integer batteryPercentage;
    @XmlSchemaType(name = "string")
    protected BatteryStatusType batteryStatus;
    protected CabinetStateInfo cabinetState;
    protected Boolean emergency;
    @XmlSchemaType(name = "string")
    protected BlockModeType mode;
    @XmlSchemaType(name = "string")
    protected PhysicalStateType physicalState;
    protected Boolean privacy;
    @XmlSchemaType(name = "string")
    protected StateType state;

    /**
     * Gets the value of the batteryPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBatteryPercentage() {
        return batteryPercentage;
    }

    /**
     * Sets the value of the batteryPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBatteryPercentage(Integer value) {
        this.batteryPercentage = value;
    }

    /**
     * Gets the value of the batteryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BatteryStatusType }
     *     
     */
    public BatteryStatusType getBatteryStatus() {
        return batteryStatus;
    }

    /**
     * Sets the value of the batteryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatteryStatusType }
     *     
     */
    public void setBatteryStatus(BatteryStatusType value) {
        this.batteryStatus = value;
    }

    /**
     * Gets the value of the cabinetState property.
     * 
     * @return
     *     possible object is
     *     {@link CabinetStateInfo }
     *     
     */
    public CabinetStateInfo getCabinetState() {
        return cabinetState;
    }

    /**
     * Sets the value of the cabinetState property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabinetStateInfo }
     *     
     */
    public void setCabinetState(CabinetStateInfo value) {
        this.cabinetState = value;
    }

    /**
     * Gets the value of the emergency property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets the value of the emergency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEmergency(Boolean value) {
        this.emergency = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link BlockModeType }
     *     
     */
    public BlockModeType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockModeType }
     *     
     */
    public void setMode(BlockModeType value) {
        this.mode = value;
    }

    /**
     * Gets the value of the physicalState property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalStateType }
     *     
     */
    public PhysicalStateType getPhysicalState() {
        return physicalState;
    }

    /**
     * Sets the value of the physicalState property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalStateType }
     *     
     */
    public void setPhysicalState(PhysicalStateType value) {
        this.physicalState = value;
    }

    /**
     * Gets the value of the privacy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrivacy() {
        return privacy;
    }

    /**
     * Sets the value of the privacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrivacy(Boolean value) {
        this.privacy = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link StateType }
     *     
     */
    public StateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateType }
     *     
     */
    public void setState(StateType value) {
        this.state = value;
    }

}
