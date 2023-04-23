
package lt.pavilonis.classroommonitor.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wirelessResultDoorListLockdownAreas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wirelessResultDoorListLockdownAreas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://soap.ws.ts1000.tesa.es/}wirelessResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="areas" type="{http://soap.ws.ts1000.tesa.es/}wirelessDoorListLockDownAreas" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wirelessResultDoorListLockdownAreas", propOrder = {
    "areas"
})
public class WirelessResultDoorListLockdownAreas
    extends WirelessResult
{

    @XmlElement(nillable = true)
    protected List<WirelessDoorListLockDownAreas> areas;

    /**
     * Gets the value of the areas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the areas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAreas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WirelessDoorListLockDownAreas }
     * 
     * 
     */
    public List<WirelessDoorListLockDownAreas> getAreas() {
        if (areas == null) {
            areas = new ArrayList<WirelessDoorListLockDownAreas>();
        }
        return this.areas;
    }

}
