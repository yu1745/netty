import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder.decode");
        int len = in.readInt();
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(len);
        messageProtocol.setBytes(bytes);
        out.add(messageProtocol);
    }
}
