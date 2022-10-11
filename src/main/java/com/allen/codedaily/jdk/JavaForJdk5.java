package com.allen.codedaily.jdk;

import java.util.ArrayList;

/**
 * @author allen
 * @date 2022/10/11 14:23
 */
public class JavaForJdk5 {
    public static void main(String[] args) {
        // 泛型
        ArrayList list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        // 自动拆装箱
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("111");
//        int x = strList.get(0).parseInt();
//        int y = strList.get(0);

        // for-each
        for(int i = 0; i< strList.size(); i++){
            System.out.println(strList.get(0));
        }

        for (String str : strList){
            System.out.println(str);
        }

        // static import 静态导入
        // 变长参数，可变参数
        service();
    }

    private static void service(int ...args){
        System.out.println(args.toString());
    }
}
