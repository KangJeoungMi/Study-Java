## Java 1일차 학습

### 목차
1. VSCode 자바 실행 초기 설정
2. 메소드
----

### 1. VSCode 자바 실행 초기 설정

1. VSCode 확장 -> **Java Extension Pack** 설치
2. `command`+`shift`+`p` **Java: Create Java Project** 선택
3. `No build tools` 선택 
4. 프로젝트를 생성 할 디렉토리 선택 -> 프로젝트 이름 입력
    ![img01_png](/images/markdown/Day01/img01.png)
5. 패키지 생성 -> src 파일 내 패키지 생성
    ![img02_png](/images/markdown/Day01/img02.png)

---

### 2. 메소드
> 메소드 : 객체의 동작이나 행위를 정의하는 코드 블록
> 클래스 내에 정의되며 객체의 상태를 변경하거나 특정 작업을 수행할 떄 사용됨
- `인스턴스 메소드(Instance Method)` : 특정 객체에 속하는 메소드로, 객체를 생성한 후 해당 객체를 통해 호출된다. 객체의 상태(인스턴스 변수)를 변경하거나 참조할 수 있다.
- `정적 메소드(static Method)` : 클래스 자체에 속하는 메소드로, 객체를 생성하지 않고 클래스 이름을 통해 직접 호출. 정적 메소드는 인스턴스 변수에 접근할 수 없고 클래스 변수나 정적 변수에만 접근 가능
> [static]()
- static : class method
- no static : instance method
1. method Input : 메소드가 실행될 때 필요한 데이터를 의미
    - `매개변수(parameter)` : 메소드를 정의할 때 선언하는 변수로, 메소드 호출 시 전달된 데이터를 받아들이는 역할을 한다. 매개변수는 메소드 내부에서 사용될 데이터를 미리 선언해두는 것이다
    - `인자(argument)` : 메소드를 호출할때 실제로 전달되는 값이나 변수. 이 값들은 메소드의 매개변수에 대응되어 전달됨
2. method Output : 메소드가 작업을 수행한 후 반환하는 값
    - `return` : 메소드가 작업을 완료한 후 호출한 곳으로 값을 돌려주는 것. 메소드가 특정 작업을 수행한 결과를 전달할 때 사용


```java
class Calculator {

    // 인스턴스 변수
    int baseValue;

    // 생성자
    Calculator(int baseValue) {
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
        int staticResult = Calculator.staticAdd(10, 20); // 10, 20은 인자 (Argument)
        System.out.println("Static method result: " + staticResult);

        // 인스턴스 메소드 호출: 객체 생성 후 호출
        Calculator calc = new Calculator(5);  // baseValue = 5
        int instanceResult = calc.add(10, 20); // 10, 20은 인자 (Argument)
        System.out.println("Instance method result: " + instanceResult);
    }
}

```

2. 활용
```java
package Day01;

public class AccountingApp {
    // 공급가액
    public static double valueOfSupply  = 10000.0;
    // 부가가치 세율
    public static double vatRate = 0.1;

    public static double getVAT(){
        return valueOfSupply * vatRate;
    }
    private static double getTotal() {
        return valueOfSupply + getVAT();
    }

    public static void main(String[] args) {

        System.out.println("Value of supply : " + valueOfSupply);
        System.out.println("VAT : " + getVAT());
        System.out.println("Total : " + getTotal());
    }
}
```

***참고***
- `클래스` : 비슷한 연관된 일을 하는 메소드와 변수들을 묶어 그룹으로 만 든 것
- `인스턴스` : 이러한 틀로 하여 실제로 프로그램에서 동작하는 객체들
     -  클래스 인스턴스 차이점 : 클래스는 일종의 형틀이고, 인스턴스는 그 형틀로 찍어서 만든 실체이다.
- **`객체지향 프로그래밍(OPP, Object Oriented Programming)`** : 이러한 객체를 뼈대로 해서 프로그램을 만들어 가는 방식
-  접근제한자
    |keyword|description|
    |-------|-----------|
    |public|바깥으로 드러나서 호출할 수 있는 것|
    |private|외부에서 굳이 알 필요도 없거나 알아서는 안되는 것|
    |protected|같은 패키지 또는 자식 클래스에서 사용할 수 있는 것|
    |default|같은 패키지에 소속된 클래스에서만 사용할 수 있는 것|
