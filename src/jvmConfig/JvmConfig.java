package jvmConfig;

public class JvmConfig {

    /*
    关键的三个参数的说明
    1、 -Xms 是最小启动内存参数
    2、 -Xmx 是最大运行内存参数
    3、-XX:ReservedCodeCacheSize 保留代码占用的内存容量参数


    一、电脑运行内存为8G的建议
    -server
    -Xms512m
    -Xmx1024m
    -XX:ReservedCodeCacheSize=300m
    -XX:+UseConcMarkSweepGC
    -XX:SoftRefLRUPolicyMSPerMB=50
    -ea
    -Dsun.io.useCanonCaches=false
    -Djava.net.preferIPv4Stack=true
    -Djdk.http.auth.tunneling.disabledSchemes=""
    -XX:+HeapDumpOnOutOfMemoryError
    -XX:-OmitStackTraceInFastThrow


    二、电脑运行内存为16G的建议
    -server
    -Xms1024m
    -Xmx2048m
    -XX:ReservedCodeCacheSize=500m
    -XX:+UseConcMarkSweepGC
    -XX:SoftRefLRUPolicyMSPerMB=50
    -ea
    -Dsun.io.useCanonCaches=false
    -Djava.net.preferIPv4Stack=true
    -Djdk.http.auth.tunneling.disabledSchemes=""
    -XX:+HeapDumpOnOutOfMemoryError
    -XX:-OmitStackTraceInFastThrow
     */
    public static void main(String[] args) {

    }
}
