package com.kanwaljeetsm.tapthetile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class Results extends AppCompatActivity {

    private String difficulty;
    private int score;
    private TextView topEasyScore, topMediumScore, topHardScore, txtScore, remark;
    private Button btnRetry, btnQuit;
    private String strTopEasyScore, strTopMediumScore, strTopHardScore;
    private int intTopEasyScore, intTopMediumScore, intTopHardScore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        topEasyScore = findViewById(R.id.topEasyScore);
        topMediumScore = findViewById(R.id.topMediumScore);
        topHardScore = findViewById(R.id.topHardScore);
        txtScore = findViewById(R.id.txtScore);
        remark = findViewById(R.id.remark);
        btnRetry = findViewById(R.id.btnRetry);
        btnQuit = findViewById(R.id.btnQuit);

        final Intent intent = getIntent();
        difficulty = intent.getStringExtra("difficulty");
        score = intent.getIntExtra("score", 0);

        txtScore.setText(String.valueOf(score));

        final ParseObject sendData = new ParseObject("TopScores");
        final ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("TopScores");
        parseQuery.whereEqualTo("objectId", getResources().getString(R.string.objId));
        parseQuery.getInBackground(getResources().getString(R.string.objId), new GetCallback<ParseObject>() {

            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    strTopEasyScore = (String) object.get("easyScore");
                    strTopMediumScore = (String) object.get("mediumScore");
                    strTopHardScore = (String) object.get("hardScore");
                    intTopEasyScore = Integer.parseInt(strTopEasyScore);
                    intTopMediumScore = Integer.parseInt(strTopMediumScore);
                    intTopHardScore = Integer.parseInt(strTopHardScore);
                    topEasyScore.setText(strTopEasyScore);
                    topMediumScore.setText(strTopMediumScore);
                    topHardScore.setText(strTopHardScore);

                    switch (difficulty) {
                        case "Easy":
                            if (score >= intTopEasyScore) {
                                remark.setText(getResources().getString(R.string.msgTopScorer));
                                ParseQuery<ParseObject> parseQuery1 = ParseQuery.getQuery("TopScores");
                                parseQuery1.whereEqualTo("objectId", getResources().getString(R.string.objId));
                                parseQuery1.getInBackground(getResources().getString(R.string.objId), new GetCallback<ParseObject>() {
                                    @Override
                                    public void done(ParseObject object, ParseException e) {
                                        object.put("easyScore", String.valueOf(score));
                                        object.saveInBackground(new SaveCallback() {
                                            @Override
                                            public void done(ParseException e) {
                                                if (e == null) {
                                                    strTopEasyScore = String.valueOf(score);
                                                    topEasyScore.setText(strTopEasyScore);
                                                } else {
                                                    e.printStackTrace();
                                                    Toast.makeText(Results.this, R.string.uploadFailure, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                            else {
                                remark.setText(getResources().getString(R.string.msgLowScorer));
                            }
                            break;

                        case "Medium":
                            if (score >= intTopMediumScore) {
                                remark.setText(getResources().getString(R.string.msgTopScorer));
                                ParseQuery<ParseObject> parseQuery1 = ParseQuery.getQuery("TopScores");
                                parseQuery1.whereEqualTo("objectId", getResources().getString(R.string.objId));
                                parseQuery1.getInBackground(getResources().getString(R.string.objId), new GetCallback<ParseObject>() {
                                    @Override
                                    public void done(ParseObject object, ParseException e) {
                                        object.put("mediumScore", String.valueOf(score));
                                        object.saveInBackground(new SaveCallback() {
                                            @Override
                                            public void done(ParseException e) {
                                                if (e == null) {
                                                    strTopMediumScore = String.valueOf(score);
                                                    topMediumScore.setText(strTopMediumScore);
                                                } else {
                                                    e.printStackTrace();
                                                    Toast.makeText(Results.this, R.string.uploadFailure, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                            else {
                                remark.setText(getResources().getString(R.string.msgLowScorer));
                            }
                            break;

                        case "Hard":
                            if (score >= intTopHardScore) {
                                remark.setText(getResources().getString(R.string.msgTopScorer));
                                ParseQuery<ParseObject> parseQuery1 = ParseQuery.getQuery("TopScores");
                                parseQuery1.whereEqualTo("objectId", getResources().getString(R.string.objId));
                                parseQuery1.getInBackground(getResources().getString(R.string.objId), new GetCallback<ParseObject>() {
                                    @Override
                                    public void done(ParseObject object, ParseException e) {
                                        object.put("hardScore", String.valueOf(score));
                                        object.saveInBackground(new SaveCallback() {
                                            @Override
                                            public void done(ParseException e) {
                                                if (e == null) {
                                                    strTopHardScore = String.valueOf(score);
                                                    topHardScore.setText(strTopHardScore);
                                                } else {
                                                    e.printStackTrace();
                                                    Toast.makeText(Results.this, R.string.uploadFailure, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                            else {
                                remark.setText(getResources().getString(R.string.msgLowScorer));
                            }
                            break;
                    }
                }else {
                    e.printStackTrace();
                    Toast.makeText(Results.this, R.string.noInternetWarning, Toast.LENGTH_LONG).show();
                    topEasyScore.setText(R.string.blank);
                    topMediumScore.setText(R.string.blank);
                    topHardScore.setText(R.string.blank);
                }
            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Results.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}