package com.ylf;

/**
 * @author: leifeng.ye
 * @date: 2019-08-08
 * @desc: 希尔排序
 */
public class ShellSort {
   public static void shellSort(int[] array){
       int n=array.length;
       int d=n/2;
       while(d>0){
           for(int i=d;i<n;i++){
               int j=i-d;
               while(j>=0&&array[j]>array[j+d]){
                   int temp=array[j];
                   array[j]=array[j+d];
                   array[j+d]=temp;
                   j-=d;
               }
           }
           d=d/2;
       }
   }

    public static void printArray(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
           int array[]=new int[]{0,11,2,4,1,8,10,3,7};
           insert(array);
           printArray(array);
    }

    public static void insert(int[] array){
       int n=array.length;
       for(int k=1;k<n;k++){
           while(k>=0&&array[k-1]>array[k]){
                  int temp=array[k-1];
                  array[k-1]=array[k];
                  array[k]=temp;
                  k--;
           }
       }
    }
}
