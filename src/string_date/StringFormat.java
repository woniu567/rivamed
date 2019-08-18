package string_date;

/*
搭配转换符的标志

标    志			说    明					示    例					结    果

  +		       为正数或者负数添加符号		 	("%+d",15)					+15

  −			         左对齐				 	("%-5d",15)					|15   |

  0			 数字前面补0			 	("%04d", 99)				0099

   空格		  在整数之前添加指定数量的空格		 	("% 4d", 99)				|  99|

  ,		             以“,”对数字分组			 	("%,f", 9999.99)			9,999.990000

  (		          使用括号包含负数			 	("%(f", -99.99)				(99.990000)

  #	               如果是浮点数则包含小数点，			("%#x", 99)					0x63
	 	   如果是16进制或8进制则添加0x或0		("%#o", 99)					0143

  < 	 格式化前一个转换符所描述的参数	 	("%f和%<3.2f", 99.45)		99.450000和99.45

  $		           被格式化的参数索引			("%1$d,%2$s", 99,"abc")		99,abc

 * */
public class StringFormat {
	
	public static void main(String[] args) {  
	    String str=null;  
	    //$使用  
	    str=String.format("格式参数$的使用：%1$d,%2$s", 99,"abc");             
	    System.out.println(str);                       
	    //+使用  
	    System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);  
	    //补O使用  
	    System.out.printf("最牛的编号是：%03d%n", 7);  
	    //空格使用  
	    System.out.printf("Tab键的效果是：% 8d%n", 7);  
	    //.使用  
	    System.out.printf("整数分组的效果是：%,d%n", 9989997);  
	    //空格和小数点后面个数  
	    System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);  
	}  

}
