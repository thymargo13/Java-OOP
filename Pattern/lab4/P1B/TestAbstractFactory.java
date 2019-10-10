public class TestAbstractFactory {
		public static void main(String[] args) {
			String [] factories = {"ConcreteFactory1", "ConcreteFactory2"};
			try {
				Client c = new Client();
				int choice = Integer.parseInt(args[0]);

				AbstractFactory af =(AbstractFactory)Class.forName(factories[choice]).newInstance();
				//AbstractFactory af =(AbstractFactory)new ConcreteFactory2();
				System.out.println("Product A Created : " 
								+ c.createA(af).getName());
				System.out.println("Product B Created : " 
								+ c.createB(af).getName());
			}
			catch (Exception e) {
				System.out.println("Problem encountered");
			}
		}
}
