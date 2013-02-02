package org.codechimp.appchooser;

public interface AppChooserListener {
	public void onAppSelected(AppItem value);
	public void onDismiss();
}
