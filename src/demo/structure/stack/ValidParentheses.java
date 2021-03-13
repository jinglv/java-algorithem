package demo.structure.stack;

import java.util.Stack;

/**
 * 有效的括号（leetcode 20题）
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 *
 * @author jingLv
 * @date 2020/12/01
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 将字符串拆为字符数组
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 左侧括号压入栈
                stack.push(c);
            } else {
                // 栈为空，则直接返回false
                if (stack.isEmpty()) {
                    return false;
                }
                // 右侧括号和目前栈顶的元素进行匹配，如果匹配成功，则出栈
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        // 匹配完成，栈为空，则表示都已匹配，直接返回true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("[{()}]，是否匹配？" + new ValidParentheses().isValid("[{()}]"));
        System.out.println("[]{}()，是否匹配？" + new ValidParentheses().isValid("[]{}()"));
        System.out.println("[({)}]，是否匹配？" + new ValidParentheses().isValid("[({)}]"));
    }
}
