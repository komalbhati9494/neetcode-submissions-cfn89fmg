class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        
        int currentMax = 0;
        int maxAccumulator = nums[0];
        
        
        int currentMin = 0;
        int minAccumulator = nums[0];
        
        for (int num : nums) {
            totalSum += num;
            
            
            currentMax = Math.max(num, currentMax + num);
            maxAccumulator = Math.max(maxAccumulator, currentMax);
            
            
            currentMin = Math.min(num, currentMin + num);
            minAccumulator = Math.min(minAccumulator, currentMin);
        }
        
        
        if (maxAccumulator > 0) {
            return Math.max(maxAccumulator, totalSum - minAccumulator);
        } else {
            return maxAccumulator;
        }
    }
}