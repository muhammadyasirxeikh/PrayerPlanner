package com.prayerplanner.com.ui.fragment;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.colorgreen.swiper.OnSwipeTouchListener;
import com.colorgreen.swiper.SwipeAction;
import com.prayerplanner.com.R;
import com.prayerplanner.com.databinding.FragmentPrayerDetailBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class PrayerDetail extends Fragment {

  private FragmentPrayerDetailBinding binding;
  String prayer_name,short_info,prayer_description;
  int prayer_image,prayer_image_icon;
  int audio,length=0;

    MediaPlayer mp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPrayerDetailBinding.inflate(getLayoutInflater(),container,false);

        setSharedElementEnterTransition(TransitionInflater.from(getContext())
                .inflateTransition(android.R.transition.move));

        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        final SpringAnimation springAnim = new SpringAnimation(binding.prayerImage, DynamicAnimation.TRANSLATION_Y, 0);
//        final SpringAnimation anim1Y = new SpringAnimation(view,
//                DynamicAnimation.TRANSLATION_Y);
//        final SpringAnimation anim2Y = new SpringAnimation(view,
//                DynamicAnimation.TRANSLATION_Y);
//
//        anim1Y.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float value,
//                                          float velocity) {
//                anim2Y.animateToFinalPosition(value);
//            }
//        });
//        springAnim.start();

        prayer_name=getArguments().getString("prayer_name");
        prayer_description=getArguments().getString("prayer_description");
        short_info=getArguments().getString("short_info");
        prayer_image=getArguments().getInt("prayer_image");
        prayer_image_icon=getArguments().getInt("image_icon");
        audio=getArguments().getInt("audio");


        binding.prayerName.setText(prayer_name);
        binding.shortdesc.setText(short_info);
        binding.prayerImage.setImageResource(prayer_image);
        binding.prayerDescription.setText(prayer_description);
        binding.icon.setImageResource(prayer_image_icon);



        mp= MediaPlayer.create(requireContext(), audio);

        float duration=mp.getDuration();
        float t=(duration/1000)/60;
        String s = String.format("%.2f", t);
        binding.time.setText(s+" mins");










        binding.play.setOnClickListener(v->{
            binding.play.setBackgroundResource(R.drawable.play_full_opacity);

            binding.pause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_filled_24);
            if (length==0){
                mp.start();
            }else {
                mp.seekTo(length);
                mp.start();
            }


        });
        binding.mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Animation rotate = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in);
                        binding.prayerImage.startAnimation(rotate);
                        break;

                }
                return true;
            }
        });
        binding.pause.setOnClickListener(v->{
            binding.play.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24);

            binding.pause.setBackgroundResource(R.drawable.pause_ful_opacity);
            mp.pause();
            length=mp.getCurrentPosition();
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    
}