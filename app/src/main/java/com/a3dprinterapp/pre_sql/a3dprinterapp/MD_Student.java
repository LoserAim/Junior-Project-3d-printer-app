package com.a3dprinterapp.pre_sql.a3dprinterapp;

public class MD_Student {
    int StudentID;
    String Email;
    String Password;
    String Name;
    int admin;

    public MD_Student(){}

    public MD_Student(int stuID, String _email, String _pw, String _Name, int _admin)
    {
        this.StudentID = stuID;
        this.Email = _email;
        this.Password = _pw;
        this.Name = _Name;
        this.admin = _admin;
    }

    public void SetID(int Id)
    {
      this.StudentID = Id;
    }

    public void SetName (String _Name) { this.Name = _Name; }
    public void SetEmail(String _email)
    {
        this.Email = _email;
    }

    public void SetPassword(String _password)
    {
        this.Password = _password;
    }

    public void SetAdmin(int _admin)
    {
        this.admin = _admin;
    }

    public long GetId()
    {
        return this.StudentID;
    }

    public String GetName () { return this.Name; }
    public String GetEmail()
    {
        return this.Email;
    }
    public String GetPassword()
    {
        return this.Password;
    }
    public int GetAdmin()
    {
        return this.admin;
    }
}