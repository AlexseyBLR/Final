package com.reception.entity;

import java.util.Objects;

public class NewUser {

    private String first_name;
    private String last_name;
    private String patronymic;
    private String email;
    private String password;
    private String phoneNumber;
    private int mathResult;
    private int physResult;
    private int langResult;
    private int sertResult;
    private String role;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public User(){}

=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018
    public User(String first_name, String last_name, String patronymic, String email,
                String password, String phoneNumber, int mathResult,
                int physResult, int langResult, int sertResult, String role) {
=======
    public NewUser(String first_name, String last_name, String patronymic, String email,
                   String password, String phoneNumber, int mathResult,
                   int physResult, int langResult, int sertResult, String role) {
>>>>>>> parent of 0ef4810... version 20/04/18

        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.mathResult = mathResult;
        this.physResult = physResult;
        this.langResult = langResult;
        this.sertResult = sertResult;
        this.role = role;

    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getMathResult() {
        return mathResult;
    }

    public void setMathResult(int mathResult) {
        this.mathResult = mathResult;
    }

    public int getPhysResult() {
        return physResult;
    }

    public void setPhysResult(int physResult) {
        this.physResult = physResult;
    }

    public int getLangResult() {
        return langResult;
    }

    public void setLangResult(int langResult) {
        this.langResult = langResult;
    }

    public int getSertResult() {
        return sertResult;
    }

    public void setSertResult(int sertResult) {
        this.sertResult = sertResult;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getMathResult() == user.getMathResult() &&
                getPhysResult() == user.getPhysResult() &&
                getLangResult() == user.getLangResult() &&
                getSertResult() == user.getSertResult() &&
                Objects.equals(getFirst_name(), user.getFirst_name()) &&
                Objects.equals(getLast_name(), user.getLast_name()) &&
                Objects.equals(getPatronymic(), user.getPatronymic()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
                Objects.equals(getRole(), user.getRole());
=======
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(first_name, newUser.first_name) &&
                Objects.equals(last_name, newUser.last_name) &&
                Objects.equals(patronymic, newUser.patronymic) &&
                Objects.equals(email, newUser.email) &&
                Objects.equals(password, newUser.password) &&
                Objects.equals(phoneNumber, newUser.phoneNumber) &&
                Objects.equals(mathResult, newUser.mathResult) &&
                Objects.equals(physResult, newUser.physResult) &&
                Objects.equals(langResult, newUser.langResult) &&
                Objects.equals(sertResult, newUser.sertResult);
>>>>>>> parent of 0ef4810... version 20/04/18
=======
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
=======
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
>>>>>>> parent of f48f517... version from 01/05/2018
        return Objects.equals(first_name, user.first_name) &&
                Objects.equals(last_name, user.last_name) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(mathResult, user.mathResult) &&
                Objects.equals(physResult, user.physResult) &&
                Objects.equals(langResult, user.langResult) &&
                Objects.equals(sertResult, user.sertResult);
<<<<<<< HEAD
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018
    }

    @Override
    public int hashCode() {

        return Objects.hash(first_name, last_name, patronymic, email, password, phoneNumber, mathResult, physResult, langResult, sertResult);
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
                ", mathResult='" + mathResult + '\'' +
                ", physResult='" + physResult + '\'' +
                ", langResult='" + langResult + '\'' +
                ", sertResult='" + sertResult + '\'' +
                '}';
    }
}
