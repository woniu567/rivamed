package regex;

import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

    }

    //验证文件名字1
    public static boolean isValidFileName1(String fileName) {
        if (fileName == null || fileName.length() > 255)
            return false;
        else {
            String regular = "^\\s\\\\/:\\*\\?\\\"<>\\|[^\\s\\\\/:\\\\?\\\"<>\\|\\.]$";
            return Pattern.matches(regular, fileName);
        }
    }

    //验证文件名字2
    public static boolean isValidFileName2(String fileName) {
        if (fileName == null || fileName.length() > 255) {
            return false;
        } else{
            return fileName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
        }
    }

    public Boolean checkFilePath() {
        String filePath = "C:\\rivamed\\log.out";
        //String regularExpression = "^(?<path>(?:[a-zA-Z]:)?\\\\(?:[^\\\\\\?\\/\\*\\|<>:\"]+\\\\)+)(?<filename>(?<name>[^\\\\\\?\\/\\*\\|<>:\"]+?)\\.(?<ext>[^.\\\\\\?\\/\\*\\|<>:\"]+))$";
        String regularExpression = "^(?<path>(?:[c-fC-F]:)?\\\\(?:[^\\\\\\?\\/\\*\\|<>:\"]+\\\\)+)(?<filename>(?<name>[^\\\\\\?\\/\\*\\|<>:\"]+?)\\.(?<ext>[^.\\\\\\?\\/\\*\\|<>:\"]+))$";
        //String regularExpression = "^\\s\\\\/:\\*\\?\\\"<>\\|[^\\s\\\\/:\\\\?\\\"<>\\|\\.]$";
		/*Pattern pattern = Pattern.compile(regularExpression);
		Matcher m = pattern.matcher(filePath);
		if (!m.find()) {
			logger.info("文件路径格式错误!");
		}
		logger.info(m.group(1));*/
        Boolean isMatched = Pattern.matches(regularExpression, filePath);
        //logger.info(filePath + "..." + pattern.pattern() + "...." + isMatched);
        return isMatched;
    }
}
