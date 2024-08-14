package app.common;

import app.common.methods.ProgressBarInstance;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SimpleSuiteListener implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    log("🚀 Running", suite);
    // Initial call to print 0% progress
    ProgressBarInstance.getInstance().setTotal(suite.getAllMethods().size());
  }

  @Override
  public void onFinish(ISuite suite) {
    log("🏁 Completed", suite);
  }

  private static void log(String prefix, ISuite suite) {
    String msg = prefix + " execution for the suite named " + suite.getName();
    System.err.println(msg);
  }
}
