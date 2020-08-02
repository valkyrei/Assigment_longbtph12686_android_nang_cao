package com.example.helplearning.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.helplearning.R;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imgCourses = view.findViewById(R.id.course);
        ImageView imgMaps = view.findViewById(R.id.maps);
        ImageView imgNews = view.findViewById(R.id.news);
        imgCourses.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_courses));
        imgMaps.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_maps));
        imgNews.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_news));
        return view;
    }
}