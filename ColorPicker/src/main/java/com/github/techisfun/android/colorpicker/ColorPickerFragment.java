package com.github.techisfun.android.colorpicker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * Created by Andrea Maglie on 12/26/13.
 */
public class ColorPickerFragment extends DialogFragment {

    private static final String COLOR_ARRAY_BUNDLE_KEY = "colorpicker-colorArray";

    private static final String TAG = ColorPickerFragment.class.getSimpleName();

    private List<String> colorArray;

    private ColorPickerListener listener;

    public static ColorPickerFragment getInstance(String[] colors) {
        ColorPickerFragment arrayColorPickerFragment = new ColorPickerFragment();

        Bundle args = new Bundle();
        args.putStringArray(COLOR_ARRAY_BUNDLE_KEY, colors);

        arrayColorPickerFragment.setArguments(args);
        return arrayColorPickerFragment;
    }

    public static ColorPickerFragment getInstance() {
        return new ColorPickerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initColorList();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ColorPickerListener) {
            listener = (ColorPickerListener) activity;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        ColorPickerAdapter adapter = new ColorPickerAdapter(
                getActivity(), R.layout.color_picker_item, colorArray);

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.color_picker_layout,
                null);
        builder.setView(view);

        GridView gridView = (GridView) view
                .findViewById(R.id.array_color_picker_gridview);
        gridView.setAdapter(adapter);

        if (listener != null) {
            gridView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    String color = (String) parent.getItemAtPosition(position);
                    listener.onColorSelected(color);
                }
            });
        }

        return builder.create();
    }

    public List<String> getDefaultColors() {

        List<String> colors = Arrays.asList("#DC143C", "#CD5C5C", "#FF1493",
                "#C71585", "#FFD700", "#FF8C00", "#6A5ACD", "#3CB371",
                "#006400", "#20B2AA", "#1E90FF", "#DCDCDC", "#C0C0C0",
                "#778899", "#000000", "#FFFFFF");

        Collections.sort(colors);

        return colors;
    }

    private void initColorList() {
        try {
            colorArray = getArguments().getStringArrayList(
                    COLOR_ARRAY_BUNDLE_KEY);
        } catch (Exception e) {
            Log.d(TAG, "ignored", e);
        }

        if (colorArray == null) {
            colorArray = getDefaultColors();
        }
    }

    @SuppressWarnings("unused")
    private String asHex(int red, int green, int blue) {
        return String.format("#%02x%02x%02x", red, green, blue);
    }
}
