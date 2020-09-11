package enumdemo;

public enum UseStateEnum {

    stop("停用"),
    start("启用");

    public final String value;

    UseStateEnum(String value){
        this.value = value;
    }

    public static UseStateEnum typeNameOf(String typeName) {
        for (UseStateEnum TypeEnum : UseStateEnum.values()) {
            if (TypeEnum.name().equals(typeName)) {
                return TypeEnum;
            }
        }
        return null;
    }
}
