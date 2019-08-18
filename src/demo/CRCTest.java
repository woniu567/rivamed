package demo;

public class CRCTest {

    public static void main(String[] args) {

        byte[] buf = new byte[22];
        /*buf[0] = (byte) 0xFC;
        buf[1] = (byte) 0xFC;
        buf[2] = (byte) 0x07;
        buf[3] = (byte) 0x01;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        buf[7] = (byte) 0x01;
        buf[8] = (byte) 0x00;
        buf[9] = (byte) 0x0C;
        buf[10] = (byte) 0xCF;
        buf[11] = (byte) 0xBA;
        buf[12] = (byte) 0xCE;
        buf[13] = (byte) 0xAE;
        buf[14] = (byte) 0x0A;
        buf[15] = (byte) 0x1C;
        buf[16] = (byte) 0xD0;
        buf[17] = (byte) 0x12;
        buf[18] = (byte) 0x10;
        buf[19] = (byte) 0x33;
        buf[20] = (byte) 0x22;
        buf[21] = (byte) 0x01;*/

        byte[] bytes = new byte[12];

        //00 00 00 00 00 00 00

        buf[0] = (byte) 0xFC;
        buf[1] = (byte) 0xFC;
        buf[2] = (byte) 0x02;
        buf[3] = (byte) 0x00;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        buf[7] = (byte) 0x00;
        buf[8] = (byte) 0x00;
        buf[9] = (byte) 0x00;

        //byte[] check = crc16(buf);
        byte[] check = crc16(bytes);
        System.out.println(TransferUtils.Byte2String(check));
    }

    public static byte[] crc16(byte[] buf) {
        //*1,1000,0000,0000,0101B
        int crcGen = 0xa001;
        int crc = 0xffff;
        byte jc;
        for (byte b : buf) {
            crc ^= ((int) b & 0x00ff);
            for (jc = 0; jc < 8; jc++) {
                if ((crc & 0x0001) != 0) {
                    crc >>= 1;
                    crc ^= crcGen;
                } else {
                    crc >>= 1;
                }
            }
        }
        crc ^= 0xffff;
        return intToU16Bytes(crc);
    }

    /**
     * 将int转成byte[]
     *
     * @param i int 值
     * @return byte素组
     */
    private static byte[] intToU16Bytes(int i) {
        i &= 0xffff;
        byte[] ret = new byte[]{0x00, 0x00};
        System.out.println();
        ret[0] = (byte) ((i / 256) & 0xff);
        ret[1] = (byte) ((i % 256) & 0xff);
        return ret;
    }
}
