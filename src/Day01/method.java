package Day01;
class Print{
    public String delimiter;
    // 매개변수 , parameter
    public void method(){
        System.out.println(this.delimiter);
        System.out.println("a");

    }
    public static String methodA(String text, String delimiter){
        String out = "";
        out += delimiter +"\n";
        out += text +"\n";
        out += text +"\n";
        return out;
    }

  
}

public class method {
   
    
    public static void main(String[] args) {
        // 인자 , argument
        System.out.println(Print.methodA("d", "+"));

        // instance
        Print t1 = new Print();
        t1.delimiter="-";
        t1.method();
    }
}
