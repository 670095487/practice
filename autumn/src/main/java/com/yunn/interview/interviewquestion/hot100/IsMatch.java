package com.yunn.interview.interviewquestion.hot100;

/**
 * @author yunN
 * @date 2023/01/09.
 */
public class IsMatch {

    // dp
    // f[i][j] = f[i-1][j-1] ,if p.charAt(i) != *
    // f[i][j] = f[i-1][j] || f[i][j-2]
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果舍弃当前p的*位【因为是将(j-1,j)看作一个整体来匹配，所以一旦舍弃就意味着
                // f[i][j]的状态就来自f[i][j-2] 】
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    // 如果当前p的j位上是*，那么查看一下p的上一位是否和s的当前位匹配
                    // 如果匹配则说明当前的p位的*可以再次匹配掉s的当前位
                    boolean res = matches(s, p, i, j - 1);
                    if (res) {
                        // 因为是否舍弃p的第（j-1,j）位是双向选择，所以状态转移时只要有一种选择是true
                        // 那么f[i][j] 的状态应该就是true
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
