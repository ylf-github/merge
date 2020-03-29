package com.ylf;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        System.out.println(getResult(array));
    }
    public static int getResult(int[] nums) {
        // write your code here
        if(nums.length==0){
            return 0;
        }
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}