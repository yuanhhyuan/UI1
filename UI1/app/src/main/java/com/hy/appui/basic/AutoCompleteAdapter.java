package com.hy.appui.basic;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * @version V1.0
 * @Package com.ui.basic
 * @Description: ${todo}
 * @author: huangyuan
 * @date: 2017/11/20 16:50
 * @Copyright: www.***.com Inc. All rights reserved.
 */
public class AutoCompleteAdapter extends CursorAdapter {
    public AutoCompleteAdapter(Context context) {
        super(context, null, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        TextView view = (TextView) inflater.inflate(
                android.R.layout.simple_dropdown_item_1line, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view).setText(cursor.getString(cursor.getColumnIndex(DbHelper.COL_SCHOOL_NAME)));
    }
}
