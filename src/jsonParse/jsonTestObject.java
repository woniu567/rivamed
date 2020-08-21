package jsonParse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class jsonTestObject {

    public static void main(String[] args) {

    }

    public void readFile(){
        try {
            String jsonString = FileUtil.readFile(getRobotFilePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRobotFilePath(){
        String robotdir = FileUtil.getFilePath();
        robotdir = robotdir+File.separator + "File" + File.separator;
        robotdir = robotdir + "robotFile.txt";
        FileUtil.createFile(robotdir);
        return robotdir;
    }

    public String addJson(String jsonString,RobotVo rVo){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String jsonStr = jsonObject.getString("publishedRobots");
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObj.getJSONArray("robot");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject robotObject = jsonArray.getJSONObject(i);
                RobotVo robotVo = new RobotVo(robotObject);
                if (robotVo.getRobotCode().equals(rVo.getRobotCode())){
                    jsonArray.put(rVo);
                }
            }
            return jsonStr;
        } catch (JSONException e) {
            String string = org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e);
            return "";
        }
    }
}
