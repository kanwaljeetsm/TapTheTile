package com.kanwaljeetsm.tapthetile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEasy, btnMedium, btnHard;
    private TextView txtStart;
    Intent intent;
    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        btnEasy = findViewById(R.id.btnEasy);
        btnMedium = findViewById(R.id.btnMedium);
        btnHard = findViewById(R.id.btnHard);
        txtStart = findViewById(R.id.txtStart);

        intent = new Intent(MainActivity.this, GameActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.gameplay:
                FragmentManager fm = getSupportFragmentManager();
                GameplayInfo gameplayInfo = new GameplayInfo();
                fm.beginTransaction().replace(R.id.constraint,gameplayInfo).addToBackStack("backStack").commit();
                break;
            case R.id.about:
                FragmentManager fm1 = getSupportFragmentManager();
                AboutInfo aboutInfo = new AboutInfo();
                fm1.beginTransaction().replace(R.id.constraint,aboutInfo).addToBackStack("secondBackStack").commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnEasy:
                difficulty = "Easy";
                btnEasy.setBackgroundColor(getResources().getColor(R.color.easy));
                btnMedium.setBackgroundColor(getResources().getColor(R.color.medium));
                btnHard.setBackgroundColor(getResources().getColor(R.color.medium));
                break;
            case R.id.btnMedium:
                difficulty = "Medium";
                btnEasy.setBackgroundColor(getResources().getColor(R.color.medium));
                btnMedium.setBackgroundColor(getResources().getColor(R.color.easy));
                btnHard.setBackgroundColor(getResources().getColor(R.color.medium));
                break;
            case R.id.btnHard:
                difficulty = "Hard";
                btnEasy.setBackgroundColor(getResources().getColor(R.color.medium));
                btnMedium.setBackgroundColor(getResources().getColor(R.color.medium));
                btnHard.setBackgroundColor(getResources().getColor(R.color.easy));
                break;
        }

        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    intent.putExtra("difficulty", difficulty);
                    startActivity(intent);
                    finish();
            }
        });
    }
}