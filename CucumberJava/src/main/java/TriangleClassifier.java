import java.util.Scanner;

public class TriangleClassifier {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        // Read input
	int side1 = scanner.nextInt();
	int side2 = scanner.nextInt();
	int side3 = scanner.nextInt();
	
        // Close the scanner
	scanner.close();

        // Validate input
	if (side1 < 0 || side2 < 0 || side3 < 0) {
		System.out.println("Invalid Triangle");
		return;
	}
        // Check if the triangle is equilateral
	if (side1 == side2 && side2 == side3) {
		System.out.println("equilateral");
	}
        // Check if the triangle is isosceles
	else if (side1 == side2 || side1 == side2 || side2 == side3) {
		System.out.println("isosceles");
	}
        // If none of the above, it must be scalene
	else
		System.out.println("scalene");
		
}
}