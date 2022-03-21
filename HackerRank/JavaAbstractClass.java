import java.util.*;

/***************************************************************************
 * A Java abstract class is a class that can't be instantiated. That means 
 * you cannot create new instances of an abstract class. It works as a base 
 * for subclasses. You should learn about Java Inheritance before attempting 
 * this challenge.
 * 
 * Following is an example of abstract class:
 * 
 */

abstract class Book{
	String title;
	abstract void setTitle(String s);
	String getTitle(){
		return title;
	}	

//Write MyBook class here

class MyBook extends Book {

    @Override
    void setTitle(String s) {
        title = s;        
    }
}

public class JavaAbstractClass{
	
	public static void main(String []args){
		//Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
		
	}
}