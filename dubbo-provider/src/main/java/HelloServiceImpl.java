public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String s) {
        s = (s == null ? "null" : s);
        return "hello " + s;
    }
}
