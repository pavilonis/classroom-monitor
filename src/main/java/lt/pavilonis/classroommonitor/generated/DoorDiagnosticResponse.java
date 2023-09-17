
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doorDiagnosticResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doorDiagnosticResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operationResultRFDiagnostic" type="{http://soap.ws.ts1000.tesa.es/}wirelessResultRFModuleInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doorDiagnosticResponse", propOrder = {
    "operationResultRFDiagnostic"
})
public class DoorDiagnosticResponse {

    protected WirelessResultRFModuleInfo operationResultRFDiagnostic;

    /**
     * Gets the value of the operationResultRFDiagnostic property.
     * 
     * @return
     *     possible object is
     *     {@link WirelessResultRFModuleInfo }
     *     
     */
    public WirelessResultRFModuleInfo getOperationResultRFDiagnostic() {
        return operationResultRFDiagnostic;
    }

    /**
     * Sets the value of the operationResultRFDiagnostic property.
     * 
     * @param value
     *     allowed object is
     *     {@link WirelessResultRFModuleInfo }
     *     
     */
    public void setOperationResultRFDiagnostic(WirelessResultRFModuleInfo value) {
        this.operationResultRFDiagnostic = value;
    }

}
