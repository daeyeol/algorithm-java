package codility.lesson07_Stacks_and_Queues;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

 S is empty;
 S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 S has the form "VW" where V and W are properly nested strings.
 For example, the string "{[()()]}" is properly nested but "([)()]" is not.

 Write a function:

 class Solution { public int solution(String S); }
 that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

 For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

 Assume that:

 N is an integer within the range [0..200,000];
 string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

 괄호의 쌍이 맞으면 1, 아니면 0
 */
public class Brackets {

    public static void main(String...args) {
        assertEquals(1, solution("{[()()]}"));
        assertEquals(0, solution("([)()]"));
        assertEquals(0, solution("())(()"));
    }

    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return 0;
                }

                char bracket = stack.pop();

                if ((c == '}' && bracket != '{') ||
                        (c == ']' && bracket != '[') ||
                        (c == ')' && bracket != '(')) {
                    return 0;
                }
            }
        }

        return stack.empty() ? 1 : 0;
    }

}