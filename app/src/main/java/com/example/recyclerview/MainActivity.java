package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.Adapters.EmailAdapter;
import com.example.recyclerview.model.Email;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //STEP 5: Declare and initialize your recyclerview
    private RecyclerView mEmailRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STEP 5 (CONTINUED)
        mEmailRv = findViewById(R.id.email_rv);

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

        //STEP 6: Initialize our adapter and set it to our recyclerview
        EmailAdapter myAdapter = new EmailAdapter(emailList);
        mEmailRv.setAdapter(myAdapter);

        //STEP 7: Set a linear layout manager to our recyclerview
        mEmailRv.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        RecyclerView.VERTICAL,
                        false
                )
        );
    }
}