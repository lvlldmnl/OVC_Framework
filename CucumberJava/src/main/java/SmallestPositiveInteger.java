import java.util.HashSet;

public class SmallestPositiveInteger {
	
	public static int smallestMissingPositive(int[] A ) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int num : A) {
			if (num > 0) {
				set.add(num);
			}
		}
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			if (!set.contains(i)) {
				return 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
    	int[] A1 = {1, 3, 6, 4, 1, 2};
    	int[] A2 = {1, 2, 3};
    	int[] A3 = {-4, -2};
    	
    	System.out.println("Smallest missing positive integer for A1: " + smallestMissingPositive(A1));
    	System.out.println("Smallest missing positive integer for A2: " + smallestMissingPositive(A2));
    	System.out.println("Smallest missing positive integer for A3: " + smallestMissingPositive(A3));

	}

}
