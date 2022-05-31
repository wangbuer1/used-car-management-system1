package com.sx.pojo;

public class Admin {

    private String adminname;

    private String apassword;

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public Admin(String adminname, String apassword){
        this.adminname=adminname;
        this.apassword=apassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminname='" + adminname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }
}
