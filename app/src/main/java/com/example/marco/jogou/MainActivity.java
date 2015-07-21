package com.example.marco.jogou;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import mehdi.sakout.fancybuttons.FancyButton;


@SuppressWarnings("ALL")
public class MainActivity extends ActionBarActivity {

    final int[] number ={5};
    final Jogou jogou = new Jogou();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity context = this;
        float scale = context.getResources().getDisplayMetrics().density;

        final DiscreteSeekBar bar = (DiscreteSeekBar) findViewById(R.id.barNumbers);
        bar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i, boolean b) {
                number[0] = bar.getProgress();
                jogou.setQuantity(number[0]);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {

            }
        });


        //-------------------------------------Buttons------------------------------------
        final FancyButton btnQuina = (FancyButton) findViewById(R.id.btnQuina);
        btnQuina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number[0]>=5 && number[0]<=7){
                    jogou.setNumber(80);
                    insertNumbers(jogou.generate());
                }else{
                    Toast.makeText(MainActivity.this,"Favor selecionar de 5 a 7 dezenas!", Toast.LENGTH_LONG).show();
                }
            }
        });

        FancyButton btnSena = (FancyButton) findViewById(R.id.btnSena);
        btnSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number[0]>=6 && number[0]<=15){
                    jogou.setNumber(60);
                    insertNumbers(jogou.generate());
                }else{
                    Toast.makeText(MainActivity.this,"Favor selecionar de 6 a 15 dezenas!", Toast.LENGTH_LONG).show();
                }
            }
        });

        FancyButton btnFacil = (FancyButton) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number[0]>=15 && number[0]<=18){
                    jogou.setNumber(25);
                    insertNumbers(jogou.generate());
                }else{
                    Toast.makeText(MainActivity.this,"Favor selecionar de 15 a 18 dezenas!", Toast.LENGTH_LONG).show();
                }
            }
        });


        if(scale > 2.0){
            btnQuina.setTextSize(18);
            btnSena.setTextSize(18);
            btnFacil.setTextSize(18);
        }else{
            btnQuina.setTextSize(16);
            btnSena.setTextSize(16);
            btnFacil.setTextSize(16);
        }
    }


    public void insertNumbers(String v[]) {
        MainActivity context = this;
        float scale = context.getResources().getDisplayMetrics().density;
        //-----ITNES FOR SHOW NUMBERS--------------------
        View tb[] = {findViewById(R.id.tr0),
                findViewById(R.id.tr1),
                findViewById(R.id.tr2),
                findViewById(R.id.tr3)};
        int j =0;
        while (j < tb.length){
            ((LinearLayout) tb[j]).removeAllViews();
            j++;
         }
        for(int i=0; i<number[0];i++){

            //LinearLayout layout = (LinearLayout) findViewById(R.id.info);

            TextView tvNumber = new TextView(this);
            tvNumber.setText(v[i]);
            tvNumber.setId(5);
            tvNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            //----------------------4 WORK IN DIFFERENT SCREENS----------------------//
            if(scale > 2.0) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(45, 0, 45, 0);
                tvNumber.setPadding(12,8,12,8);
                tvNumber.setLayoutParams(params);
            }else {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
                params.setMargins(20, 0, 20, 0);
                tvNumber.setPadding(2, 2, 2, 2);
                tvNumber.setLayoutParams(params);
            }
            tvNumber.setGravity(Gravity.CENTER);
            //----------------------4 WORK IN DIFFERENT SCREENS----------------------//

            //------------------Circle green------------------//
            GradientDrawable circle =  new GradientDrawable();
            circle.setCornerRadius(100);
            circle.setColor(Color.rgb(76,175,80));
            tvNumber.setBackground(circle);
            tvNumber.setTextColor(Color.WHITE);
            //------------------Circle green------------------//

            if(i < 5){
                ((LinearLayout) tb[0]).addView(tvNumber);
            }else if((i >= 5) && (i<10)){
                ((LinearLayout) tb[1]).addView(tvNumber);
            }else if(i >= 10 && i<15){
                ((LinearLayout) tb[2]).addView(tvNumber);
            }else if(i >= 15 && i<20){
                ((LinearLayout) tb[3]).addView(tvNumber);
            }
        }
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
    protected void onResume() {

        super.onResume();
    }


}


