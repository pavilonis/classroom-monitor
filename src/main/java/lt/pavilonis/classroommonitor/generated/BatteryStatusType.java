
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for batteryStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="batteryStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="LOW_BATTERIES"/&gt;
 *     &lt;enumeration value="VERY_LOW_BATTERIES"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "batteryStatusType")
@XmlEnum
public enum BatteryStatusType {

    OK,
    LOW_BATTERIES,
    VERY_LOW_BATTERIES;

    public String value() {
        return name();
    }

    public static BatteryStatusType fromValue(String v) {
        return valueOf(v);
    }

}
