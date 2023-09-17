
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lockdownMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="lockdownMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LOCKDOWN_OFF"/&gt;
 *     &lt;enumeration value="LOCKDOWN_OPEN"/&gt;
 *     &lt;enumeration value="LOCKDOWN_CLOSE"/&gt;
 *     &lt;enumeration value="LOCKDOWN_BLOCK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "lockdownMode")
@XmlEnum
public enum LockdownMode {

    LOCKDOWN_OFF,
    LOCKDOWN_OPEN,
    LOCKDOWN_CLOSE,
    LOCKDOWN_BLOCK;

    public String value() {
        return name();
    }

    public static LockdownMode fromValue(String v) {
        return valueOf(v);
    }

}
