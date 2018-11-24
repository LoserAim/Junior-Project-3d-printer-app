package com.a3dprinterapp.pre_sql.a3dprinterapp;

public class MD_Student {
    int StudentID;
    String Email;
    String Password;
    String Name;
    boolean admin;

    public MD_Student(){}

    public MD_Student(String _email, String _pw, boolean _admin)
    {
        this.Email = _email;
        this.Password = _pw;
        this.admin = _admin;
    }

    public void SetID(int Id)
    {
      this.StudentID = Id;
    }

    public void SetEmail(String _email)
    {
        this.Email = _email;
    }

    public void SetPassword(String _password)
    {
        this.Password = _password;
    }

    public void SetAdmin(boolean _admin)
    {
        this.admin = _admin;
    }

    public long GetId()
    {
        return this.StudentID;
    }

    public String GetEmail()
    {
        return this.Email;
    }
    public String GetPassword()
    {
        return this.Password;
    }
    public boolean GetAdmin()
    {
        return this.admin;
    }
}