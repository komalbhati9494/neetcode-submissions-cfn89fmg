class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Convert string to char array
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // Sorted string as key
            String key = new String(chars);

            // Add string to map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}
