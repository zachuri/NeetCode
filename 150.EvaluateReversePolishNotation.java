import java.util.Stack;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens)  {
      if (token.equals("+")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a + b);
      }
      else if (token.equals("-")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a - b);
      }
      else if (token.equals("*")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a * b);
      }
      else if (token.equals("/")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a / b);
      }
      else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.pop();
  }
}