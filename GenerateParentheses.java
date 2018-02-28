/**Question: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  For example, given n = 3, a solution set is:

  [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
  ]
  Question Link: https://leetcode.com/problems/generate-parentheses/description/
*/

//Answer: Use backtracking method to go through all possible permutation.
//Note: we can understanding the recursive method by thinking it as a black-box method which we only know
//the functionality of it. Never, Never, Never dive in it. In this question, we think backtrack() as a method that will
//produce all possible combination of valid parentheses given an unfinished prefix string. Therefore, all possible permutations
//are add a "(" or a ")" to the prefix string.

class GenerateParentheses {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        backtrack(n, 0, 0, "");
        return res;
    }
    
    private void backtrack(int n, int left, int right, String s) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            backtrack(n, left + 1, right, s + "(");
        }
        if (right < left) {
            backtrack(n, left, right + 1, s + ")");
        }
    }
}
