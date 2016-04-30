package com.majidmokhtari.hangman.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.majidmokhtari.hangman.R;

public class MainActivity extends AppCompatActivity {

    private Button mCountriesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountriesBtn = (Button)findViewById(R.id.conurtiesCat);

        mCountriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = mCountriesBtn.getText().toString();
                //Toast.makeText(MainActivity.this, category, Toast.LENGTH_LONG).show();
                startStory(category);
            }
        });
    }

    public void startStory(String category){
        Intent intent = new Intent(this, HangmanActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

}
