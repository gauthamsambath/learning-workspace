package Leetcode;

import java.util.Stack;

/**
 * The type Valid paranthesis.
 */
public class ValidParanthesis {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String s = "[{()}]";
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println("Are the braces valid and closed properly = " + validParanthesis.isValid(s));
    }

    /**
     * Is valid boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean isValid(String s) {
        char[] braces = s.toCharArray();
        Stack<Character> braceStack = new Stack<>();
        for (int i = 0; i < braces.length; i++) {
            if (!braceStack.isEmpty()) {
                if (braces[i] == ')') {
                    modifyStackBasedOnCharacters(braces[i], '(', braceStack);
                } else if (braces[i] == '}') {
                    modifyStackBasedOnCharacters(braces[i], '{', braceStack);
                } else if (braces[i] == ']') {
                    modifyStackBasedOnCharacters(braces[i], '[', braceStack);
                } else if (braces[i] == '(' || braces[i] == '{' || braces[i] == '[') {
                    braceStack.push(braces[i]);
                }
            } else {
                braceStack.push(braces[i]);
            }
        }
        return braceStack.isEmpty();
    }

    /**
     * Modify stack based on characters.
     *
     * @param brace      the brace
     * @param c          the c
     * @param braceStack the brace stack
     */
    private void modifyStackBasedOnCharacters(char brace, char c, Stack<Character> braceStack) {
        if (braceStack.peek() == c) {
            braceStack.pop();
        } else {
            braceStack.push(brace);
        }
    }
}
