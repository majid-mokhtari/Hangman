package com.majidmokhtari.hangman.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.majidmokhtari.hangman.R;
import com.majidmokhtari.hangman.ui.model.CustomGridAdapter;
import com.majidmokhtari.hangman.ui.model.Game;

public class HangmanActivity extends AppCompatActivity {

    private TextView mAnswerTxtView;
    private String mCategoryName;
    private Game mGame;
    private TextView text;
    private GridView gridView;
    private final String[] items = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private CustomGridAdapter mGridAdapter;
    private Button mPlayAgainBtn;
    private Button mSearchWordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        Intent intent = getIntent();
        mCategoryName = intent.getStringExtra("category");
        mAnswerTxtView = (TextView) findViewById(R.id.answer);
        mPlayAgainBtn = (Button) findViewById(R.id.playAgainBtn);
        mSearchWordBtn = (Button) findViewById(R.id.searchWordBtn);

        if (mCategoryName.equals("Countries")){
            mGame = new Game("IRAN");
            mAnswerTxtView.setText(mGame.getCurrentProgress());
        }

        gridView = (GridView) this.findViewById(R.id.btnsGridView);
        mGridAdapter = new CustomGridAdapter(HangmanActivity.this, items);
        gridView.setAdapter(mGridAdapter);

        mPlayAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HangmanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void itemClicked(int position, Button button) {
        Boolean isHit = mGame.applyGuess(items[position].charAt(0));
        if(isHit){
            mAnswerTxtView.setText(mGame.getCurrentProgress());
        }else{
            //Toast.makeText(HangmanActivity.this, "wrong", Toast.LENGTH_LONG).show();
            Integer counter = mGame.getCounter();

            //Filled shape
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#000000"));

            //Empty shape
            Paint stroke = new Paint();
            stroke.setStyle(Paint.Style.STROKE);
            stroke.setStrokeWidth(5);

            Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bg);
            switch (counter) {
                case 1:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    break;
                case 2:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    break;
                case 3:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    break;
                case 4:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    break;
                case 5:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    break;
                case 6:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    canvas.drawLine(290, 200, 340, 250, stroke);
                    break;
                case 7:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    canvas.drawLine(290, 200, 340, 250, stroke);
                    canvas.drawLine(290, 200, 240, 250, stroke);
                    break;
                case 8:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    canvas.drawLine(290, 200, 340, 250, stroke);
                    canvas.drawLine(290, 200, 240, 250, stroke);
                    canvas.drawLine(290, 345, 340, 400, stroke);
                    break;
                case 9:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    canvas.drawLine(290, 200, 340, 250, stroke);
                    canvas.drawLine(290, 200, 240, 250, stroke);
                    canvas.drawLine(290, 345, 340, 400, stroke);
                    canvas.drawLine(290, 345, 240, 400, stroke);
                    break;
            }
            LinearLayout ll = (LinearLayout) findViewById(R.id.drawHangman);
            ll.setBackgroundDrawable(new BitmapDrawable(bg));

            if (counter >= 9){
                gridView.setVisibility(View.GONE);
                mAnswerTxtView.setText("IRAN");
                mAnswerTxtView.setPadding(0, 1000, 0, 100);
                mPlayAgainBtn.setVisibility(View.VISIBLE);
                mPlayAgainBtn.animate().scaleX(0).scaleY(0).start();
                mPlayAgainBtn.animate().scaleX(1).scaleY(1).setDuration(3000).start();
                mSearchWordBtn.setVisibility(View.VISIBLE);
            }

        }
    }

}
