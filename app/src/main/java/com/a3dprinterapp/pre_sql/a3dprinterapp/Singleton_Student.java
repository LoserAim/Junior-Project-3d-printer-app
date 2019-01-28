package com.a3dprinterapp.pre_sql.a3dprinterapp;

public class Singleton_Student {
    public static volatile Singleton_Student instance;

    public MD_Student student;
    private Singleton_Student(){}
    public static Singleton_Student GetInstance()
    {
        if (instance == null)
        {
            synchronized (Singleton_Student.class)
            {
                if(instance == null)
                {
                    instance = new Singleton_Student();
                }
            }
        }
        return instance;
    }
}
