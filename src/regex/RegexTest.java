package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    因而决定使用正则表达式试试，表达式如下:

    ^(?<path>(?:[a-zA-Z]:)?\\(?:[^\\\?\/\*\|<>:"]+\\)+)(?<filename>(?<name>[^\\\?\/\*\|<>:"]+?)\.(?<ext>[^.\\\?\/\*\|<>:"]+))$

    下面解析下这个表达式
    ^                                               #匹配字符串的开始
    (?<path>                                        #文件路径分组，指定分组名为path
      (?:[a-zA-Z]:)?\\                              #匹配盘符,如"C:\"、"e:\"、"\"
        (?:[^\\\?\/\*\|<>:"]+\\)+                   #匹配文件夹名称部分,如"folder1\"、"folder1\folder2\"
    )                                               #文件路径分组结束
    (?<filename>                                    #文件名分组，指定分组名为filename
      (?<name>                                      #文件名分组，指定分组名为name
        [^\\\?\/\*\|<>:"]+?)                         #匹配文件名称，不包含字符'\'、'?'、'/'、'|'、'<'、'>'、':'、'"'
          \.                                        #匹配字符'.'
            (?<ext>[^.\\\?\/\*\|<>:"]+)             #匹配文件后缀名
    )
    $                                               #匹配字符串的结束
 */
public class RegexTest {

    public static void main(String[] args) {
        Boolean flag = regex();
        System.out.println(flag);
    }

    public static Boolean regex(){
        String filePath = "C:\\aaa\\bbb\\ab.txt";
        String regularExpression = "^(?<path>(?:[a-zA-Z]:)?\\\\(?:[^\\\\\\?\\/\\*\\|<>:\"]+\\\\)+)(?<filename>(?<name>[^\\\\\\?\\/\\*\\|<>:\"]+?)\\.(?<ext>[^.\\\\\\?\\/\\*\\|<>:\"]+))$";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher m = pattern.matcher(filePath);
        if (!m.find()) {
            System.out.println("文件路径格式错误!");
        }
        System.out.println(m.group(1));
        Boolean isMatched = Pattern.matches(regularExpression, filePath);
        System.out.println(filePath + "..." + pattern.pattern() + "...." + isMatched);
        return isMatched;
    }
}
