package com.sourcebits.contactprovider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements LoaderCallbacks<Cursor> {

	CustomAdapter adapter;
	private static final int URL_LOADER = 0;
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		Log.d("hi", "onCreate...");
		getLoaderManager().initLoader(URL_LOADER, null, this);

	}

	/*
	 * 
	 * //data used for query Uri uri = Contacts.CONTENT_URI; String[] projection
	 * = null; String selection =null; String[] selectionArgs =null; String
	 * sortOrder = null;ContentResolver cr = getContentResolver(); Cursor cursor
	 * =cr.query(uri, projection, selection, selectionArgs, sortOrder);
	 * 
	 * if(cursor.getCount() > 0) { for(int i =0 ;i<cursor.getColumnCount();i++)
	 * { String str = cursor.getColumnName(i) ; if(str==null) { str="null" ; }
	 * Log.i("hi",Integer.toString(i)+" "+str); }
	 * 
	 * } else Log.i("hi"," empty");
	 */

	public Loader<Cursor> onCreateLoader(int ID, Bundle args) {

		Log.d("hi", "onCreateLoader...");
		switch (ID) {
		case URL_LOADER:
			return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI, null, null, null,
					null);
		default:
			return null;
		}
	}

	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {

		ListView listView = (ListView) findViewById(R.id.lv1);
		// CustomAdapter adapter = new
		// CustomAdapter(getBaseContext(),R.layout.contact_cp,null,null,null,0);
		CustomAdapter adapter = new CustomAdapter(null, arg1);
		listview.setAdapter(adapter);
	}

	public void onLoaderReset(Loader<Cursor> arg0) {

	}
}
