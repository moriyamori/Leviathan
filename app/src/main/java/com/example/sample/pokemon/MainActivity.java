package com.example.sample.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//クラスを設定
public class MainActivity extends AppCompatActivity {

    //定数を定義
    private static final int QUANTITY_MAX = 9999;
    private static final int QUANTITY_MIN = 0;

    private int quantity;
    private TextView quantityTextView;
    private Button plusButton;
    private Button minusButton;

    //起動後の処理
    //Viewを初期化
    //ボタンを押下する
    //値を更新する
    //更新した値をText化して表示する
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        quantityTextView = (TextView) findViewById(R.id.quantityTextView);

        disableBotton();
        quantityConmmaAdded();
    }

    private void setEnableTrue() {
        plusButton.setEnabled(true);
        minusButton.setEnabled(true);
    }

    //数量値で非活性処理
    private void disableBotton() {
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
            setEnableTrue();
        }
    }

    private void quantityConmmaAdded() {
        String quantityText = String.format("%,d", quantity);
        quantityTextView.setText(String.valueOf(quantityText));
    }

    //(+)ボタンの処理
    public void onClickByPlusButton(View view) {
        quantity++;
        disableBotton();
        quantityConmmaAdded();
    }

    //(-)ボタン押下時の処理
    public void onClickByMinusButton(View view) {
        quantity--;
        quantityConmmaAdded();
        disableBotton();
    }

    //Test用
    private int quantityForTesting = QUANTITY_MAX;

    //数量(?)追加ボタン(カンマ実装確認用)
    public void onClickByTestButton(View view) {
        quantity = quantityForTesting;
        quantityConmmaAdded();
        disableBotton();
    }
}