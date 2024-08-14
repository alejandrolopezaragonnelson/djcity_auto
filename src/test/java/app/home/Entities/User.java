package app.home.Entities;

public class User {

  String name = "Gloria";
  String lastname = "Fuertes";
  String age = "25";
  String country = "España";
  String province = "Madrid";
  String mail = "gloriafuertes@gmail.com";
  String phone = "649857815";
  String studyLevel = "ES-5";
  String process_campaigncode = "";

  public User(
    String name,
    String lastname,
    String age,
    String country,
    String province,
    String mail,
    String phone,
    String studyLevel,
    String process_campaigncode
  ) {
    this.name = name;
    this.lastname = lastname;
    this.age = age;
    this.country = country;
    this.province = province;
    this.mail = mail;
    this.phone = phone;
    this.studyLevel = studyLevel;
    this.process_campaigncode = process_campaigncode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getStudyLevel() {
    return studyLevel;
  }

  public void setStudyLevel(String studyLevel) {
    this.studyLevel = studyLevel;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getProcess_campaigncode() {
    return process_campaigncode;
  }

  public void setProcess_campaigncode(String process_campaigncode) {
    this.process_campaigncode = process_campaigncode;
  }
}
