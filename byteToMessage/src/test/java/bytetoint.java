public class bytetoint {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 1;
        byte c = 1;
        byte d = 1;
        int i = a << 24 | b << 16 | c << 8 | d;
        System.out.println(i);
    }
}
