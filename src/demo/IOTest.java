package demo;

import java.util.Arrays;

public class IOTest {

    public static void main(String[] args) {

        String A = "wew79894313asndfkw798ds";
        String[] aa = A.split("");
        getLongestPalindrome(aa, aa.length);
    }

    public static int getLongestPalindrome(String[] A, int n){
        int max=0,count=0;
        for(int i=0;i<n;i++) //i作为回文串的中心
        {
            for(int j=0;((i-j)>=0)&&((i+j)<n);j++)//若回文串是奇数个，i中心前面有j个,后面有j个
            {
                if(A[i-j]!=A[i+j])
                    break;
                count=j*2+1;
            }
            if(max<count)
                max=count;
            for(int j=0;((i-j)>=0)&&((i+1+j)<n);j++)//若回文串是偶数个，i和i+1是中心，前面有j个,后面有j个
            {
                if(A[i-j]!=A[i+1+j])
                    break;
                count=j*2+2;
            }
            if(max<count)
                max=count;
        }
        return max;
    }
}
