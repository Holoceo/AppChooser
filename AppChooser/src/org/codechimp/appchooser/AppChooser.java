package org.codechimp.appchooser;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;


public class AppChooser {

	public static void showChooserDialog(final Context context) {
		Builder builder = new AlertDialog.Builder(context);
		
//		builder.setTitle(String.format(
//				context.getString(R.string.dialog_title),
//				context.getString(R.string.app_name)));
//
//		builder.setMessage(String.format(
//				context.getString(R.string.rate_message),
//				context.getString(R.string.app_name)));
//
//		builder.setPositiveButton(context.getString(R.string.rate),
//				new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int id) {
//
//						
//						dialog.dismiss();			
//					}
//				});
		
		builder.show();
	}

}
