package practice;

import org.testng.annotations.Test;

public class Demo3 
{
	@Test(priority=2)
	public void createCustomer() 
	{
	System.out.println("customer created");
	}
	@Test(priority=1)
	public void createEmployee() 
	{
	System.out.println("employee created");
	}
	@Test(priority=3)
	public void createstudent() 
	{
	System.out.println("student created");
	}
	}


