package practice;

import org.testng.annotations.Test;

public class Demo4
{
	@Test
	public void createcustomer()
	{
		System.out.println("customer created");
	}
	@Test(dependsOnMethods="createcustomer")
	public void createemployee()
	{
	System.out.println("employee created");
	}
	@Test(dependsOnMethods="createcustomer")
	public void createstudent()
	{
	System.out.println("student created");
	}
}
