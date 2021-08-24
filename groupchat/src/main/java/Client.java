import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class Client {
    public static final String SERVER_ADDRESS = "localhost";
    public static final int PORT = 8888;

    public void run() throws InterruptedException {
//        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(SERVER_ADDRESS, PORT).sync();
            Channel channel = future.channel();
            System.out.println("-----------------------------" + channel.localAddress().toString().substring(1) + "-----------------------------");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                channel.writeAndFlush(line+"\r\n");
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Client().run();
    }
}
