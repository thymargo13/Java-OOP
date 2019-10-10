public class Main {
	public static void main(String[] args) {
		Fraction a, b;

		a = new ObjectFractionAdapter(new LongFraction(1,2)); // 1/2
		b = new ObjectFractionAdapter(new LongFraction(1,4)); // 2/3

		System.out.println(a + "+" + b + "="+ a.add(b));
		System.out.println(a + "-" + b + "=" + a.subtract(b));
		System.out.println(a + "-" + 1 + "=" + a.subtract(1));
		System.out.println(a + "+" + 1 + "=" + a.add(1));
	}
}