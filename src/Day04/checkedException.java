package Day04;
import java.io.FileWriter;
import java.io.IOException;
public class checkedException {
    public static void main(String[] args) {
        FileWriter f1 = null ;
        try {
            f1 = new FileWriter("data.txt");
            f1.write("hello");
            // close 를 하기 전에 예외가 ㅎ발생할 . 수있기 때문에 finally 로 처리해야 한다
            f1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
