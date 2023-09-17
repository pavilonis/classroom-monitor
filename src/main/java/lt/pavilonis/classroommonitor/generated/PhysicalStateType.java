
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physicalStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="physicalStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DOOR_CLOSED"/&gt;
 *     &lt;enumeration value="INTRUSION"/&gt;
 *     &lt;enumeration value="DOOR_LEFT_OPEN"/&gt;
 *     &lt;enumeration value="DOOR_CLOSED_NOT_SECURED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "physicalStateType")
@XmlEnum
public enum PhysicalStateType {

    DOOR_CLOSED,
    INTRUSION,
    DOOR_LEFT_OPEN,
    DOOR_CLOSED_NOT_SECURED;

    public String value() {
        return name();
    }

    public static PhysicalStateType fromValue(String v) {
        return valueOf(v);
    }

}
