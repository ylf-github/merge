package com.ylf;

import java.util.Collections;

/**
 * @author: leifeng.ye
 * @date: 2019-08-08
 * @desc: 归并排序
 */
public class MergeSort {

    public static void merge(int[] array,int left,int mid,int right){
        int[] temp=new int[array.length];
        int point1=left;
        int point2=mid+1;
        int t=left;
        while(point1<=mid&&point2<=right){
            if(array[point1]<=array[point2]){
                temp[t++]=array[point1++];
            }
            else{
                temp[t++]=array[point2++];
            }
        }
        while(point1<=mid){
            temp[t++]=array[point1++];
        }
        while(point2<=right){
            temp[t++]=array[point2++];
        }
        for(int i=left;i<=right;i++){
            array[i]=temp[i];
        }
    }

    public static void split(int array[],int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            split(array,left,mid);
            split(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    public static void main(String[] args) {
        int array[]=new int[]{0,11,2,4,1,8,10,3,7};
        split(array,0,array.length-1);
        ShellSort.printArray(array);
    }
}
