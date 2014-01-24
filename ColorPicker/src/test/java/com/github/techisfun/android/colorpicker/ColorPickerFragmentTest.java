package com.github.techisfun.android.colorpicker;

import com.github.techisfun.android.colorpicker.ColorPickerFragment;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
public class ColorPickerFragmentTest {

    private ColorPickerFragment mColorPickerFragment;

    @Before
    public void setUp() {
        mColorPickerFragment = new ColorPickerFragment();
    }

    @Test
    public void getDefaultColors_notEmpty() {
        assertTrue(mColorPickerFragment.getDefaultColors().size() > 0);
    }

    @Test
    public void testFragment() {
        RobolectricGradleTestRunner.startFragment(mColorPickerFragment);
        assertNotNull(mColorPickerFragment);
    }
}