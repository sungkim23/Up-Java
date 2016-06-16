package com.uptech.up;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.text.Text;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;


public class StatisticsActivity extends AppCompatActivity {

    private TextView textView13, textView12, textView14, textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        textView13 = (TextView)findViewById(R.id.textView13);
        textView12 = (TextView)findViewById(R.id.textView12);
        textView11 = (TextView)findViewById(R.id.textView11);
        textView14 = (TextView)findViewById(R.id.textView14);

        new HttpAsyncTask().execute("http://demo-jdluna.rhcloud.com/api/identificador/0000045");
    }

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "0";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if(result != null || !(result.compareTo("0")==0)){
                Log.d("RESULT", result);
                try {
                    JSONObject json = new JSONObject(result);
                    Log.d("UNO", json.get("indicadorMetano").toString());
                    textView11.setText(json.get("indicadorCo2").toString());
                    textView12.setText(json.get("indicadorHumedad").toString());
                    textView13.setText(json.get("indicadorMetano").toString());
                    textView14.setText(json.get("indicadorAmoniaco").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
