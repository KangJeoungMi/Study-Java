package Day04;

public class ExceptionApp {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10,20,30};

        // try {
        //     System.out.println(scores[3]);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("계산 오류");
        // }
        // unchecked exception
        try{
            System.out.println(1);
            System.out.println(1);
            System.out.println(scores[3]);
            System.out.println(2/0);
            System.out.println(4);
            System.out.println(5);

        }catch(Exception e){
            System.out.println("오류");}
        // catch(ArithmeticException e){
        //     System.out.println("계산 오류");
        // }catch (ArrayIndexOutOfBoundsException e) {
        //         System.out.println("문자 오류");
        // }
        System.out.println(3);
    }
}
