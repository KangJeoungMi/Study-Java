package Day02;
import java.io.FileWriter;
import java.io.IOException;
public class othersOOP {
    public static void main(String[] args) throws IOException {
        // class : System, Math, FileWriter
        // instance : f1, f2
        System.out.println(Math.PI);
        System.out.println(Math.floor(1.8));
        System.out.println(Math.ceil(1.8));
        
        // Math 클래스에서는 이름에 걸맞게 수학적 계산을 도와주는 여러 메소드를 포함
        // 메소드와 변수는 인스턴스를 생성하지 않더라도 클래스에서 직접적으로 호출 가능

        FileWriter f1 = new FileWriter("data.txt");
        f1.write("java");
        f1.write("Hello");
        f1.close();

        // FileWriter 클래스는 파일을 열어서 원하는 내용을 입력할 수 있는 기능들을 제공
        // 그래서 각각의 파일에 해당하는 인스턴스를 생성하여 write 메소드로 쓰기 작업을 수행하고
        // close 메소드로 파일을 닫습니다.
        // 이러한 메소드와 변수는 인스턴스를 생성하여 사용하여야 하고 클래스에서 직접적으로 호출할 수 없습니다.
    }
}
