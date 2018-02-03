//Question: sum from 1 to n without using if, while, case, multiply and devision.



//Answer: use recursive to add and short-circuit to terminate.
public class SumAll {
    public int Sum_Solution(int n) {
        boolean tmp = (n > 0) && ((n = n + Sum_Solution(n-1)) != 0);
        return n;
    }
}
