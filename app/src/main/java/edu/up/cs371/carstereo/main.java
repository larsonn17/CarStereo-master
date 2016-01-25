package edu.up.cs371.carstereo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.concurrent.TimeUnit;


public class main extends Activity implements View.OnClickListener, View.OnLongClickListener{
    protected Button powerButton;
    protected Button preset1;
    protected Button preset2;
    protected Button preset3;
    protected Button preset4;
    protected Button preset5;
    protected Button preset6;
    protected Button playPauseButton;
    protected Button repeatButton;
    protected Button forwardButton;
    protected Button amFm;
    protected Button minusButton;
    protected Button plusButton;

    protected TextView stationText;

    boolean powerButtonOff = true;
    boolean preset1Off = true;
    boolean preset2Off = true;
    boolean preset3Off = true;
    boolean preset4Off = true;
    boolean preset5Off = true;
    boolean preset6Off = true;

    double pre1FM =90.9;
    double pre2FM =92.9;
    double pre3FM =94.9;
    double pre4FM =96.9;
    double pre5FM =98.9;
    double pre6FM =100.9;

    int pre1AM = 550;
    int pre2AM = 600;
    int pre3AM = 650;
    int pre4AM = 700;
    int pre5AM = 750;
    int pre6AM = 800;


    int AMstation;
    double FMstation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        powerButton = (Button)findViewById(R.id.powerButton);
        powerButton.setOnClickListener(this);

        preset1 = (Button)findViewById(R.id.preset1);
        preset1.setOnClickListener(this);
        preset1.setOnLongClickListener(this);
        preset2 = (Button)findViewById(R.id.preset2);
        preset2.setOnClickListener(this);
        preset2.setOnLongClickListener(this);
        preset3 = (Button)findViewById(R.id.preset3);
        preset3.setOnClickListener(this);
        preset3.setOnLongClickListener(this);
        preset4 = (Button)findViewById(R.id.preset4);
        preset4.setOnClickListener(this);
        preset4.setOnLongClickListener(this);
        preset5 = (Button)findViewById(R.id.preset5);
        preset5.setOnClickListener(this);
        preset5.setOnLongClickListener(this);
        preset6 = (Button)findViewById(R.id.preset6);
        preset6.setOnClickListener(this);
        preset6.setOnLongClickListener(this);

        playPauseButton = (Button)findViewById(R.id.playPauseButton);
        playPauseButton.setOnClickListener(this);
        repeatButton = (Button)findViewById(R.id.repeatButton);
        repeatButton.setOnClickListener(this);
        forwardButton = (Button)findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(this);

        amFm = (Button)findViewById(R.id.am_fm);
        amFm.setOnClickListener(this);

        minusButton = (Button)findViewById(R.id.minusButton);
        minusButton.setOnClickListener(this);

        plusButton = (Button)findViewById(R.id.plusButton);
        plusButton.setOnClickListener(this);

        stationText = (TextView)findViewById(R.id.stationText);

        AMstation = 1000;
        FMstation = 100.1;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onLongClick(View v){
        if (!powerButtonOff) {
            boolean AM = true;
            if (amFm.getText().equals("FM")) {
                AM = false;
            }
//            stationText.setBackgroundColor(0xff0066cc);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//            }
//            stationText.setBackgroundColor(0xffffffff);
            if (v.getId()== R.id.preset1) {
                if (AM) {
                    pre1AM = AMstation;
                }
                else {
                    pre1FM = FMstation;
                }
            }
            if (v.getId()== R.id.preset2) {
                if (AM) {
                    pre2AM = AMstation;
                }
                else {
                    pre2FM = FMstation;
                }
            }
            if (v.getId()== R.id.preset3) {
                if (AM) {
                    pre3AM = AMstation;
                }
                else {
                    pre3FM = FMstation;
                }
            }
            if (v.getId()== R.id.preset4) {
                if (AM) {
                    pre4AM = AMstation;
                }
                else {
                    pre4FM = FMstation;
                }
            }
            if (v.getId()== R.id.preset5) {
                if (AM) {
                    pre5AM = AMstation;
                }
                else {
                    pre5FM = FMstation;
                }
            }
            if (v.getId()== R.id.preset6) {
                if (AM) {
                    pre6AM = AMstation;
                }
                else {
                    pre6FM = FMstation;
                }
            }
        }
        return true;
    }


    public void onClick(View v){

        if(v.getId()== R.id.powerButton && powerButtonOff) {
            v.setBackgroundColor(0xff009933);
            powerButtonOff = false;

            if (amFm.getText().equals("FM")) {
                String FMStationText = String.format("%.1f", FMstation);
                stationText.setText(FMStationText);
            }
            else {
                stationText.setText("" + AMstation);
            }


            forwardButton.setBackgroundColor(0xff009933);
            playPauseButton.setBackgroundColor(0xff009933);
            repeatButton.setBackgroundColor(0xff009933);
            preset1.setBackgroundColor(0xff009933);
            preset2.setBackgroundColor(0xff009933);
            preset3.setBackgroundColor(0xff009933);
            preset4.setBackgroundColor(0xff009933);
            preset5.setBackgroundColor(0xff009933);
            preset6.setBackgroundColor(0xff009933);


        }
        else if(v.getId()== R.id.powerButton && !powerButtonOff) {
            v.setBackgroundColor(0xff990033);
            powerButtonOff = true;

            forwardButton.setBackgroundColor(0xff990033);
            playPauseButton.setBackgroundColor(0xff990033);
            repeatButton.setBackgroundColor(0xff990033);
            preset1.setBackgroundColor(0xff990033);
            preset2.setBackgroundColor(0xff990033);
            preset3.setBackgroundColor(0xff990033);
            preset4.setBackgroundColor(0xff990033);
            preset5.setBackgroundColor(0xff990033);
            preset6.setBackgroundColor(0xff990033);
            Log.i("red", "red");
        }
        if(!powerButtonOff) {
            if (v.getId() == R.id.am_fm) {
                if (amFm.getText().equals("AM")) {
                    amFm.setText("FM");
                    String FMStationText = String.format("%.1f", FMstation);
                    stationText.setText(FMStationText);
                } else {
                    amFm.setText("AM");
                    stationText.setText("" + AMstation);
                }

            }

            if (v.getId() == R.id.minusButton) {
                if (amFm.getText().equals("AM")) {
                    if (AMstation == 530) {
                        AMstation = 1700;
                    } else {
                        AMstation -= 10;
                    }
                    stationText.setText("" + AMstation);
                } else {
                    String FMTest = String.format("%.1f", FMstation);

                    if (FMTest.equals("88.1")) {
                        FMstation = 107.9;
                    } else {
                        FMstation -= 0.2;
                    }
                    String FMStationText = String.format("%.1f", FMstation);
                    stationText.setText(FMStationText);
                }

            }
            if (v.getId() == R.id.plusButton) {
                if (amFm.getText().equals("AM")) {
                    if (AMstation == 1700) {
                        AMstation = 530;
                    } else {
                        AMstation += 10;
                    }
                    stationText.setText("" + AMstation);
                } else {
                    String FMTest = String.format("%.1f", FMstation);

                    if (FMTest.equals("107.9")) {
                        FMstation = 88.1;
                        Log.i("test", "test");
                    } else {
                        FMstation += 0.2;
                    }
                    String FMStationText = String.format("%.1f", FMstation);
                    stationText.setText(FMStationText);

                }
            }
            if (v.getId() == R.id.preset1) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre1AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre1FM);
                    stationText.setText(FMStationText);
                }
            }
            if (v.getId() == R.id.preset2) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre2AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre2FM);
                    stationText.setText(FMStationText);
                }
            }
            if (v.getId() == R.id.preset3) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre3AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre3FM);
                    stationText.setText(FMStationText);
                }
            }
            if (v.getId() == R.id.preset4) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre4AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre4FM);
                    stationText.setText(FMStationText);
                }
            }
            if (v.getId() == R.id.preset5) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre5AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre5FM);
                    stationText.setText(FMStationText);
                }
            }
            if (v.getId() == R.id.preset6) {
                if (amFm.getText().equals("AM")) {
                    stationText.setText("" + pre6AM);
                }
                else {
                    String FMStationText = String.format("%.1f", pre6FM);
                    stationText.setText(FMStationText);
                }
            }
        }
        else stationText.setText("____");
    }
}
