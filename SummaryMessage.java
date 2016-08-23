package com.weebly.jeribeartx.sophomoretrip;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SummaryMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout summaryLayout = new RelativeLayout(this);


        Intent intent = getIntent();
        TextView studentName = new TextView(this);
        TextView studentComments = new TextView(this);
        TextView studentCity1 = new TextView(this);
        TextView studentCity2 = new TextView(this);
        TextView studentDuration = new TextView(this);

        studentName.setId(1);
        studentComments.setId(2);
        studentCity1.setId(3);
        studentCity2.setId(4);
        studentDuration.setId(5);

        studentName.setText("Summary of " + intent.getStringExtra(MainActivity.EXTRA_NAME )+ "'s Survey:");
        studentComments.setText(intent.getStringExtra(MainActivity.EXTRA_COMMENTS));
        studentCity1.setText(intent.getStringExtra(MainActivity.EXTRA_CITY1));
        studentCity2.setText(intent.getStringExtra(MainActivity.EXTRA_CITY2));
        studentDuration.setText(intent.getStringExtra(MainActivity.EXTRA_DURATION));

        studentName.setTextSize(30);
        studentComments.setTextSize(20);
        studentCity1.setTextSize(20);
        studentCity2.setTextSize(20);
        studentDuration.setTextSize(20);

        //List Parameters
        RelativeLayout.LayoutParams namesParams = new RelativeLayout.LayoutParams(800, 100);
        RelativeLayout.LayoutParams commentsParams = new RelativeLayout.LayoutParams(800, 50);
        RelativeLayout.LayoutParams city1Params = new RelativeLayout.LayoutParams(800, 50);
        RelativeLayout.LayoutParams city2Params = new RelativeLayout.LayoutParams(800, 50);
        RelativeLayout.LayoutParams duraParams = new RelativeLayout.LayoutParams(800, 50);

        namesParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        city1Params.addRule(RelativeLayout.BELOW, studentName.getId());
        city2Params.addRule(RelativeLayout.BELOW, studentCity1.getId());
        duraParams.addRule(RelativeLayout.BELOW, studentCity2.getId());
        commentsParams.addRule(RelativeLayout.BELOW, studentDuration.getId());

        summaryLayout.addView(studentName, namesParams);
        summaryLayout.addView(studentCity1,city1Params);
        summaryLayout.addView(studentCity2, city2Params);
        summaryLayout.addView(studentDuration, duraParams);
        summaryLayout.addView(studentComments, commentsParams);


        setContentView(summaryLayout);
    }
}
