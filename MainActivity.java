package com.example.arslan.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView txt_City, txt_Temperature, txt_Weather, txt_Descript;
    private ImageView image;
    String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_City = (TextView) findViewById(R.id.txt_city);
        txt_Descript = (TextView) findViewById(R.id.txt_descr);
        txt_Temperature = (TextView) findViewById(R.id.txt_temp);
        txt_Weather = (TextView) findViewById(R.id.txt_weather);
        image = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();

        cityName=intent.getStringExtra("sehir");
//        JsonParse jsonParse = new JsonParse();
        new JsonParse().execute();
    }

    protected class JsonParse extends AsyncTask<Void, Void, Void>{
        String result_main ="";
        String result_description = "";
        String result_icon = "";
        int result_temp;
        String result_city;
        Bitmap bitImage;
        @Override
        protected Void doInBackground(Void... params) {
            String result="";
            try {
                URL weather_url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=5519df78a91952f50079565124888a76");

                BufferedReader bufferedReader = null;
                bufferedReader = new BufferedReader(new InputStreamReader(weather_url.openStream()));
                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("weather");
                JSONObject jsonObject_weather = jsonArray.getJSONObject(0);
                result_main = jsonObject_weather.getString("main");
                result_description = jsonObject_weather.getString("description");
                result_icon = jsonObject_weather.getString("icon");

                JSONObject jsonObject_main = jsonObject.getJSONObject("main");
                Double temp = jsonObject_main.getDouble("temp");
                result_city = jsonObject.getString("name");
                result_temp = (int) (temp-273);
                URL icon_url = new URL("http://openweathermap.org/img/w/"+result_icon+".png");
                bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            txt_Temperature.setText(String.valueOf(result_temp));
            txt_Weather.setText(result_main);
            txt_City.setText(result_city);
            txt_Descript.setText(result_description);
            image.setImageBitmap(bitImage);
            super.onPostExecute(aVoid);
        }
    }
}
