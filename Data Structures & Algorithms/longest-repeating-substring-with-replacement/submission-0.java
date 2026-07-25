class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int l=0, maxFreq=0, maxLen=0;

        for(int r=0; r<s.length(); r++){
            int idx=s.charAt(r) - 'A';
            count[idx]++;
            maxFreq = Math.max(maxFreq, count[idx]);

            while((r-l+1) - maxFreq>k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
