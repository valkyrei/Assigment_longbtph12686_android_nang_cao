package com.example.helplearning.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helplearning.Adapter.AdapterCourse;
import com.example.helplearning.Database;
import com.example.helplearning.Model.Course;
import com.example.helplearning.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {
    private ArrayList<Course> courses;
    Database database;
    AdapterCourse adapterCourse;
    ListView lvListCourse;
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        database = new Database(getContext());
        lvListCourse = view.findViewById(R.id.lvListCourses);
        floatingActionButton = view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_user));
        if (database.getAllCourse().size() == 0) {
            Log.e("insert", "insert");
            insertData();
        }
        courses = new ArrayList<>();
        courses = database.getAllCourse();

        adapterCourse = new AdapterCourse(courses);
        lvListCourse.setAdapter(adapterCourse);
        lvListCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                if (courses.get(i).getState() == 0) {
                    builder.setTitle("Bạn có muốn đăng ký khóa học này ?");
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int click) {
                            Course course = database.searchCourse(i + 1);
                            course.setState(1);
                            database.updateCourse(course);
                            courses.get(i).setState(1);
                            adapterCourse.notifyDataSetChanged();
                        }
                    });
                } else {
                    builder.setTitle("Bạn có muốn hủy đăng ký khóa học này ?");
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int click) {
                            Course course = database.searchCourse(i + 1);
                            course.setState(0);
                            courses.get(i).setState(0);
                            database.updateCourse(course);
                            adapterCourse.notifyDataSetChanged();
                        }
                    });
                }

                builder.show();
            }
        });
        return view;
    }

    private void insertData() {
        String[] arrNodeJs = getResources().getStringArray(R.array.course_nodejs);
        String[] arrAndroid = getResources().getStringArray(R.array.course_android);
        String[] arrPhp = getResources().getStringArray(R.array.course_php);
        String[] arrReactJs = getResources().getStringArray(R.array.course_reactjs);
        String[] arrFlutter = getResources().getStringArray(R.array.course_flutter);
        String[] arrCSharp = getResources().getStringArray(R.array.course_csharp);
        database.insert
                (new Course(Integer.parseInt(arrNodeJs[0]),
                        arrNodeJs[1], arrNodeJs[2], arrNodeJs[3], arrNodeJs[4], arrNodeJs[5], arrNodeJs[6], Integer.parseInt(arrNodeJs[7])));
        database.insert
                (new Course(Integer.parseInt(arrAndroid[0]),
                        arrAndroid[1], arrAndroid[2], arrAndroid[3], arrAndroid[4], arrAndroid[5], arrAndroid[6], Integer.parseInt(arrAndroid[7])));
        database.insert
                (new Course(Integer.parseInt(arrReactJs[0]),
                        arrReactJs[1], arrReactJs[2], arrReactJs[3], arrReactJs[4], arrReactJs[5], arrReactJs[6], Integer.parseInt(arrReactJs[7])));
        database.insert
                (new Course(Integer.parseInt(arrPhp[0]),
                        arrPhp[1], arrPhp[2], arrPhp[3], arrPhp[4], arrPhp[5], arrPhp[6], Integer.parseInt(arrPhp[7])));
        database.insert
                (new Course(Integer.parseInt(arrFlutter[0]),
                        arrFlutter[1], arrFlutter[2], arrFlutter[3], arrFlutter[4], arrFlutter[5], arrFlutter[6], Integer.parseInt(arrFlutter[7])));
        database.insert
                (new Course(Integer.parseInt(arrCSharp[0]),
                        arrCSharp[1], arrCSharp[2], arrCSharp[3], arrCSharp[4], arrCSharp[5], arrCSharp[6], Integer.parseInt(arrCSharp[7])));
    }
}