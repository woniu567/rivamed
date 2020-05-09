package enumdemo;

public enum LocatePlanEnum {

    蓝牙定位方案("bluetooth", 1), RFID定位方案("rfid", 2);

    public final int showNumber;
    private String code;

    LocatePlanEnum(String code, int showNumber) {
        this.code = code;
        this.showNumber = showNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
