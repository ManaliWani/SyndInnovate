package com.example.lenovo.whatsappapiintegration;

public class Profile {

    String uID;
    String uname;
    String accountNo;
    String accountType;
    Integer balance;

    Profile(){

    }

    public Profile(String uID, String uname, String accountNo, String accountType) {
        this.uID = uID;
        this.uname = uname;
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.balance = 500;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
