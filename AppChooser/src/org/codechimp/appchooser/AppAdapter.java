package org.codechimp.appchooser;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AppAdapter extends ArrayAdapter {

	private static final String TAG = "AppChooser";
	private static final int RESOURCE = R.layout.app_row;
	private LayoutInflater inflater;

	static class ViewHolder {
		TextView textviewTitle;
	}

	@SuppressWarnings("unchecked")
	public AppAdapter(Context context, java.util.List<App> apps) {
		super(context, RESOURCE, apps);
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			// inflate a new view and setup the view holder for future use
			convertView = inflater.inflate(RESOURCE, null);

			holder = new ViewHolder();
			holder.textviewTitle = (TextView) convertView
					.findViewById(R.id.apptitle);
			convertView.setTag(holder);
		} else {
			// view already defined, retrieve view holder
			holder = (ViewHolder) convertView.getTag();
		}

		App app = (App) getItem(position);
		if (app == null) {
			Log.e(TAG, "Invalid App position: " + position);
		}

		holder.textviewTitle.setText(app.getTitle());

		// parent.getContext();

		// holder.textviewTitle.setCompoundDrawables( app.getIcon(), null, null,
		// null );

		return convertView;
	}
}