package com.zubair.contacts_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.ContactViewHolder> {

    private ArrayList<String> cName = new ArrayList<>();
    private ArrayList<String> cImage = new ArrayList<>();
    private Context cContext;

    public Contact_Adapter(Context cContext, ArrayList<String> cName, ArrayList<String> cImage ) {
        this.cName = cName;
        this.cImage = cImage;
        this.cContext = cContext;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favourite_contacts,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Glide.with(cContext)
                .asBitmap()
                .load(cImage.get(position))
                .into(holder.image);
        holder.name.setText(cName.get(position));
    }

    @Override
    public int getItemCount() {
        return cName.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        static ImageView horizontal_cross_button;

        public ContactViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.horizontal_imge);
            name = itemView.findViewById(R.id.horizontal_name);
            horizontal_cross_button = itemView.findViewById(R.id.horizontal_cross_image);

        }

        public static void setVisibility(int visibility){
            Log.d("Message ","Zubair");
            if(visibility == 1){

                horizontal_cross_button.setVisibility(View.VISIBLE);
            }else {
                horizontal_cross_button.setVisibility(View.INVISIBLE);
            }
        }
    }
}
