class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        for (int p : piles){
            right = Math.max(right, p);
        }
        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if(canEatAll(piles, h, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean canEatAll(int[] piles, int h, int k){
        int hours = 0;

        for(int pile : piles){
            hours += (pile + k -1) / k;
        }
        return hours <= h;
    }
}
