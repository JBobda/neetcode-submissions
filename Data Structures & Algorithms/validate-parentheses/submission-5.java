class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                char comp = ' ';

                if(!stack.isEmpty()) comp = stack.pop();

                if(c == ')' && comp != '(') return false;

                if(c == '}' && comp != '{') return false;

                if(c == ']' && comp != '[') return false;
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
