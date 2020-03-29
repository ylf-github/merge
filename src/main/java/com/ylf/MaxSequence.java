package com.ylf;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: leifeng.ye
 * @date: 2019-08-13
 * @desc: 求最大连续子串和
 */
public class MaxSequence {
    public static void main(String[] args) {
        int[] a=new int[]{1,3,-2,4,-5};
        System.out.println(maxSequence(a));
    }
    public static  int maxSequence(int[] args){
        int max,temp;
        max=args[0];
        temp=args[0];
        for(int i=1;i<args.length;i++){
            if(temp<0){
                temp=args[i];
            }
            else{
                temp+=args[i];
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }
}
