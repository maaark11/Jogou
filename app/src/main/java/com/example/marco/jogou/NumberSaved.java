package com.example.marco.jogou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NumberSaved extends AppCompatActivity {

    final static DialogHowTo dialogHow = new DialogHowTo();
    final static DialogAbout dialogAbo = new DialogAbout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_saved);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number_saved, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_howTo) {
            dialogHow.show(getFragmentManager(), "TAG");
        }
        if (id == R.id.action_about) {
            dialogAbo.show(getFragmentManager(), "TAG");
        }

        if(id == R.id.action_search){
            Toast.makeText(NumberSaved.this, "Test", Toast.LENGTH_LONG).show();
        }

        return true;
    }
}
