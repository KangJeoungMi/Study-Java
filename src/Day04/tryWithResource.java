package Day04;
import java.io.FileWriter;
import java.io.IOException;
public class tryWithResource {
    public static void main(String[] args) {
        // try with resource statements
        try (FileWriter f1 = new FileWriter("data.txt")){
            f1.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
           
}
