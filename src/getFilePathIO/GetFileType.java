package getFilePathIO;

import java.util.Arrays;
import java.util.List;

public class GetFileType {

    private static List<String> accTypes = Arrays.asList("jpg","bmp","gif","doc","docx","rar");
    public static void main(String[] args) {
        for (String arg:args){
            String type = getFileType(arg);
            if (accTypes.contains(type)){
                System.out.println(arg + "后缀合法!");
            }else {
                System.out.println(arg + "后缀不合法!");
            }
        }
    }

    /**
     * 获取文件名后缀
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName){
        int pos = fileName.lastIndexOf(".");
        if (pos == -1){
            return null;
        }
        return fileName.substring(pos+1);
    }
}
