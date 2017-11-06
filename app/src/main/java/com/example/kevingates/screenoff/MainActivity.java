package com.example.kevingates.screenoff;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLoadData = (Button)findViewById(R.id.scrrenoffbutton);

//        buttonLoadData.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //editText
//                //turnOffScreen();
//                //new GetClass(this).execute();
//            }
//        });
    }

    public void sendGetRequest(View View) {
        new GetClass(this).execute();
    }

    private class GetClass extends AsyncTask<String, Void, Void> {

        private final Context context;

        public GetClass(Context c){
            this.context = c;
        }

        @Override
        protected Void doInBackground(String... params) {
            try {

                final TextView outputView = (TextView) findViewById(R.id.textview1);
                URL url = new URL("https://robotrader.ai/api/front/v1/market/prices/crypto?base_currency=CNY");

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                String urlParameters = "fizz=buzz";
                connection.setRequestMethod("GET");
                connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");

                int responseCode = connection.getResponseCode();

                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);

                final StringBuilder output = new StringBuilder("Request URL " + url);
                //output.append(System.getProperty("line.separator") + "Request Parameters " + urlParameters);
                output.append(System.getProperty("line.separator")  + "Response Code " + responseCode);
                output.append(System.getProperty("line.separator")  + "Type " + "GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                StringBuilder responseOutput = new StringBuilder();

                System.out.println("output===============" + br);
                while((line = br.readLine()) != null ) {
                    responseOutput.append(line);
                }
                br.close();

                output.append(System.getProperty("line.separator") + "Response " + System.getProperty("line.separator") + System.getProperty("line.separator") + responseOutput.toString());

                System.out.println("data : " + responseOutput.toString());


                //textview1.setText(output, TextView.BufferType.EDITABLE);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textview1 = (TextView)findViewById(R.id.textview1);
                        textview1.setText(output);
                    }
                });


            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

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


