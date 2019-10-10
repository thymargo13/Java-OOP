public class ClassFractionAdapter extends LongFraction implements Fraction{
   
     public ClassFractionAdapter(long num, long denum){
    	super(num,denum);
    }
    
    public int getNumerator(){return (int)numerator();}
	public int getDenominator(){return (int)denominator();}
	
	
	public Fraction add(Fraction b){
		LongFraction a =new LongFraction(b.getNumerator(),b.getDenominator());
		return new ClassFractionAdapter(plus(a).numerator(),plus(a).denominator());
	}
 	public Fraction add(int b){
 		//LongFraction result = plus(b);
		return new ClassFractionAdapter( plus(b).numerator(), plus(b).denominator());
	}
	public Fraction subtract(Fraction b){
		LongFraction a =new LongFraction(b.getNumerator(),b.getDenominator());
		return new ClassFractionAdapter(minus(a).numerator(),minus(a).denominator());
	}
	public Fraction subtract(int b){
	    return new ClassFractionAdapter(minus(b).numerator(),minus(b).denominator());
	} 
	
}