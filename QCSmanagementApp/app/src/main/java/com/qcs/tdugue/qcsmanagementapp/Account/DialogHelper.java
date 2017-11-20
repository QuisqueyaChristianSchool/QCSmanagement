package com.qcs.tdugue.qcsmanagementapp.Account;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by tdugue on 10/23/2017.
 */

public class DialogHelper {
    public static AlertDialog createErrorDialog(Context context, String title, String message )
    {
        return new AlertDialog.Builder( context )
                .setTitle( title )
                .setMessage( message )
                .setIcon( android.R.drawable.ic_dialog_alert )
                .create();
    }


}

