package Day02;
public class myOOP {
	// 클래스 파일 분리 [마우스 우클릭] > 리팩터링 > move > add filename
	public static void main(String[] args) {
		print p1 = new print( "****");
		p1.A();
		p1.A();
		p1.B();
		p1.B();
		
		// print.delimiter = "****"; // 하나의 클래스의 상태를 바꾸는 중이다
        print p2 = new print("++++++");
		p2.A();
		p2.A();
		p2.B();
		p2.B();

        p1.A();
        p2.A();
        p1.B();
        p2.B();
	}
	
}