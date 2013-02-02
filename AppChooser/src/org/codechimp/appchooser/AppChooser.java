package org.codechimp.appchooser;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AppChooser {
	
	public static void showChooserDialog(final Context context) {
		
		buildAppList(context);
		
		Builder builder = new AlertDialog.Builder(context);
		
		builder.setTitle("Select App"); // context.getString(R.string.dialog_title)

		ListView modeList = new ListView(context);
		String[] stringArray = new String[] { "Bright Mode", "Normal Mode" };
		ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);
		modeList.setAdapter(modeAdapter);

		builder.setView(modeList);
		final Dialog dialog = builder.create();

		modeList.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				//TODO: send choice back
				dialog.dismiss();				
			}
		});

		dialog.show();		
	}
	
	private static void buildAppList(final Context context){
		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List<ResolveInfo> pkgAppsList = context.getPackageManager().queryIntentActivities( mainIntent, 0);
        
        ArrayList<String> mIdList=new ArrayList<String>();
        for(ResolveInfo appItem:pkgAppsList){
                mIdList.add(appItem.activityInfo.applicationInfo.packageName);
                //appItem.activityInfo.applicationInfo.name;
        }
        
//        Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage(mIdList.get(2));
//        context.startActivity( LaunchIntent );
	}

}
