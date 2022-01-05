package com.example.mowater.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mowater.R;
import com.example.mowater.data.models.Video.Videoo;

import java.util.ArrayList;

public class VideoSliderAdapter extends RecyclerView.Adapter<VideoSliderAdapter.VideoSliderViewHolder> {
    ArrayList<Videoo> list = new ArrayList<>();
    Context context;
    ViewPager2 viewPager2;
    String fff;

    public VideoSliderAdapter(ArrayList<Videoo> list, ViewPager2 pager2) {
        this.list = list;
        this.viewPager2 = pager2;
    }

    public class VideoSliderViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;

        public VideoSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vv_item);
        }
    }

    @NonNull
    @Override
    public VideoSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_itme, parent, false);
        VideoSliderViewHolder viewHolder = new VideoSliderViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoSliderViewHolder holder, int position) {
        Videoo videoo = list.get(position);
        holder.videoView.setVideoPath(videoo.getUri());
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.start();
            }
        });
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
