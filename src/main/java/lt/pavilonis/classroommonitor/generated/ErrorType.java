
package lt.pavilonis.classroommonitor.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for errorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="errorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ERROR_SERVICE_AUTHENTICATION"/&gt;
 *     &lt;enumeration value="ERROR_SERVICE_AUTHORIZATION"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_TIMEOUT"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_DOOR_UNKNOWN"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_HUB_UNKNOWN"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_DOOR_NOT_WIRELESS"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_MODULE_NOT_CONFIGURED"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_HUB_BUSY"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_UNKNOWN_ERROR"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_DOOR_NOT_INITIALIZED"/&gt;
 *     &lt;enumeration value="ERROR_FORMAT_ERROR"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_USER_UNKNOWN"/&gt;
 *     &lt;enumeration value="ERROR_HUB_MODULE_LIST_FULL"/&gt;
 *     &lt;enumeration value="ERROR_HUB_MODULE_ALREADY_EXISTS"/&gt;
 *     &lt;enumeration value="ERROR_HUB_MODULE_LIST_EMPTY"/&gt;
 *     &lt;enumeration value="ERROR_HUB_MODULE_NOT_IN_LIST"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_MODULE_LOCK"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_NO_ANSWER"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_LOCK_NOT_WAKING_UP"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_HUB_MODULE"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_BAD_SYNTAX"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_RF_1"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_RF_2"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_WIRELESS_MEANS_BUSY"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_RF_4"/&gt;
 *     &lt;enumeration value="ERROR_COMMUNICATION_RF_COLLISION"/&gt;
 *     &lt;enumeration value="ERROR_DOOR_WRONGINIT"/&gt;
 *     &lt;enumeration value="ERROR_DOOR_WRONGSYS"/&gt;
 *     &lt;enumeration value="ERROR_DOOR_WRONGDOOR"/&gt;
 *     &lt;enumeration value="ERROR_DOOR_LOWBATT"/&gt;
 *     &lt;enumeration value="ERROR_DOOR_WRONGDIALOG"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_ROOM_OCCUPIED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_ROOM_PREASSIGNED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_PARENT_OCCUPIED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_PARENT_PREASSIGNED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_CHILD_OCCUPIED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_CHILD_PREASSIGNED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_INVALID_ROOM"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_INVALID_PARENT_ROOM"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_INVALID_CHILD_ROOM"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_ROOM_NOT_OCCUPIED"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_TOO_MANY_COPIES"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_CHECKIN_ENCODING_TARGET_MISSING"/&gt;
 *     &lt;enumeration value="RESULT_ERROR_COPY_EMAIL_ADDRESSES_MISSING"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_IN_LOCKING_PLAN"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_OUT_OF_TIME"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_MISSING_GRANT"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_USER_INACTIVE_OR_EXPIRED"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_IN_SERVER_SITE_LICENSE"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_DOOR_BLOCKED"/&gt;
 *     &lt;enumeration value="ERROR_NOT_AUTHORIZED_DOOR_PRIVACY_ON"/&gt;
 *     &lt;enumeration value="ERROR_BAD_PARAMETERS"/&gt;
 *     &lt;enumeration value="ERROR_DATA_ERROR"/&gt;
 *     &lt;enumeration value="ERROR_CANNOT_DELETE_IN_USE"/&gt;
 *     &lt;enumeration value="ERROR_PCTOLOCK_FILE_INVALID"/&gt;
 *     &lt;enumeration value="ERROR_PCTOLOCK_FILE_WRONG_SITE"/&gt;
 *     &lt;enumeration value="ERROR_PCTOLOCK_DOOR_DOES_NOT_EXIST"/&gt;
 *     &lt;enumeration value="ERROR_PCTOLOCK_INITIALIZATION_TYPE_MISMATCH"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_DEVICE_NOT_ELIGIBLE"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_NO_CARD_ISSUED"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_CARD_ALREADY_ISSUED"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_ROOM_MUST_BE_CHECKED_OUT"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_REMOTE_SERVER_RESPONSE_OK_NFC_EXECUTION_FAILED"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_DEVICE_MISSING"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_DEVICE_NOT_FOUND"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_READ_TIMEOUT"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_NO_COMMUNICATION"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_BUSY"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_OTHER"/&gt;
 *     &lt;enumeration value="ERROR_READING_UNKNOWN"/&gt;
 *     &lt;enumeration value="ERROR_READING_USER_DELETED"/&gt;
 *     &lt;enumeration value="ERROR_READING_SECURE_CARD"/&gt;
 *     &lt;enumeration value="ERROR_READING_DELETED_CARD"/&gt;
 *     &lt;enumeration value="ERROR_READING_CARD"/&gt;
 *     &lt;enumeration value="ERROR_READING_EMPTY"/&gt;
 *     &lt;enumeration value="ERROR_READING_FORMAT"/&gt;
 *     &lt;enumeration value="ERROR_READING_UNKNOWN_MESSAGE"/&gt;
 *     &lt;enumeration value="ERROR_READING_OTHER_SITE"/&gt;
 *     &lt;enumeration value="ERROR_READING_NON_PROPIETARY"/&gt;
 *     &lt;enumeration value="ERROR_READING_WRONG_SIZE"/&gt;
 *     &lt;enumeration value="ERROR_READING_LOST_COMM"/&gt;
 *     &lt;enumeration value="ERROR_READING_SECTOR_AUTH"/&gt;
 *     &lt;enumeration value="ERROR_READING_COULD_NOT_AUTH"/&gt;
 *     &lt;enumeration value="ERROR_ENCODING_WRITE_ERROR"/&gt;
 *     &lt;enumeration value="ERROR_READING_OLD_CARD"/&gt;
 *     &lt;enumeration value="ERROR_READING_NOT_ACTIVE"/&gt;
 *     &lt;enumeration value="ERROR_READING_EXPIRED"/&gt;
 *     &lt;enumeration value="ERROR_READING_NOT_AUTHORIZED"/&gt;
 *     &lt;enumeration value="ERROR_ROOM_FREE"/&gt;
 *     &lt;enumeration value="ERROR_ROOM_OCCUPIED"/&gt;
 *     &lt;enumeration value="ERROR_ROOM_PREASSIGNED"/&gt;
 *     &lt;enumeration value="ERROR_READING_FRAUDULENT_KEY_CARD"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_SELECT_CARD"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_SELECT_APPLICATION"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_GET_CARD_VERSION"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CARD_ENCRYPTION_NOT_SUPPORTED"/&gt;
 *     &lt;enumeration value="ERROR_CARD_CANNOT_CHANGE_KEY"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_GET_APP_LIST"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_CREATE_APP"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_DELETE_APP"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_GET_FILE"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_CREATE_FILE"/&gt;
 *     &lt;enumeration value="ERROR_DESFIRE_CANNOT_DELETE_FILE"/&gt;
 *     &lt;enumeration value="ERROR_CANNOT_READ_DATA"/&gt;
 *     &lt;enumeration value="ERROR_CANNOT_WRITE_DATA"/&gt;
 *     &lt;enumeration value="ERROR_CANNOT_DELETE_DATA"/&gt;
 *     &lt;enumeration value="ERROR_CANNOT_FORMAT_DATA"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_CANCELLED_DELETING"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_CANCELLED_OPERATION"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_CANCELLED_WRITING"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_INVALID_CONFIGURATION"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_INVALID_CARD_TYPE"/&gt;
 *     &lt;enumeration value="ERROR_ICLASS_INVALID_FACILITY_CODE"/&gt;
 *     &lt;enumeration value="ERROR_SERVER_CANNOT_CONNECT"/&gt;
 *     &lt;enumeration value="ERROR_SERVER_RESPONSE_SITE_BLOCKED"/&gt;
 *     &lt;enumeration value="ERROR_SERVER_RESPONSE_OTHER"/&gt;
 *     &lt;enumeration value="ERROR_SERVICE_SITE_INTERNAL_ERROR"/&gt;
 *     &lt;enumeration value="ERROR_OPERATION_LOCKDOWN_IN_PROGRESS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "errorType")
@XmlEnum
public enum ErrorType {

    ERROR_SERVICE_AUTHENTICATION,
    ERROR_SERVICE_AUTHORIZATION,
    ERROR_OPERATION_TIMEOUT,
    ERROR_OPERATION_DOOR_UNKNOWN,
    ERROR_OPERATION_HUB_UNKNOWN,
    ERROR_OPERATION_DOOR_NOT_WIRELESS,
    ERROR_OPERATION_MODULE_NOT_CONFIGURED,
    ERROR_OPERATION_HUB_BUSY,
    ERROR_OPERATION_UNKNOWN_ERROR,
    ERROR_OPERATION_DOOR_NOT_INITIALIZED,
    ERROR_FORMAT_ERROR,
    ERROR_OPERATION_USER_UNKNOWN,
    ERROR_HUB_MODULE_LIST_FULL,
    ERROR_HUB_MODULE_ALREADY_EXISTS,
    ERROR_HUB_MODULE_LIST_EMPTY,
    ERROR_HUB_MODULE_NOT_IN_LIST,
    ERROR_COMMUNICATION_MODULE_LOCK,
    ERROR_COMMUNICATION_NO_ANSWER,
    ERROR_COMMUNICATION_LOCK_NOT_WAKING_UP,
    ERROR_COMMUNICATION_HUB_MODULE,
    ERROR_COMMUNICATION_BAD_SYNTAX,
    ERROR_COMMUNICATION_RF_1,
    ERROR_COMMUNICATION_RF_2,
    ERROR_COMMUNICATION_WIRELESS_MEANS_BUSY,
    ERROR_COMMUNICATION_RF_4,
    ERROR_COMMUNICATION_RF_COLLISION,
    ERROR_DOOR_WRONGINIT,
    ERROR_DOOR_WRONGSYS,
    ERROR_DOOR_WRONGDOOR,
    ERROR_DOOR_LOWBATT,
    ERROR_DOOR_WRONGDIALOG,
    RESULT_ERROR_CHECKIN_ROOM_OCCUPIED,
    RESULT_ERROR_CHECKIN_ROOM_PREASSIGNED,
    RESULT_ERROR_CHECKIN_PARENT_OCCUPIED,
    RESULT_ERROR_CHECKIN_PARENT_PREASSIGNED,
    RESULT_ERROR_CHECKIN_CHILD_OCCUPIED,
    RESULT_ERROR_CHECKIN_CHILD_PREASSIGNED,
    RESULT_ERROR_CHECKIN_INVALID_ROOM,
    RESULT_ERROR_CHECKIN_INVALID_PARENT_ROOM,
    RESULT_ERROR_CHECKIN_INVALID_CHILD_ROOM,
    RESULT_ERROR_CHECKIN_ROOM_NOT_OCCUPIED,
    RESULT_ERROR_CHECKIN_TOO_MANY_COPIES,
    RESULT_ERROR_CHECKIN_ENCODING_TARGET_MISSING,
    RESULT_ERROR_COPY_EMAIL_ADDRESSES_MISSING,
    ERROR_NOT_AUTHORIZED_IN_LOCKING_PLAN,
    ERROR_NOT_AUTHORIZED_OUT_OF_TIME,
    ERROR_NOT_AUTHORIZED_MISSING_GRANT,
    ERROR_NOT_AUTHORIZED_USER_INACTIVE_OR_EXPIRED,
    ERROR_NOT_AUTHORIZED_IN_SERVER_SITE_LICENSE,
    ERROR_NOT_AUTHORIZED_DOOR_BLOCKED,
    ERROR_NOT_AUTHORIZED_DOOR_PRIVACY_ON,
    ERROR_BAD_PARAMETERS,
    ERROR_DATA_ERROR,
    ERROR_CANNOT_DELETE_IN_USE,
    ERROR_PCTOLOCK_FILE_INVALID,
    ERROR_PCTOLOCK_FILE_WRONG_SITE,
    ERROR_PCTOLOCK_DOOR_DOES_NOT_EXIST,
    ERROR_PCTOLOCK_INITIALIZATION_TYPE_MISMATCH,
    ERROR_ENCODING_DEVICE_NOT_ELIGIBLE,
    ERROR_ENCODING_NO_CARD_ISSUED,
    ERROR_ENCODING_CARD_ALREADY_ISSUED,
    ERROR_ENCODING_ROOM_MUST_BE_CHECKED_OUT,
    ERROR_ENCODING_REMOTE_SERVER_RESPONSE_OK_NFC_EXECUTION_FAILED,
    ERROR_ENCODING_DEVICE_MISSING,
    ERROR_ENCODING_DEVICE_NOT_FOUND,
    ERROR_ENCODING_READ_TIMEOUT,
    ERROR_ENCODING_NO_COMMUNICATION,
    ERROR_ENCODING_BUSY,
    ERROR_ENCODING_OTHER,
    ERROR_READING_UNKNOWN,
    ERROR_READING_USER_DELETED,
    ERROR_READING_SECURE_CARD,
    ERROR_READING_DELETED_CARD,
    ERROR_READING_CARD,
    ERROR_READING_EMPTY,
    ERROR_READING_FORMAT,
    ERROR_READING_UNKNOWN_MESSAGE,
    ERROR_READING_OTHER_SITE,
    ERROR_READING_NON_PROPIETARY,
    ERROR_READING_WRONG_SIZE,
    ERROR_READING_LOST_COMM,
    ERROR_READING_SECTOR_AUTH,
    ERROR_READING_COULD_NOT_AUTH,
    ERROR_ENCODING_WRITE_ERROR,
    ERROR_READING_OLD_CARD,
    ERROR_READING_NOT_ACTIVE,
    ERROR_READING_EXPIRED,
    ERROR_READING_NOT_AUTHORIZED,
    ERROR_ROOM_FREE,
    ERROR_ROOM_OCCUPIED,
    ERROR_ROOM_PREASSIGNED,
    ERROR_READING_FRAUDULENT_KEY_CARD,
    ERROR_DESFIRE_CANNOT_SELECT_CARD,
    ERROR_DESFIRE_CANNOT_SELECT_APPLICATION,
    ERROR_DESFIRE_CANNOT_GET_CARD_VERSION,
    ERROR_DESFIRE_CARD_ENCRYPTION_NOT_SUPPORTED,
    ERROR_CARD_CANNOT_CHANGE_KEY,
    ERROR_DESFIRE_CANNOT_GET_APP_LIST,
    ERROR_DESFIRE_CANNOT_CREATE_APP,
    ERROR_DESFIRE_CANNOT_DELETE_APP,
    ERROR_DESFIRE_CANNOT_GET_FILE,
    ERROR_DESFIRE_CANNOT_CREATE_FILE,
    ERROR_DESFIRE_CANNOT_DELETE_FILE,
    ERROR_CANNOT_READ_DATA,
    ERROR_CANNOT_WRITE_DATA,
    ERROR_CANNOT_DELETE_DATA,
    ERROR_CANNOT_FORMAT_DATA,
    ERROR_ICLASS_CANCELLED_DELETING,
    ERROR_ICLASS_CANCELLED_OPERATION,
    ERROR_ICLASS_CANCELLED_WRITING,
    ERROR_ICLASS_INVALID_CONFIGURATION,
    ERROR_ICLASS_INVALID_CARD_TYPE,
    ERROR_ICLASS_INVALID_FACILITY_CODE,
    ERROR_SERVER_CANNOT_CONNECT,
    ERROR_SERVER_RESPONSE_SITE_BLOCKED,
    ERROR_SERVER_RESPONSE_OTHER,
    ERROR_SERVICE_SITE_INTERNAL_ERROR,
    ERROR_OPERATION_LOCKDOWN_IN_PROGRESS;

    public String value() {
        return name();
    }

    public static ErrorType fromValue(String v) {
        return valueOf(v);
    }

}
