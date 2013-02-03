package org.codechimp.appchooser;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;

public class AppItem {
	private Context context;
	private ApplicationInfo applicationInfo;
	private String title;
	private String packageName;
	private Drawable icon = null;

	public AppItem(Context context, ApplicationInfo applicationInfo) {
		this.context = context;
		this.applicationInfo = applicationInfo;
		this.title = applicationInfo.loadLabel(context.getPackageManager())
				.toString();
		this.packageName = applicationInfo.packageName;
		
		//this.icon = applicationInfo.loadIcon(context.getPackageManager());
	}

	public String getTitle() {
		return title;
	}

	public String getPackageName() {
		return packageName;
	}

	public Drawable getIcon() {		
		if (icon == null)
			icon = applicationInfo.loadIcon(context.getPackageManager());

		return icon;
	}
	
}
