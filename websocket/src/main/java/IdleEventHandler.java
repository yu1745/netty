import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class IdleEventHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        super.userEventTriggered(ctx, evt);
        if(evt instanceof IdleStateEvent) {
            switch (((IdleStateEvent) evt).state()) {
                case READER_IDLE:
                    System.out.println(ctx.channel().remoteAddress().toString().substring(1) + " read idle");
                    break;
                case WRITER_IDLE:
                    System.out.println(ctx.channel().remoteAddress().toString().substring(1) + " write idle");
                    break;
                case ALL_IDLE:
                    System.out.println(ctx.channel().remoteAddress().toString().substring(1) + " both idle");
            }
            System.out.println("sever is do something...");
        }else{
            ctx.fireUserEventTriggered(evt);
        }

    }
}
