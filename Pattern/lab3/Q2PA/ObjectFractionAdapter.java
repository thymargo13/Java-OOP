public class ObjectFractionAdapter implements Fraction{
    LongFraction lF;
   
    
    public ObjectFractionAdapter(LongFraction lF){
        this.lF=lF;
    }

    public int getNumerator(){return (int)lF.numerator();}
	public int getDenominator(){return (int)lF.denominator();}
	
	public Fraction add(Fraction b){
		LongFraction a =new LongFraction(b.getNumerator(),b.getDenominator());
		return new ObjectFractionAdapter(lF.plus(a));
	}
 	public Fraction add(int b){
		return new ObjectFractionAdapter(lF.plus(b));
	}
	public Fraction subtract(Fraction b){
		LongFraction a =new LongFraction(b.getNumerator(),b.getDenominator());
		return new ObjectFractionAdapter(lF.minus(a));
	}
	public Fraction subtract(int b){
	    return new ObjectFractionAdapter(lF.minus(b));
	} 
	public String toString(){
	    return lF.toString();
	}
}