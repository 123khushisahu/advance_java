package com.pack1;

import java.util.Scanner;

public class CLASSA {
	Scanner sc=new Scanner(System.in);
	void meth1() {
		System.out.println("ENTER THE NO YOU LIKE MOST");
		int x=Integer.parseInt(sc.nextLine());
		
		System.out.println("i like '"+x+"' very much");
	}

	public static void main(String[] args) {
		new CLASSA.meth1();

	}

}
