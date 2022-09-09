package com.allen.codedaily.day;

import java.util.logging.Logger;

/**
 * @author allen
 * @date 2022/9/9 16:00
 * @deprecated
 * 两段代码的逻辑都比较简单，实现两个 String 的比较是否相同，按照我们正常的逻辑来看，应该选择方法一，
 * 主要原因是：
 * 我们完全不需要去比较全部的字符，只需要比较遇到的第一个不一样的字符时，直接返回 false 即可。
 * 但是现实的情况却恰恰相反，当需要做一些比较敏感数据的比较时，都会选择 方法二，目的是：主要出于安全方面的考虑，防止外部恶意的使用 计时攻击 破解程序内部逻辑。
 *
 */
public class Day01 {

    public static void main(String[] args) {

        String s1 = "xyz";
        String s2 = "xyz";
        System.out.println(notSafeEqual(s1, s2));
        System.out.println(safeEqual(s1, s2));
    }

    public static boolean notSafeEqual(String x, String y) {
        if (x == null || y == null) {
            return false;
        }
        if (x.length() != y.length()) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < x.length(); i++) {
            // not safe
            if (x.charAt(i) != y.charAt(i)){
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean safeEqual(String x, String y) {
        if (x == null || y == null) {
            return false;
        }
        if (x.length() != y.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < x.length(); i++) {
            // prevent timing attacks 预防计时攻击
            result |= x.charAt(i) ^ y.charAt(i);
        }
        return result == 0;
    }

}
