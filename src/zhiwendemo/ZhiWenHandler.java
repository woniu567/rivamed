package zhiwendemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ZhiWenHandler {


    private boolean running=false;
    private long lastSendTime;
    private static Socket socket;

    ServerSocket ss;
    {
        try {
            ss = new ServerSocket(40003);
            socket = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ZhiWenHandler(){}

    public void start(){
        if(running)
            return;
        //System.out.println("本地端口："+socket.getLocalPort());
        lastSendTime=System.currentTimeMillis();
        running=true;
        new Thread(new ZhiWenHandler.KeepAliveWatchDog()).start();

    }

    class KeepAliveWatchDog implements Runnable{

        long checkDelay = 10;
        long keepAliveDelay = 2000;

        public void run() {
            while(running){
                if(System.currentTimeMillis()-lastSendTime>keepAliveDelay){
                    try {
                        try {
                            ZhiWenHandler.this.startReader();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ZhiWenHandler.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                }else{
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        ZhiWenHandler.this.stop();
                    }
                }
            }
        }
    }


    private static short CalcChkSumOfPkt(byte[] pDataPkt, int nSize)
    {
        int     i, nChkSum = 0;

        for(i=0;i<nSize;i++)
        {
            if ((int)pDataPkt[i] < 0)
                nChkSum = nChkSum + ((int)pDataPkt[i] + 256);
            else
                nChkSum = nChkSum + pDataPkt[i];
        }

        return (short)nChkSum;
    }


    public void startReader() throws Exception{

        //02 08 B0 00 00 00 00 45
        /*byte[] buf = new byte[8];
        buf[0] = (byte) 0x02;
        buf[1] = (byte)0x08;
        buf[2] = (byte)0xB0;
        buf[3] = (byte) 0x00;
        buf[4] = (byte) 0x00;
        buf[5] = (byte) 0x00;
        buf[6] = (byte) 0x00;
        CheckSum(buf,(byte) buf.length);



        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buf);*/

        //测试指纹仪连接55 AA 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01
        byte[] bytes = new byte[26];
        bytes[0] = (byte)0x55;
        bytes[1] = (byte)0xAA;
        bytes[2] = (byte)0x01;
        bytes[3] = (byte)0x01;
        bytes[4] = (byte)0x01;
        bytes[5] = (byte)0x00;
        bytes[6] = (byte)0x00;
        bytes[7] = (byte)0x00;
        bytes[8] = (byte)0x00;
        bytes[9] = (byte)0x00;
        bytes[10] = (byte)0x00;
        bytes[11] = (byte)0x00;
        bytes[12] = (byte)0x00;
        bytes[13] = (byte)0x00;
        bytes[14] = (byte)0x00;
        bytes[15] = (byte)0x00;
        bytes[16] = (byte)0x00;
        bytes[17] = (byte)0x00;
        bytes[18] = (byte)0x00;
        bytes[19] = (byte)0x00;
        bytes[20] = (byte)0x00;
        bytes[21] = (byte)0x00;
        bytes[22] = (byte)0x00;
        bytes[23] = (byte)0x00;
        bytes[24] = (byte)0x02;
        bytes[25] = (byte)0x01;
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);


        //获取指纹仪设备ID55 AA 01 01 03 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 05 01


        InputStream in = socket.getInputStream();
        System.out.println(in.available());
        if (in.available() == 0){
            System.out.println("null");
        }else {
            byte[] by = new byte[26];
            in.read(by);
            //CheckSum(bytes,(byte)12);
            String str = toHex(by);
            //String[] str1 = str.split("");
            //ttoString(str1);
            System.out.println(str);
        }



        /*byte[] by2 = new byte[17];
        in.read(by2);
        String str2 = toHex(by2);
        String[] str4 = str2.split("");
        String[] str5 = new String[getInt(str4)];
        System.arraycopy(str4,0,str5,0,getInt(str4));
        if(getInt(str4)>3)
            System.out.println(ttoString(str5));
        set = new HashSet();
        set.add(ttoString(str5));
        list = new ArrayList(set);
        System.out.println(list);*/
    }

    public static void CheckSum(byte[] buf, byte len)
    {
        byte i;
        byte checksum;
        checksum = 0;
        for (i = 0; i < (len - 1); i++)
        {
            checksum ^= buf[i];
        }
        buf[len - 1] = (byte)~checksum;
    }

    private void SendGetId()
    {
        byte[]	w_abyData = new byte[1];
        w_abyData[0] = (byte)0;//0代表获取设备ID
        //InitCmdPacket(CMD_GET_PARAM, m_bySrcDeviceID, m_byDstDeviceID, w_abyData, (short)1);
        byte[] buf =DataProtocolIDWD1019.InitCmdPacket(DataProtocolIDWD1019.CMD_GET_PARAM,w_abyData,(short)1);
        //SendBuf(buf);
    }

    static class DataProtocolIDWD1019{

        //源标识（1byte） Soruce Device ID；目标标识（1byte） Destination Device ID
        public static byte		m_bySrcDeviceID = 1, m_byDstDeviceID = 1;

        /***************************************************************************/
        /***************************************************************************/
        private static final int CMD_PREFIX_CODE		= 0xAA55;
        private static final int CMD_DATA_PREFIX_CODE	= 0xA55A;
        private static final int RCM_PREFIX_CODE		= 0x55AA;
        private static final int RCM_DATA_PREFIX_CODE	= 0x5AA5;

        /***************************************************************************
         * System Code (0x0000 ~ 0x001F, 0x0000 : Reserved)
         ***************************************************************************/
        private static final short CMD_TEST_CONNECTION		= 0x0001;
        private static final short CMD_SET_PARAM			= 0x0002;
        private static final short CMD_GET_PARAM			= 0x0003;
        private static final short CMD_GET_DEVICE_INFO		= 0x0004;
        private static final short CMD_ENTER_ISPMODE		= 0x0005;
        private static final short CMD_SET_ID_NOTE			= 0x0006;
        private static final short CMD_GET_ID_NOTE			= 0x0007;
        private static final short CMD_SET_MODULE_SN		= 0x0008;
        private static final short CMD_GET_MODULE_SN		= 0x0009;

        /***************************************************************************
         * Sensor Code (0x0020 ~ 0x003F)
         ***************************************************************************/
        private static final short CMD_GET_IMAGE			= 0x0020;
        private static final short CMD_FINGER_DETECT		= 0x0021;
        private static final short CMD_UP_IMAGE				= 0x0022;
        private static final short CMD_DOWN_IMAGE			= 0x0023;
        private static final short CMD_SLED_CTRL			= 0x0024;

        /***************************************************************************
         * Template Code (0x0040 ~ 0x005F)
         ***************************************************************************/
        private static final short CMD_STORE_CHAR			= 0x0040;
        private static final short CMD_LOAD_CHAR			= 0x0041;
        private static final short CMD_UP_CHAR				= 0x0042;
        private static final short CMD_DOWN_CHAR			= 0x0043;
        private static final short CMD_DEL_CHAR				= 0x0044;
        private static final short CMD_GET_EMPTY_ID			= 0x0045;
        private static final short CMD_GET_STATUS			= 0x0046;
        private static final short CMD_GET_BROKEN_ID		= 0x0047;
        private static final short CMD_GET_ENROLL_COUNT		= 0x0048;

        /***************************************************************************
         * FingerPrint Alagorithm Code (0x0060 ~ 0x007F)
         ***************************************************************************/
        private static final short CMD_GENERATE				= 0x0060;
        private static final short CMD_MERGE				= 0x0061;
        private static final short CMD_MATCH				= 0x0062;
        private static final short CMD_SEARCH				= 0x0063;
        private static final short CMD_VERIFY				= 0x0064;

        /***************************************************************************
         * Unknown Command
         ***************************************************************************/
        private static final short RCM_INCORRECT_COMMAND	= 0x00FF;

        /***************************************************************************
         * Error Code
         ***************************************************************************/
        public static final int ERR_SUCCESS				= 0;
        public static final int ERR_FAIL				= 1;
        public static final int ERR_CONNECTION			= 2;
        public static final int ERR_VERIFY				= 0x10;
        public static final int ERR_IDENTIFY			= 0x11;
        public static final int ERR_TMPL_EMPTY			= 0x12;
        public static final int ERR_TMPL_NOT_EMPTY		= 0x13;
        public static final int ERR_ALL_TMPL_EMPTY		= 0x14;
        public static final int ERR_EMPTY_ID_NOEXIST	= 0x15;
        public static final int ERR_BROKEN_ID_NOEXIST	= 0x16;
        public static final int ERR_INVALID_TMPL_DATA	= 0x17;
        public static final int ERR_DUPLICATION_ID		= 0x18;
        public static final int ERR_BAD_QUALITY			= 0x19;
        public static final int ERR_MERGE_FAIL			= 0x1A;
        public static final int ERR_NOT_AUTHORIZED		= 0x1B;
        public static final int ERR_MEMORY				= 0x1C;
        public static final int ERR_INVALID_TMPL_NO		= 0x1D;
        public static final int ERR_INVALID_PARAM		= 0x22;
        public static final int ERR_GEN_COUNT			= 0x25;
        public static final int ERR_INVALID_BUFFER_ID	= 0x26;
        public static final int ERR_INVALID_OPERATION_MODE	= 0x27;
        public static final int ERR_FP_NOT_DETECTED		= 0x28;

        /***************************************************************************
         * Make Command Packet
         ***************************************************************************/

        public static byte[] InitCmdPacket(short wCMDCode, byte[] pbyData, int nDataLen)
        {
            byte[]	m_abyPacket = new byte[64 * 1024];

            short	w_wCheckSum;
            int CMD_PREFIX_CODE		= 0xAA55;//头部
            int CMD_PACKET_LEN			= 26;//长度

            Arrays.fill(m_abyPacket, 0, CMD_PACKET_LEN, (byte)0);
            //g_pCmdPacket->m_wPrefix = CMD_PREFIX_CODE;
            m_abyPacket[0] = (byte)(CMD_PREFIX_CODE & 0xFF);
            m_abyPacket[1] = (byte)((CMD_PREFIX_CODE >> 8) & 0xFF);

            //g_pCmdPacket->m_bySrcDeviceID = p_bySrcDeviceID;
            m_abyPacket[2] = m_bySrcDeviceID;

            //g_pCmdPacket->m_byDstDeviceID = p_byDstDeviceID;
            m_abyPacket[3] = m_byDstDeviceID;

            //g_pCmdPacket->m_wCMDCode = p_wCMDCode;
            m_abyPacket[4] = (byte)(wCMDCode & 0xFF);
            m_abyPacket[5] = (byte)((wCMDCode >> 8) & 0xFF);

            //g_pCmdPacket->m_wDataLen = p_wDataLen;
            m_abyPacket[6] = (byte)(nDataLen & 0xFF);
            m_abyPacket[7] = (byte)((nDataLen >> 8) & 0xFF);

            if (nDataLen > 0)
                //memcpy(g_pCmdPacket->m_abyData, p_pbyData, wDataLen);
                System.arraycopy(pbyData, 0, m_abyPacket, 8, nDataLen);

            w_wCheckSum = CalcChkSumOfPkt(m_abyPacket, CMD_PACKET_LEN-2);

            //g_pCmdPacket->m_wCheckSum = w_wCheckSum;
            m_abyPacket[24] = (byte)(w_wCheckSum & 0xFF);
            m_abyPacket[25] = (byte)((w_wCheckSum >> 8) & 0xFF);

            byte[] rebyte = new byte[CMD_PACKET_LEN];
            System.arraycopy(m_abyPacket,0, rebyte,0, CMD_PACKET_LEN);
            return rebyte;
        }

        /***************************************************************************
         * Get 2bytes packet checksum(pDataPkt[0] + pDataPkt[1] + ....)
         ***************************************************************************/
        private static short CalcChkSumOfPkt(byte[] pDataPkt, int nSize)
        {
            int     i, nChkSum = 0;

            for(i=0;i<nSize;i++)
            {
                if ((int)pDataPkt[i] < 0)
                    nChkSum = nChkSum + ((int)pDataPkt[i] + 256);
                else
                    nChkSum = nChkSum + pDataPkt[i];
            }

            return (short)nChkSum;
        }
    }

    private static String toHex(byte[] result) {
        StringBuffer sb = new StringBuffer(result.length * 2);
        for (int i = 0; i < result.length; i++) {
            sb.append(Character.forDigit((result[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(result[i] & 15, 16));
        }
        return sb.toString();
    }

    public static int transfer(String[] strings){

        return Integer.parseInt(strings[3],16);
    }

    public static String ttoString(String[] sts){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sts.length; i++) {
            sb.append(sts[i]);
        }
        return sb.toString();
    }

    public static int getInt(String[] str){
        int a = Integer.parseInt(str[3],16);
        return 4+a*2;
    }

    public void stop(){
        if(running)
            running=false;
    }
}
