package com.kanwaljeetsm.tapthetile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private String difficulty;
    private TextView txtTime, placeOne, placeTwo, placeThree, placeFour, placeFive, placeSix, placeSeven;
    private TextView placeEight, placeNine, placeTen, placeEleven, placeTwelve, placeThirteen, placeFourteen;
    private TextView placeFifteen, placeSixteen;
    private long timer = 31000, interval, startTimer = 3000;
    private int randomNum, prevRandomNum = 0;
    private int score = 0;
    private LinearLayout linearLayout2, linearLayout;
    private TextView txtTitle, textView;
    private View constraintGame;
    private MediaPlayer positiveAudio, negativeAudio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        textView = findViewById(R.id.textView);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout2 = findViewById(R.id.linearLayout2);
        txtTitle = findViewById(R.id.txtTitle);
        txtTime = findViewById(R.id.txtTime);
        placeOne = findViewById(R.id.placeOne);
        placeTwo = findViewById(R.id.placeTwo);
        placeThree = findViewById(R.id.placeThree);
        placeFour = findViewById(R.id.placeFour);
        placeFive = findViewById(R.id.placeFive);
        placeSix = findViewById(R.id.placeSix);
        placeSeven = findViewById(R.id.placeSeven);
        placeEight = findViewById(R.id.placeEight);
        placeNine = findViewById(R.id.placeNine);
        placeTen = findViewById(R.id.placeTen);
        placeEleven = findViewById(R.id.placeEleven);
        placeTwelve = findViewById(R.id.placeTwelve);
        placeThirteen = findViewById(R.id.placeThirteen);
        placeFourteen = findViewById(R.id.placeFourteen);
        placeFifteen = findViewById(R.id.placeFifteen);
        placeSixteen = findViewById(R.id.placeSixteen);
        constraintGame = findViewById(R.id.constraintGame);

        final Intent intent = getIntent();
        final Random random = new Random();
        positiveAudio = MediaPlayer.create(GameActivity.this, R.raw.positiveaudio);
        negativeAudio = MediaPlayer.create(GameActivity.this, R.raw.negativeaudio);
        difficulty = intent.getStringExtra("difficulty");

        switch (difficulty) {
            case "Easy":
                interval = 800;
                break;
            case "Medium":
                interval = 650;
                break;
            case "Hard":
                interval = 500;
                break;
        }

        CountDownTimer countDownTimer = new CountDownTimer(startTimer, 1000) {
            @Override
            public void onTick(long l) {
                textView.setText(R.string.get);
                if(l/1000 == 1) {
                    textView.setText(R.string.set);
                }
                if(l/1000 == 0) {
                    textView.setText(R.string.go);
                }
            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                txtTitle.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);

                CountDownTimer totalTime = new CountDownTimer(timer, 1000) {
                    @Override
                    public void onTick(long l) {
                        txtTime.setText(String.valueOf(l / 1000));
                    }

                    @Override
                    public void onFinish() {
                        //start a new activity
                        Intent intent1 = new Intent(GameActivity.this, Results.class);
                        intent1.putExtra("difficulty", difficulty);
                        intent1.putExtra("score", score);
                        startActivity(intent1);
                        finish();
                    }
                }.start();

                CountDownTimer changeTile = new CountDownTimer(timer, interval) {
                    @Override
                    public void onTick(long l) {
                        prevRandomNum = randomNum;
                        randomNum = random.nextInt(16);

                        placeOne.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeOne.setSelected(false);

                        placeTwo.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeTwo.setSelected(false);

                        placeThree.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeThree.setSelected(false);

                        placeFour.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeFour.setSelected(false);

                        placeFive.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeFive.setSelected(false);

                        placeSix.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeSix.setSelected(false);

                        placeSeven.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeSeven.setSelected(false);

                        placeEight.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeEight.setSelected(false);

                        placeNine.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeNine.setSelected(false);

                        placeTen.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeTen.setSelected(false);

                        placeEleven.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeEleven.setSelected(false);

                        placeTwelve.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeTwelve.setSelected(false);

                        placeThirteen.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeThirteen.setSelected(false);

                        placeFourteen.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeFourteen.setSelected(false);

                        placeFifteen.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeFifteen.setSelected(false);

                        placeSixteen.setBackgroundColor(getResources().getColor(R.color.tileDefault));
                        placeSixteen.setSelected(false);

                        switch (randomNum) {
                            case 0:
                                placeOne.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeOne.setSelected(true);
                                break;
                            case 1:
                                placeTwo.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeTwo.setSelected(true);
                                break;
                            case 2:
                                placeThree.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeThree.setSelected(true);
                                break;
                            case 3:
                                placeFour.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeFour.setSelected(true);
                                break;
                            case 4:
                                placeFive.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeFive.setSelected(true);
                                break;
                            case 5:
                                placeSix.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeSix.setSelected(true);
                                break;
                            case 6:
                                placeSeven.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeSeven.setSelected(true);
                                break;
                            case 7:
                                placeEight.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeEight.setSelected(true);
                                break;
                            case 8:
                                placeNine.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeNine.setSelected(true);
                                break;
                            case 9:
                                placeTen.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeTen.setSelected(true);
                                break;
                            case 10:
                                placeEleven.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeEleven.setSelected(true);
                                break;
                            case 11:
                                placeTwelve.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeTwelve.setSelected(true);
                                break;
                            case 12:
                                placeThirteen.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeThirteen.setSelected(true);
                                break;
                            case 13:
                                placeFourteen.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeFourteen.setSelected(true);
                                break;
                            case 14:
                                placeFifteen.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeFifteen.setSelected(true);
                                break;
                            case 15:
                                placeSixteen.setBackgroundColor(getResources().getColor(R.color.tileSelected));
                                placeSixteen.setSelected(true);
                                break;
                        }
                    }

                    @Override
                    public void onFinish() {}
                }.start();
            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        if(view.isSelected()) {
            score++;
            positiveAudio.start();
            view.setBackgroundColor(getResources().getColor(R.color.easy));
        }
        else {
            score--;
            negativeAudio.start();
            view.setBackgroundColor(getResources().getColor(R.color.hard));
        }
    }
}



