package com.example.jerry_huang.sortandsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String peopleNames[] = {"Jerry 64","Luke 24", "Miguel 7", "Skye 12", "Kyle 11", "Khaalel 2", "Leo 6", "Jonathan 13"};
    private int peopleNumber[] = {64, 24, 7, 12, 11, 2, 6, 13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView peopleList = (ListView) findViewById(R.id.peopleView);
        peopleList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peopleNames));
        peopleList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        RadioButton byName = (RadioButton) findViewById(R.id.nameButton);
        RadioButton byNum = (RadioButton) findViewById(R.id.ageButton);

        byNum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Sort by
                Toast.makeText(MainActivity.this, "by Number Selected", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < (peopleNames.length - 1); i++)
                    for (int j = 0; j < (peopleNames.length - i - 1); j++)
                        if (peopleNumber[j] > peopleNumber[j + 1]) {
                            int tempNum = peopleNumber[j];
                            peopleNumber[j] = peopleNumber[j + 1];
                            peopleNumber[j + 1] = tempNum;

                            String tempPeople = peopleNames[j];
                            peopleNames[j] = peopleNames[j + 1];
                            peopleNames[j + 1] = tempPeople;
                        }
                peopleList.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, peopleNames));

            }
        });

        byName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Sort by
                Toast.makeText(MainActivity.this, "by Name Selected", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < (peopleNames.length - 1); i++)
                    for (int j = 0; j < (peopleNames.length - i - 1); j++)
                        if (peopleNames[j].compareTo( peopleNames[j + 1]) > 0) {
                            int tempNum = peopleNumber[j];
                            peopleNumber[j] = peopleNumber[j + 1];
                            peopleNumber[j + 1] = tempNum;

                            String tempPeople = peopleNames[j];
                            peopleNames[j] = peopleNames[j + 1];
                            peopleNames[j + 1] = tempPeople;
                        }
                peopleList.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, peopleNames));

            }
        });
    }
}


