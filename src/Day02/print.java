package Day02;

// 클래스와 변수와 메소드
class print{
    public String delimiter = "";

    public print(String delimiter){
        this.delimiter = delimiter;
    }

	public void A() {
		System.out.println(this.delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	public void B() {
		System.out.println(this.delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}