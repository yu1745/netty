import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ByteToLongDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 8) {
//            byte a = in.readByte();
//            byte b = in.readByte();
//            byte c = in.readByte();
//            byte d = in.readByte();
//            byte e = in.readByte();
//            byte f = in.readByte();
//            byte g = in.readByte();
//            byte h = in.readByte();
//            long i = (long) a << 56 | (long) b << 48 | (long) c << 40 | (long) d << 32 | e << 24 | f << 16 | g << 8 | h;
            long i = in.readLong();
            out.add(i);
//            System.out.println("received long: " + i);
        }
    }
}
