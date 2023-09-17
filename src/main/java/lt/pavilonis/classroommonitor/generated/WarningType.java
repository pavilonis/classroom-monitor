
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="warningType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="WARNING_RF_LOW_SIGNAL"/&gt;
 *     &lt;enumeration value="WARNING_DOOR_WAS_ALREADY_OPEN"/&gt;
 *     &lt;enumeration value="WARNING_HUB_RF_VERSION_ERROR_VALUE"/&gt;
 *     &lt;enumeration value="WARNING_DOOR_MODULE_COMMUNICATION_ERROR"/&gt;
 *     &lt;enumeration value="WARNING_HUB_MORE_DOORS_ACCESSIBLE"/&gt;
 *     &lt;enumeration value="WARNING_HUB_BOOT_MODE"/&gt;
 *     &lt;enumeration value="WARNING_HUB_INCOMPLETE_BOOT_MODE"/&gt;
 *     &lt;enumeration value="WARNING_RF_BOOT_MODE"/&gt;
 *     &lt;enumeration value="WARNING_RF_INCOMPLETE_BOOT_MODE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "warningType")
@XmlEnum
public enum WarningType {

    WARNING_RF_LOW_SIGNAL,
    WARNING_DOOR_WAS_ALREADY_OPEN,
    WARNING_HUB_RF_VERSION_ERROR_VALUE,
    WARNING_DOOR_MODULE_COMMUNICATION_ERROR,
    WARNING_HUB_MORE_DOORS_ACCESSIBLE,
    WARNING_HUB_BOOT_MODE,
    WARNING_HUB_INCOMPLETE_BOOT_MODE,
    WARNING_RF_BOOT_MODE,
    WARNING_RF_INCOMPLETE_BOOT_MODE;

    public String value() {
        return name();
    }

    public static WarningType fromValue(String v) {
        return valueOf(v);
    }

}
