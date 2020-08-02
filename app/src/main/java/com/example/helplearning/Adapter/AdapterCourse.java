package com.example.helplearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helplearning.Model.Course;
import com.example.helplearning.R;

import java.util.ArrayList;

public class AdapterCourse extends BaseAdapter {
    private ArrayList<Course> courses;

    public AdapterCourse(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_courses, viewGroup, false);
        TextView tvNameCourse = view.findViewById(R.id.tvNameCourse);
        TextView tvToTalTime = view.findViewById(R.id.tvToTalTime);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvDateExam = view.findViewById(R.id.tvDateExam);
        TextView tvDateOnWeek = view.findViewById(R.id.tvDateOnWeek);
        TextView tvLocation = view.findViewById(R.id.tvLocation);
        TextView tvState = view.findViewById(R.id.tvState);
        ImageView imageView = view.findViewById(R.id.imageView);
        tvNameCourse.setText(String.valueOf(courses.get(i).getNameCourse()));
        tvToTalTime.setText("Thời gian học : "+String.valueOf(courses.get(i).getTotalTime()));
        tvPrice.setText("Chi phí : " +String.valueOf(courses.get(i).getPrice()));
        tvDateExam.setText( "Ngày thi : "+String.valueOf(courses.get(i).getDateExam()));
        tvDateOnWeek.setText( "Lịch học : " +String.valueOf(courses.get(i).getDateOnWeek()));
        tvLocation.setText(String.valueOf(courses.get(i).getLocation()));
        if (courses.get(i).getState() == 0) {
            tvState.setText("Chưa đăng ký");
        } else {
            tvState.setText("Đã đăng ký");
        }
        switch (courses.get(i).getId()) {
            case 1:
                imageView.setImageResource(R.drawable.nodejs);
                break;
            case 2:
                imageView.setImageResource(R.drawable.android);
                break;
            case 3:
                imageView.setImageResource(R.drawable.react);
                break;
            case 4:
                imageView.setImageResource(R.drawable.php);
                break;
            case 5:
                imageView.setImageResource(R.drawable.flutter);
                break;
            case 6:
                imageView.setImageResource(R.drawable.sharp);
                break;
        }
        imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
        return view;
    }
}
