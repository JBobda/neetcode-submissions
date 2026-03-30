class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if(val == '(' || val == '{' || val == '[') {
                stack.push(val);
            } else {
                if(stack.size() == 0)
                    return false;
                    
                char top = stack.pop();
                if(val == ')' && top != '(') {
                    return false;
                }
                if(val == '}' && top != '{') {
                    return false;
                }
                if(val == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.size() == 0 ? true : false;
    }
}
