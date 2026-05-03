class Solution {
    public int splitArray(int[] nums, int k) {
        
        int left = 0, right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int current = 0;
        int count = 1;

        for (int num : nums) {
            if (current + num > maxSum) {
                count++;
                current = 0;
            }
            current += num;
        }

        return count <= k;
    }
}