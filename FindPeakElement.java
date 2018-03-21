/**
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.



Answer: Use binary search, the logic is:
Lets say you have a mid number at index x, nums[x]
if (num[x+1] > nums[x]), that means a peak element HAS to exist on the right half of that array,
because (since every number is unique) 
1. the numbers keep increasing on the right side, and the peak will be the last element. 
2. the numbers stop increasing and there is a ‘dip’, or there exists somewhere a number such that nums[y] < nums[y-1],
which means number[x] is a peak element.

This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                left = mid2;
            } else {
                right = mid1;
            }
        }
        return left;
    }
}
