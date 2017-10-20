package com.example.sample.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sample.pokemon.R;

import org.w3c.dom.Text;

import static android.R.attr.button;
import static android.R.attr.value;
import static com.example.sample.pokemon.R.id.plusButton;
//test
public class MainActivity extends AppCompatActivity {
    private int addQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
    }
    //(+)ボタンの処理
    public void addPlusButton(View view){
    addQuantity++;
        TextView countView = (TextView) findViewById(R.id.textView);
        countView.setText(String.valueOf(addQuantity));
    }
    //(-)ボタンの処理
    public void addMinusButton(View view){
        addQuantity--;
        TextView countView = (TextView) findViewById(R.id.textView);//IDがtextviewのviewをcountView変数に格納
        countView.setText(String.valueOf(addQuantity));//contviewに数値(addQuantity)を格納

    }
    //テスト用ボタン
    public void addTestButton(View view){
        Button plusButton = (Button) findViewById(R.id.plusButton);
        plusButton.setEnabled(false);
    }
    private int thousand = 1000;

    //数量1000追加ボタン(カンマ実装確認用)
    public void addOneThousandButton(View view){
        TextView muu = (TextView) findViewById(R.id.textView);
        muu.setText(String.valueOf(thousand));
    }
}


    //入れる対象
    //TextView counView = (TextView) findViewById(R.id.textView2);
    //数値を追加
    //int price = 99999999;
    //String priceStr = String.format("%,d", price); // => 99,999,999円;
       // counView.setText(String.valueOf(priceStr));