package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplit {

    private static List<String> listArray = new ArrayList<>();

    public static void main(String[] args) {

        /*StringBuffer strB = new StringBuffer();
        //目标字符串
        String str = ",A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
        //截取获得字符串数组
        String[] strArray = str.split(",");
        for (int i = 0; i < strArray.length; i++) {
            //System.out.println(i+":" + strArray[i]);
            System.out.println(strArray[i]);
            //其他操作
            if(strArray[i].equals("H")){
                strB = strB.append(strArray[i]);
            }else if(strArray[i].equals("I")){
                strB = strB.append(strArray[i]);
            }
        }
        System.out.println("result:" + strB);*/

        String str = "a,b,c,d,e,f,c,g";
        String[] string = str.split(",");
        //List<String> string = Arrays.asList(str.split(","));
        /*for (int i = 0; i < string.size(); i++) {
            //System.out.println(string[i]);
            if (!listArray.contains(string.get(i))){
                listArray.add(string.get(i));
            }
        }*/
        for (int i = 0; i < string.length; i++) {
            //System.out.println(string[i]);
            if (!listArray.contains(string[i])){
                listArray.add(string[i]);
            }
        }
        for (int i = 0; i < listArray.size(); i++) {
            System.out.print(listArray.get(i) + " ");
        }

        /*String s = "one, two, there, four";
        String[] as = s.split(", ");
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }*/

        /*String str = "one, two, there, four";
        String[] ary = str.split(",\\s+");
        for(String item: ary){
            System.out.println(item);
        }*/


        /*List<String> list = Arrays.asList(str.split(","));
        for (int i = 1; i < str.length(); i++){
            System.out.println(list.get(i));
        }*/

        /*String[] strArray = str.split(",");
        List<String> list = Arrays.asList(str.split(","));
        for(String s : list){
            System.out.println(s);
        }*/
    }
}
