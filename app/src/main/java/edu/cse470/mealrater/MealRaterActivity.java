package edu.cse470.mealrater;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.Format;

public class MealRaterActivity extends AppCompatActivity implements RateDialog.SaveRatingBarListener {

    //private static final String TAG = "MealRaterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRateMealButton();
    }

    private void initRateMealButton() {
        // once this button is clicked the rating bar will appear.
        Button buttonRate = findViewById(R.id.rateButton);
        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                RateDialog rating = new RateDialog();
                rating.show(fm, "Rate Meal");

            }
        });
    }

    @Override
    public void didFinishRatingBarDialog(RatingBar rateTime) {
        // displays the rating the user gave the dish.
        TextView ratingText = findViewById(R.id.displayRatingtextview);
        ratingText.setText(String.valueOf(rateTime.getRating()));
    }
}