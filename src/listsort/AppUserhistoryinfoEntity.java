package listsort;

public class AppUserhistoryinfoEntity {

    private String work_time;

    private String time;

    public AppUserhistoryinfoEntity(){}

    public AppUserhistoryinfoEntity(String work_time,String time){
        this.work_time = work_time;
        this.time = time;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
