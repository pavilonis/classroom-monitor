
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="doorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TYPE_ZERO"/&gt;
 *     &lt;enumeration value="TYPE_CYLINDER"/&gt;
 *     &lt;enumeration value="TYPE_LOCK"/&gt;
 *     &lt;enumeration value="TYPE_READER"/&gt;
 *     &lt;enumeration value="TYPE_SAFE_MAG"/&gt;
 *     &lt;enumeration value="TYPE_CYLINDER_MEC"/&gt;
 *     &lt;enumeration value="TYPE_READER_ONLINE"/&gt;
 *     &lt;enumeration value="TYPE_ESCUTCHEON_PROX"/&gt;
 *     &lt;enumeration value="TYPE_READER_PROX_OFF"/&gt;
 *     &lt;enumeration value="TYPE_READER_PROX_ON"/&gt;
 *     &lt;enumeration value="TYPE_LOCK_DUAL"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR_PROX"/&gt;
 *     &lt;enumeration value="TYPE_READER_DUAL"/&gt;
 *     &lt;enumeration value="TYPE_SAFE_KEYBOARD"/&gt;
 *     &lt;enumeration value="TYPE_SAFE_PROX"/&gt;
 *     &lt;enumeration value="TYPE_READER_UPDATER"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR_DUAL"/&gt;
 *     &lt;enumeration value="TYPE_ESCUTCHEON_UOL"/&gt;
 *     &lt;enumeration value="TYPE_CABINET"/&gt;
 *     &lt;enumeration value="TYPE_READER_UOL"/&gt;
 *     &lt;enumeration value="TYPE_READER_DUAL_UOL"/&gt;
 *     &lt;enumeration value="TYPE_SPY_MAG"/&gt;
 *     &lt;enumeration value="TYPE_VISUALIZER"/&gt;
 *     &lt;enumeration value="TYPE_SPY_DUAL_UOL"/&gt;
 *     &lt;enumeration value="TYPE_SPY_MAG_UOL"/&gt;
 *     &lt;enumeration value="TYPE_READER_MAG_UOL"/&gt;
 *     &lt;enumeration value="TYPE_KNOB_CYLINDER"/&gt;
 *     &lt;enumeration value="TYPE_KNOB_CYLINDER_UOL"/&gt;
 *     &lt;enumeration value="TYPE_ENERGYSAVER_PROX"/&gt;
 *     &lt;enumeration value="TYPE_ENERGYSAVER_MAG"/&gt;
 *     &lt;enumeration value="TYPE_ENERGYSAVER_DUAL"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR_UOL"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR_PROX_UOL"/&gt;
 *     &lt;enumeration value="TYPE_ELEVATOR_DUAL_UOL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "doorType")
@XmlEnum
public enum DoorType {

    TYPE_ZERO,
    TYPE_CYLINDER,
    TYPE_LOCK,
    TYPE_READER,
    TYPE_SAFE_MAG,
    TYPE_CYLINDER_MEC,
    TYPE_READER_ONLINE,
    TYPE_ESCUTCHEON_PROX,
    TYPE_READER_PROX_OFF,
    TYPE_READER_PROX_ON,
    TYPE_LOCK_DUAL,
    TYPE_ELEVATOR,
    TYPE_ELEVATOR_PROX,
    TYPE_READER_DUAL,
    TYPE_SAFE_KEYBOARD,
    TYPE_SAFE_PROX,
    TYPE_READER_UPDATER,
    TYPE_ELEVATOR_DUAL,
    TYPE_ESCUTCHEON_UOL,
    TYPE_CABINET,
    TYPE_READER_UOL,
    TYPE_READER_DUAL_UOL,
    TYPE_SPY_MAG,
    TYPE_VISUALIZER,
    TYPE_SPY_DUAL_UOL,
    TYPE_SPY_MAG_UOL,
    TYPE_READER_MAG_UOL,
    TYPE_KNOB_CYLINDER,
    TYPE_KNOB_CYLINDER_UOL,
    TYPE_ENERGYSAVER_PROX,
    TYPE_ENERGYSAVER_MAG,
    TYPE_ENERGYSAVER_DUAL,
    TYPE_ELEVATOR_UOL,
    TYPE_ELEVATOR_PROX_UOL,
    TYPE_ELEVATOR_DUAL_UOL;

    public String value() {
        return name();
    }

    public static DoorType fromValue(String v) {
        return valueOf(v);
    }

}
