package com.example.recyclerview.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;

//STEP 3: CREATE A VIEWHOLDER CLASS (does not ne
class EmailViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTv;
    private TextView subjectTv;
    private TextView bodyTv;
    private ImageView emailIcon;

    public EmailViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTv = itemView.findViewById(R.id.name_tv);
        subjectTv = itemView.findViewById(R.id.subject_tv);
        bodyTv = itemView.findViewById(R.id.body_tv);
        emailIcon = itemView.findViewById(R.id.email_icon);
    }

    public void bindItems(String name, String subject, String body, String imageUrl, Context context) {
        nameTv.setText(name);
        subjectTv.setText(subject);
        bodyTv.setText(body);

        //now we want to set our image view to the image url we get?
        //..how do?
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(emailIcon);
    }
}
