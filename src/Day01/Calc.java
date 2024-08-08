package Day01;

public class Calc {
    // 인스턴스 변수
    int baseValue;

    // 생성자
    Calc(int baseValue) {
        this.baseValue = baseValue;
    }

    // 인스턴스 메소드: 두 수를 더하고, baseValue를 더한 값을 리턴
    public int add(int a, int b) {  // a, b는 매개변수 (Parameter)
        int sum = a + b;
        return sum + this.baseValue;  // 리턴 값
    }

    // 정적 메소드: 두 수를 더한 결과를 리턴 (인스턴스 변수 사용 불가)
    public static int staticAdd(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 정적 메소드 호출: 객체 생성 없이 클래스 이름으로 호출 가능
        int staticResult = Calc.staticAdd(10, 20); // 10, 20은 인자 (Argument)
        System.out.println("Static method result: " + staticResult);

        // 인스턴스 메소드 호출: 객체 생성 후 호출
        Calc calc = new Calc(5);  // baseValue = 5
        int instanceResult = calc.add(10, 20); // 10, 20은 인자 (Argument)
        System.out.println("Instance method result: " + instanceResult);
    }
}
