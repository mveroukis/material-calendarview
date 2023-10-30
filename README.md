<img src="/images/hero.png"/>

# Material Calendar View
A Material design back port of Android's CalendarView migrated to Androidx libraries. The goal is to have a Material look
and feel, rather than 100% parity with the platform's implementation.

<img src="/images/screencast.gif" alt="Demo Screen Capture" width="300px" />

## Installation

Step 1. Add the JitPack repository to your build file

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```groovy
dependencies {
  implementation 'com.github.mveroukis:material-calendarview:1.2.0'
}
```

## Usage

1. Add `MaterialCalendarView` into your layouts or view hierarchy.
2. Set a `OnDateSelectedListener` or call `MaterialCalendarView.getSelectedDates()` when you need it.

[Javadoc Available Here](http://prolificinteractive.github.io/material-calendarview/)

Example:

```xml
<com.neoex.materialcalendarview.MaterialCalendarView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/calendarView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:mcv_showOtherDates="all"
    app:mcv_selectionColor="#00F"
    />
```


## Documentation

Make sure to check all the documentation available [here](https://github.com/thiago-you/material-calendarview/wiki).

## Customization

One of the aims of this library is to be customizable. The many options include:

* [Define the view's width and height in terms of tile size](https://github.com/thiago-you/material-calendarview/wiki/Customization#tile-size)
* [Single or Multiple date selection, or disabling selection entirely](https://github.com/thiago-you/material-calendarview/wiki/Customization#date-selection)
* [Showing dates from other months or those out of range](https://github.com/thiago-you/material-calendarview/wiki/Customization#showing-other-dates)
* [Setting the first day of the week](https://github.com/thiago-you/material-calendarview/wiki/Customization-Builder#first-day-of-the-week)
* [Show only a range of dates](https://github.com/thiago-you/material-calendarview/wiki/Customization-Builder#date-ranges)
* [Customize the top bar](https://github.com/thiago-you/material-calendarview/wiki/Customization#topbar-options)
* [Custom labels for the header, weekdays, or individual days](https://github.com/thiago-you/material-calendarview/wiki/Customization#custom-labels)


### Events, Highlighting, Custom Selectors, and More!

All of this and more can be done via the decorator api. Please check out the [decorator documentation](https://github.com/thiago-you/material-calendarview/wiki/Decorators).

# Contributing

Would you like to contribute? Fork us and send a pull request! Be sure to checkout our issues first.
