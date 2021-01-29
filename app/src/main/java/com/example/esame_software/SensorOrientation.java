package com.example.esame_software;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class SensorOrientation extends AppCompatActivity {
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_orientation);
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearOrientation);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mList = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        for (int count = 1; count <= mList.size(); count++) {
            LinearLayout ll = new LinearLayout(this);
            final Button btn = new Button(this);
            btn.setId(count);
            btn.setText("Sensor number " + count);
            btn.setLayoutParams(params);
            ll.addView(btn);
            lm.addView(ll);
        }
    }
}