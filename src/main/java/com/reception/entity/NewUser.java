package com.reception.entity;

import java.util.Objects;

public class NewUser {

    private String first_name;
    private String last_name;
    private String patronymic;
    private String email;
    private String password;
    private String phoneNumber;
    private String birthday;
    private String mathResult;
    private String physResult;
    private String langResult;
    private String sertResult;
    private static final String ROLE = "user";

    public NewUser(String first_name, String last_name, String patronymic, String email,
                   String password, String phoneNumber, String birthday, String mathResult,
                   String physResult, String langResult, String sertResult) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.mathResult = mathResult;
        this.physResult = physResult;
        this.langResult = langResult;
        this.sertResult = sertResult;

    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMathResult() {
        return mathResult;
    }

    public void setMathResult(String mathResult) {
        this.mathResult = mathResult;
    }

    public String getPhysResult() {
        return physResult;
    }

    public void setPhysResult(String physResult) {
        this.physResult = physResult;
    }

    public String getLangResult() {
        return langResult;
    }

    public void setLangResult(String langResult) {
        this.langResult = langResult;
    }

    public String getSertResult() {
        return sertResult;
    }

    public void setSertResult(String sertResult) {
        this.sertResult = sertResult;
    }

    public static String getROLE() {
        return ROLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(first_name, newUser.first_name) &&
                Objects.equals(last_name, newUser.last_name) &&
                Objects.equals(patronymic, newUser.patronymic) &&
                Objects.equals(email, newUser.email) &&
                Objects.equals(password, newUser.password) &&
                Objects.equals(phoneNumber, newUser.phoneNumber) &&
                Objects.equals(birthday, newUser.birthday) &&
                Objects.equals(mathResult, newUser.mathResult) &&
                Objects.equals(physResult, newUser.physResult) &&
                Objects.equals(langResult, newUser.langResult) &&
                Objects.equals(sertResult, newUser.sertResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first_name, last_name, patronymic, email, password, phoneNumber, birthday, mathResult, physResult, langResult, sertResult);
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mathResult='" + mathResult + '\'' +
                ", physResult='" + physResult + '\'' +
                ", langResult='" + langResult + '\'' +
                ", sertResult='" + sertResult + '\'' +
                '}';
    }
}
