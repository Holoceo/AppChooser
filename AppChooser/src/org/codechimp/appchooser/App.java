package org.codechimp.appchooser;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;

class App {
	private String   title;
	private String   packageName;
	private Drawable icon;
	
	public App(Context context, ApplicationInfo applicationInfo) {
		this.title = applicationInfo.loadLabel(context.getPackageManager()).toString();
		this.packageName = applicationInfo.packageName;
		// this.icon = icon;		
	}

	public String getTitle() {
		return title;
	}
	public String getPackageName() {
		return packageName;
	}

	public Drawable getIcon() {
		return icon;
	}

}
