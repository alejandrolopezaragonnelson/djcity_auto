package app.common;

import app.common.methods.ProgressBarInstance;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class DotTestListener extends TestListenerAdapter {

  @Override
  public void onTestFailure(ITestResult tr) {
    log("❌ " + tr.getName() + " " + printProgres());
  }

  @Override
  public void onTestSkipped(ITestResult tr) {
    log("❗ " + tr.getName() + " " + printProgres());
  }

  @Override
  public void onTestSuccess(ITestResult tr) {
    log("✅ " + tr.getName() + " " + printProgres());
  }

  private void log(String string) {
    System.err.println(string);
  }

  private String printProgres() {
    int currentProgress = ProgressBarInstance.getProgress() + 1;
    int total = ProgressBarInstance.getInstance().getTotal();
    return ProgressBarInstance.getInstance().getStringProgress(currentProgress, total);
  }
}
