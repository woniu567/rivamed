package mynettynio.manyNetty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;


//服务器端初始化Initializer
public class MyChatServerInializer extends ChannelInitializer<SocketChannel>{
    protected MyChatServerHandler handler;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //分割接收到的Bytebu，根据指定的分割符
        pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        handler=new MyChatServerHandler();
        pipeline.addLast(handler);
    }

    public void sendMsg(String msg){
        handler.sendMsg(msg);
    }
}
