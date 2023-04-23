
package lt.pavilonis.classroommonitor.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessResultDoorList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessResultDoorList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://soap.ws.ts1000.tesa.es/}wirelessResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="recordCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="wirelessDoor" type="{http://soap.ws.ts1000.tesa.es/}wirelessDoor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessResultDoorList", propOrder = {
    "recordCount",
    "wirelessDoor"
})
public class WirelessResultDoorList
    extends WirelessResult
{

    protected Integer recordCount;
    @XmlElement(nillable = true)
    protected List<WirelessDoor> wirelessDoor;

    /**
     * Gets the value of the recordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordCount(Integer value) {
        this.recordCount = value;
    }

    /**
     * Gets the value of the wirelessDoor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wirelessDoor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWirelessDoor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WirelessDoor }
     * 
     * 
     */
    public List<WirelessDoor> getWirelessDoor() {
        if (wirelessDoor == null) {
            wirelessDoor = new ArrayList<WirelessDoor>();
        }
        return this.wirelessDoor;
    }

}
