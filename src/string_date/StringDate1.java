package string_date;

import java.util.Date;
import java.util.Locale;

/*
�������ڸ�ʽ��ת��������ʹ����ͨ��ָ����ת�����������ַ�������Щ����ת������ͼ��ʾ
 */
public class StringDate1 {
	
	public static void main(String[] args) {
		Date date=new Date();                                      
	    //b��ʹ�ã��·ݼ��  
	    String str=String.format(Locale.US,"Ӣ���·ݼ�ƣ�%tb",date);       
	    System.out.println(str);                                                                              
	    System.out.printf("�����·ݼ�ƣ�%tb%n",date); 
	    
	    //B��ʹ�ã��·�ȫ��  
	    str=String.format(Locale.US,"Ӣ���·�ȫ�ƣ�%tB",date);  
	    System.out.println(str);  
	    System.out.printf("�����·�ȫ�ƣ�%tB%n",date);  
	    
	    //a��ʹ�ã����ڼ��  
	    str=String.format(Locale.US,"Ӣ�����ڵļ�ƣ�%ta",date);  
	    System.out.println(str);  
	    
	    //A��ʹ�ã�����ȫ��  
	    System.out.printf("�������ڵļ�ƣ�%tA%n",date); 
	    
	    //C��ʹ�ã���ǰ��λ  
	    System.out.printf("���ǰ��λ���֣�������λǰ�油0����%tC%n",date);  
	    
	    //y��ʹ�ã������λ  
	    System.out.printf("��ĺ���λ���֣�������λǰ�油0����%ty%n",date); 
	    
	    //j��ʹ�ã�һ�������  
	    System.out.printf("һ���е�����������ĵڼ��죩��%tj%n",date);  
	    
	    //m��ʹ�ã��·�  
	    System.out.printf("��λ���ֵ��·ݣ�������λǰ�油0����%tm%n",date); 
	    
	    //d��ʹ�ã��գ���λ���������㣩  
	    System.out.printf("��λ���ֵ��գ�������λǰ�油0����%td%n",date);  
	    
	    //e��ʹ�ã��գ�һλ�����㣩  
	    System.out.printf("�·ݵ��գ�ǰ�治��0����%te",date);
	}  
	    
}
