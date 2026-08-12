package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class Customlistener implements IExecutionListener, ISuiteListener {

    public void onexecutionfinish()
    {
        long endtime=System.currentTimeMillis();
        System.out.println("Execution finished at--"+ endtime);
    }


    public void onexecutionstart()
    {
        long starttime=System.currentTimeMillis();
        System.out.println("Execution starts at --"+starttime);
    }


}