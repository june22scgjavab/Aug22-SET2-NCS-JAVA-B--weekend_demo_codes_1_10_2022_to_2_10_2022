package vargsdemo;

public class VargDemo {

	public static void display(String ...strings )
	{
		for(String s : strings)
		{
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		  
		display("hi","hello");
		display("hi","hello","bye");

	}

}
