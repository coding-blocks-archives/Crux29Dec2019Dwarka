package Lecture6;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>();
		
		list.toString();
		System.out.println(list);
		System.out.println(list.size());
	//	System.out.println(list.get(3));
		
	//	System.out.println(list.set(2,10));
	//	list.add(3, 10);
		
		list.add(10);
		System.out.println(list);
		System.out.println(list.size());
		
		
		list.add(20);
		System.out.println(list);
		System.out.println(list.size());
		list.add(0,5);
		System.out.println(list);
		System.out.println(list.size());
		
		
		list.add(40);
		System.out.println(list);
		System.out.println(list.size());
		
		
		list.add(50);
		System.out.println(list);
		System.out.println(list.size());
		
		list.set(2,30);
		System.out.println(list);
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		ArrayList<ArrayList<Integer>> list2=new ArrayList<>();
		
		System.out.println(list2);
		
		//System.out.println(list2.get(0));
		list2.add(new ArrayList<>());
		list2.add(new ArrayList<>());
		list2.add(new ArrayList<>());
		
		System.out.println(list2);
		list2.get(0).add(10);
		list2.get(1).add(20);
		list2.get(1).add(30);
		
		System.out.println(list2);
		System.out.println(list2.size());
		System.out.println(list2.get(1).size());
		System.out.println(list2.get(2).size());
		
		
		int[] arr= {50,40,30,20,10,5};
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
