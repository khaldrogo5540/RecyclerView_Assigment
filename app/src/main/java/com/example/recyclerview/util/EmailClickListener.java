package com.example.recyclerview.util;

import android.view.View;

//STEP 1 FOR ALLOWING YOUR ITEMS TO BE CLICKED: create your listener
public interface EmailClickListener {
    void onEmailClicked(View view, int position);
}
