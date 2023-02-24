/*
                                                              Wildcard Matching
Question:
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
Solution:

*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starti = -1;
        int startj = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i ++;
                j ++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                starti = i;
                startj = j;
                j ++;
            }
            else if (startj != -1) {
                j = startj + 1;
                i = starti + 1;
                starti ++;
            }
            else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j ++;
        }
        return j == p.length();
    }
}
