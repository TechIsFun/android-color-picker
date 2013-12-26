package com.github.techisfun.android.colorpicker;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Andrea Maglie on 12/26/13.
 */
public class ColorPickerAdapter extends ArrayAdapter<String> {

    private static final String TAG = ColorPickerAdapter.class
            .getSimpleName();

    public ColorPickerAdapter(Context context, int textViewResourceId,
                                   List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView view = (TextView) super.getView(position, convertView, parent);

        String colorAsString = getItem(position);
        try {
            int colorAsInt = Color.parseColor(colorAsString);
            view.setText("");
            view.setBackgroundColor(colorAsInt);
            view.setTag(colorAsString);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "parse color exception", e);
            view.setVisibility(View.GONE);
        }

        return view;
    }
}
