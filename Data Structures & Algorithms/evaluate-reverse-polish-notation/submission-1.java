class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());

                if(token.equals("+")) {
                    stack.push(Integer.toString(op1 + op2));
                }
                if(token.equals("-")) {
                    stack.push(Integer.toString(op1 - op2));
                }
                if(token.equals("*")) {
                    stack.push(Integer.toString(op1 * op2));
                }
                if(token.equals("/")) {
                    stack.push(Integer.toString(op1 / op2));
                }

            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
