package com.majidmokhtari.hangman.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
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
import com.majidmokhtari.hangman.ui.model.Answer;
import com.majidmokhtari.hangman.ui.model.CustomGridAdapter;
import com.majidmokhtari.hangman.ui.model.Game;

public class HangmanActivity extends AppCompatActivity {

    private TextView mAnswerTxtView;
    private String mCategoryName;
    private Game mGame;
    private Answer mAnswer;
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

        mAnswer = new Answer(mCategoryName);
        mGame = new Game(mAnswer.getWord());

        mAnswerTxtView.setText(mGame.getCurrentProgress());

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

        mSearchWordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // missing 'http://' will cause crashed
                Uri uri = Uri.parse("https://www.google.com/?gws_rd=ssl#q=" + mAnswer.getWord());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void itemClicked(int position, Button button) {
        Boolean isHit = mGame.applyGuess(items[position].charAt(0));
        if(isHit){
            mAnswerTxtView.setText(mGame.getCurrentProgress());
            if (mGame.getCurrentProgress().indexOf("_") < 0){
                finishGame();
            }
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
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    break;
                case 2:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    break;
                case 3:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    break;
                case 4:
                    canvas.drawRect(80, 40, 100, 450, paint);
                    canvas.drawLine(50, 450, 130, 450, stroke);
                    canvas.drawRect(60, 40, 320, 60, paint);
                    canvas.drawLine(90, 110, 130, 60, stroke);
                    canvas.drawRect(280, 40, 300, 100, paint);
                    canvas.drawCircle(290, 146, 50, stroke);
                    canvas.drawRect(285, 198, 295, 350, paint);
                    canvas.drawLine(290, 200, 340, 250, stroke);
                    break;
                case 5:
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
                case 6:
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
                    canvas.drawLine(290, 345, 340, 400, stroke);
                    canvas.drawLine(290, 345, 240, 400, stroke);
                    break;
            }
            LinearLayout ll = (LinearLayout) findViewById(R.id.drawHangman);
            ll.setBackgroundDrawable(new BitmapDrawable(bg));

            if (counter >= 7){
                finishGame();
            }
        }
    }

    public void finishGame(){
        gridView.setVisibility(View.GONE);
        mAnswerTxtView.setText(mAnswer.getWord());
        //mAnswerTxtView.setPadding(0, 500, 0, 100);
        //mAnswerTxtView.setHeight(1200);
        animateBtn(mPlayAgainBtn);
        animateBtn(mSearchWordBtn);
    }

    public void animateBtn(Button button){
        button.setVisibility(View.VISIBLE);
        button.setScaleX(0);
        button.setScaleY(0);
        button.animate().scaleX(1).scaleY(1).start();
    }

}
