package me.roryoc.weartest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements AnimationListener {

    private TextView mTextView;
    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    private RelativeLayout colorView;
    private Animation animFadeIn;

    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter

            if (mAccel > 7) {
                System.out.println(mAccel);
                textChange();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);

            }
        });

        // load the animation
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        // set animation listener
        animFadeIn.setAnimationListener(this);



        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation



    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }

    public void textChange(){

        Random rn = new Random();
        int answer = rn.nextInt(20) + 1;
        System.out.println(answer);

        mTextView = (TextView) findViewById(R.id.text);
        colorView = (RelativeLayout) findViewById(R.id.roundLayout);


        if (answer==1) {
            mTextView.setText("It is certain");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==2){
            mTextView.setText("It is decidedly so");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==3){
            mTextView.setText("Without a doubt");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==4){
            mTextView.setText("Yes, definitely");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==5){
            mTextView.setText("You may rely on it");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==6){
            mTextView.setText("As I see it, yes");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==7){
            mTextView.setText("Most likely");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==8){
            mTextView.setText("Outlook good");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==9){
            mTextView.setText("Yes");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255, 0, 200, 0));
        }else if(answer==10){
            mTextView.setText("Signs point to yes");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.argb(255,34,139,34));
        }else if(answer==11){
            mTextView.setText("Reply hazy try again");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.BLUE);
        }else if(answer==12){
            mTextView.setText("Ask again later");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.BLUE);
        }else if(answer==13){
            mTextView.setText("Better not tell you now");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.BLUE);
        }else if(answer==14){
            mTextView.setText("Cannot predict now");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.BLUE);
        }else if(answer==15){
            mTextView.setText("Concentrate and ask again");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.BLUE);
        }else if(answer==16){
            mTextView.setText("Don't count on it");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.RED);
        }else if(answer==17){
            mTextView.setText("My reply is no");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.RED);
        }else if(answer==18){
            mTextView.setText("My sources say no");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.RED);
        }else if(answer==19){
            mTextView.setText("Outlook not so good");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.RED);
        }else if(answer==20){
            mTextView.setText("Very doubtful");
            mTextView.startAnimation(animFadeIn);
            colorView.setBackgroundColor(Color.RED);

        }


    }
}

//adb forward tcp:4444 localabstract:/adb-hub
//adb connect localhost:4444