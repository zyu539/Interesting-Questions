/**
Question: There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
Link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/



Answer: This kind of question can be thought as a general kind of question, say find the kth element in
log time complexity. So we write a function to find the kth value.

first we can compare A[k/2-1] with B[k/2-1], note that you can choose all index that sum up to k, but half
is the most efficient. if A < B then all element in A such that A[i] < A[k/2-1] will not be the median value,
so we can depreciate them, the same for B. We do this recursively until one of the array becomes empty or
A[k/2-1] == B[k/2-1].

Idea from: https://ask.julyedu.com/question/197
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findK(nums1, nums2, nums1.length, nums2.length, total / 2 + 1);
        } else {
            return (findK(nums1, nums2, nums1.length, nums2.length, total / 2 + 1)
                + findK(nums1, nums2, nums1.length, nums2.length, total / 2)) / 2;
        }
    }
    
    /**
     * m: the search space of A
     * n: the search space of B
     * k: the kth element of the merged array
     */
    private double findK(int[] A, int[] B, int m, int n, int k) {
        if (m > n) return findK(B, A, n, m, k);
        
        int lenA = A.length;
        int lenB = B.length;
        
        if (m == 0) {
            return B[lenB - n + k-1];
        }
        
        if (k == 1) {
            return Math.min(A[lenA-m], B[lenB-n]);
        }
        
        int pA = Math.min(k/2, m);
        int pB = k - pA;
        if (A[lenA - m + pA - 1] < B[lenB - n + pB - 1]) {
            return findK(A, B, m-pA, n, k-pA);
        } else if (A[lenA - m + pA - 1] > B[lenB - n + pB - 1]) {
            return findK(A, B, m, n-pB, k-pB);
        } else {
            return A[lenA - m + pA - 1];
        }
    }
}
