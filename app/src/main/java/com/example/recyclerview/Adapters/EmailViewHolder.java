package com.example.recyclerview.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.util.EmailClickListener;

//STEP 3: CREATE A VIEWHOLDER CLASS
//STEP 2 FOR ALLOWING YOUR ITEMS TO BE CLICKED: implement a View.OnClickListener
class EmailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    //STEP 2A FOR ALLOWING YOUR ITEMS TO BE CLICKED:
    //declare and initialize your emailclick listener in your viewholder
    private TextView nameTv;
    private TextView subjectTv;
    private TextView bodyTv;
    private ImageView emailIcon;
    private EmailClickListener mListener;

    public EmailViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTv = itemView.findViewById(R.id.name_tv);
        subjectTv = itemView.findViewById(R.id.subject_tv);
        bodyTv = itemView.findViewById(R.id.body_tv);
        emailIcon = itemView.findViewById(R.id.email_icon);

    }

    //STEP 2B FOR ALLOWING YOUR ITEMS TO BE CLICKED:
    //create a setter for your item click listener
    public void setListener(EmailClickListener listener) {
        this.mListener = listener;
        //dont forget to set your item view to the onClickListner
        itemView.setOnClickListener(this);
    }

    public void bindItems(String name,
                          String subject,
                          String body,
                          String imageUrl,
                          Context context
    ) {
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

    //STEP 2C FOR ALLOWING YOUR ITEMS TO BE CLICKED:
    //override the onClick method
    @Override
    public void onClick(View v) {
        mListener.onEmailClicked(v, getAdapterPosition());
    }
}
