package com.mvp.learn.leetcode.solution.MedianNumberOfTwoArray;

/**
 * 4.给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class TwoSortedArrayMedian {
    /**
     * 查找两个有序数组的中位数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        //// 若总个数为奇数，则直接取中间数。
        if (totalLength % 2 == 1) {
            int middleLength = totalLength / 2 + 1;
            return findKthElement(nums1, 0, nums2, 0, middleLength);
        }

        //// 若总个数为偶数，则需要分别查找左侧中位数和右侧中位数，再计算平均中位数。
        // 查找左侧中位数
        int leftLength = totalLength / 2;
        int leftMedian = findKthElement(nums1, 0, nums2, 0, leftLength);
        // 查找右侧中位数
        int rightLength = totalLength / 2 + 1;
        int rightMedian = findKthElement(nums1, 0, nums2, 0, rightLength);
        return (leftMedian + rightMedian) / 2.0;
    }

    /**
     * 二分法递归查找中位数值
     *
     * @param nums1  数组1
     * @param i      nums1 本次查找的起始位置
     * @param nums2  数组2
     * @param j      nums2 本次查找的起始位置
     * @param length 本次查找的区间长度
     * @return 中位数值
     */
    private int findKthElement(int[] nums1, int i, int[] nums2, int j, int length) {
        //// 边界情况
        // 若一个数组的区间起始索引越界，则选取另一数组区间中的最后一个元素，该值为上一轮递归的最小值。
        if (i >= nums1.length) {
            return nums2[j + length - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + length - 1];
        }

        // length=1时，只需比较两个数组区间范围内首元素值的大小
        if (length == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        //// 正常情况
        int halfLength = length / 2;
        int midVal1 = (i + halfLength - 1 < nums1.length) ? nums1[i + halfLength - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + halfLength - 1 < nums2.length) ? nums2[j + halfLength - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            // midVal1 < 中间数 < midVal2, 在num1索引范围[i + halfLength, length - halfLength] 和 num2索引范围[j, length - halfLength] 内递归查找
            return findKthElement(nums1, i + halfLength, nums2, j, length - halfLength);
        }

        return findKthElement(nums1, i, nums2, j + halfLength, length - halfLength);
    }

    public static void main(String[] args) {
        // 总个数为奇数
//        int[] nums1 = {3, 4, 5, 7, 10};
//        int[] nums2 = {6, 8, 10, 12};

        // 总个数为偶数
        int[] nums1 = {3, 4, 5, 7};
        int[] nums2 = {6, 8, 10, 12};
        TwoSortedArrayMedian obj = new TwoSortedArrayMedian();
        double kth = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(kth);
    }
}