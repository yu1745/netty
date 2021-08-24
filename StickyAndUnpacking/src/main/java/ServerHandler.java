import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
//        byte[] bytes = new byte[msg.readableBytes()];
//        msg.readBytes(bytes);
//        String s = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("server received : " + s);
//        System.out.println("server received msg count = " + ++count);
//        ctx.writeAndFlush(Unpooled.copiedBuffer(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)));
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        System.out.println("exception message: " + cause.getMessage());
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("server received message: " + new String(msg.getBytes()));
    }
}
