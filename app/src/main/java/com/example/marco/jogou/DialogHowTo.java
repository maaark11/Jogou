package com.example.marco.jogou;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


/**
 * Created by kpit on 22/07/2015.
 */
public class DialogHowTo extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();



        // Inflate and set the layout for the dialogHow
        // Pass null as the parent view because its going in the dialogHow layout
        builder.setView(inflater.inflate(R.layout.dialoghowto, null)).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // sign in the user ...
            }
        });
        return builder.create();
    }


}