
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessDoorListLockDownAreas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessDoorListLockDownAreas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="areaHasNotSupportedDoors" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="areaHasPendingDoors" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="areaId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="areaInExecution" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wirelessDoors" type="{http://soap.ws.ts1000.tesa.es/}wirelessResultDoorList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessDoorListLockDownAreas", propOrder = {
    "areaHasNotSupportedDoors",
    "areaHasPendingDoors",
    "areaId",
    "areaInExecution",
    "areaName",
    "wirelessDoors"
})
public class WirelessDoorListLockDownAreas {

    protected Boolean areaHasNotSupportedDoors;
    protected Boolean areaHasPendingDoors;
    protected Integer areaId;
    protected Boolean areaInExecution;
    protected String areaName;
    protected WirelessResultDoorList wirelessDoors;

    /**
     * Gets the value of the areaHasNotSupportedDoors property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAreaHasNotSupportedDoors() {
        return areaHasNotSupportedDoors;
    }

    /**
     * Sets the value of the areaHasNotSupportedDoors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAreaHasNotSupportedDoors(Boolean value) {
        this.areaHasNotSupportedDoors = value;
    }

    /**
     * Gets the value of the areaHasPendingDoors property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAreaHasPendingDoors() {
        return areaHasPendingDoors;
    }

    /**
     * Sets the value of the areaHasPendingDoors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAreaHasPendingDoors(Boolean value) {
        this.areaHasPendingDoors = value;
    }

    /**
     * Gets the value of the areaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * Sets the value of the areaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAreaId(Integer value) {
        this.areaId = value;
    }

    /**
     * Gets the value of the areaInExecution property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAreaInExecution() {
        return areaInExecution;
    }

    /**
     * Sets the value of the areaInExecution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAreaInExecution(Boolean value) {
        this.areaInExecution = value;
    }

    /**
     * Gets the value of the areaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets the value of the areaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

    /**
     * Gets the value of the wirelessDoors property.
     * 
     * @return
     *     possible object is
     *     {@link WirelessResultDoorList }
     *     
     */
    public WirelessResultDoorList getWirelessDoors() {
        return wirelessDoors;
    }

    /**
     * Sets the value of the wirelessDoors property.
     * 
     * @param value
     *     allowed object is
     *     {@link WirelessResultDoorList }
     *     
     */
    public void setWirelessDoors(WirelessResultDoorList value) {
        this.wirelessDoors = value;
    }

}
