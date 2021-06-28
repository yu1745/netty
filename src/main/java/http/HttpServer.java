//package http;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//public class HttpServer {
//    public static void main(String[] args) {
//        var boss = new NioEventLoopGroup();
//        var worker = new NioEventLoopGroup();
//        try{
//            ServerBootstrap bootstrap = new ServerBootstrap();
//            bootstrap.group(boss,worker)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new HttpServerInitializer());
//            ChannelFuture future = bootstrap.bind(8888).sync();
//            ChannelFuture future1 = future.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            boss.shutdownGracefully();
//            worker.shutdownGracefully();
//        }
//    }
//}
