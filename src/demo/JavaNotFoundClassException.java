package demo;

/*
    报错了差哪个包，对应去找，感觉包导入了还报错，打开包的目录看看有不有那个类，没有就换别的版本看看，lang3与lang目录有改变，所以会有错误。
    json 共有6个jar包，

    以下是网上搜的，不想看可以忽略：
    如果有类似错误可以参考，版本不同，记得看下里面包名是否和报错信息对应的上。
     
    commons-beanutils-1.8.0.jar不加这个包
    java.lang.NoClassDefFoundError: org/apache/commons/beanutils/DynaBean
    commons-collections.jar 不加这个包
    java.lang.NoClassDefFoundError: org/apache/commons/collections/map/ListOrderedMap
    commons-lang-2.4.jar不加这个包
    java.lang.NoClassDefFoundError: org/apache/commons/lang/exception/NestableRuntimeException
    commons-logging-1.1.1.jar不加这个包
    java.lang.NoClassDefFoundError: org/apache/commons/logging/LogFactory
    ezmorph-1.0.4.jar不加这个包
    java.lang.NoClassDefFoundError: net/sf/ezmorph/Morpher
    json-lib-2.3-jdk15.jar不加这个包
    java.lang.NoClassDefFoundError: net/sf/json/JSONObject
    相应jar包可到网上下载，也可以用下面提供的！
 */
public class JavaNotFoundClassException {

    public static void main(String[] args) {

    }
}
