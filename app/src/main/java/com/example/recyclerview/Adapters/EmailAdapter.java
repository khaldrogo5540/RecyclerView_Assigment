package com.example.recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Email;
import com.example.recyclerview.util.EmailClickListener;

import java.util.List;

//STEP 4: CREATE AN ADAPTER CLASS by extending the RecyclerView.Adapter class
//(BTW, YOU WILL NEED TO PASS IN YOUR Generic Viewholder class to this recyclerview adapter
public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder> {
    private List<Email> emailList;
    private Context context;

    //STEP 4B: Create a public constructor (and probably some setters) that takes in your
    //data as a list of items
    public EmailAdapter(List<Email> emails) {
        emailList = emails;
    }

    //what if we wanted to set a new list to our adapter?
    public void setEmailList(List<Email> emails) {
        emailList = emails;
        //let your recyclerview refresh itself once the list has been updated
        notifyDataSetChanged();
    }

    public void setEmail(int position, Email email) {
        emailList.set(position, email);
        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        //this layout inflater will be used to create our view, which will be used for creating
        //our Viewholder
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //we specify which layout we want to inflate here
        View myView = layoutInflater.inflate(R.layout.email_item, parent, false);


//        Can be done in one step, like so:
//        return new EmailViewholder(
//                LayoutInflater.from(context).inflate(R.layout.email_item, parent, false)
//        );

        //STEP 5 FOR ALLOWING YOUR ITEMS TO BE CLICKED
        //we can pass our listener here and set it to our Viewholder
        //but..how do?
        EmailViewHolder emailViewHolder = new EmailViewHolder(myView);
        emailViewHolder.setListener((EmailClickListener) context);
        return emailViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        //this step connects the data that we get from our list item to our elements in
        //the viewholder
        //so...how do?

        Email currentEmail = emailList.get(position);

        /**
        holder.nameTv.setText(currentEmail.getName());
        holder.subjectTv.setText(currentEmail.getSubject());
        holder.bodyTv.setText(currentEmail.getBody());
         */

        holder.bindItems(
                currentEmail.getName(),
                currentEmail.getSubject(),
                currentEmail.getBody(),
                currentEmail.getImageUrl(),
                context
        );
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }
}
