
public class EvenOddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 1;
		int end = 20;
		
		System.out.println("Even numbers");
		for (int i = start; i <= end; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("\n Odd numbers");
		for (int i = start; i <= end; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}

	}

}
