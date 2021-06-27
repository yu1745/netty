import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.Random;

public class MyLongToByteHandler extends MessageToByteEncoder<Long> {
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//       /* byte a,b,c,d;
//        for (int i = 0; i < 100; i++) {
//            Random random = new Random();
//            a = (byte) random.nextInt(127);
//            b = (byte) random.nextInt(127);
//            c = (byte) random.nextInt(127);
//            d = (byte) random.nextInt(127);
//            ctx.writeAndFlush(Unpooled.copiedBuffer(new byte[]{a,b,c,d}));
//        }*/
//
//    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        var buf = (ByteBuf) msg;
//        System.out.println("server response: " + buf.toString(StandardCharsets.UTF_8));
//        System.out.println("server address: "+ctx.channel().remoteAddress());
//    }

//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        out.writeLong(msg);
    }
}
