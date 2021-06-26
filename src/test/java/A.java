import java.util.ArrayList;

public class A {
    public void a(){
        ArrayList<B> list = new ArrayList<>();
        list.add(new B());
        list.add(new B());
        list.add(new B());
        list.add(new B());
        list.add(new B());
        list.add(new B());
        list.add(new B());
        list.stream().forEach(x->list.remove(x));
        list.forEach(System.out::println);
    }
}
