package mynettynio.nettydemo.demo2;

import demo.TransferUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloWorldClientHandler extends ChannelInboundHandlerAdapter {

    private final String msg = "hello java world";


    /**
     * Creates a client-side handler.
     */
    public HelloWorldClientHandler() {
        //TODO
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(msg);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);

        if (!(msg instanceof ByteBuf)) {
            return;
        }
        //收到的所有数据都为ByteBuf类型，转换数据
        ByteBuf in = (ByteBuf) msg;
        if (in.isReadable()) {
            byte[] buf = new byte[in.readableBytes()];
            in.readBytes(buf);
            //转换数据为byte[]
            System.out.println("接收到消息:::" + TransferUtils.Byte2String(buf));
            //交给子类自己去解析数据
        }

        byte[] bytes = show();
        ctx.write(bytes);
        ctx.flush();
        //        ctx.write(msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    public static byte[] show(){
        byte[] buf = new byte[128];
        buf[0] = (byte)0xFC;
        buf[1] = (byte)0xFC;
        buf[2] = (byte)0x07;
        buf[3] = (byte)0x01;
        buf[4] = (byte)0x00;
        buf[5] = (byte)0x00;
        buf[6] = (byte)0x00;
        buf[7] = (byte)0x01;
        buf[8] = (byte)0x00;
        buf[9] = (byte)0x0C;
        buf[10] = (byte)0xCF;
        buf[11] = (byte)0xBA;
        buf[12] = (byte)0xCE;
        buf[13] = (byte)0xFC;
        buf[14] = (byte)0x0A;
        buf[15] = (byte)0x1C;
        buf[16] = (byte)0xD0;
        buf[17] = (byte)0x12;
        buf[18] = (byte)0x10;
        buf[19] = (byte)0x33;
        buf[20] = (byte)0x22;
        buf[21] = (byte)0x01;
        buf[22] = (byte)0x5E;
        buf[23] = (byte)0x69;

        buf[24] = (byte)0xFC;
        buf[25] = (byte)0xFC;
        buf[26] = (byte)0x07;
        buf[27] = (byte)0x01;
        buf[28] = (byte)0x00;
        buf[29] = (byte)0x00;
        buf[30] = (byte)0x00;
        buf[31] = (byte)0x01;
        buf[32] = (byte)0x00;
        buf[33] = (byte)0x0C;
        buf[34] = (byte)0xCF;
        buf[35] = (byte)0xBA;
        buf[36] = (byte)0xCE;
        buf[37] = (byte)0xFC;
        buf[38] = (byte)0x0A;
        buf[39] = (byte)0x1C;
        buf[40] = (byte)0xD0;
        buf[41] = (byte)0x12;
        buf[42] = (byte)0x10;
        buf[43] = (byte)0x33;
        buf[44] = (byte)0x22;
        buf[45] = (byte)0x02;
        buf[46] = (byte)0x5F;
        buf[47] = (byte)0x29;

        buf[48] = (byte)0xFC;
        buf[49] = (byte)0xFC;
        buf[50] = (byte)0x07;
        buf[51] = (byte)0x01;
        buf[52] = (byte)0x00;
        buf[53] = (byte)0x00;
        buf[54] = (byte)0x00;
        buf[55] = (byte)0x01;
        buf[56] = (byte)0x00;
        buf[57] = (byte)0x0C;
        buf[58] = (byte)0xCF;
        buf[59] = (byte)0xBA;
        buf[60] = (byte)0xCE;
        buf[61] = (byte)0xFC;
        buf[62] = (byte)0x0A;
        buf[63] = (byte)0x1C;
        buf[64] = (byte)0xD0;
        buf[65] = (byte)0x12;
        buf[66] = (byte)0x10;
        buf[67] = (byte)0x33;
        buf[68] = (byte)0x22;
        buf[69] = (byte)0x03;
        buf[70] = (byte)0x9F;
        buf[71] = (byte)0xE8;

        buf[72] = (byte)0xFC;
        buf[73] = (byte)0xFC;
        buf[74] = (byte)0x07;
        buf[75] = (byte)0x01;
        buf[76] = (byte)0x00;
        buf[77] = (byte)0x00;
        buf[78] = (byte)0x00;
        buf[79] = (byte)0x01;
        buf[80] = (byte)0x00;
        buf[81] = (byte)0x0C;
        buf[82] = (byte)0xCF;
        buf[83] = (byte)0xBA;
        buf[84] = (byte)0xCE;
        buf[85] = (byte)0xFC;
        buf[86] = (byte)0x0A;
        buf[87] = (byte)0x1C;
        buf[88] = (byte)0xD0;
        buf[89] = (byte)0x12;
        buf[90] = (byte)0x10;
        buf[91] = (byte)0x33;
        buf[92] = (byte)0x22;
        buf[93] = (byte)0x04;
        buf[94] = (byte)0x5D;
        buf[95] = (byte)0xA9;

        buf[96] = (byte)0xFC;
        buf[97] = (byte)0xFC;
        buf[98] = (byte)0x07;
        buf[99] = (byte)0x01;
        buf[100] = (byte)0x00;
        buf[101] = (byte)0x00;
        buf[102] = (byte)0x00;
        buf[103] = (byte)0x01;
        buf[104] = (byte)0x00;
        buf[105] = (byte)0x0C;
        buf[106] = (byte)0xCF;
        buf[107] = (byte)0xBA;
        buf[108] = (byte)0xCE;
        buf[109] = (byte)0xFC;
        buf[110] = (byte)0x0A;
        buf[111] = (byte)0x1C;
        buf[112] = (byte)0xD0;
        buf[113] = (byte)0x12;
        buf[114] = (byte)0x10;
        buf[115] = (byte)0x33;
        buf[116] = (byte)0x22;
        buf[117] = (byte)0x05;
        buf[118] = (byte)0x9D;
        buf[119] = (byte)0x68;

        buf[120] = (byte)0xFC;
        buf[121] = (byte)0xFC;
        buf[122] = (byte)0x07;
        buf[123] = (byte)0x01;
        buf[124] = (byte)0x00;
        buf[125] = (byte)0x00;
        buf[126] = (byte)0x00;
        buf[127] = (byte)0x01;
        buf[128] = (byte)0x09;

        return buf;
    }

}
