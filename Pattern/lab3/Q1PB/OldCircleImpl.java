public class OldCircleImpl implements OldCircle {
	private double [] coeff = new double[3];
	public OldCircleImpl(double a, double b, double c) {
		coeff[0] = a; coeff[1] = b; coeff[2] = c;
	//for(int i =0;i<coeff.length;i++){System.out.println(coeff[i]);}
	}
	public double [ ] getCoeff( ) {
		return coeff;
	}
}
