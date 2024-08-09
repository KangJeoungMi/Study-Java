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
