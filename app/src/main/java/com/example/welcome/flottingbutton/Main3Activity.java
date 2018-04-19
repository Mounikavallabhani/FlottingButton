package com.example.welcome.flottingbutton;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity  implements View.OnClickListener{


    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

        fab.setOnClickListener(Main3Activity.this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);


    }


    @Override
    public void onClick (View view){


        int id = view.getId();
        switch (id)
        {
            case R.id.fab:
                animateFAB();
                break;

            case R.id.fab1:
                Intent i = new Intent(this, Main2Activity.class);
                startActivity(i);
                break;

            case R.id.fab2:
                Intent i1 = new Intent(this, MainActivity.class);
                startActivity(i1);
                break;

        }
    }
    public void animateFAB() {

        if (isFabOpen)
        {

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
            Toast.makeText(this, "fab close", Toast.LENGTH_SHORT).show();

        }
        else
        {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
            Toast.makeText(this, "fab open", Toast.LENGTH_SHORT).show();

        }
    }
}
