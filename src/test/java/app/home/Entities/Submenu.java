package app.home.Entities;

public class Submenu {

  String href;
  String data_drupal_link_system_path;
  int menuOption;

  public Submenu(String href, String data_drupal_link_system_path, int menuOption) {
    this.href = href;
    this.data_drupal_link_system_path = data_drupal_link_system_path;
    this.menuOption = menuOption;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getData_drupal_link_system_path() {
    return data_drupal_link_system_path;
  }

  public void setData_drupal_link_system_path(String data_drupal_link_system_path) {
    this.data_drupal_link_system_path = data_drupal_link_system_path;
  }

  @Override
  public String toString() {
    return (
      "Submenu [href=" +
      href +
      ", data_drupal_link_system_path=" +
      data_drupal_link_system_path +
      ", menuOption=" +
      menuOption +
      "]"
    );
  }

  public String getCssSelector() {
    if (this.getData_drupal_link_system_path() == null) {
      return ("a[href='" + this.getHref() + "']");
    } else {
      return (
        "a[href='" +
        this.getHref() +
        "'][data-drupal-link-system-path='" +
        this.getData_drupal_link_system_path() +
        "']"
      );
    }
  }

  public int getMenuOption() {
    return menuOption;
  }

  public void setMenuOption(int menuOption) {
    this.menuOption = menuOption;
  }
}
