//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Selector selector = Selector.open();
//        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.bind(new InetSocketAddress("12.0.0.1",9999));
//        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//    }
//}
