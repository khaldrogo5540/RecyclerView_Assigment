package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//STEP 3: CREATE AN ADAPTER CLASS by extending the RecyclerView.Adapter class
//(BTW, YOU WILL NEED TO PASS IN YOUR Generic Viewholder class to this recyclerview adapter
public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewholder> {
    private List<Email> emailList;
    private Context context;

    //STEP 3B: Create a public constructor (and probably some setters) that takes in your
    //data as a list of items
    public EmailAdapter(List<Email> emails) {
        emailList = emails;
    }

    @NonNull
    @Override
    public EmailViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        //this layout inflater will be used to create our view, which will be used for creating
        //our Viewholder
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //we specify which layout we want to inflate here
        View myView = layoutInflater.inflate(R.layout.email_item, parent, false);
        return new EmailViewholder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //STEP 4: CREATE A VIEWHOLDER CLASS (does not ne
    public class EmailViewholder extends RecyclerView.ViewHolder {

        public EmailViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
