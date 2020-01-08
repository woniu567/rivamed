package mynettynio.manyNetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

public class ManyHandlerContext{

    protected static Map<String,ChannelHandlerContext> map;

    public Map<String, ChannelHandlerContext> getMap() {
        return map;
    }

    public void setMap(Map<String, ChannelHandlerContext> map) {
        this.map = map;
    }

}
