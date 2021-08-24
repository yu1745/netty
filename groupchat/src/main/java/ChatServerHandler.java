import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup recipients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        recipients.writeAndFlush("[client]" + ctx.channel().remoteAddress().toString().substring(1) + " get connected");
        recipients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        recipients.writeAndFlush(ctx.channel().remoteAddress().toString().substring(1) + " disconnected");
        recipients.writeAndFlush("there are " + recipients.size() + " users in the chatroom");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        recipients.parallelStream().forEach(ch -> {
            if (ch != channel)
                ch.writeAndFlush("[client]" + ch.remoteAddress().toString().substring(1) + " said:" + msg);
            else
                ch.writeAndFlush("[me]said that " + msg);
        });
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println(ctx.channel().remoteAddress().toString().substring(1) + " is offline");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println(ctx.channel().remoteAddress().toString().substring(1) + " is online");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
