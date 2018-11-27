package com.a3dprinterapp.pre_sql.a3dprinterapp;

public class Singleton_Student {
    public static volatile MD_Student student;

    private Singleton_Student(){}
    public static MD_Student GetInstance(String value)
    {
        if (student == null)
        {
            synchronized (Singleton_Student.class)
            {
                if(student == null)
                {
                    student = new MD_Student();
                }
            }
        }
        return student;
    }
}
