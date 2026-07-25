//import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> Map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];

            if(Map.containsKey(complement)){
                return new int[] { Map.get(complement), i};
            }
            Map.put(nums[i], i);
        }
        return new int[] {};
    }
}
