package com.example.rulerseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rulerseekbar.rulerpickerview.RulerValuePickerListener;
import com.example.rulerseekbar.rulerpickerview.VerticalRulerValuePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RulerPickerTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VerticalRulerValuePicker rulerValuePicker = findViewById(R.id.ruler_picker);
        final TextView tvHeight = findViewById(R.id.tv_height);

        rulerValuePicker.setValuePickerListener(new RulerValuePickerListener() {
            @Override
            public void onValueChange(final int selectedValue) {
                //Value changed and the user stopped scrolling the ruler.
                //Application can consider this value as final selected value.
                Log.i(TAG, "OnValueChange: " + selectedValue);
            }

            @Override
            public void onIntermediateValueChange(final int selectedValue) {
                //Value changed but the user is still scrolling the ruler.
                //This value is not final value. Application can utilize this value to display the current selected value.
                Log.i(TAG, "OnIntermediateValueChange: " + selectedValue);
                tvHeight.setText(String.format(Locale.ENGLISH, "Value: %d", selectedValue));
            }
        });
    }
}
