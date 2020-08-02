package com.example.helplearning.Model;

public class Course {
    private int id;
    private String nameCourse;
    private String totalTime;
    private String price;
    private String dateExam;
    private String dateOnWeek;
    private String location;
    private int state;

    public Course(int id, String nameCourse, String totalTime, String price, String dateExam, String dateOnWeek, String location, int state) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.totalTime = totalTime;
        this.price = price;
        this.dateExam = dateExam;
        this.dateOnWeek = dateOnWeek;
        this.location = location;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateExam() {
        return dateExam;
    }

    public void setDateExam(String dateExam) {
        this.dateExam = dateExam;
    }

    public String getDateOnWeek() {
        return dateOnWeek;
    }

    public void setDateOnWeek(String dateOnWeek) {
        this.dateOnWeek = dateOnWeek;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", price='" + price + '\'' +
                ", dateExam='" + dateExam + '\'' +
                ", dateOnWeek='" + dateOnWeek + '\'' +
                ", location='" + location + '\'' +
                ", state=" + state +
                '}';
    }
}
