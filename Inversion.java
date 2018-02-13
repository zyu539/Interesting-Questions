//https://leetcode.com/problems/global-and-local-inversions/description/



//answer: As shown in <<Introduction to Algorithms>>, the number of inversions should be the same as steps taken to bring
//number back to the place it should be in ordered array using insertion sort. SO if the absolute diff between the number
//and the place it should be is larger than 1, we can confirm that global is larger than the local one.
class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length < 2) return true;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
