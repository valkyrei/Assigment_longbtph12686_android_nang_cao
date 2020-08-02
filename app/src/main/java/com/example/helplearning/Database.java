package com.example.helplearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.helplearning.Model.Course;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String NAME = "Database.db";
    public static final String COURSE = "CREATE TABLE COURSE(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAMECOURSE TEXT,TOTALTIME TEXT,PRICE TEXT,DATEEXAM TEXT,DATEONWEEK TEXT,LOCATION TEXT,STATE INTEGER)";

    public Database(@Nullable Context context) {
        super(context, NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(COURSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS COURSE");
        onCreate(sqLiteDatabase);
    }

    public long insert(Course course) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAMECOURSE", course.getNameCourse());
        contentValues.put("TOTALTIME", course.getTotalTime());
        contentValues.put("PRICE", course.getPrice());
        contentValues.put("DATEEXAM", course.getDateExam());
        contentValues.put("DATEONWEEK", course.getDateOnWeek());
        contentValues.put("LOCATION", course.getLocation());
        contentValues.put("STATE", course.getState());
        long result = sqLiteDatabase.insert("COURSE", null, contentValues);
        return result;
    }

    public Course searchCourse(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] arr = {"ID", "NAMECOURSE", "TOTALTIME", "PRICE", "DATEEXAM", "DATEONWEEK", "LOCATION", "STATE"};
        String selection = "ID = ?";
        String[] args = {String.valueOf(id)};
        Cursor cursor = sqLiteDatabase.query("COURSE", arr, selection, args, null, null, null);
        cursor.moveToFirst();
        String id2 = cursor.getString(0);
        String nameCourse = cursor.getString(1);
        String totalTime = cursor.getString(2);
        String price = cursor.getString(3);
        String dateExam = cursor.getString(4);
        String dateOnWeek = cursor.getString(5);
        String location = cursor.getString(6);
        String state = cursor.getString(7);
        Course course = new Course(Integer.parseInt(id2), nameCourse, totalTime, price, dateExam, dateOnWeek, location, Integer.parseInt(state));
        return course;
    }

    public ArrayList<Course> getAllCourse() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Course> courses = new ArrayList<>();
        String select = "SELECT * FROM COURSE";
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String nameCourse = cursor.getString(1);
            String totalTime = cursor.getString(2);
            String price = cursor.getString(3);
            String dateExam = cursor.getString(4);
            String dateOnWeek = cursor.getString(5);
            String location = cursor.getString(6);
            String state = cursor.getString(7);
            Course course = new Course(Integer.parseInt(id), nameCourse, totalTime, price, dateExam, dateOnWeek, location, Integer.parseInt(state));
            courses.add(course);
            cursor.moveToNext();
        }
        return courses;
    }

    public ArrayList<Course> getAllCourse(int s) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Course> courses = new ArrayList<>();
        String select = "SELECT * FROM COURSE WHERE STATE = ?";
        String[] args = {String.valueOf(s)};
        Cursor cursor = sqLiteDatabase.rawQuery(select, args);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String nameCourse = cursor.getString(1);
            String totalTime = cursor.getString(2);
            String price = cursor.getString(3);
            String dateExam = cursor.getString(4);
            String dateOnWeek = cursor.getString(5);
            String location = cursor.getString(6);
            String state = cursor.getString(7);
            Course course = new Course(Integer.parseInt(id), nameCourse, totalTime, price, dateExam, dateOnWeek, location, Integer.parseInt(state));
            courses.add(course);
            cursor.moveToNext();
        }
        return courses;
    }

    public int updateCourse(Course course) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATE", course.getState());
        String[] args = {String.valueOf(course.getId())};
        int count = sqLiteDatabase.update("COURSE", contentValues, "ID = ?", args);
        return count;
    }

}
