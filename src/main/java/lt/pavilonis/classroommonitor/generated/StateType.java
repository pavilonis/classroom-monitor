
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="stateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CARD"/&gt;
 *     &lt;enumeration value="PASSAGE"/&gt;
 *     &lt;enumeration value="FIRST_USER"/&gt;
 *     &lt;enumeration value="KEYPAD"/&gt;
 *     &lt;enumeration value="CARD_PIN"/&gt;
 *     &lt;enumeration value="DUAL_USER"/&gt;
 *     &lt;enumeration value="PIN_CARD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "stateType")
@XmlEnum
public enum StateType {

    CARD,
    PASSAGE,
    FIRST_USER,
    KEYPAD,
    CARD_PIN,
    DUAL_USER,
    PIN_CARD;

    public String value() {
        return name();
    }

    public static StateType fromValue(String v) {
        return valueOf(v);
    }

}
