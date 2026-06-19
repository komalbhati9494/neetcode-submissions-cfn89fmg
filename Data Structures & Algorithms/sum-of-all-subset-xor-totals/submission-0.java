class Solution {

    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return sum;
    }

    private void dfs(int[] nums, int index, int xor) {

        if (index == nums.length) {
            sum += xor;
            return;
        }

        // Exclude current element
        dfs(nums, index + 1, xor);

        // Include current element
        dfs(nums, index + 1, xor ^ nums[index]);
    }
}