package com.example.instagram;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.instagram.home.adapter;

public class user_adapter extends ArrayAdapter<user> {

    Context context;
    int resource;

    public user_adapter(@NonNull Context context, int resource, @NonNull ArrayList<user> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView textView =convertView.findViewById(R.id.name);
        ImageView post_image = convertView.findViewById(R.id.post);
        CircleImageView circleImageView = convertView.findViewById(R.id.profile_image);
        final ImageView love = convertView.findViewById(R.id.like);
        ImageView comment = convertView.findViewById(R.id.comment);
        final ImageView star = convertView.findViewById(R.id.stars);
         ImageView delt = convertView.findViewById(R.id.delete);
        ImageView share = convertView.findViewById(R.id.share);

        final user currentUser = (user) getItem(position);

        textView.setText(currentUser.getName());
        post_image.setImageResource(currentUser.getPost_image());
        circleImageView.setImageResource(currentUser.getProfile());
        love.setImageResource( currentUser.isLove() ? R.drawable.favorite1 : R.drawable.favorite);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentUser.setLove( !currentUser.isLove());
                love.setImageResource( currentUser.isLove() ? R.drawable.favorite1 : R.drawable.favorite);

            }
        });

        star.setImageResource(currentUser.isRate() ? R.drawable.star : R.drawable.star1);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(user_adapter.this.context);
                View mView =LayoutInflater.from(context).inflate(R.layout.rate,null);
                final RatingBar Rating =mView.findViewById(R.id.starDialog);
                final TextView result =mView.findViewById(R.id.rate3);
                Rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                        result.setText(String.valueOf(v));
                        switch ((int) ratingBar.getRating()) {
                            case 1:
                                result.setText("Very bad");
                                break;
                            case 2:
                                result.setText("Need some improvement");
                                break;
                            case 3:
                                result.setText("Good");
                                break;
                            case 4:
                                result.setText("Great");
                                break;
                            case 5:
                                result.setText("Awesome. I love it");
                                break;
                            default:
                                result.setText("");
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

                currentUser.setRate((!currentUser.isRate()));
                star.setImageResource(currentUser.isRate()? R.drawable.star : R.drawable.star1);
            }
        });

        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.values.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}

