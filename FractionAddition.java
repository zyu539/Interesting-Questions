/**
Question: https://leetcode.com/problems/fraction-addition-and-subtraction/description/



Answer: use zero-width assertion to capture all the numbers with their signs. Then add them one by one
and divided them by their GCD to ensure irreducible fraction.
*/
class FractionAddition {
    public String fractionAddition(String expression) {
        Scanner s = new Scanner(expression);
        s.useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (s.hasNextInt()) {
            int a = s.nextInt();
            int b = s.nextInt();
            A = A * b + a * B;
            B = B * b;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }
    
    private int gcd(int a, int b) {
        return a != 0 ? gcd(b % a, a) : Math.abs(b);
    }
}
