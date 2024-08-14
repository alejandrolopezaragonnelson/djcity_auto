package app.common.methods;

public class ProgressBarInstance {

  // Private static instance of the class
  private static ProgressBarInstance instance;
  private static int progress;
  private static int total;

  // Private constructor to prevent instantiation from outside
  private ProgressBarInstance() {}

  // Public method to get the instance of the class
  public static ProgressBarInstance getInstance() {
    if (instance == null) {
      instance = new ProgressBarInstance();
    }
    return instance;
  }

  public static void setInstance(ProgressBarInstance instance) {
    ProgressBarInstance.instance = instance;
  }

  public static int getProgress() {
    return progress;
  }

  public static void setProgress(int progress) {
    ProgressBarInstance.progress = progress;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    ProgressBarInstance.total = total;
  }

  public String getStringProgress(int current, int total) {
    ProgressBarInstance.progress = current;
    ProgressBarInstance.total = total;
    int porcentage = (int) (Math.floor((current / (float) total) * 100));
    return "[" + current + "/" + total + "] " + porcentage + "%";
  }
}
