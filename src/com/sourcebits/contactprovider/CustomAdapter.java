package com.sourcebits.contactprovider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomAdapter extends CursorAdapter {

	public CustomAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	private static Context context;
	private int layout_id;
	private Cursor c;
	private String[] fields;
	private String[] columns;
	private int flags;

	@SuppressLint("NewApi")


	/*public CustomAdapter(Context context, int layout_id ,Cursor c,String[] columns,String[] fields, int flags)
	{
		this.context=context;
		this.layout_id=layout_id;
		this.c=c;
		this.fields=fields;
		this.columns=columns;
		this.flags=flags;
	}*/

	
	public View newView(Context context, Cursor cursor, ViewGroup parent) {

		return LayoutInflater.from(context).inflate(R.layout.contact_cp, parent, false);
	}

	public void bindView(View view, Context context, Cursor cursor) {

		TextView nametv = (TextView) view.findViewById(R.id.name);
		TextView numbertv = (TextView) view.findViewById(R.id.number);
		String contactname = cursor.getString(cursor.getColumnIndexOrThrow("ContactsContract.Contacts.DISPLAY_NAME"));
		String contactnumber = cursor
				.getString(cursor.getColumnIndexOrThrow("ContactsContract.CommonDataKinds.Phone.NUMBER"));

		// Populate fields with extracted properties
		nametv.setText(contactname);
		numbertv.setText(String.valueOf(contactnumber));

	}
}
