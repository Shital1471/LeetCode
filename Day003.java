/*
                                                                         Generate Parentheses
Question:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]
Constraints:

1 <= n <= 8

Solution:
*/
class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        /// Recursively generate parentheses
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }
     private void generateParenthesis(List<String> result, String s, int open, int close, int n) {
        // Base case
        if (open == n && close == n) {
            result.add(s);
            return;
        }
        // If the number of open parentheses is less than the given n
        if (open < n) {
            generateParenthesis(result, s + "(", open + 1, close, n);
        }
        // If we need more close parentheses to balance
        if (close < open) {
            generateParenthesis(result, s + ")", open, close + 1, n);
        }
    }
}
