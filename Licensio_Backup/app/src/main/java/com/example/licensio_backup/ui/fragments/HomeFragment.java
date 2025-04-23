package com.example.licensio_backup.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.licensio_backup.R;
import com.example.licensio_backup.data.models.User;
import com.example.licensio_backup.ui.activities.homepage.Homepage;

public class HomeFragment extends Fragment {

    private TextView welcomeBackTextView;

    private User user;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        user = ((Homepage) getContext()).getUser();

        //Modify greeting of user
        welcomeBackTextView = rootView.findViewById(R.id.welcomeBackTextView);
        welcomeBackTextView.append(" " + user.getUsername() + "!");


        return rootView;
    }
}