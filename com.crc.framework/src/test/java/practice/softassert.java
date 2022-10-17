package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassert 
{
@Test	
public void createcustomerTest()
{
System.out.println("step1");
System.out.println("step1");
SoftAssert soft=new SoftAssert();
soft.assertEquals("A", "A");
System.out.println("step3");
System.out.println("step4");
soft.assertAll();
}
@Test
public void modifycustomerTest()
{
System.out.println("-----------");
System.out.println("step1");
System.out.println("step2");
System.out.println("step3");
}
}
