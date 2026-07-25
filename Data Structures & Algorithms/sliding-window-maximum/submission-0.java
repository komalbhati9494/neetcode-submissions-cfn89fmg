class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for(int i=0; i<n; i++){

            //remove elements out of window
            if(!dq.isEmpty() && dq.peekFirst() == i - k){
                dq.pollFirst();
            }

            //remove the smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            //add current index
            dq.offerLast(i);

            //add max to result
            if(i >= k - 1){
                result[idx++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
