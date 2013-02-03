package org.codechimp.appchooser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AppAdapter extends ArrayAdapter<AppItem> {

	private static final String TAG = "AppChooser";
	private static final int RESOURCE = R.layout.app_row;
	private LayoutInflater inflater;

	static class ViewHolder {		
		TextView textviewTitle;
		ImageView imageviewIcon;		
	}

	public AppAdapter(Context context, java.util.List<AppItem> apps) {
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
			holder.imageviewIcon = (ImageView) convertView
					.findViewById(R.id.appicon);
			convertView.setTag(holder);
		} else {
			// view already defined, retrieve view holder
			holder = (ViewHolder) convertView.getTag();
		}

		AppItem app = (AppItem) getItem(position);
		if (app == null) {
			Log.e(TAG, "Invalid App position: " + position);
		}

		holder.textviewTitle.setText(app.getTitle());
		
		
		new ImageLoader().execute(holder.imageviewIcon, app);
		
		
		return convertView;
	}
	
	public class ImageLoader extends AsyncTask<Object, Void, Drawable> {

	    private ImageView view;
	    private Drawable icon= null;

	    @Override
	    protected Drawable doInBackground(Object... parameters) {

	        // Get the passed arguments here
	        view = (ImageView) parameters[0];
	        AppItem app = (AppItem)parameters[1];

	        icon = app.getIcon();
	        return icon;
	    }

	    @Override
	    protected void onPostExecute(Drawable icon) {
	        if (icon != null && view != null) {
	            view.setImageDrawable(icon);
	        }
	    }
	}
}