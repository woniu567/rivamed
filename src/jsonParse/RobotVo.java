package jsonParse;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RobotVo {

    private String id;

    //机器人编号
    private String robotCode;

    //机器人名称
    private String robotName;

    //机器人类型名称
    private String robotTypeName;

    //机器人类型编码
    private String robotTypeCode;

    //机器人工作类别
    private String workTypeName;

    //机器人工作类型编码
    private String workTypeCode;

    //科室名称（服务站点/消毒区域）
    private List<String> departName;

    //科室名称编码（服务站点/消毒区域）
    private List<String> departCodes;

    //服务站点（仅前端条件查询时用）
    private String siteName;

    //机器人启用状态编码
    private String useStatusCode;

    //机器人状态(启用)
    private String useStatusName;

    //设备序列号
    private String serial;

    //机器人mac地址
    private String mac;

    //机器人IP地址
    private String ip;

    //机器人激光雷达高度
    private String laserTypeCode;

    //激光雷达高度
    private String laserTypeName;

    //停靠站点
    private String stopPointCodes;

    //充电站点
    private String chargePointCodes;

    //运行速度
    //高速
    private String velHigh;

    //正常速度
    private String velNormal;

    //低速
    private String velLow;

    //倒车速度
    private String velBack;

    //转弯速度
    private String velTurn;

    //电量管理
    //满电量值
    private String batteryFull;

    //空闲充电值
    private String batteryFree;

    //强制充电值
    private String batteryForce;

    //最低充电值
    private String batteryLow;

    //自动充电值
    private String batteryShutdown;

    //物料卸载方式
    private String carLoadModeName;

    private String relatedDeparts;

    //服务站点、消毒区域编码
    private String relatedDepartCodes;

    //机器人启用、上线时间
    private Date beginUseTime;

    //过氧化氢补充站点编号(多站点用,分割)
    private String perhydrolPointCodes;

    //机器人状态
    private String robotStatus;
    
    private long standByTime;//单位毫秒

    public RobotVo(){

    }

    public RobotVo(String robotCode){
        this.robotCode = robotCode;
    }

    public RobotVo(JSONObject jsonObject){
        try {
            this.id = jsonObject.getString("id");
            this.robotCode = jsonObject.getString("robotCode");
            this.robotName = jsonObject.getString("robotName");
            this.robotTypeName = jsonObject.getString("robotTypeName");
            this.workTypeName = jsonObject.getString("workTypeName");
            this.useStatusCode = jsonObject.getString("useStatusCode");
            this.useStatusName = jsonObject.getString("useStatusName");
            this.serial = jsonObject.getString("serial");
            this.mac = jsonObject.getString("mac");
            this.ip = jsonObject.getString("ip");
            this.laserTypeCode = jsonObject.getString("laserTypeCode");
            this.laserTypeName = jsonObject.getString("laserTypeName");
            this.stopPointCodes = jsonObject.getString("stopPointCodes");
            this.chargePointCodes = jsonObject.getString("chargePointCodes");
            this.velHigh = jsonObject.getString("velHigh");
            this.velNormal = jsonObject.getString("velNormal");
            this.velLow  = jsonObject.getString("velLow");
            this.velBack  = jsonObject.getString("velBack");
            this.velTurn  = jsonObject.getString("velTurn");
            this.batteryFull  = jsonObject.getString("batteryFull");
            this.batteryFree  = jsonObject.getString("batteryFree");
            this.batteryForce  = jsonObject.getString("batteryForce");
            this.batteryLow  = jsonObject.getString("batteryLow");
            this.batteryShutdown  = jsonObject.getString("batteryShutdown");
            this.carLoadModeName  = jsonObject.getString("carLoadModeName");
            this.robotTypeCode = jsonObject.getString("robotTypeCode");
            this.workTypeCode = jsonObject.getString("workTypeCode");
            this.relatedDeparts = jsonObject.getString("relatedDeparts");
            this.robotStatus = "";
            try {
                this.beginUseTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jsonObject.getString("beginUseTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.perhydrolPointCodes = jsonObject.getString("perhydrolPointCodes");
            this.relatedDepartCodes = jsonObject.getString("relatedDepartCodes");
           
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getRobotCode() {
        return robotCode;
    }

    public void setRobotCode(String robotCode) {
        this.robotCode = robotCode;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public String getRobotTypeName() {
        return robotTypeName;
    }

    public void setRobotTypeName(String robotTypeName) {
        this.robotTypeName = robotTypeName;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getUseStatusName() {
        return useStatusName;
    }

    public void setUseStatusName(String useStatusName) {
        this.useStatusName = useStatusName;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStopPointCodes() {
        return stopPointCodes;
    }

    public void setStopPointCodes(String stopPointCodes) {
        this.stopPointCodes = stopPointCodes;
    }

    public String getChargePointCodes() {
        return chargePointCodes;
    }

    public void setChargePointCodes(String chargePointCodes) {
        this.chargePointCodes = chargePointCodes;
    }

    public String getVelHigh() {
        return velHigh;
    }

    public void setVelHigh(String velHigh) {
        this.velHigh = velHigh;
    }

    public String getVelNormal() {
        return velNormal;
    }

    public void setVelNormal(String velNormal) {
        this.velNormal = velNormal;
    }

    public String getVelLow() {
        return velLow;
    }

    public void setVelLow(String velLow) {
        this.velLow = velLow;
    }

    public String getVelBack() {
        return velBack;
    }

    public void setVelBack(String velBack) {
        this.velBack = velBack;
    }

    public String getVelTurn() {
        return velTurn;
    }

    public void setVelTurn(String velTurn) {
        this.velTurn = velTurn;
    }

    public String getBatteryFull() {
        return batteryFull;
    }

    public void setBatteryFull(String batteryFull) {
        this.batteryFull = batteryFull;
    }

    public String getBatteryFree() {
        return batteryFree;
    }

    public void setBatteryFree(String batteryFree) {
        this.batteryFree = batteryFree;
    }

    public String getBatteryForce() {
        return batteryForce;
    }

    public void setBatteryForce(String batteryForce) {
        this.batteryForce = batteryForce;
    }

    public String getBatteryLow() {
        return batteryLow;
    }

    public void setBatteryLow(String batteryLow) {
        this.batteryLow = batteryLow;
    }

    public String getBatteryShutdown() {
        return batteryShutdown;
    }

    public void setBatteryShutdown(String batteryShutdown) {
        this.batteryShutdown = batteryShutdown;
    }

    public String getCarLoadModeName() {
        return carLoadModeName;
    }

    public void setCarLoadModeName(String carLoadModeName) {
        this.carLoadModeName = carLoadModeName;
    }

    public List<String> getDepartName() {
        return departName;
    }

    public void setDepartName(List<String> departName) {
        this.departName = departName;
    }

    public String getLaserTypeCode() {
        return laserTypeCode;
    }

    public void setLaserTypeCode(String laserTypeCode) {
        this.laserTypeCode = laserTypeCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRobotTypeCode() {
        return robotTypeCode;
    }

    public void setRobotTypeCode(String robotTypeCode) {
        this.robotTypeCode = robotTypeCode;
    }

    public String getWorkTypeCode() {
        return workTypeCode;
    }

    public void setWorkTypeCode(String workTypeCode) {
        this.workTypeCode = workTypeCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLaserTypeName() {
        return laserTypeName;
    }

    public void setLaserTypeName(String laserTypeName) {
        this.laserTypeName = laserTypeName;
    }

    public String getRelatedDeparts() {
        return relatedDeparts;
    }

    public void setRelatedDeparts(String relatedDeparts) {
        this.relatedDeparts = relatedDeparts;
    }

    public Date getBeginUseTime() {
        return beginUseTime;
    }

    public void setBeginUseTime(Date beginUseTime) {
        this.beginUseTime = beginUseTime;
    }

    public String getPerhydrolPointCodes() {
        return perhydrolPointCodes;
    }

    public void setPerhydrolPointCodes(String perhydrolPointCodes) {
        this.perhydrolPointCodes = perhydrolPointCodes;
    }

    public String getRelatedDepartCodes() {
        return relatedDepartCodes;
    }

    public void setRelatedDepartCodes(String relatedDepartCodes) {
        this.relatedDepartCodes = relatedDepartCodes;
    }

    public List<String> getDepartCodes() {
        return departCodes;
    }

    public void setDepartCodes(List<String> departCodes) {
        this.departCodes = departCodes;
    }

    public String getRobotStatus() {
        return robotStatus;
    }

    public void setRobotStatus(String robotStatus) {
        this.robotStatus = robotStatus;
    }

    public String getUseStatusCode() {
        return useStatusCode;
    }

    public void setUseStatusCode(String useStatusCode) {
        this.useStatusCode = useStatusCode;
    }

	public long getStandByTime() {
		return standByTime;
	}

	public void setStandByTime(long standByTime) {
		this.standByTime = standByTime;
	}
}
