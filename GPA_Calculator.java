package Package2;

import java.util.Scanner;


public class GPA_Calculator<T>
{
	 private Course lastCourse; 
	 private int numberOfEntries;
	 private double points;
	 private int hours;
	 private double GPA;
	
	 private Course tracker;
		private Course tracker2;
		private Course tracker3;
		
	 public GPA_Calculator()
	 {
	 initializeDataFields();
	 } 
	 
	 //clears list
	
	 public void clear()
	 {
	 initializeDataFields();
	 } 

	 //Initial values
	 private void initializeDataFields()
	 {
	 
	
	lastCourse = null;
	 numberOfEntries = 0;
	 } 

	//Gets course at a given position
	 private Course getCourseAt(int givenPosition)
	 {

		 GPA_Calculator.Course currentCourse = new Course(null, 0, 0);
		 currentCourse = lastCourse;
		 if (givenPosition == numberOfEntries)
		 {
			 return currentCourse;
		 }
		 
		 else
		 {
		 
		 for (int counter = numberOfEntries; counter > givenPosition; counter--)
		 { 
			 currentCourse = currentCourse.getNextCourse();
		 }
			 
			 return currentCourse;

		 }
		 
		 } 

	 // returns position of course given name
	 
	 public int getPosition (String CourseName)
	 {
		 int i;
		 String SelectedCourseName;
		 boolean found = false;
		 Course c;
		 
		 for (i=1; i <= numberOfEntries && !found; i++)
		 {
			 c = (Course)getEntry(i);
			 SelectedCourseName = c.name;
			 if (SelectedCourseName.contentEquals(CourseName))
			 {
				 found = true;
			 }
			 
		 }
		 if (found == true)
		 {
			 return i-1;
		 }
		 else
		 {
			 return -1;
		 }
		 
		 
	 }
	
	 class Course 
	 {
		 private String name; 
		 private Course next; 
		 private double GPA;
		 private int hours;
		 private double p = GPA* hours;
		 
		 private int position;
		 
		  private Course(String dataPortion, int Hours, double Grade)
		  {
		  this(dataPortion, null, Hours, Grade);
		  } 
		  
		  private Course getNextCourse()
		  {
			  return next;
		  }
		 
		  private Course(String dataPortion, Course nextCourse, int h, double GP)
		  {
		  name = dataPortion;
		  next = nextCourse;
		  hours = h;
		  GPA = GP;
		  p = GPA * hours;
		  
		  } 
	 }
// adds entry at given position
	 
	public void add(T newEntry)
	{
		{
			Course t = new Course(null, 0, 0);
			t = (Course)newEntry;
			
			
				t.next = lastCourse;	
				 numberOfEntries++;
				 t.position = numberOfEntries;
				 lastCourse = t;
			
			}
		
	}


	
	//Removes entry at given position


	 
	public T remove(int givenPosition)
	{
		if (givenPosition <= 0)
		{
			System.out.println("Error: invalid position");
			return null;
		}
		else if (numberOfEntries == 1)
		{
			this.clear();
	//		System.out.println(numberOfEntries);
			return null;
		}
		else
			
		{
			if (givenPosition ==1)
			{
				Course t = lastCourse;
				while(givenPosition < t.position)
				{
					if (t.position == 2)
					{
						t.next = null;
						t.position --;
					}
					else
					{
					t.position --;
					t= t.next;
					}
					
				}
				numberOfEntries --;
			}
			else if (givenPosition == numberOfEntries)
			{
				lastCourse = lastCourse.next;
				numberOfEntries--;
						
			}
			else
			{
				
		tracker = (Course)getEntry(givenPosition);
		tracker2 = tracker.next;
		tracker3 = (Course)getEntry(givenPosition+1);
		tracker3.next = tracker2;
		tracker = new Course(null, 0, 0);
		
		Course t = lastCourse;
		
			
					
		while(givenPosition < t.position)
		{
			t.position --;
			t= t.next;
			
		}
		
		numberOfEntries--;
			}
		return null;
		}
	}

	 
// returns entry at given position
	 
	public T getEntry(int givenPosition)
	{
		Course t = lastCourse;
		if (givenPosition > 0 && givenPosition <=numberOfEntries)
			
		{			
		t = getCourseAt(givenPosition);
			
		return (T)t;
		}
		
		else
			
		{	

			System.out.println("error: position is out of bounds.");
			return null;
		}
	} 

	// lists all courses in list 
	public void listCourses()
	{
		int i;
		Course t;
	
		System.out.println("The list contains:");
		
		for (i=1; i<=numberOfEntries; i++)
		{
			t= (Course)getEntry(i);
			System.out.println("Course Name: " +t.name+" hours: "+ t.hours + " GPA for course: " + t.GPA +" ");
		
		}
		
	}
	 // returns number of entries
	public int getLength()
	{
		
		return numberOfEntries;
	}
	 
	//true if empty
	public boolean isEmpty() {
	
		return (numberOfEntries == 0);
	} 

	//calculates hours
	public void setHours()
	{
		int i;
		Course t;
	
		int totalhours= 0;
		
		for (i=1; i<=numberOfEntries; i++)
		{
			t= (Course)getEntry(i);
			totalhours =totalhours + t.hours;
		
		}	
		
		hours = totalhours;
	}
	
	//Calculates points
	public void setPoints()
	{
		int i;
		Course t;
	
		double totalGPA= 0;
		
		for (i=1; i<=numberOfEntries; i++)
		{
			t= (Course)getEntry(i);
			totalGPA =totalGPA + t.p;
		
		}	
		
		points = totalGPA;
	}

	//Calculates GPA
	public void setGPA()
	{
		GPA = points / hours;
	}

	//Returns hours
	public int getHours()
	{
		return hours;
	}

	// Returns Points
	public double getPoints()
	{
		return points;
	}
	
	// returns GPA
	public double getGPA()
	{
		return GPA;
	}
// shows hours, points, and GPA
	public void getResults ()
	{
		setPoints();
		setHours();
		setGPA();
		
		System.out.println("Hours:");
		System.out.println(getHours());
		System.out.println(" ");
		System.out.println("Total points:");
		System.out.println(getPoints());
		System.out.println(" ");
		System.out.println("GPA:");
		System.out.println(getGPA());
		System.out.println(" ");
		System.out.println();
	}

	//Adds Course to the list
	public void Create (String s, int i, double d)
	{
		Course c = new Course (s, i, d);
		T t = (T) c;
		this.add(t);
	}
// gets values to add to create a new course which will be added to the list
	public void GetValues ()
	{
		String s;
		int i;
		double d;
		
		System.out.println("Enter the course Name:");
		Scanner keyboard = new Scanner (System.in);
		s = keyboard.nextLine();
		
		System.out.println("Enter the amount of hours:");
		Scanner keyboard2 = new Scanner (System.in);
		i = keyboard2.nextInt();
		
		System.out.println("Enter the GPA:");
		Scanner keyboard3 = new Scanner (System.in);
		d = keyboard3.nextDouble();
		
		Create(s, i, d);
		

		
		
	}

}
