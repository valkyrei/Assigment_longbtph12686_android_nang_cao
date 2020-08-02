package com.example.helplearning.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.helplearning.Adapter.AdapterCourse;
import com.example.helplearning.Database;
import com.example.helplearning.Model.Course;
import com.example.helplearning.R;

import java.util.ArrayList;


public class User extends Fragment {
    ListView lvListUser;
    Database database;
    AdapterCourse adapterCourse;
    ArrayList<Course> courses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        lvListUser = view.findViewById(R.id.lvListUser);
        database = new Database(getContext());
        courses = database.getAllCourse(1);
        adapterCourse = new AdapterCourse(courses);
        lvListUser.setAdapter(adapterCourse);
        return view;
    }
}