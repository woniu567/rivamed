package enumdemo;

/*
各种枚举类
 */
public enum MessageTypeEnum {

    thingDeviceLocationNotMatch("设备配件不匹配提醒"),
    thingUnLocated("设备定位异常提醒"),
    qualityControlNotice("质控提醒"),
    damageReportNotice("损坏上报提醒");

    private String typeName;

    MessageTypeEnum(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public static MessageTypeEnum typeNameOf(String typeName) {
        for (MessageTypeEnum messageTypeEnum : MessageTypeEnum.values()) {
            if (messageTypeEnum.typeName.equals(typeName)) {
                return messageTypeEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MessageTypeEnum.valueOf("1");
    }
}
