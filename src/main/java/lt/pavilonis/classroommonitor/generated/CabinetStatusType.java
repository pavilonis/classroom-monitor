
package lt.pavilonis.classroommonitor.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cabinetStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="cabinetStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FREE"/&gt;
 *     &lt;enumeration value="IN_USE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "cabinetStatusType")
@XmlEnum
public enum CabinetStatusType {

    FREE,
    IN_USE;

    public String value() {
        return name();
    }

    public static CabinetStatusType fromValue(String v) {
        return valueOf(v);
    }

}
