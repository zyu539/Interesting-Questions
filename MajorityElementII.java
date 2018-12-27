/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]


Hint: Use a variant Moore-Voting algorithm. 摩尔投票算法是基于这个事实：
每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个

Link: https://leetcode.com/problems/majority-element-ii/
*/
class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList=new ArrayList<>();
        if (nums==null||nums.length==0){
            return resultList;
        }

        int candidateA=nums[0];
        int candidateB=nums[0];
        int countA=0;
        int countB=0;

        for (int num:nums){
            if (num==candidateA){
                countA++;
                continue;
            }

            if (num==candidateB){
                countB++;
                continue;
            }
            if (countA==0){
                candidateA=num;
                countA++;
                continue;
            }

            if (countB==0){
                candidateB=num;
                countB++;
                continue;
            }

            countA--;
            countB--;
        }

        countA=0;
        countB=0;

        for (int num:nums){
            if (num==candidateA){
                countA++;
            }else if (num==candidateB){
                countB++;
            }
        }


        if (countA>nums.length/3){
            resultList.add(candidateA);
        }

        if (countB>nums.length/3){
            resultList.add(candidateB);
        }

        return resultList;
    }

}
