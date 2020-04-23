package enumdemo;

public enum ThingLocateRegionEnum {

    LOCATION_ABNORMAL("未知区域", 9000),
    LOCATION_UNABLE("无法定位", 9001);
    private String statusName;
    private int statusCode;

    private ThingLocateRegionEnum(String statusName, int statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }

    public static ThingLocateRegionEnum valueOf(int statusCode) {
        for (ThingLocateRegionEnum c : ThingLocateRegionEnum.values()) {
            if (c.getStatusCode() == statusCode) {
                return c;
            }
        }
        throw new IllegalArgumentException("No enum constant " + ThingLocateRegionEnum.class.getName());
    }

    @Override
    public String toString() {
        return String.valueOf(this.statusCode);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStrStatusCode() {
        return String.valueOf(statusCode);
    }

    public String getStatusName() {
        return statusName;
    }
}
