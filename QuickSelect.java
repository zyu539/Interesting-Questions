/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int pivot = partition(nums, lo, hi);
            //System.out.println(pivot - lo + 1);
            if (pivot > k - 1) {
                hi = pivot - 1;
            } else if (pivot < k - 1) {
                lo = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[lo];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        Random rand = new Random();
        int pivot = lo + rand.nextInt(hi - lo + 1);
        int start = lo;
        int e = hi;
        //System.out.println(nums[pivot]);
        swap(nums, pivot, lo++);
        for (int i = lo; i < hi+1; i++) {
            if (nums[i] >= nums[start]) swap(nums, lo++, i);			
        }
	    swap(nums, --lo, start);
        // for (int i = start; i <= e; i++) {
        //     System.out.print(nums[i] + ",");
        // }
        System.out.println();
        return lo; 
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
