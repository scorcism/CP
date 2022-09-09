class Inheritance{

	static class Aa{
		int a = 5;
		void print(){
			System.out.println("Class: Aa     Varible = 5");
		}
	}

	static class Bb extends Aa{
		int b = 6;
		void print(){
			System.out.println("Class: Bb   varible = 6 ");
			System.out.println("SuperClass varibale: " + a);
		}
	}

	static class Cc extends Bb{
		int c = 7;
		void print(){
			System.out.println("Class: Cc    varibale  = 7");
			System.out.println("grandparent: " + a + " Parent: " + b);
		}
	}

	static class Dd extends {
		int d = 8;
		void print(){
			System.out.println("Class");
		}
	}



	public static void main(String args[]){
		System.out.println("Inheritance\n");
		// Class
		System.out.println("Class: ");
		Aa a = new Aa();
		a.print();


		System.out.println("Single Inheritance: ");
		// Single Inheritance
		Bb b = new Bb();
		b.print();
	
		
		System.out.println("Multilevel Inhertance: ");
		// Multilevel Inheritance
		Cc c = new Cc();
		c.print();
	

	}
}
