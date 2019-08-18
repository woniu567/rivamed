package demo;

public class CRCDemo {

    public static void main(String[] args) {

        byte[] buf = new byte[10];
        buf[0] = (byte) 0xFC;
        buf[1] = (byte) 0xFC;
        buf[2] = (byte) 0x01;
        buf[3] = (byte) 0x00;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        buf[7] = (byte) 0x00;
        buf[8] = (byte) 0x00;
        buf[9] = (byte) 0x00;
        byte[] check = calcCRC(buf);
        System.out.println(TransferUtils.Byte2String(check));
    }

    static byte[] calcCRC(byte[] buf) {
        int crcReg = 0xffff;
        boolean flag = true;
        for (byte b : buf) {
            int dcdBitMask = 0x80;
            if (flag) {
                flag = false;
                continue;
            }
            for (int i = 0; i < 8; i++) {
                boolean bit1 = ((crcReg >> 15 & 1) == 1);
                crcReg = crcReg * 2;
                crcReg = crcReg & 0xffff;
                if (((b & dcdBitMask) == dcdBitMask)) {
                    crcReg |= 1;
                }
                if (bit1) {
                    crcReg = crcReg ^ 0x1021;
                }
                dcdBitMask = dcdBitMask / 2;
            }
        }
        return intToU16Bytes(crcReg);
    }

    /**
     * 将int转成byte【】
     *
     * @param i int 值
     * @return byte素组
     */
    private static byte[] intToU16Bytes(int i) {
        i &= 0xffff;
        byte[] ret = new byte[]{0x00, 0x00};
        ret[0] = (byte) ((i / 256) & 0xff);
        ret[1] = (byte) ((i % 256) & 0xff);
        return ret;
    }
}
