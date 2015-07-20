package com.example.marco.jogou;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import mehdi.sakout.fancybuttons.FancyButton;


@SuppressWarnings("ALL")
public class MainActivity extends ActionBarActivity {

    final int[] number ={5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final DiscreteSeekBar bar = (DiscreteSeekBar) findViewById(R.id.barNumbers);
        bar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i, boolean b) {
                number[0] = bar.getProgress();

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
                insertNumbers();
            }
        });

        FancyButton btnSena = (FancyButton) findViewById(R.id.btnSena);
        btnSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SENA!" + number[0], Toast.LENGTH_LONG).show();
            }
        });

        FancyButton btnFacil = (FancyButton) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Facil", Toast.LENGTH_LONG).show();
            }
        });

        FancyButton btnMania = (FancyButton) findViewById(R.id.btnMania);
        btnMania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mania", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void insertNumbers() {
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
            tvNumber.setText("[00]");
            tvNumber.setId(5);
            tvNumber.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            tvNumber.setPadding(40,0,40,0);

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


