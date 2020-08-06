package listsort;

import java.util.*;

public class ComplexSort {

    public static void main(String[] args) {


    }

    public static void sortMyUserHistoryList(List<AppUserhistoryinfoEntity> UserHistorylst) {
        Collections.sort(UserHistorylst, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                AppUserhistoryinfoEntity a0 = (AppUserhistoryinfoEntity) arg0;
                AppUserhistoryinfoEntity a1 = (AppUserhistoryinfoEntity) arg1;
                int result = 0;
                // 按照服务时间排序，如果服务时间相同则以创建时间排序
                if (a0.getWork_time() != null && a1.getWork_time() != null && a0.getTime() != null && a1.getTime() != null) {
                    if (a1.getWork_time().compareTo(a0.getWork_time()) == 0) {
                        result = a1.getTime().compareTo(a0.getTime());
                    } else {
                        result = a1.getWork_time().compareTo(a0.getWork_time());
                    }
                } else {
                    result = a1.getTime().compareTo(a0.getTime());
                }
                return result;
            }
        });
    }

    public static void sortMethod(){
        List<Map> dataList = new ArrayList<>();
        Map dataItem;// 数据库中查询到的每条记录zhi
        Map<String, List<Map>> resultMap = new HashMap<String, List<Map>>();// 最终要的结果dao
        for(int i=0;i<dataList.size();i++) {
            dataItem = dataList.get(i);
            if (resultMap.containsKey(dataItem.get("merohant_id"))) {
                resultMap.get(dataItem.get("merohant_id")).add(dataItem);
            } else {
                List<Map> list = new ArrayList<Map>();
                list.add(dataItem);
                //resultMap.put(dataItem.get("merohant_id"),list);
            }
        }
    }
}
