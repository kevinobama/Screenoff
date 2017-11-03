package com.example.kevingates.screenoff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLoadData = (Button)findViewById(R.id.scrrenoffbutton);

        buttonLoadData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //editText
                turnOffScreen();

                /**
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.flags |= LayoutParams.FLAG_KEEP_SCREEN_ON;
                params.screenBrightness = 0;
                getWindow().setAttributes(params);
                **/
                //Window window;
                //WindowsUtils::lockScreenDim();
                //Window window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        });
    }

    public void turnOffScreen(){
        int numberOne = 100;
        int numberTwo = 300;
        int numberThree = numberOne + numberTwo;

        WindowsUtils WindowsUtils1 = new WindowsUtils();

        TextView textview1 = (TextView)findViewById(R.id.textview1);
        textview1.setText("sum="+WindowsUtils1.addWord("obama"), TextView.BufferType.EDITABLE);
    }
}
