import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

public class ClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
//        byte[] bytes = new byte[msg.readableBytes()];
//        msg.readBytes(bytes);
//        String s = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("client received : " + s);
//        System.out.println("client received msg count = " + ++count);
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        for (int i = 0; i < 10; i++) {
            var s = "The weather today is good " + i;
            var messageProtocol = new MessageProtocol();
            messageProtocol.setBytes(s.getBytes(StandardCharsets.UTF_8));
            messageProtocol.setLen(messageProtocol.getBytes().length);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {

    }
}
