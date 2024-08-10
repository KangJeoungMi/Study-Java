## Java 3일차 학습

### 목차
1. 상속
2. 인터페이스

----

### 1. 상속
- 기존 클래스를 재사용하여 새로운 클래스를 만드는 방법으로 **중복을 줄이고**, 기존 클래스의 **기능을 확장** 할 수 있음

- 부모클래스 : `상위 클래스`, `슈퍼 클래스`, `기본 클래스`라고 불린다. 다른 클래스에게 상속 될 수 있는 클래스
- 자식클래스 : `하위 클래스`, `서브 클래스`, `파생 클래스`라고 불린다. 부모 클래스로부터 상속 받아 부모 클래스의 속성과 메서드를 사용한다
```java
class Cal {
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
}

class Cal3 extends Cal{
	public int minus(int v1, int v2) {
		return v1 - v2;
	}
}
```
- `오버라이드(override)` : 부모 클래스에서 정의된 메서드를 자식 클래스에서 `재정의`하는 것이다. 자식 클래스에서 부모 클래스의 메서드를 수정하여 다른 동작을 하도록 할 수 있음
    - 메서드의 이름, 리턴 타입, 매개변수 모두 부모 클래스와 동일하야함
- `오버로드(overload)` : 같은 이름의 메서드를 여러 개 정의하되, 각 메서드의 `매개변수 목록(타입, 개수 등)`이 다른 경우이다. 상속과 직접적인 관련은 없으나 **메서드의 다형성을 제공**
```java
package Day03;
class Cal {
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
    // overroding, 오버 로딩
    public int sum(int v1, int v2, int v3) {
		return this.sum(v1, v2) + v3;
	}
}

class Cal3 extends Cal{
	// overridinng, 오버라이딩
	public int sum(int v1, int v2) {
		System.out.println("Cal3!!!");
		return super.sum(v1, v2);
	}

	public int minus(int v1, int v2) {
		return v1 - v2;
	}
}
public class InheritanceApp {
    public static void main(String[] args) {
		Cal c = new Cal();
		System.out.println(c.sum(2, 1));
		System.out.println(c.sum(2, 1,1));
		Cal3 c3 = new Cal3();
		System.out.println(c3.sum(2, 1));
		System.out.println(c3.minus(2, 1));
	}
}

```

- this : 자기자신, 현재 인스턴스를 참조하는 키워드. 메서드나 생성자에서 인스턴스 변수와 매개변수 이름이 같을 때 사용
- super : 자신의 부모, 부모 클래스의 멤버(변수나 메서드)를 참조할 때 사용한다.
```java
class Parent {
    void show() {
        System.out.println("부모 클래스의 show 메서드");
    }
}

class Child extends Parent {
    void show() {
        super.show(); // 부모 클래스의 show 메서드 호출
        System.out.println("자식 클래스의 show 메서드");
    }
}
```
- 상속과 생성자 : 자식 클래스의 생성자가 호출되면, 먼저 부모클래스의 생성자가 호출된다. 이는 **부모 클래스의 초기화**가 먼저 이루어진 후에 **자식 클래스의 초기화**가 이루어져야 하기 때문이다. 자식클래스의 생성자에서 `super()`를 사용하여 부모 클래스의 생성자를 명시적으로 호출할 수 있음
```java
class Parent {
    void show() {
        System.out.println("부모 클래스의 show 메서드");
    }
}

class Child extends Parent {
    void show() {
        super.show(); // 부모 클래스의 show 메서드 호출
        System.out.println("자식 클래스의 show 메서드");
    }
}
```
### 2. 인터페이스
> 클래스가 구현해야 하는 메서드의 목록을 정의한다. 자바에서 인터페이스는 **다중 상속을 구현**한다
- 인터페이스의 형식
    1. 인터페이스는 추상 메서드(구현되지 않은 메서드)만을 포함한다. `자바 8` 이후부터는 디폴트 메서드(구현된 메서드)와 정적 메서드도 포함할 수 있습니다.
    2. 인터페이스의 변수는 `public static final`로 선언되며, 반드시 초기화되어야 한다.
    3. 인터페이스를 구현한 클래스는 인터페이스에 정의된 모든 메서드를 구현해야 한다.
```java
interface Animal {
    void sound();  // 추상 메서드
}

class Dog implements Animal {
    public void sound() {
        System.out.println("멍멍");
    }
}
```
 
- `다형성(polymorphism)` : 인터페이스를 사용하여 다형성을 구현할 수 있음. 즉, 같은 인터페이스를 구현한 여러 클래스의 객체를 동일한 인터페이스 타입으로 다룰 수 있습니다.
```java
Animal myDog = new Dog();
myDog.sound();  // "멍멍" 출력
```
- `접근 제어자(access modifier)` : 클래스, 메서드, 변수의 접근 범위를 제어하는 키워드

|keyword|description|
|-------|-----------|
|`public`|모든 클래스에서 접근 가능|
|`protected`|같은 패키지 내, 또는 다른 패키지의 자식클래스에서 접근 가능|
|`default`|(아무 키워드도 쓰지 않은 경우) 같은 패키지 내에서만 접근 가능|
|`private`|같은 클래스 내에서만 접근 가능|

- `final` 키워드 : 변수, 메서드, 클래스에 사용됨
|keyword|description|
|-------|-----------|
|`final` 변수|값을 한번만 할당 할 수 있음. **상수로 사용**|
|`final` 메서드|이 메서드는 자식 클래스에서 오버라이드 할 수 없음|
|`final` 클래스|이 클래스는 상속될 수 없음|

- `abstract` 키워드 : 추상 클래스 또는 추상 메서드 정의 할 때 사용
    - 추상 클래스 : 하나 이상의 추상 메서드를 포함한 클래스. 쟂체를 직접 생성할 . 수없으며, 이를 상속받은 자식 클래스에서 구현
    - 추상 메서드 : 구현이 없는 메스드로, 상속받은 클래스에서 반드시 구현해야 한다
```java
abstract class Animal {
    abstract void sound();  // 추상 메서드
}

class Dog extends Animal {
    void sound() {
        System.out.println("멍멍");
    }
}
```

- `Java API`속의 인터페이스 : 자바 API에는 다양한 인터페이스가 포함되어 있으며, 대표적으로 `Comparable`, `Runnable`, `Serializable` 등이 있음

|keyword|description|
|-------|-----------|
|`Comparable`|객체를 비교할 수 있게 해주는 인터페이스로, 정렬을 위해 주로 사용|
|`Runnable`| 스레드의 실행을 정의하는 인터페이스|
|`Serializable`|객체를 직렬화할 수 있게 해주는 인터페이스|