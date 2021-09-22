package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STEP 0: HAVE SOME DATA TO BE DISPLAYED TO A RECYCLERVIEW
        //Let's create a list of emails that we later want to display onto our
        //recyclerview
        List<Email> emailList = new ArrayList<Email>();
        for (int i=0; i<100; i++) {
            Email currentEmail = new Email(
                    "name " + i,
                    "subject " + i + "i",
                    "body " + i,
                    "https://purepng.com/public/uploads/large/purepng.com-mail-iconsymbolsiconsapple-iosiosios-8-iconsios-8-721522596075clftr.png"
            );

            emailList.add(currentEmail);
        }
    }
}