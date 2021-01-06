
package com.vk.Week_01;


import java.util.Arrays;

public class Test01 {

    public static void main(String[] args) {


    }


    //删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[nums.length - 1];
                nums = Arrays.copyOf(nums, nums.length - 1);
            }
        }
        return nums.length;
    }


    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

}

