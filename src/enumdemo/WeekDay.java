package enumdemo;

public enum WeekDay {

    //调用带参构造方法，匿名子类重写nextDay()方法
    SUN(1){
        public WeekDay nextDay() {
            return MON;
        }
    },
    MON(2){
        public WeekDay nextDay() {
            return TUE;
        }
    },
    TUE(3){
        public WeekDay nextDay() {
            return WED;
        }
    },
    WED(4){
        public WeekDay nextDay() {
            return THU;
        }
    },
    THU(5){
        public WeekDay nextDay() {
            return FRI;
        }
    },
    FRI(6){
        public WeekDay nextDay() {
            return SAT;
        }
    },
    SAT(7){
        public WeekDay nextDay() {
            return SUN;
        }
    };


    //星期索引，星期日为第一天
    private int index;
    //Constructor，必须为private
    private WeekDay(){ }

    private WeekDay(int index){
        this.index = index;
    }

    //获取下一天
    public abstract WeekDay nextDay();

    public String toString() {

        StringBuffer week = new StringBuffer();

        switch (index) {
            case 1:
                week.append("星期日");
                break;
            case 2:
                week.append("星期一");
                break;
            case 3:
                week.append("星期二");
                break;
            case 4:
                week.append("星期三");
                break;
            case 5:
                week.append("星期四");
                break;
            case 6:
                week.append("星期五");
                break;
            case 7:
                week.append("星期六");
                break;
        }

        return week.toString();
    }

}
