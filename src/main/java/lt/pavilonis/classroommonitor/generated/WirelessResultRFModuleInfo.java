
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessResultRFModuleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessResultRFModuleInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://soap.ws.ts1000.tesa.es/}wirelessResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rfModuleInfo" type="{http://soap.ws.ts1000.tesa.es/}rfModuleInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessResultRFModuleInfo", propOrder = {
    "rfModuleInfo"
})
public class WirelessResultRFModuleInfo
    extends WirelessResult
{

    protected RfModuleInfo rfModuleInfo;

    /**
     * Gets the value of the rfModuleInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RfModuleInfo }
     *     
     */
    public RfModuleInfo getRfModuleInfo() {
        return rfModuleInfo;
    }

    /**
     * Sets the value of the rfModuleInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RfModuleInfo }
     *     
     */
    public void setRfModuleInfo(RfModuleInfo value) {
        this.rfModuleInfo = value;
    }

}
