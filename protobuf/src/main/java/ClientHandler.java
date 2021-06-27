import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import pojo.MyDataInfo;
import pojo.StudentPOJO;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int random = new Random().nextInt(3);
        MyDataInfo.MyMessage message = null;
        if(0==random){
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DATA_TYPE.StudentType).setStudent(MyDataInfo.Student.newBuilder().setId(1).setName("张三").build()).build();
        }else{
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DATA_TYPE.WorkerType).setWorker(MyDataInfo.Worker.newBuilder().setAge(20).setName("李四").build()).build();

        }
//        StudentPOJO.Student student = StudentPOJO.Student.newBuilder().setId(4).setName("nmsl").build();
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,server".getBytes()));
        ctx.writeAndFlush(message);
//        ctx.channel().eventLoop().schedule(() -> ctx.channel().writeAndFlush(student), 1, TimeUnit.SECONDS);
//        ctx.channel().eventLoop().schedule(() -> ctx.channel().writeAndFlush(student), 2, TimeUnit.SECONDS);
//        ctx.channel().eventLoop().schedule(() -> ctx.channel().writeAndFlush(student), 3, TimeUnit.SECONDS);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        var buf = (ByteBuf) msg;
        System.out.println("server response: " + buf.toString(StandardCharsets.UTF_8));
        System.out.println("server address: " + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
