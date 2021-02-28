package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int delay = 1000;

    private int max = 6000;
    private int min = 1000;

//    final Handler mHandler = new Handler();
//    Runnable r = new Runnable() {
//
//        @Override
//        public void run() {
//            //do something
//            Log.i("'MainActivity'", "--------定时任务------");
//            Random random = new Random();
//            delay = random.nextInt(max)%(max - min + 1) + min;
//            Log.i("'MainActivity'", "--------间隔------" + delay);
//            //每隔1s循环执行run方法
//            mHandler.postDelayed(this, delay);
//        }
//    };

    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //do something
                Log.i("'MainActivity'", "--------定时任务2------");
                Random random = new Random();
                delay = random.nextInt(max)%(max - min + 1) + min;
                Log.i("'MainActivity'", "--------间隔2------" + delay);
            }
            super.handleMessage(msg);
        }
    };

    private Timer timer = new Timer();

    class MyTimerTask extends TimerTask{

        private int time; // 定时执行时间
        public MyTimerTask() {
            super();
        }

        public MyTimerTask(int time) {
            this.time = time;
        }


        @Override
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);

            timer.cancel();
            timer = null;
            timer = new Timer();
            timer.schedule(new MyTimerTask(delay), delay);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //主线程中调用：
//        mHandler.postDelayed(r, delay);//延时100毫秒

        //主线程中调用：
        timer.schedule(new MyTimerTask(delay), delay, delay);//延时1s，每隔500毫秒执行一次run方法
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

    @Override
    protected void onDestroy() {
//        mHandler.removeCallbacks(r);
//        mHandler = null;
        super.onDestroy();
    }
}