package com.example.CrunkApp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dominicnunes on 1/5/2014.
 */
public class NextDrink extends Activity {


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

    float crunkRatio2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink2);


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
                Float crunkRatio1 = getIntent().getExtras().getFloat("passedCrunkValue");

                price = Float.parseFloat(etPrice.getText().toString());
                volume = Float.parseFloat(etVolume.getText().toString());
                quantity = Integer.parseInt(etQuantity.getText().toString());
                percentage = Float.parseFloat(etPercentage.getText().toString());


                if (quantity == 0 || etQuantity.getText() == null) quantity = 1;


                if (percentage > 100){
//                TODO: popup that explains incorrect percentage
                }else crunkRatio2 = (volume * (percentage/100) / price);


                if (crunkRatio2 > crunkRatio1)
                    Toast.makeText(getApplicationContext(), "Drink 2 will get you more crunk for the money! "
                            + crunkRatio2 + "ml per dollar VS "  + crunkRatio1 + "ml per dollar",
                            Toast.LENGTH_LONG).show();

                else

                Toast.makeText(getApplicationContext(), "Drink 1 will get you more crunk for the money! "
                        + crunkRatio1 + "ml per dollar VS "  + crunkRatio2 + "ml per dollar",
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}