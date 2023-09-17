
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doorGetAllResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doorGetAllResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operationResultAssignedRFModules" type="{http://soap.ws.ts1000.tesa.es/}wirelessResultDoorList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doorGetAllResponse", propOrder = {
    "operationResultAssignedRFModules"
})
public class DoorGetAllResponse {

    protected WirelessResultDoorList operationResultAssignedRFModules;

    /**
     * Gets the value of the operationResultAssignedRFModules property.
     * 
     * @return
     *     possible object is
     *     {@link WirelessResultDoorList }
     *     
     */
    public WirelessResultDoorList getOperationResultAssignedRFModules() {
        return operationResultAssignedRFModules;
    }

    /**
     * Sets the value of the operationResultAssignedRFModules property.
     * 
     * @param value
     *     allowed object is
     *     {@link WirelessResultDoorList }
     *     
     */
    public void setOperationResultAssignedRFModules(WirelessResultDoorList value) {
        this.operationResultAssignedRFModules = value;
    }

}