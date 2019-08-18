package zhiwendemo;

public class ZhiWenClient {

    public static void main(String[] args) {

        /*byte[] bytes = new byte[8];
        System.out.println(bytes);

        //byte[] arr = new byte[]{00010110,  01010010,  10111000};
        byte[] arr1 = {0x16,      0x52,      0x28};
        byte[] arr2 = {22,        82,        124};*/

        //RfidDemo rfidDemo = new RfidDemo();
        ZhiWenHandler rfidHandler = new ZhiWenHandler();
        rfidHandler.start();


    }
}
