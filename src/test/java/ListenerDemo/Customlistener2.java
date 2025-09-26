package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class Customlistener2 implements IExecutionListener, ISuiteListener {

    public void  onExecutionFinish()
    {
        long endtime=System.currentTimeMillis();
        System.out.println("--Finished execution at--"+endtime);

    }

    public void onExecutionStart()
    {
        long starttime= System.currentTimeMillis();
        System.out.println("--Started execution at--"+starttime);
    }
}
