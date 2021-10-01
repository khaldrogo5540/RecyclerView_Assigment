package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.model.Email;

public class SecondActivity extends AppCompatActivity {
//    public static String SELECTED_EMAIL_NAME = "SELECTED_EMAIL_NAME";
//    public static String SELECTED_EMAIL_BODY = "SELECTED_EMAIL_BODY";
//    public static String SELECTED_EMAIL_SUBJECT = "SELECTED_EMAIL_SUBJECT";
//    public static String SELECTED_EMAIL_URL = "SELECTED_EMAIL_URL";
    public static String SELECTED_EMAIL_POSITION = "SELECTED_EMAIL_POSITION";
    public static String SELECTED_EMAIL_OBJECT = "SELECTED_EMAIL_OBJECT";
    public static final String EXTRA_REPLY = "com.example.android.secondactivity.extra.REPLY";


    private Email mEmail;
    private int mPosition;
    private TextView mName;
    private ImageView mImage;
    private TextView mSubject;
    private TextView mBody;
    private EditText mUpdateName;
    private EditText mUpdateSubject;
    private EditText mUpdateBody;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mImage = findViewById(R.id.email_image);
        mName = findViewById(R.id.name_t);
        mSubject = findViewById(R.id.subject_t);
        mBody = findViewById(R.id.body_t);
        mUpdateName = findViewById(R.id.Edit_name);
        mUpdateSubject= findViewById(R.id.Edit_subject);
        mUpdateBody = findViewById(R.id.Edit_body);

        Intent intent = getIntent();
        if (intent != null) {
            mEmail = intent.getParcelableExtra(SELECTED_EMAIL_OBJECT);
            mPosition = intent.getIntExtra(SELECTED_EMAIL_POSITION, 0);

//            String emailName = intent.getStringExtra(SELECTED_EMAIL_NAME);
//            String emailBody = intent.getStringExtra(SELECTED_EMAIL_BODY);
//            String emailSubject = intent.getStringExtra(SELECTED_EMAIL_SUBJECT);
//            String emailUrl = intent.getStringExtra(SELECTED_EMAIL_URL);

            mName.setText(mEmail.getName());
            mSubject.setText(mEmail.getSubject());
            mBody.setText(mEmail.getBody());
            Glide.with(this)
                    .load(mEmail.getImageUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mImage);
        }
    }

    public void updateInfo(View view) {
        String replyName = mUpdateName.getText().toString();
        String replySubject = mUpdateSubject.getText().toString();
        String replyBody = mUpdateBody.getText().toString();

        mEmail.setName(replyName);
        mEmail.setSubject(replySubject);
        mEmail.setBody(replyBody);

        Intent replyIntent= new Intent();
        replyIntent.putExtra(SELECTED_EMAIL_OBJECT, mEmail);
        replyIntent.putExtra(SELECTED_EMAIL_POSITION, mPosition);

        setResult(RESULT_OK, replyIntent);
        finish();

    }
}