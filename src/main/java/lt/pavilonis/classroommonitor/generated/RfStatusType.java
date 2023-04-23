
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rfStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="rfStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ALWAYS_AWAKE"/&gt;
 *     &lt;enumeration value="SLEEP_AWAKE"/&gt;
 *     &lt;enumeration value="ALWAYS_SLEEP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "rfStatusType")
@XmlEnum
public enum RfStatusType {

    ALWAYS_AWAKE,
    SLEEP_AWAKE,
    ALWAYS_SLEEP;

    public String value() {
        return name();
    }

    public static RfStatusType fromValue(String v) {
        return valueOf(v);
    }

}
