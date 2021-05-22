package Package2;

import java.util.Scanner;

public class GPACalculator_Final
{

	public static void main (String[] args)

{
	GPA_Calculator<Object> c = new GPA_Calculator<Object>();
	System.out.println("Type 1 to add a course, 2 to remove a course,  ");
	System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");


	Scanner keyboard7878 = new Scanner (System.in);
	

		while (1 ==1)
		{
			
		
	int n = 0;		
	 n = keyboard7878.nextInt();
	 
	 

	
	if (n==1)
	{
		c.GetValues();
		System.out.println(" ");
		System.out.println("Type 1 to add a course, 2 to remove a course,  ");
		System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");
		System.out.println(" ");
		
	
	}
	
	else if (n==2)
	{
		if (!c.isEmpty())
		{
			
		System.out.println(" ");
		System.out.println("Enter the course name you want removed(case sensitive and whitespace sensitive, type enter after name is typed)");
		String CourseName = null;
		Scanner keyboard78789 = new Scanner (System.in);
		CourseName = keyboard78789.nextLine();
		int position = c.getPosition(CourseName);
	//	System.out.println("****" + position);
		
		while (position < 0)
		{
			System.out.println(" ");
			System.out.println("Error: invalid course name");
			System.out.println("Enter the course name you want removed(case sensitive and whitespace sensitive, type enter after name is typed)");
			CourseName = keyboard78789.nextLine();
			position = c.getPosition(CourseName);
		}
		
		if (position >= 1)
		
		c.remove(position);
		System.out.println(" ");
		System.out.println("Type 1 to add a course, 2 to remove a course,  ");
		System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");
		System.out.println(" ");
		
		
		}
		else
		{
			System.out.println(" ");
			System.out.println("Error: No courses have been added yet");
			System.out.println(" ");
			System.out.println("Type 1 to add a course, 2 to remove a course,  ");
			System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");
			System.out.println(" ");
			
		}
	}
	
	
	
	else if (n==3)
	{
		c.getResults();
		System.out.println(" ");
		System.out.println("Type 1 to add a course, 2 to remove a course, ");
		System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");
		System.out.println(" ");
	}
	else if (n==4)
	{
		c.listCourses();
		System.out.println(" ");
		System.out.println("Type 1 to add a course, 2 to remove a course, ");
		System.out.println("3 to calculate your GPA, and 4 to show all courses and 5 to close the program.");
		System.out.println(" ");
	}
	else if (n==5)
	{
	
		System.out.println("Program has ended");
		c.clear();
		System.exit(0);
	}
	
	else
	{
		System.out.println("Error: invalid input. Enter 1, 2, 3, 4, or 5");
		System.out.println(" ");
	}
	
	
	
	}
		
	
	
}

}
