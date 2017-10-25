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

        setQuantityComma();
        judgeByQuantity();
    }

    //数量で判定処理
    public void judgeByQuantity() {
        Button minusButton = (Button) findViewById(R.id.minusButton);
        Button plusButton = (Button) findViewById(R.id.plusButton);
        switch (quantity) {
            case 0:
                minusButton.setEnabled(false);
                break;
            case 9999:
                plusButton.setEnabled(false);
                break;
            default:
                minusButton.setEnabled(true);
                plusButton.setEnabled(true);
        }
    }

    public void setQuantityComma() {
        String addCommaToQuantity = String.format("%,d", quantity);
        quantityTextView.setText(String.valueOf(addCommaToQuantity));
    }

    //(+)ボタンの処理
    public void onClickByPlusButton(View view) {
        quantity = quantity + 100;
        setQuantityComma();
        judgeByQuantity();
    }

    //(-)ボタン押下時の処理
    public void onClickByMinusButton(View view) {
        quantity--;
        setQuantityComma();
        judgeByQuantity();
    }

    private int quantityForTesting = 9999;

    //数量(?)追加ボタン(カンマ実装確認用)
    public void onClickByThousandButton(View view) {
        quantity = quantityForTesting;
        setQuantityComma();
        judgeByQuantity();
    }
}