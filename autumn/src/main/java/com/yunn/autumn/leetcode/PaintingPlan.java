package com.yunn.autumn.leetcode;

/**
 * Created by yunN on 2021/05/04.
 * <p>
 * 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
 * <p>
 * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
 * <p>
 * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ccw6C7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PaintingPlan {

    /*
        限制：1<= n <= 6
             0<= k <= n*n
     */
    public int paintingPlan(int n, int k) {
        int res = 0;

        //一个不涂或者全部都要涂，只有一种涂法
        if (k == 0 || k == n * n) return 1;
        //第一层循环表示涂 i 行 第二层循环表示涂 j 列
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                //当你涂了 i 行 j 列  则有 i * n + j * n个方格被涂过了
                //去掉重复计入的 i*j个方格 是否等于结果k
                if ((i * n) + (j * n) - (i * j) == k) {
                    res += C(i, n) * C(j, n);
                }
        }
        return res;
    }

    public int C(int x, int y) {
        if (x == 0) return 1;
        int n = 1;
        for (int i = 0; i < x; i++) {
            n *= (y - i);
        }
        for (int i = 1; i <= x; i++) {
            n /= i;
        }
        return n;
    }
}
