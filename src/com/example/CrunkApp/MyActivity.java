package com.example.CrunkApp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    EditText etPrice;
    EditText etVolume;
    EditText etQuantity;
    EditText etPercentage;

    TextView tvAnswer;


    Button bCrunkCalc;

    float price = 1;
    float volume = 1;
    float percentage = 1;
    int quantity = 1;

    float crunkRatio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        etPrice = (EditText) findViewById(R.id.etPrice);
        etVolume = (EditText) findViewById(R.id.etVolume);
        etQuantity = (EditText) findViewById(R.id.etQuantity);
        etPercentage = (EditText) findViewById(R.id.etPercentage);

        bCrunkCalc = (Button) findViewById(R.id.bCrunkcalc);

        tvAnswer = (TextView) findViewById(R.id.tvAnswer);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        tvAnswer.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView5.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));
        textView6.setTypeface(Typeface.createFromAsset(getAssets(), "newfont2.ttf"));

        bCrunkCalc.setTypeface(Typeface.createFromAsset(getAssets(), "newfont.ttf"));

        bCrunkCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                price = Float.parseFloat(etPrice.getText().toString());
                volume = Float.parseFloat(etVolume.getText().toString());
                quantity = Integer.parseInt(etQuantity.getText().toString());
                percentage = Float.parseFloat(etPercentage.getText().toString());


                if (quantity == 0 || etQuantity.getText() == null) quantity = 1;


                if (percentage > 100){
//                TODO: popup that explains incorrect percentage
                }else crunkRatio = (volume * (percentage/100) / price);

                tvAnswer.setText(String.valueOf(crunkRatio) + " per dollar!");

                Intent i = new Intent(MyActivity.this, NextDrink.class);
                i.putExtra("passedCrunkValue", crunkRatio);

                startActivity(i);
            }
        });

    }

}
