package com.allen.codedaily.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 位运算-异或测试
 *
 * 1.交换律：a ^ b ^ c <=> a ^ c ^ b
 * 2.任何数于0异或为任何数 0 ^ n => n
 * 3.相同的数异或为0: n ^ n => 0
 *
 * @author allen
 * @date 2022/9/14 11:03
 */
public class Day03 {
    public static void main(String[] args) {
        // 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        int[] x = new int[]{2,2,1};
        int[] y = new int[]{4,1,2,1,2};

        // 使用简单，便于理解
        System.out.println("A-Method: x = "+ singleNumberA(x));
        System.out.println("A-Method: y = "+ singleNumberA(y));

        // 异或运算可能在开发中很少用到，不过这种位运算也给我们提供了一种计算或比较的思路
        System.out.println("B-Method: x = "+ singleNumberB(x));
        System.out.println("B-Method: y = "+ singleNumberB(y));

    }

    /**
     * map计数，简单暴力
     *
     * @param nums
     * @return int
     */
    public static int singleNumberA(int[] nums){
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length * 2);
        for (int k : nums){
            int v = map.getOrDefault(k, 0);
            // 上面使用了get的默认方法，不存在的k会直接返回0，所以这里不需要额外的判断
            map.put(k, v + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 异或位运算
     *
     * @param nums
     * @return int
     */
    public static int singleNumberB(int[] nums){
        // 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
