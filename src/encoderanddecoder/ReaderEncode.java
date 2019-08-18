package encoderanddecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.IOException;

public class ReaderEncode extends MessageToByteEncoder<byte[]> {

    @Override
    protected void encode(ChannelHandlerContext ctx, byte[] msg, ByteBuf out) throws IOException {
        out.writeBytes(msg);
    }
}
