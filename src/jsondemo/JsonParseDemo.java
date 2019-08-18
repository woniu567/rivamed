package jsondemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParseDemo {

    public static void main(String[] args) {

        String jstring = "{'name':'张三','age':'33'}";

        JSONObject object = null;//通过一个具有json格式的字符串就可以创建一个json对象
        try {
            object = new JSONObject(jstring);

            //获取json对象之后 就可以通过key 去取值 根据需求选择相关的getXXXX方法
            //可以获取的数据类型  string int long double boolean object
            String name = object.getString("name");
            int age = object.getInt("age");
            System.out.println("名字:"+name+"; age:"+age);

            String jsonArray = "[{'name':'张三','age':'20'},{'name':'李四','age':'35'}]";
            JSONArray array = new JSONArray(jsonArray);//根据一个具有json数组格式的字符串 创建一个json数组对象
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                name = jsonObject.getString("name");
                age = jsonObject.getInt("age");
                System.out.println("名字:"+name+"; age:"+age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
