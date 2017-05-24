package com.example.ashwin.assetsresponserender;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String tempString;
    private Persons persons;
    private ArrayList<Person> personsArrayList;
    private TextView mOutputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        getPersons();

        String output = "";

        if (persons != null) {
            personsArrayList = new ArrayList<>();
            personsArrayList = persons.getPersons();

            for (Person p : personsArrayList) {
                output += p.getName() + " (" + p.getAge() + ") : \t" + p.getCity() + ", " + p.getCountry() + "\n\n";
            }
        } else {
            output = "Null";
        }

        mOutputTextView.setText(output);
    }

    private void initViews() {
        mOutputTextView = (TextView) findViewById(R.id.outputTextView);
    }

    private void getPersons() {
        AssetManager assetManager = getResources().getAssets();
        try {
            StringBuilder buf = new StringBuilder();
            InputStream json = assetManager.open("example1.json");
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();

            String response = buf.toString();

            tempString = response;

            Log.d("debuglogging", "MainActivity : string : " + tempString);

            Gson gson = new Gson();
            persons = gson.fromJson(response, Persons.class);

        } catch (Exception e) {
            Log.e("debuglogging", "MainActivity : Error while getting bundle" + e.toString());
        }
    }

}
