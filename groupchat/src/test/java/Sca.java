import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sca {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\wangyu\\IdeaProjects\\netty\\groupchat\\src\\test\\resources\\a.txt"));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
        }
    }
}