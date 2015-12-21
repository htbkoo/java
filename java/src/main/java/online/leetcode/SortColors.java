package online.leetcode;

/**
 * Created by Hey on 21/12/15
 */

/*

https://leetcode.com/problems/sort-colors/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Subscribe to see which companies asked this question

*/

public class SortColors {
    public void sortColors(int[] nums) {
        final int length = nums.length;
        int red0Pointer = 0;
        int blue2Pointer = length - 1;

        for (int i = 0; (i <= blue2Pointer) && (red0Pointer<blue2Pointer) && (blue2Pointer>=0); ++i) {
            if (nums[i] == 0) {
                if (i > red0Pointer) {
                    swap(nums, i, red0Pointer);
                }
                ++red0Pointer;
            } else if (nums[i] == 2) {
                if (i<blue2Pointer) {
                    swap(nums, i, blue2Pointer);
                }
                --blue2Pointer;
                --i;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private class SortColorsByStraightForwardTwoPassUsingCountingSort {
        public void sortColors(int[] nums) {
            int red0 = 0;
            int white1 = 0;
            int blue2 = 0;
            for (int num : nums) {
                switch (num) {
                    case 0:
                        ++red0;
                        break;
                    case 1:
                        ++white1;
                        break;
                    case 2:
                        ++blue2;
                        break;
                }
            }

            for (int i = 0; i < red0; ++i) {
                nums[i] = 0;
            }
            for (int i = red0; i < red0 + white1; ++i) {
                nums[i] = 1;
            }
            for (int i = red0 + white1; i < red0 + white1 + blue2; ++i) {
                nums[i] = 2;
            }

        }
    }

    private class FailedAttemptForOnePassAlgorithm{
        public void sortColors(int[] nums) {
            final int length = nums.length;
            int red0Pointer = 0;
            int blue2Pointer = length - 1;

            for (int i = 0; i <= blue2Pointer; ++i) {
                while (nums[blue2Pointer] == 2) {
                    --blue2Pointer;
                    if (blue2Pointer < 0) {
                        return;
                    }
                }
                while (nums[red0Pointer] == 0) {
                    ++red0Pointer;
                    if (red0Pointer > length - 1) {
                        return;
                    }
                }

                if (nums[i] == 0) {
                    if (i > red0Pointer) {
                        swap(nums, i, red0Pointer);
                    }
                    ++red0Pointer;
                } else if (nums[i] == 2) {
                    if (i<blue2Pointer) {
                        swap(nums, i, blue2Pointer);
                    }
                    --blue2Pointer;
                    if (nums[i] == 0) {
                        if (i > red0Pointer) {
                            swap(nums, i, red0Pointer);
                        }
                        ++red0Pointer;
                    }
                }
            }

        }

        private void swap(int[] nums, int i, int j) {
            final int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
