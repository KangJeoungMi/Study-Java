## Java 3일차 학습

### 목차
1. 예외
---

1. 예외

- 예외가 발생하는 이유
    - 예외는 프로그램 실행 중에 발생할 수 있는 오류 (잘못된 사용자 입력, 파일처리 오류, 네트워크 오류, 메모리 부족, 0으로 나누기 등)
- 예외 처리 방법
    - `try`,`catch`,`finally`블럭 사용
    ```java
    try {
    // 예외가 발생할 가능성이 있는 코드
    } catch (ExceptionType e) {
        // 예외 발생 시 처리할 코드
    } finally {
        // 예외 발생 여부와 상관없이 항상 실행되는 코드
    }
    ```
- 예외의 우선순위 : 여러 예외를 한번에 처라 가능. 특정예외 먼저 처리 후 포괄적인 예외는 나중에 처리하는 방식
    - `RuntimeException` : `RuntimeException`은 `Exception` 클래스로부터 상속받은 클래스.
    - 그래서 여러 예외가 있더라도 `Exception` 클래스를 이용해서 포괄적으로 처리할 수 있습니다.
    ```java
    try {
    // 코드
    } catch (NullPointerException e) {
        // NullPointerException 처리
    } catch (Exception e) {
        // 나머지 예외 처리
    }
    ```
- `e.getMessage()` : 발생한 예외에 대한 간단한 설명을 반환
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println(e.getMessage()); // 출력: / by zero
}
```
- `e.printStackTrace()` : 예외 발생 시점의 스택 트레이스를 출력하여, 어디에서 예외가 발생했는지 디버깅 정보를 제공
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace(); // 예외 스택 트레이스 출력
}
```
- checked Exception / unchecked Exceiption
![img01_png](/images/markdown/Day04/img01.png)

|keyword|description|example|
|-------|-----------|-------|
|Checked Exception|컴파일러가 예외 처리 여부를 검사하는 예외. 예외 처리를 강제하며, 파일 입출력이나 네트워크 관련 작업 등에서 주로 발생| `IOException`, `SQLException`|
|Unchecked Exception| 컴파일러가 예외 처리를 강제하지 않는 예외. 주로 프로그래밍 논리 오류로 인해 발생하며, `RuntimeException`의 하위 클래스이다|`NullPointerException`, `ArrayIndexOutOfBoundsException`|

- Checked Exception
```java
try {
    FileInputStream fis = new FileInputStream("file.txt");
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```
- Unchecked Exception
```java
int[] arr = new int[5];
System.out.println(arr[10]); // ArrayIndexOutOfBoundsException 발생
```
- `resource` : 파일, 네트워크 소켓, 데이터베이스 연결과 같은 리소스는 사용 후 반드시 반환해야 한다
- `Finally` : 예외 발생 여부와 관계없이 항상 실행되는 블록. 리소스를 닫거나 정리하는 코트에 사용
```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("file.txt");
    // 파일 읽기 코드
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fis != null) {
        try {
            fis.close(); // 파일 리소스 닫기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
- `try with resource` : 자바 7에서 도입된 구문으로, **리소스를 자동으로 닫아주는 기능**을 제공.
    - `AutoCloseable` 인터페이스를 구현한 리소스를 사용할 때 유용
    ```java
    try (FileInputStream fis = new FileInputStream("file.txt")) {
    // 파일 읽기 코드
    } catch (IOException e) {
        e.printStackTrace();
    } // try 블록이 끝나면 fis.close()가 자동으로 호출됩니다.
    ```
- `throws Exception` :  **메서드 선언부에서 특정 예외를 던질 수 있음**을 명시. 메서드를 호출하는 쪽에서 해당 예외를 처리
```java
public void readFile(String fileName) throws IOException {
    FileInputStream fis = new FileInputStream(fileName);
    // 파일 읽기 코드
}
```