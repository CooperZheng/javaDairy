package com.qianfeng.controller;

import java.util.Arrays;

/**
 * @ClassName demo1
 * @Description: TODO
 * @Author 臧红久
 * @Date 2019/10/18
 * @Version V1.0
 **/
public class demo1 {
    public static void main(String[] args) {
        int grap=2;//递减率
        int[] arr={1,41,73,3,92,13,43,21,66,77,66,44,55};
        int size = arr.length;//长度
        int i=1;//计数

        grap= (int) (size*0.8);
        while (grap>=1){
            System.out.println("第"+i+"次交换前"+ Arrays.toString(arr));
            for (int j = grap; j < size; j++) {
                if (arr[j]<arr[j-grap]){
                    System.out.println("交换前"+arr[j-grap]+" → "+arr[j]);
                    int n=arr[j];
                    arr[j]=arr[j-grap];
                    arr[j-grap]=n;
                    System.out.println("交换后"+arr[j-grap]+"   "+arr[j]);
                }
            }
            System.out.println("第"+i+"次交换"+ Arrays.toString(arr)+"间隔为："+grap);
            System.out.println();
            i++;
            grap= (int) (grap*0.8);
            if (grap<1){
                break;
            }
        }
    }
}
