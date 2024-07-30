
public class EqualDivisions {

	public static int maxEqualDivisions(String s) {
		int n = s.length();
		int maxDivisions = 1;
		
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				boolean isEqualDivisions = true;
				for (int j = i; j < n; j++) {
					if (s.charAt(j) != s.charAt(j % i)) {
						isEqualDivisions = false;
					}
				}
				if (isEqualDivisions) {
					maxDivisions = Math.max(maxDivisions, n / i);
				}
			}
		}
		return maxDivisions;
	}

	public static void main(String[] args) {
		String s1 = "AABAABAAB";
        String s2 = "AAAAAAAAA";
        String s3 = "AXAWEAGAW";

        // Output the maximum equal divisions for each string
        System.out.println("Max equal divisions for s1: " + maxEqualDivisions(s1));
        System.out.println("Max equal divisions for s2: " + maxEqualDivisions(s2));
        System.out.println("Max equal divisions for s3: " + maxEqualDivisions(s3));
	}

}
