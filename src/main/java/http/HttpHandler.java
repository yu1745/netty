//package http;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.http.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//@Slf4j
//public class HttpHandler extends SimpleChannelInboundHandler<HttpObject> {
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
//        if(msg instanceof HttpRequest){
//            log.info("pipeline's hashcode: "+ctx.pipeline().hashCode());
////            System.out.println("msg's type is "+msg.getClass());
//            log.info(ctx.channel().remoteAddress().toString().substring(1));
//            HttpRequest request = (HttpRequest) msg;
//            URI uri = new URI(request.uri());
//            log.info(uri.toString());
//            if("/favicon.ico".equals(uri.getPath())){
////                log.info("request favicon, do not response");
//                return;
//            }
//            ByteBuf content = Unpooled.wrappedBuffer("hello, this is http server擦阿达萨斯的".getBytes(StandardCharsets.UTF_8));
//            DefaultFullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
//            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
//            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
//            ctx.writeAndFlush(httpResponse);
//        }
//    }
//}
