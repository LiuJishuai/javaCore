package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Message:  created by Liujishuai on 2015年11月10日
 * 
 * @Description: 基础算法
 */
public class BaseArithmetic {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(11);list.add(16);list.add(8);list.add(88);list.add(23);list.add(19);
		list.add(11);list.add(56);list.add(49);list.add(6);list.add(22);list.add(18);
		//第一种，桶算法
		List<Integer> sortList1=sortBucketArithmetic(90,list);
		System.out.println("桶算法：");
		for (Integer obj:sortList1) {
			System.out.print(obj+"  ");
		}
		System.out.println();
		System.out.println("--------------------------------------------");
		//第二种 冒泡排序
		int[] numberArray = sortBubble(list);
		System.out.println("冒泡：");
		for(int i=0;i<numberArray.length;i++){
			System.out.print(numberArray[i]+"  ");
		}
		System.out.println();
		System.out.println("--------------------------------------------");
		//第二种快速排序
				int[] quickNumber = quickSort(list, 0, list.size()-1);
				System.out.println("快速排序：");
				for(int i=0;i<quickNumber.length;i++){
					System.out.print(quickNumber[i]+"  ");
				}
				System.out.println();
				System.out.println("--------------------------------------------");
	}
	
	/**
	 * 桶算法
	 * 优点：快
	 * 缺点 浪费空间，范围多大，空间就得开多大
	 * 时间复杂度 O(M+N)
	 * M,N为数字范围和需要排序的数字个数
	 * @param range 数字范围，
	 * @param nuberlist  需要排序的数字列表
	 * @return
	 */
	public static List<Integer> sortBucketArithmetic(int range,List<Integer> nuberlist){
		int[] books=new int[range];
		List<Integer> valueList=new ArrayList<Integer>();
		for(int i=0;i<range;i++){
			books[i]=0;
		}
		for(Integer temp:nuberlist){
			books[temp]++;
		}
		for(int i=0;i<range;i++){
			for(int j=0;j<books[i];j++){
				valueList.add(i);
			}
		}
		return valueList;
		
	}
	/**
	 * 冒泡排序
	 * 缺点：慢，效率低下
	 * 时间复杂度 O(N^2)
	 * 没有什么值得推荐的
	 * @param nuberlist 需要排序的列表
	 * @return
	 */
	public static int[] sortBubble(List<Integer> list){
		int[] numberArray=new int[list.size()];
		for(int i=0;i<list.size();i++){
			numberArray[i]=list.get(i);
		}
		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size();j++){	
				if(numberArray[i]>numberArray[j]){
					int temp=numberArray[i];
					numberArray[i]=numberArray[j];
					numberArray[j]=temp;
				}
			}
		}
		return numberArray;
	}
	/**
	 * 快速排序
	 * 最常用的排序方法
	 * 时间复杂度：最慢O(N^2) 平均O(NlogN)
	 * @param list 需要排序的列表
	 * @param begin开始排序的最左边位置
	 * @param end 开始排序的最右边位置
	 * @return
	 */
	public static int[] quickSort(List<Integer> list,int begin,int end){
		int[] numberArray=new int[list.size()];
		for(int i=0;i<list.size();i++){
			numberArray[i]=list.get(i);
		}
	    
		return quicksort(numberArray, begin, end);
	}
	 static int[] quicksort(int n[], int left, int right) {
	        int dp;
	        if (left < right) {
	            dp = partition(n, left, right);
	            quicksort(n, left, dp - 1);
	            quicksort(n, dp + 1, right);
	        }
	        return n;
	    }
	 static int partition(int n[], int left, int right) {
	        int pivot = n[left];
	        while (left < right) {
	            while (left < right && n[right] >= pivot)
	                right--;
	            if (left < right)
	                n[left++] = n[right];
	            while (left < right && n[left] <= pivot)
	                left++;
	            if (left < right)
	                n[right--] = n[left];
	        }
	        n[left] = pivot;
	        return left;
	    }
}

