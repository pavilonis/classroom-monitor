
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doorGetAllByLockdownAreaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doorGetAllByLockdownAreaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operationResultAssignedRFModules" type="{http://soap.ws.ts1000.tesa.es/}wirelessResultDoorListLockdownAreas" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doorGetAllByLockdownAreaResponse", propOrder = {
    "operationResultAssignedRFModules"
})
public class DoorGetAllByLockdownAreaResponse {

    protected WirelessResultDoorListLockdownAreas operationResultAssignedRFModules;

    /**
     * Gets the value of the operationResultAssignedRFModules property.
     * 
     * @return
     *     possible object is
     *     {@link WirelessResultDoorListLockdownAreas }
     *     
     */
    public WirelessResultDoorListLockdownAreas getOperationResultAssignedRFModules() {
        return operationResultAssignedRFModules;
    }

    /**
     * Sets the value of the operationResultAssignedRFModules property.
     * 
     * @param value
     *     allowed object is
     *     {@link WirelessResultDoorListLockdownAreas }
     *     
     */
    public void setOperationResultAssignedRFModules(WirelessResultDoorListLockdownAreas value) {
        this.operationResultAssignedRFModules = value;
    }

}
