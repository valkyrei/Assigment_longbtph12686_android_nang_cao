package com.example.helplearning.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helplearning.R;


public class MapsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/maps/place/FPT+Polytechnic+Hanoi/@21.0379876,105.745167,17z/data=!4m5!3m4!1s0x313454b991d80fd5:0x53cefc99d6b0bf6f!8m2!3d21.0381278!4d105.7467871"));
        startActivity(intent);
        return inflater.inflate(R.layout.fragment_maps2, container, false);
    }
}