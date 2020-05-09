package enumdemo;

import java.util.HashSet;
import java.util.Set;

public class EnumTest {

    public static void main(String[] args) {

        EnumTest enumTest = new EnumTest();
        enumTest.enumMethod();
        System.out.println("---------------------------");
        enumTest.enumMethod2();
        System.out.println("---------------------------");
        enumTest.enumMethod3();
        System.out.println("---------------------------");
        enumTest.enumMethod4();

        System.out.println("---------------------------");
        WeekDay weekDay = WeekDay.FRI;
        System.out.println(weekDay.nextDay());

        System.out.println("---------------------------");
        enumTest.enumMethod6();
    }

    public void enumMethod(){
        String string = "质控提醒";
        MessageTypeEnum messageTypeEnum = MessageTypeEnum.typeNameOf(string);
        System.out.println(messageTypeEnum.getTypeName());

        String str = "thingUnLocated";
        MessageTypeEnum mte = MessageTypeEnum.valueOf(str);
        System.out.println(mte.getTypeName());
    }

    public void enumMethod2(){
        ExecuteRateEnum ere1 = ExecuteRateEnum.halfYear;
        System.out.println(ere1.getStatusName());
        System.out.println(ere1.getStatusCode());
        System.out.println("---------------------------");

        ExecuteRateEnum ere2 = ExecuteRateEnum.month;
        System.out.println(ere2.getStatusName());
        System.out.println(ere2.getStatusCode());
        System.out.println("---------------------------");

        ExecuteRateEnum ere3 = ExecuteRateEnum.week;
        System.out.println(ere3.getStatusName());
        System.out.println(ere3.getStatusCode());
        System.out.println("---------------------------");

        ExecuteRateEnum ere4 = ExecuteRateEnum.year;
        System.out.println(ere4.getStatusName());
        System.out.println(ere4.getStatusCode());
    }

    public void enumMethod3(){
        ThingLocateRegionEnum tlre1 = ThingLocateRegionEnum.LOCATION_ABNORMAL;
        System.out.println(tlre1.getStatusName());
        System.out.println(tlre1.getStatusCode());
        System.out.println("---------------------------");
        ThingLocateRegionEnum tlre2 = ThingLocateRegionEnum.LOCATION_UNABLE;
        System.out.println(tlre2.getStatusName());
        System.out.println(tlre2.getStatusCode());
        System.out.println("---------------------------");
        String string = "LOCATION_UNABLE";
        ThingLocateRegionEnum tlre3 = ThingLocateRegionEnum.valueOf(string);
        System.out.println(tlre3.getStatusName());
        int code = 9001;
        ThingLocateRegionEnum tlre4 = ThingLocateRegionEnum.valueOf(code);
        System.out.println(tlre4.getStatusName());
    }

    public void enumMethod4(){
        String string = "未知区域资产报警";
        MsgNoticeTypeEnum mnte = MsgNoticeTypeEnum.valueOf(string);
        System.out.println(mnte.getTypeCode());
    }

    public void enumMethod5(){
        MqInputConnEnum mice = MqInputConnEnum.记录仪流水;

    }

    public void enumMethod6(){

        Set<String> dbExistCodes = new HashSet<>();
        for (LocatePlanEnum type : LocatePlanEnum.values()) {
            // 数据库中不存在
            if (!dbExistCodes.contains(type.name())) {
                System.out.println(type.getCode());
                System.out.println(type.showNumber);
            }
        }
    }
}
