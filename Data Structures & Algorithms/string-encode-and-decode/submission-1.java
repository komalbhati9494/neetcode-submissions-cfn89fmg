class Solution {

    // Encode
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    // Decode
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            // Find delimiter '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(s.substring(i, j));
            j++; // move past '#'

            result.add(s.substring(j, j + length));
            i = j + length;
        }

        return result;
    }
}
