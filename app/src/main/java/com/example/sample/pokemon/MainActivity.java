package com.example.sample.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int quantity;
    private TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantityTextView);
    }

    //(+)ボタンの処理
    public void onClickByPlusButton(View view){
        quantity = quantity + 100;
        String addCommaToQuantity = String.format("%,d",quantity);
        quantityTextView.setText(String.valueOf(addCommaToQuantity));
    }

    //数量が０の場合(-)ボタンを非活性

    //(-)ボタンの処理
    public void onClickByMinusButton(View view){
        quantity--;
        String addCommaToQuantity = String.format("%,d",quantity);
        quantityTextView.setText(String.valueOf(addCommaToQuantity));//quantiryTextViewに数値(quantity)を格納
    }

    //テスト用ボタン(pulsButton非活性)
    public void onClickTestButton(View view){
        Button plusButton = (Button) findViewById(R.id.plusButton);
        plusButton.setEnabled(false);
    }

        private int thousand = 1000;

    //数量1000追加ボタン(カンマ実装確認用)
    public void onClickByThousandButton(View view){
        quantity = quantity + 1000;
        String addCommaToQuantity = String.format("%,d",thousand);//数値をカンマありきの文字列に変換
        quantityTextView.setText(String.valueOf(addCommaToQuantity));
    }
}


    //入れる対象
    //TextView counView = (TextView) findViewById(R.id.textView2);
    //数値を追加
    //int price = 99999999;
    //String priceStr = String.format("%,d", price); // => 99,999,999円;
       // counView.setText(String.valueOf(priceStr));