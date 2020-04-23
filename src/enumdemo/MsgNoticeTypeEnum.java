package enumdemo;

import java.util.List;

public enum MsgNoticeTypeEnum {

    无法定位资产报警("01"),
    未知区域资产报警("02"),
    电子围栏进入报警("11"),
    电子围栏离开报警("12"),
    维修报警("3");

    private String typeCode;

    MsgNoticeTypeEnum(String typeCode) {
        this.typeCode = typeCode;
    }

    public static MsgNoticeTypeEnum getByCode(String typeCode){
        MsgNoticeTypeEnum[] mntes = MsgNoticeTypeEnum.values();
        for (MsgNoticeTypeEnum mnte:mntes){
            if (mnte.getTypeCode().equals(typeCode)){
                return mnte;
            }
        }
        return null;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
