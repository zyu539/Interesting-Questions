import java.util.Scanner;

/**
 * Question: Output the number of chars need to be deleted to get a palindrome
 * @author zyu539
 *
 *
 *
 *
 * Answer: construct a reverse of the original string and find the Longest Common Substring of them(use dynamic programming).
 * Note: See lcs.pdf
 */
public class ConstrucPalindromeByDeletion {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.length() < 2) {
				System.out.println(line.length());
				continue;
			}
			String reverse = new StringBuilder(line).reverse().toString();
			int[][] res = new int[line.length()+1][line.length()+1];
			for (int i = 1; i < res.length; i++) {
				for (int j = 1; j < res.length; j++) {
					//System.out.println(i + " " + j + ": " + res[i-1][j-1] + "--" + line.charAt(i-1) + " " + reverse.charAt(j-1));
					res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
					res[i][j] = Math.max(res[i][j], res[i-1][j-1] + (line.charAt(i-1) == reverse.charAt(j-1) ? 1 : 0));
				}
			}
			System.out.println(line.length() - res[line.length()][line.length()]);
		}
	}

}
