package demo;

/*
1、ps -ef | grep 9088
2、kill -9
3、cd /home/apache-tomcat-9.0.24-9088/
4、./bin/startup.sh
5、tail -f logs/catalina.out


./restart.sh启动文件问题：
进入到部署目录下，输入命令：
./restart.sh
如果出现./restart.sh没有权限，就在该目录下赋予权限，输入命令：
chmod 777 ./restart.sh    //赋予权限
tail -f nohup.out             //查看日志


su root:切换root 需要输入密码
配置文件生效命令：source /etc/profile
执行脚本：./restart.sh


停止war包命令:
ps -ef | grep java
kill -9 进程号


防火墙状态：systemctl status firewalld
关闭防火墙：systemctl stop firewalld


有的进程不好查，就用这种查询方式
[root@localhost ctm]# netstat -tunlp|grep 8001
tcp6       0      0 :::8001                 :::*                    LISTEN      5736/java
[root@localhost ctm]# kill -9 5736


windows下查看进程启用端口
netstat -ano|findstr "15100"
找到主进程，右键转到详细信息可以看到pid


59服务器eureka备份
defaultZone: http://192.168.111.59:8002/eureka/


已验证
解压war包： jar -xvf tm.war
压缩：jar -cvfM0 tm.war ./
运行：java -jar tm.war


压缩war包： jar -uvf0 ciis.war
java -jar tm.war


arthas执行成功的命令:
trace cn.rivamed.tm.sysmanage.dictionaryManage.dao.DictionaryDao findAll '#cost>5' -n 5



 */
public class Deploy部署命令 {
}
