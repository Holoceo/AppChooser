package org.codechimp.appchooser;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class AppChooser {
	
	static List<App> appList = new ArrayList<App>();
	
	public static void showChooserDialog(final Context context) {
		
		if (appList.isEmpty())
			refreshAppList(context);
		
		Builder builder = new AlertDialog.Builder(context);
		
		builder.setTitle("Select App"); // context.getString(R.string.dialog_title)

		ListView appListView = new ListView(context);

		AppAdapter appAdapter = new AppAdapter(context, appList);
		appListView.setAdapter(appAdapter);

		builder.setView(appListView);
		final Dialog dialog = builder.create();

		appListView.setOnItemClickListener(new OnItemClickListener() {		
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//TODO: send choice back
				dialog.dismiss();				
			}
		});

		dialog.show();		
	}
	
	public static void refreshAppList(final Context context){
		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List<ResolveInfo> pkgAppsList = context.getPackageManager().queryIntentActivities( mainIntent, 0);
                
        appList.clear();
        
        for(ResolveInfo appItem:pkgAppsList){
        		appList.add(new App(context, appItem.activityInfo.applicationInfo));
        }
        
//        Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage(mIdList.get(2));
//        context.startActivity( LaunchIntent );
	}

}