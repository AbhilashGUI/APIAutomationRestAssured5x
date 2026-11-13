package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListener3 implements IExecutionListener, ISuiteListener {

    public void onexecutionstart()
    {
        long starttime=System.currentTimeMillis();
        System.out.println("Started at"+starttime);
    }

    public void onexecutionfinish()
    {
        long endtime=System.currentTimeMillis();
        System.out.println("Ended at"+endtime);


    }

}
