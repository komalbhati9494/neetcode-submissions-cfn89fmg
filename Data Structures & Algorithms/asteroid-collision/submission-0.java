class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // right asteroid smaller, explode
                } else if (stack.peek() == -a) {
                    stack.pop(); // same size, both explode
                    alive = false;
                } else {
                    alive = false; // left asteroid destroyed
                }
            }

            if (alive) stack.push(a);
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}