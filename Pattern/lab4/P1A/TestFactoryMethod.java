public class TestFactoryMethod {
		public static void main(String [] args) {
			String [] creators = {"ConcreteCreatorA", "ConcreteCreatorB"};
			try {
				int choice = Integer.parseInt(args[0]);
				Creator c = 
					(Creator)Class.forName(creators[choice]).newInstance();
				c.anOperation();
			}
			catch (Exception e) {
				System.out.println("Problem Encoutered");
			}
		}
	}
