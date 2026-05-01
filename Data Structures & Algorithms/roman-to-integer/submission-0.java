class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = value(s.charAt(i));

            // check next value if it exists
            if (i + 1 < s.length()) {
                int next = value(s.charAt(i + 1));

                // subtract case
                if (current < next) {
                    total -= current;
                } else {
                    total += current;
                }
            } else {
                // last character
                total += current;
            }
        }

        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}