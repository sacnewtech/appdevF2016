package com.weebly.jeribeartx.sophomoretrip;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.graphics.Color;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public final static String EXTRA_NAME = "com.weebly.jeribeartx.sophomoretrip.NAME";
    public final static String EXTRA_COMMENTS = "com.weebly.jeribeartx.sophomoretrip.COMMENTS";
    public final static String EXTRA_CITY1 = "com.weebly.jeribeartx.sophomoretrip.CITY1";
    public final static String EXTRA_CITY2 = "com.weebly.jeribeartx.sophomoretrip.CITY2";

    private String cities[] = {"Monterey Bay", "Los angeles",
            "Sacramento", "San Diego", "San Francisco"};
    private String durations[] = {"1 week", "3 days", "1 day"};

    private EditText nameField = new EditText(this);
    private ListView cityList = new ListView(this);
	private ListView cityList2 = new ListView(this);
	private EditText commentsField = new EditText(this);


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            Log.d("Activity", "Touch event "+event.getRawX()+","+event.getRawY()+" "+x+","+y+" rect "+w.getLeft()+","+w.getTop()+","+w.getRight()+","+w.getBottom()+" coords "+scrcoords[0]+","+scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView cityTitle = new TextView(this);
        cityTitle.setText("Choose Your FIRST Choice City:");

        TextView cityTitle2 = new TextView(this);
        cityTitle2.setText("Choose Your SECOND Choice City:");

        TextView durationTitle = new TextView(this);
        durationTitle.setText("Choose How Long You Would Want to Stay:");


        nameField.setHint("First and Last Name");
        commentsField.setHint("comments");


        //nameField.setMinWidth(600);
        nameField.setWidth ( (int) TypedValue.applyDimension (
                TypedValue.COMPLEX_UNIT_DIP,
                600,
                getResources().getDisplayMetrics()
                )
        );
        //commentsField.setMinWidth(800);
        nameField.setWidth ( (int) TypedValue.applyDimension (
                TypedValue.COMPLEX_UNIT_DIP,
                800,
                getResources().getDisplayMetrics()
                )
        );

        //ListAdapter adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_single_choice, cities);

        //setListAdapter(adapter);


        cityList.setAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, cities));
        cityList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "#1 Choice Is " + item, Toast.LENGTH_SHORT).show();


            }
        });


        cityList2.setAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, cities));
        cityList2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        cityList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "#1 Choice Is " + item, Toast.LENGTH_SHORT).show();


            }
        });


        ListView duraList = new ListView(this);
        duraList.setAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, durations));
        duraList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        duraList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Duration Choice is " + item, Toast.LENGTH_SHORT).show();


            }
        });

        //List Parameters
        RelativeLayout.LayoutParams duraParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams listParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams cityTitleParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams listParams2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams cityTitleParams2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams durationTitleParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams nameParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams commentsParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Submit Button
        Button submitButton = new Button(this);
        submitButton.setText("Submit Survey");
        submitButton.setBackgroundColor(Color.DKGRAY);
        submitButton.setTextColor(Color.WHITE);
        submitButton.setMinWidth(700);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                summaryMessage(v);
            }
        });

        //Button Parameters
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );


        //Layout
        RelativeLayout tripLayout = new RelativeLayout(this);
        cityTitle.setId(1);
        cityList.setId(2);
        cityTitle2.setId(3);
        cityList2.setId(4);

        durationTitle.setId(5);
        duraList.setId(6);
        nameField.setId(7);
        commentsField.setId(8);

        cityTitleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        listParams.addRule(RelativeLayout.BELOW, cityTitle.getId());
        cityTitleParams2.addRule(RelativeLayout.BELOW, cityList.getId());
        listParams2.addRule(RelativeLayout.BELOW, cityTitle2.getId());

        durationTitleParams.addRule(RelativeLayout.BELOW, cityList2.getId());
        duraParams.addRule(RelativeLayout.BELOW, durationTitle.getId());
        nameParams.addRule(RelativeLayout.BELOW, duraList.getId());
        commentsParams.addRule(RelativeLayout.BELOW, nameField.getId());
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);


        tripLayout.addView(cityTitle, cityTitleParams);
        tripLayout.addView(cityList, listParams);
        tripLayout.addView(cityTitle2, cityTitleParams2);
        tripLayout.addView(cityList2, listParams2);
        tripLayout.addView(durationTitle, durationTitleParams);
        tripLayout.addView(duraList, duraParams);
        tripLayout.addView(nameField, nameParams);
        tripLayout.addView(commentsField, commentsParams);

        tripLayout.setBackgroundColor(Color.WHITE);
        tripLayout.setDrawingCacheBackgroundColor(Color.BLUE);
        tripLayout.addView(submitButton, buttonParams);

        setContentView(tripLayout);
    }

    public void summaryMessage(View view) {
        Intent intent = new Intent(this, SummaryMessage.class);
        String studentName = nameField.getText().toString();
        String studentComments = commentsField.getText().toString();
        String studentCity1 = cityList.getSelectedItem().toString();
        String studentCity2 = cityList2.getSelectedItem().toString();
        intent.putExtra(EXTRA_NAME, studentName);
        intent.putExtra(EXTRA_COMMENTS, studentComments);
        intent.putExtra(EXTRA_CITY1, studentCity1);
        intent.putExtra(EXTRA_CITY2, studentCity2);
        startActivity(intent);
    }
}
