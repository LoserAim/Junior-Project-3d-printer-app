package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StudentMain extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_main, container, false);
        Button login = (Button) view.findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO::Change this to the new login page (it was broken on my branch while i made this
                Intent intent = new Intent(getActivity(), activity_login.class);
                startActivity(intent);
            }
        });

        Button Submit = (Button) view.findViewById(R.id.submitrequest_btn);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_submit_request.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
