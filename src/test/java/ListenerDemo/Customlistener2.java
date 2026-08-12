package ListenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class Customlistener2 implements IExecutionListener, ISuiteListener {


    public void onexecutionStart() {

        long startime = System.currentTimeMillis();
        System.out.println("Start time " + startime);
    }

    public void onexecutionfinish() {

        long endtime=System.currentTimeMillis();
        System.out.println("end time "+endtime);
    }


}
