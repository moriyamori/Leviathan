package com.example.sample.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //定数を定義
    private static final int QUANTITY_MAX = 9999;
    private static final int QUANTITY_MIN = 0;

    private int quantity;
    private TextView quantityTextView;
    private Button plusButton;
    private Button minusButton;

    //値を更新する
    //更新した値をText化して表示する

    //起動後の処理
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        unionUi();
        invalidationProcessingOfButtonByQuantity();
        convertToString();
    }

    //Viewを初期化
    private void unionUi() {
        setContentView(R.layout.activity_main);
        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        quantityTextView = (TextView) findViewById(R.id.quantityTextView);
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
    //現在時刻表示
    // ミリ秒

private void nuu
System.currentTimeMillis();

    // Date型にする場合
    Date now = new Date(System.currentTimeMillis);



    // 日時のフォーマットオブジェクト作成」
    public static String getNowDate(){
        // 現在日時の取得
        Date now = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");

        // フォーマット
        String nowText = formatter.format(now);

        // 表示
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(nowText);
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