package cn.rivamed;

public class DataProtocal {

    public static final byte BEGIN_SOF = (byte)0xaa;
    public static final byte CMD_INVENTORY = (byte)0x18;
    public static final byte LEN_1 = (byte)0x02;
    public static final byte LEN_2 = (byte)0x03;
    public static final byte CMD_UID = (byte)0x0a;
    public static final byte CMD_GET_STATUS = (byte)0x00; //查询RLM是否连接
    public static final byte CMD_STOP = (byte)0x12; //单步模式
    public static final byte END = (byte)0x55;

    /**
     *  sof / len / cmd / payload / crc16 / eof
     * ------------------------------------------
     *   1  /  1  / 1  /     n    /   2   /  1
     */

    public static byte[] PiceComment(byte cmd,byte[] data){

        byte[] buf = new byte[(data == null?0:data.length)+4];  //前3后1
        buf[0] = BEGIN_SOF;
        buf[1] = LEN_1;
        buf[2] = cmd;
        if(data!=null){
            System.arraycopy(data,0,buf,3,data.length);
        }

        return buf;
    }
}
