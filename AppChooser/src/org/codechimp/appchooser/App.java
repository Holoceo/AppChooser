package org.codechimp.appchooser;

import android.graphics.drawable.Drawable;

class App {
	private String   title;
	private String   packageName;
	private Drawable icon;
	

	public App(String title, String packageName, Drawable icon ) {
		this.title = title;
		this.packageName = packageName;
		this.icon = icon;		
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
