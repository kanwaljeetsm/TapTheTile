package com.kanwaljeetsm.tapthetile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Objects;

public class AboutInfo extends Fragment {

    private ImageView img1, img2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about_info, container, false);
        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.gitLink)));
                startActivity(browserIntent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.linkedinLink)));
                startActivity(browserIntent1);
            }
        });
        return view;
    }
}