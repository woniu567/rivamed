package string_date;

import java.util.Date;

/*
���ں��¼��ַ�����ʽ��
�ڳ�������о�����Ҫ��ʾʱ������ڣ���������ʾ�� ��ʽ�����������⣬��Ҫ��д�����Ĵ��뾭�������㷨�ŵõ������������ʱ���ʽ��
�ַ�����ʽ�л���%txת����û����ϸ���ܣ�����ר��������ʽ�����ں�ʱ ��ġ�%txת�����е�x��������Ĵ������ں�ʱ���ʽ��ת������
���ǵ�����ܹ������ں�ʱ���ʽ���ɶ��ָ�ʽ��

�������ں�ʱ����ϵĸ�ʽ����ͼ��ʾ��

       ת  ��  ��				˵    ��						ʾ    ��

     c				����ȫ�����ں�ʱ����Ϣ				  ������ ʮ�� 27 14:21:20 CST 2007

     F				����-��-�ա���ʽ					  2007-10-27

     D				����/��/�ꡱ��ʽ					  10/27/07
 
     r				��HH:MM:SS PM����ʽ��12ʱ�ƣ�		  02:25:51 ����

     T				��HH:MM:SS����ʽ��24ʱ�ƣ�		  14:28:16

     R				��HH:MM����ʽ��24ʱ�ƣ�			  14:28
 */
public class StringDate {
	
	public static void main(String[] args) {  
	    Date date=new Date();                                  
	    //c��ʹ��  
	    System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);          
	    //f��ʹ��  
	    System.out.printf("��-��-�ո�ʽ��%tF%n",date);  
	    //d��ʹ��  
	    System.out.printf("��/��/���ʽ��%tD%n",date);  
	    //r��ʹ��  
	    System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);  
	    //t��ʹ��  
	    System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);  
	    //R��ʹ��  
	    System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date);  
	}  

}
