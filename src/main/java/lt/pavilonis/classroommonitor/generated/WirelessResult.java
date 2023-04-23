
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://soap.ws.ts1000.tesa.es/}operationResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="doorInfo" type="{http://soap.ws.ts1000.tesa.es/}wirelessDoor" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessResult", propOrder = {
    "doorInfo"
})
@XmlSeeAlso({
    WirelessResultDoorList.class,
    WirelessResultDoorListLockdownAreas.class,
    WirelessResultRFModuleInfo.class
})
public class WirelessResult
    extends OperationResult
{

    protected WirelessDoor doorInfo;

    /**
     * Gets the value of the doorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link WirelessDoor }
     *     
     */
    public WirelessDoor getDoorInfo() {
        return doorInfo;
    }

    /**
     * Sets the value of the doorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link WirelessDoor }
     *     
     */
    public void setDoorInfo(WirelessDoor value) {
        this.doorInfo = value;
    }

}
