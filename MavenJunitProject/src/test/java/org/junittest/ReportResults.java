package org.junittest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ReportResults 
{
@Test
public void Test1()
{
	Result r = JUnitCore.runClasses(A.class,C.class,B.class);
	
System.out.println("Run Count......."+r.getRunCount());
System.out.println("Run Time......."+r.getRunCount());
System.out.println("Ignore Count......."+r.getIgnoreCount());
System.out.println("Failure Count......."+r.getFailureCount());
System.out.println("Suite result......."+r.wasSuccessful());

	List<Failure> fails = r.getFailures();
	for (Failure x : fails)
		System.out.println(x.getMessage());
}

}
