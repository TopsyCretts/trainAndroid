package com.example.trainandroid;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class KissCatFrag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kiss_cat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button start, loop;
        start = view.findViewById(R.id.start_mrr);
        loop = view.findViewById(R.id.lopp_murr);
        MediaPlayer mrrrSound = MediaPlayer.create(getContext(),R.raw.mrrr);
        MediaPlayer murSound = MediaPlayer.create(getContext(), R.raw.urr);
        GifImageView gif = view.findViewById(R.id.murr_cat);
        GifDrawable drawable = (GifDrawable) gif.getDrawable();
        drawable.pause();

        start.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = false;
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    murSound.pause();
                    murSound.seekTo(0);
                    murSound.start();
                    isPlaying = false;
                } else {
                    murSound.setVolume(1f,1f);
                    murSound.setLooping(false);
                    mrrrSound.seekTo(1);
                    murSound.start();
                    isPlaying = true;
                }
            }
        });
        loop.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = false;
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    mrrrSound.pause();
                    loop.setText("Гладить милашку");
                    isPlaying = false;
                    drawable.pause();
                } else {
                    mrrrSound.setVolume(1f,1f);
                    mrrrSound.setLooping(true);
                    mrrrSound.seekTo(1000);
                    mrrrSound.start();
                    loop.setText("Перестать гладить");
                    isPlaying=true;
                    drawable.start();
                }

            }
        });

    }
}