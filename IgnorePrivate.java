import java.lang.reflect.*;
class Student  {
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return this.id + " " + this.name;
	}

	private void show(int x,float z) {
		System.out.println(id + " " + name+" int: "+x+" float: "+z);
	}
}

public class IgnorePrivate {
	public static void main(String args[]) throws Throwable {
    //get a class object of the class named Student
    //getName() returns just the class name instead of the full package+class name
		Class c = Class.forName(Student.class.getName());
		
		//create a normal Student object
		Student s=new Student(111,"jan");
    //get a method object from the class 'c', which has method name "show", and takes an int and a float as arguments
		Method meth=c.getDeclaredMethod("show",int.class, float.class);
    //set the method as accessible
		meth.setAccessible(true);
    //.invoke(s,5,5.6F) translates to s.show(5,5.6F)
		meth.invoke(s,5,5.6F);
  }
}
