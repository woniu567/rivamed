package enumdemo;

public enum ExecuteRateEnum {

    week("每周"),
    month("每月"),
    halfYear("半年"),
    year("一年");

    private String statusName;
    private int statusCode;

    ExecuteRateEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
