class Solution {
    public int evalRPN(String[] tokens) {
    
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop();  // second operand
                int a = stack.pop();  // first operand

                int result = 0;
                if (token.equals("+")) result = a + b;
                else if (token.equals("-")) result = a - b;
                else if (token.equals("*")) result = a * b;
                else result = a / b;  // truncates toward zero

                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
