package com.zubair.contacts_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class contact_detail_adapter extends RecyclerView.Adapter<contact_detail_adapter.ContactDetailViewHolder> {

    private ArrayList<String> cName = new ArrayList<>();
    private ArrayList<String> cImage = new ArrayList<>();
    private ArrayList<String> btnVoice = new ArrayList<>();
    private ArrayList<String> btnVideo = new ArrayList<>();

    private Context cContext;

    public contact_detail_adapter( Context cContext, ArrayList<String> cName, ArrayList<String> cImage, ArrayList<String> btnVoice, ArrayList<String> btnVideo ) {
        this.cName = cName;
        this.cImage = cImage;
        this.cContext = cContext;
        this.btnVoice = btnVoice;
        this.btnVideo = btnVideo;
    }

    @NonNull
    @Override
    public ContactDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contact_detail,parent,false);
        return new ContactDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactDetailViewHolder holder, int position) {

        Glide.with(cContext)
                .load(cImage.get(position))
                .placeholder(R.drawable.pakistan)
                .into(holder.image);
        holder.name.setText(cName.get(position));
    }

    @Override
    public int getItemCount() {
        return cName.size();
    }

    public class ContactDetailViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        ImageButton btnVoiceCall;
        ImageButton btnVideoCall;
        public ContactDetailViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.txtName);
            btnVoiceCall = itemView.findViewById(R.id.btnVoiceCall);
            btnVideoCall = itemView.findViewById(R.id.btnVideoCall);
        }
    }
}
