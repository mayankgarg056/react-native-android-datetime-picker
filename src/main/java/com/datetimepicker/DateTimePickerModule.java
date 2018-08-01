package com.datetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.*;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;


import java.util.Calendar;

/**
 * Created by mayank on 29/06/18.
 */
//String selectedDate,int minYear,int maxYear
public class DateTimePickerModule extends ReactContextBaseJavaModule {
    Context context;
    DatePickerPopWin pickerPopWin;
    TimePickerPopWin timePickerPopWin;
    public DateTimePickerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }


    @Override
    public String getName() {
        return "DateTimePickerModule";
    }

    @ReactMethod
    public void openDatePicker(ReadableMap readableMap, final Promise promise) {
                 pickerPopWin = new DatePickerPopWin.Builder(context, new DatePickerPopWin.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        WritableMap map= Arguments.createMap();
                        map.putInt("year",year);
                        map.putInt("month",month);
                        map.putInt("day",day);
                        map.putString("date",dateDesc);
                        promise.resolve(map);
                        //Toast.makeText(context, dateDesc, Toast.LENGTH_SHORT).show();
                    }
                }).maxYear(readableMap.getInt("maxYear")+1)
                         .minYear(readableMap.getInt("minYear"))
                         .dateChose(readableMap.getString("selectDate"))
                         .build();
                pickerPopWin.showPopWin(getCurrentActivity());

                modifyDatePicker(readableMap);
    }


    @ReactMethod
    public void openTimePicker(ReadableMap readableMap,final Promise promise ) {
         timePickerPopWin = new TimePickerPopWin.Builder(context, new TimePickerPopWin.OnTimePickListener() {
            @Override
            public void onTimePickCompleted(int hour, int minute, String AM_PM, String time) {
                WritableMap map= Arguments.createMap();
                map.putInt("hour",hour);
                map.putInt("minute",minute);
                map.putString("AM_PM",AM_PM);
                map.putString("time",time);
                promise.resolve(map);
                //Toast.makeText(context, time, Toast.LENGTH_SHORT).show();
            }
        }).build();
        timePickerPopWin.showPopWin(getCurrentActivity());
        modifyTimePicker(readableMap);
    }

    private void modifyDatePicker(ReadableMap map) {
        // for change the confirm button text string
        if (map.hasKey("textConfirm")) {
            pickerPopWin.confirmBtn.setText(map.getString("textConfirm"));
        }
        // for change the cancel button text string
        if(map.hasKey("textCancel")){
            pickerPopWin.cancelBtn.setText(map.getString("textCancel"));
        }
        // for change the button text size
        if(map.hasKey("btnTextSize") ){
            pickerPopWin.confirmBtn.setTextSize(map.getInt("btnTextSize"));
            pickerPopWin.cancelBtn.setTextSize(map.getInt("btnTextSize"));
        }
        // change the cancel button text color
        if(map.hasKey("colorCancel")){
            pickerPopWin.cancelBtn.setTextColor(Color.parseColor(map.getString("colorCancel")));
        }
        // change the confirm button text color
        if(map.hasKey("colorConfirm")){
            pickerPopWin.confirmBtn.setTextColor(Color.parseColor(map.getString("colorConfirm")));
        }
    }

    private void modifyTimePicker(ReadableMap map) {
        // for change the confirm button text string
        if (map.hasKey("textConfirm")) {
            timePickerPopWin.confirmBtn.setText(map.getString("textConfirm"));
        }
        // for change the cancel button text string
        if(map.hasKey("textCancel")){
            timePickerPopWin.cancelBtn.setText(map.getString("textCancel"));
        }
        // for change the button text size
        if(map.hasKey("btnTextSize") ){
            timePickerPopWin.confirmBtn.setTextSize(map.getInt("btnTextSize"));
            timePickerPopWin.cancelBtn.setTextSize(map.getInt("btnTextSize"));
        }
        // change the cancel button text color
        if(map.hasKey("colorCancel")){
            timePickerPopWin.cancelBtn.setTextColor(Color.parseColor(map.getString("colorCancel")));
        }
        // change the confirm button text color
        if(map.hasKey("colorConfirm")){
            timePickerPopWin.confirmBtn.setTextColor(Color.parseColor(map.getString("colorConfirm")));
        }
    }


}
