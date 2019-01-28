package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DB_DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "3dPrinterInfo";

    // Table Name for Student
    private static final String TABLE_STUDENT = "Student";

        //Column Names for Student
        private static final String COL_STUDENT_ID = "StudentID";
        private static final String COL_STUDENT_EMAIL = "Email";
        private static final String COL_STUDENT_PASSWORD = "Password";
        private static final String COL_STUDENT_NAME = "Name";
        private static final String COL_STUDENT_ADMIN = "Admin";

    // Table Name for Request
    private static final String TABLE_REQUEST = "Request";

        //Column Names for Request
        private static final String COL_REQUEST_ID = "RequestID";
        private static final String COL_REQUEST_FK_STUDENT = "StudentID";
        private static final String COL_REQUEST_FK_PRINTER = "PrinterID";
        private static final String COL_REQUEST_STATUS = "Status";
        private static final String COL_REQUEST_PROJECTNAME = "ProjectName";
        private static final String COL_REQUEST_DESCRIPTION = "Description";
        private static final String COL_REQUEST_DATEREQUESTED = "DateRequested";
        private static final String  COL_REQUEST_FILEPATH = "FilePath";


    // Table Create Statements
    // Student table create statement
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE "
            + TABLE_STUDENT
            + "(" + COL_STUDENT_ID + " INTEGER PRIMARY KEY, "
            + COL_STUDENT_EMAIL + " TEXT, "
            + COL_STUDENT_PASSWORD + " TEXT, "
            + COL_STUDENT_NAME + " TEXT, "
            + COL_STUDENT_ADMIN + " INTEGER)";

    private static final String CREATE_TABLE_REQUEST = "CREATE TABLE "
            + TABLE_REQUEST
            + "(" + COL_REQUEST_ID + " INTEGER PRIMARY KEY, "
            + COL_REQUEST_FK_STUDENT + " Integer, "
            + COL_REQUEST_FK_PRINTER + " Integer, "
            + COL_REQUEST_STATUS + " TEXT, "
            + COL_REQUEST_PROJECTNAME + " TEXT, "
            + COL_REQUEST_DESCRIPTION + " TEXT, "
            + COL_REQUEST_DATEREQUESTED + " DATETIME, "
            + COL_REQUEST_FILEPATH +" TEXT, " +
            "FOREIGN KEY (" + COL_REQUEST_FK_STUDENT + ") REFERENCES "+ TABLE_STUDENT +" ("+ COL_STUDENT_ID+ ") ON DELETE CASCADE) ";



    public DB_DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_STUDENT);
        db.execSQL(CREATE_TABLE_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REQUEST);


        // create new tables
        onCreate(db);
    }


    //Create student table
    public long CreateStudent(MD_Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_STUDENT_EMAIL, student.GetEmail());
        values.put(COL_STUDENT_PASSWORD, student.GetPassword());
        values.put(COL_STUDENT_NAME, student.GetName());
        values.put(COL_STUDENT_ADMIN, student.GetAdmin());

        //insert row
        //Will return ID of row when inserted
        long student_id = db.insert(TABLE_STUDENT, null, values);

        return student_id;

    }


    //Create Request table
    public long createRequest(MD_Requests request)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_REQUEST_FK_STUDENT, request.GetStudentID());
        values.put(COL_REQUEST_FK_PRINTER, request.GetPrinterID());
        values.put(COL_REQUEST_STATUS, request.GetStatus());
        values.put(COL_REQUEST_PROJECTNAME, request.GetProjectName());
        values.put(COL_REQUEST_DESCRIPTION, request.GetDescription());
        values.put(COL_REQUEST_DATEREQUESTED, request.GetDateRequested());
        values.put(COL_REQUEST_FILEPATH, request.GetFilePath());

        //Insert Row
        //Will return ID of row when inserted
        long request_id = db.insert(TABLE_REQUEST, null, values);

        return request_id;
    }

    public MD_Student GetStudent(long student_id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COL_STUDENT_ID + " = " + student_id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
        {
            c.moveToFirst();

        }

        MD_Student st = new MD_Student();
        st.SetID(c.getInt(c.getColumnIndex(COL_STUDENT_ID)));
        st.SetEmail(c.getString(c.getColumnIndex(COL_STUDENT_EMAIL)));
        st.SetPassword(c.getString(c.getColumnIndex(COL_STUDENT_PASSWORD)));
        st.SetName(c.getString(c.getColumnIndex(COL_STUDENT_NAME)));
        st.SetAdmin(c.getInt(c.getColumnIndex(COL_STUDENT_ADMIN)));

        return st;
    }


    public MD_Requests GetRequests(long request_id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_REQUEST + " WHERE " + COL_REQUEST_ID + " = " + request_id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
        {
            c.moveToFirst();

        }

        MD_Requests rt = new MD_Requests();
        rt.SetRequestID(c.getInt(c.getColumnIndex(COL_REQUEST_ID)));
        rt.SetStudentID(c.getInt(c.getColumnIndex(COL_REQUEST_FK_STUDENT)));
        rt.SetPrinterID(c.getInt(c.getColumnIndex(COL_REQUEST_FK_PRINTER)));
        rt.SetStatus(c.getString(c.getColumnIndex(COL_REQUEST_STATUS)));
        rt.SetProjectName(c.getString(c.getColumnIndex(COL_REQUEST_PROJECTNAME)));
        rt.SetDescription(c.getString(c.getColumnIndex(COL_REQUEST_DESCRIPTION)));
        rt.SetDateRequested(c.getString(c.getColumnIndex(COL_REQUEST_DATEREQUESTED)));
        rt.SetFilePath(c.getString(c.getColumnIndex(COL_REQUEST_FILEPATH)));

        return rt;
    }

    public void DeleteStudent(long student_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COL_STUDENT_ID + " = ?", new String[] {String.valueOf(student_id)});
    }

    public void DeleteRequest(long request_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REQUEST, COL_REQUEST_ID + " = ?", new String[] {String.valueOf(request_id)});
    }

    public int UpdateStudent(MD_Student  st){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_STUDENT_ID, st.GetId());
        values.put(COL_STUDENT_EMAIL, st.GetEmail());
        values.put(COL_STUDENT_PASSWORD, st.GetPassword());
        values.put(COL_STUDENT_NAME, st.GetName());
        values.put(COL_STUDENT_ADMIN, st.GetAdmin());

        // updating row
        return db.update(TABLE_STUDENT, values, COL_STUDENT_ID + " = ?",
                new String[] { String.valueOf(st.GetId()) });
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public List<MD_Requests> GetAllRequests()
    {
        String selectQuery = "SELECT * FROM " + TABLE_REQUEST;
        Log.e(LOG, selectQuery);

        List<MD_Requests> requests 	= new ArrayList<MD_Requests>();
        SQLiteDatabase 	  db 		= this.getReadableDatabase();
        Cursor 			  c  		= db.rawQuery(selectQuery, null);


        if (c.moveToFirst())
        {
            do
            {
                MD_Requests req = new MD_Requests();

                req.SetRequestID(c.getInt(c.getColumnIndex(COL_REQUEST_ID)));
                req.SetStatus(c.getString(c.getColumnIndex(COL_REQUEST_STATUS)));
                req.SetStudentID(c.getInt(c.getColumnIndex(COL_REQUEST_FK_STUDENT)));
                req.SetPrinterID(c.getInt(c.getColumnIndex(COL_REQUEST_FK_PRINTER)));
                req.SetDateRequested(c.getString(c.getColumnIndex(COL_REQUEST_DATEREQUESTED)));
                req.SetProjectName(c.getString(c.getColumnIndex(COL_REQUEST_PROJECTNAME)));
                req.SetDescription(c.getString(c.getColumnIndex(COL_REQUEST_DESCRIPTION)));
                req.SetDescription(c.getString(c.getColumnIndex(COL_REQUEST_FILEPATH)));

                requests.add(req);
            } while (c.moveToNext());
        }

        return requests;
    }


    public List<MD_Student> GetAllStudents()
    {
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;
        Log.e(LOG, selectQuery);

        List<MD_Student> students 	= new ArrayList<MD_Student>();
        SQLiteDatabase 	 db 		= this.getReadableDatabase();
        Cursor 			 c  		= db.rawQuery(selectQuery, null);


        if (c.moveToFirst())
        {
            do
            {
                MD_Student st = new MD_Student();
                st.SetID(c.getInt(c.getColumnIndex(COL_STUDENT_ID)));
                st.SetEmail(c.getString(c.getColumnIndex(COL_STUDENT_EMAIL)));
                st.SetPassword(c.getString(c.getColumnIndex(COL_STUDENT_PASSWORD)));
                st.SetName(c.getString(c.getColumnIndex(COL_STUDENT_NAME)));
                st.SetAdmin(c.getInt(c.getColumnIndex(COL_STUDENT_ADMIN)));

                students.add(st);
            } while (c.moveToNext());
        }

        return students;
    }
    public int UpdateRequest(MD_Requests rq){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_REQUEST_ID, rq.GetRequestID());
        values.put(COL_REQUEST_FK_STUDENT, rq.GetStudentID());
        values.put(COL_REQUEST_FK_PRINTER, rq.GetPrinterID());
        values.put(COL_REQUEST_STATUS, rq.GetStatus());
        values.put(COL_REQUEST_PROJECTNAME, rq.GetProjectName());
        values.put(COL_REQUEST_DESCRIPTION, rq.GetDescription());
        values.put(COL_REQUEST_DATEREQUESTED, rq.GetDateRequested());
        values.put(COL_REQUEST_FILEPATH, rq.GetFilePath());


        // updating row
        return db.update(TABLE_REQUEST, values, COL_REQUEST_ID + " = ?",
                new String[] { String.valueOf(rq.GetRequestID()) });
    }
}
