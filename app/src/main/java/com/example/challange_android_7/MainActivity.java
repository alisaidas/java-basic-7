package com.example.challange_android_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity<viewListTimeTables_ListView> extends AppCompatActivity {
    ListView viewListTimeTables_ListView;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timetableContent_ListView = new ArrayList<String>();

        for (int i = 1; i <= 10; i++ ) {
            timetableContent_ListView.add(Integer.toString(i * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter_Content = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timetableContent_ListView);
        viewListTimeTables_ListView.setAdapter(arrayAdapter_Content);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableScroll_SeekBar = findViewById(R.id.timeTableScroll);
        viewListTimeTables_ListView  = findViewById(R.id.viewListTimeTables);

        timeTableScroll_SeekBar.setMax(20);
        timeTableScroll_SeekBar.setProgress(10);

        timeTableScroll_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    timeTableScroll_SeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }

                Log.i("Seekbar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}