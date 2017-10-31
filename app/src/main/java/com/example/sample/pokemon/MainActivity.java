package com.example.sample.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //定数を定義
    private static final int QUANTITY_MAX = 9999;
    private static final int QUANTITY_MIN = 0;
    private static final int FIEST_WAIT_TIME = 0;
    private static final int NEXT_WAIT_TIME = 1000;

    private int quantity;
    private TextView quantityTextView;
    private Button plusButton;
    private Button minusButton;
    private TimerTask timerTask = null;
    private final Timer timer = new Timer();
    private final SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");
    private TextView timerTextView = null;

    //起動後の処理
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        unitUi();
        invalidationProcessingOfButtonByQuantity();
        convertToString();
    }

    //Viewを初期化
    private void unitUi() {
        setContentView(R.layout.activity_main);
        plusButton = (Button) findViewById(R.id.plusbutton);
        minusButton = (Button) findViewById(R.id.minusbutton);
        quantityTextView = (TextView) findViewById(R.id.quantitytextview);
        timerTextView = (TextView) findViewById(R.id.textview_time);
    }

    @Override
    protected void onResume() {
        super.onResume();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 現在時刻の表示
                        timerTextView.setText(formatter.format(new Date()));
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, FIEST_WAIT_TIME, NEXT_WAIT_TIME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // バックグラウンドでの時刻表示の廃止
        timerTask.cancel();
    }

    public void onClickByPlusButton(View view) {
        quantity++;
        invalidationProcessingOfButtonByQuantity();
        convertToString();
    }

    public void onClickByMinusButton(View view) {
        quantity--;
        invalidationProcessingOfButtonByQuantity();
        convertToString();
    }

    //限界値でトーストも表示
    private void invalidationProcessingOfButtonByQuantity() {
        if (quantity <= QUANTITY_MIN) {
            quantity = QUANTITY_MIN;
            minusButton.setEnabled(false);
            plusButton.setEnabled(true);
            Toast.makeText(this, "初期値です", Toast.LENGTH_LONG).show();
        } else if (quantity >= QUANTITY_MAX) {
            quantity = QUANTITY_MAX;
            minusButton.setEnabled(true);
            plusButton.setEnabled(false);
            Toast.makeText(this, "これ以上数量を加算できません", Toast.LENGTH_LONG).show();
        } else {
            plusButton.setEnabled(true);
            minusButton.setEnabled(true);
        }
    }

    private void convertToString() {
        String quantityText = String.format("%,d", quantity);
        quantityTextView.setText(String.valueOf(quantityText));
    }

    //Test用
    private int quantityForTesting = QUANTITY_MAX;

    //数量(?)追加ボタン(カンマ実装確認用)
    public void onClickByTestButton(View view) {
        quantity = quantityForTesting;
        convertToString();
        invalidationProcessingOfButtonByQuantity();
    }
}