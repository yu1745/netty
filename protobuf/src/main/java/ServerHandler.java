import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import pojo.MyDataInfo;
import pojo.StudentPOJO;

import java.nio.charset.StandardCharsets;

public class ServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        StudentPOJO.Student student = (StudentPOJO.Student) msg;
//        System.out.println("client id=" + student.getId());
//        System.out.println("client name=" + student.getName());
//
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        System.out.println(msg.getDataType());
        switch (msg.getDataTypeValue()){
            case MyDataInfo.MyMessage.DATA_TYPE.StudentType_VALUE:
                System.out.println("id="+msg.getStudent().getId() + " name=" + msg.getStudent().getName());
                break;
            case MyDataInfo.MyMessage.DATA_TYPE.WorkerType_VALUE:
                System.out.println("age=" + msg.getWorker().getAge() + " name=" + msg.getWorker().getName());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client".getBytes(StandardCharsets.UTF_8)));
        System.out.println("ServerHandler.channelReadComplete");
        ;
    }
}
