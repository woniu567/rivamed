package string_date;

import java.util.Date;

/*
日期和事件字符串格式化
在程序界面中经常需要显示时间和日期，但是其显示的 格式经常不尽人意，需要编写大量的代码经过各种算法才得到理想的日期与时间格式。
字符串格式中还有%tx转换符没有详细介绍，它是专门用来格式化日期和时 间的。%tx转换符中的x代表另外的处理日期和时间格式的转换符，
它们的组合能够将日期和时间格式化成多种格式。

常见日期和时间组合的格式，如图所示。

       转  换  符				说    明						示    例

     c				包括全部日期和时间信息				  星期六 十月 27 14:21:20 CST 2007

     F				“年-月-日”格式					  2007-10-27

     D				“月/日/年”格式					  10/27/07
 
     r				“HH:MM:SS PM”格式（12时制）		  02:25:51 下午

     T				“HH:MM:SS”格式（24时制）		  14:28:16

     R				“HH:MM”格式（24时制）			  14:28
 */
public class StringDate {
	
	public static void main(String[] args) {  
	    Date date=new Date();                                  
	    //c的使用  
	    System.out.printf("全部日期和时间信息：%tc%n",date);          
	    //f的使用  
	    System.out.printf("年-月-日格式：%tF%n",date);  
	    //d的使用  
	    System.out.printf("月/日/年格式：%tD%n",date);  
	    //r的使用  
	    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
	    //t的使用  
	    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
	    //R的使用  
	    System.out.printf("HH:MM格式（24时制）：%tR",date);  
	}  

}
