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
        setContentView(summaryLayout);

        Intent intent = getIntent();
        TextView studentName = new TextView(this);
        TextView studentComments = new TextView(this);
        TextView studentCity1 = new TextView(this);
        TextView studentCity2 = new TextView(this);

        studentName.setId(1);
        studentComments.setId(2);
        studentCity1.setId(3);
        studentCity2.setId(4);

        studentName.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));
        studentComments.setText(intent.getStringExtra(MainActivity.EXTRA_COMMENTS));
        studentCity1.setText(intent.getStringExtra(MainActivity.EXTRA_CITY1));
        studentCity2.setText(intent.getStringExtra(MainActivity.EXTRA_CITY2));

        //List Parameters
        RelativeLayout.LayoutParams namesParams = new RelativeLayout.LayoutParams(800, 100);
        RelativeLayout.LayoutParams commentsParams = new RelativeLayout.LayoutParams(800, 100);
        RelativeLayout.LayoutParams city1Params = new RelativeLayout.LayoutParams(800, 100);
        RelativeLayout.LayoutParams city2Params = new RelativeLayout.LayoutParams(800, 100);

        namesParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        city1Params.addRule(RelativeLayout.BELOW, studentName.getId());
        city2Params.addRule(RelativeLayout.BELOW, studentCity1.getId());
        commentsParams.addRule(RelativeLayout.BELOW, studentCity2.getId());

        summaryLayout.addView(studentName, namesParams);
        summaryLayout.addView(studentCity1,city1Params);
        summaryLayout.addView(studentCity2, city2Params);
        summaryLayout.addView(studentComments, commentsParams);


    }
}
