
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for blockModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="blockModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="UNBLOCKED"/&gt;
 *     &lt;enumeration value="BLOCKED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "blockModeType")
@XmlEnum
public enum BlockModeType {

    UNBLOCKED,
    BLOCKED;

    public String value() {
        return name();
    }

    public static BlockModeType fromValue(String v) {
        return valueOf(v);
    }

}
