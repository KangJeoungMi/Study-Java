## Java 2일차 학습

### 목차
1. 객체지향 프로그래밍(OPP)
    - 클래스와 인스턴스
    - static
    - 생성자 this

----

### 1. 객체지향 프로그래밍(OPP)
> 현실세계의 개념을 프로그램으로 모델링하는 방식으로 **자바에서 OP**P는 `클래스를 기반`으로 하여, 이 클래스에서 여러 `인스턴스를` 생성해 프로그래밍을 한다

### 클래스와 인스턴스
- `클래스(class)` : 클래스는 객체를 생성하기 위한 **설계도나 형틀**이다, 클래스는 객체의 상태`변수`와 행동`메서드`를 정의한다
- `인스턴스(Instance)` : 클래스에서 생성된 구체적인 객체이다. ***클래스가 `설계도`***라면 ***인스턴스는 설계도를 바탕으로 만들어진 `실체(객체)`***이다

- 예시 

|클래스|인스턴스|
|----|------|
|`Car`|`myCar`,`YourCar`|

- 클래스와 인스턴스의 관계 : 클래스를 변경하면 그 클래스로부터 생성된 모든 인스턴스에 영향을 미친다. 하지만 **특정 인스턴스의 상태를 변경해도 다른 인스턴스에 영향을 주지 않는다**

### static
- static 변수와 메소드 
    - 클래스에서 생성된 모든 인스턴스가 **공유하는 자원**
    - 인스턴스를 만들지 않고도 **클래스에서 직접 호출가능**
`특징`
1. `static`이 아닌 변수와 메서드는 인스턴스를 생성한 후에만 접근할 수 있습니다.
2. `static` 변수와 메서드는 모든 인스턴스가 공유하는 자원이기 때문에, 하나의 인스턴스에서 변경하면 모든 인스턴스에 영향을 미칩니다.
3. 반면 `static`이 아닌 변수와 메서드는 인스턴스마다 고유의 값을 가지므로, 특정 인스턴스에서 값을 변경해도 다른 인스턴스에는 영향을 주지 않습니다.
```java
class Example {
    static int shared = 10;  // 모든 인스턴스가 공유하는 변수
    int unique = 5;           // 각 인스턴스마다 고유한 변수
}

Example obj1 = new Example();
Example obj2 = new Example();

obj1.shared = 20;  // obj1에서 shared 값을 변경
System.out.println(obj2.shared);  // obj2의 shared도 20으로 변경됨
```


#### 생성자 this
- `생성자(Constructor)`
    -  클래스의 인스턴스를 생성할 때 호출되는 메서드
    - 생성자의 이름은 클래스의 이름과 **동일**해햐하며, 리턴타입을 명시하지 않음
    - 생성자는 객체의 조기상태를 설정하는 역할, 필요의 경우 초기화 할 필드에 따라 파라미터를 설정할 수 있음
- `this`
    - 현재 인스턴스 자신을 참조하는 키워드
    - 주로 생성자나 메서드에서 인스턴스 변수와 메서드 파라미터 이름이 동일할 때 이를 구분하기 위해 사용
    ```java
    class Car {
    String model;
    int year;

    // 생성자
    Car(String model, int year) {
        this.model = model; // this.model은 인스턴스 변수, model은 파라미터
        this.year = year;
    }
    }
    ```


#### 활용
```java
package Day02;
class Accounnting{ // 클래스화
    // 공급가액
    public double valueOfSupply;
    // 부가가치 세율
    public static double vatRate = 0.1;
    public Accounnting(double valueOfSupply){
        this.valueOfSupply = valueOfSupply;
    }

    public double getVAT(){
        return valueOfSupply * vatRate;
    }
    public double getTotal() {
        return valueOfSupply + getVAT();
    }
}

public class AccountingApp {
        public static void main(String[] args) {
            // Accounnting a1 = new Accounnting();
            // a1.valueOfSupply = 10000.0;
            // Accounnting a2 = new Accounnting();
            // a2.valueOfSupply = 20000.0;

            Accounnting a1 = new Accounnting(10000.0);
            Accounnting a2 = new Accounnting(20000.0);

            System.out.println("a1 - Value of supply : " + a1.valueOfSupply);
            System.out.println("a1 - VAT : " + a1.getVAT());
            System.out.println("a1 - Total : " + a1.getTotal());

            System.out.println("a2 - Value of supply : " + a2.valueOfSupply);
            System.out.println("a2 - VAT : " + a2.getVAT());
            System.out.println("a2 - Total : " + a2.getTotal());
            // Accounnting.valueOfSupply = 10000.0;
            // System.out.println("Value of supply : " + Accounnting.valueOfSupply);
            // System.out.println("VAT : " + Accounnting.getVAT());
            // System.out.println("Total : " + Accounnting.getTotal());
        }
   
}
```