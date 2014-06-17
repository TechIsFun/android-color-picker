android-color-picker
====================

A simple color picker library for Android

## Usage

### Instantiate with default colors

```java
ColorPickerFragment colorPickerFragment = ColorPickerFragment.getInstance();
colorPickerFragment.show(getSupportFragmentManager(), "ColorPicker");
```

### Instantiate with custom colors

```java
String[] colors = new String[]{"#FFFFFF", "#FF0000", "#00FF00", "#000000"};
ColorPickerFragment colorPickerFragment = ColorPickerFragment.getInstance(colors);
colorPickerFragment.show(getSupportFragmentManager(), "ColorPicker");
```
