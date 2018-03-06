/**
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.




Answer: Use a greedy slide window method. The end of the window keep growing by one in each
loop and we only move the start of the window to right when the substring becomes invalid.

Note: the window will never shrink and start point will never go back. the max need only to
be updated when a hight max comes.

Link: https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
*/
class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[126];
        int start = 0, max = 0;
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end)]);
            if (max + k < end-start+1) {
                count[s.charAt(start++)]--;
            }
        }
        return s.length() - start;
    }
}
