package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class Customlistener implements IExecutionListener, ISuiteListener {


    public void onExecutionFinish()
    {
        long endtime=System.currentTimeMillis();
        System.out.println("--Finished execution at--"+endtime);
    }
  //What more can do with listeners
    // Send email to the QA lead
    // Write Java code to write the Email to QA lead


    public void onExecutionStart()
    {
        long starttime=System.currentTimeMillis();
        System.out.println("--Started execution at--"+starttime);
    }
    // Excel File Read , JSON File, Allure Report Start, Reporting, Logs starting
    // Email to QA lead automation started!!
}
