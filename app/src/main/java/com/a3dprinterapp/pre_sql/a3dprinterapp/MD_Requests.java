package com.a3dprinterapp.pre_sql.a3dprinterapp;

import java.util.Date;

public class MD_Requests {

    int RequestsID;
    String Status;
    int StudentID;
    int PrinterID;
    String DateRequested;
    String ProjectName;
    String FilePath;
    String Desc;

    public MD_Requests() {}

    public MD_Requests (int _RID, String _Status, int _SID, int _PID, String _DR, String _PN, String _Desc)
    {
        this.RequestsID = _RID;
        this.Status = _Status;
        this.StudentID = _SID;
        this.PrinterID = _PID;
        this.DateRequested = _DR;
        this.ProjectName = _PN;
        this.Desc = _Desc;
    }

    public void SetRequestID (int _RID) { this.RequestsID = _RID;}
    public void SetStatus (String _Status) {this.Status = _Status;}
    public void SetStudentID (int _SID) {this.StudentID = _SID;}
    public void SetPrinterID (int _PID) {this.PrinterID = _PID;}
    public void SetDateRequested (String _DR) {this.DateRequested = _DR;}
    public void SetProjectName (String _PN) {this.ProjectName = _PN;}
    public void SetDescription (String _Desc) {this.Desc = _Desc;}
    public void SetFilePath (String _FilePath) {this.FilePath = _FilePath;}

    public long GetRequestID () {  return this.RequestsID;}
    public String GetStatus () { return this.Status;}
    public long GetStudentID () { return this.StudentID;}
    public long GetPrinterID () { return this.PrinterID;}
    public String GetDateRequested () { return this.DateRequested;}
    public String GetProjectName () { return this.ProjectName;}
    public String GetDescription () { return this.Desc;}
    public String GetFilePath () {return this.FilePath;}



}
