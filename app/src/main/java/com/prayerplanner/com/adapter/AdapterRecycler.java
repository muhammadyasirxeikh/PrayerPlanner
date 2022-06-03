package com.prayerplanner.com.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.prayerplanner.com.R;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.FragmentNavigatorExtrasKt;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.BusinessCategoryVH> {
    private final List<String> prayernames;
    private final List<String> short_info;
    private final List<String> prayer_description;
    private final List<Integer> prayer_image;
    private final List<Integer> prayer_audio;
    private final List<Integer> prayer_image_icon;
    Context mcontext;

    public AdapterRecycler(List<String> name, List<Integer> images, List<Integer> image_icon, List<String> short_info, List<String> short_desc, List<Integer> audio, Context context) {
        this.prayernames = name;
        this.short_info = short_info;
        this.prayer_image=images;
        this.mcontext=context;
        this.prayer_image_icon=image_icon;
        this.prayer_description=short_desc;
        this.prayer_audio=audio;
    }


    @NonNull
    @NotNull
    @Override
    public BusinessCategoryVH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new BusinessCategoryVH(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BusinessCategoryVH holder, int position) {
        Transition changeTransform = TransitionInflater.from(mcontext).
                inflateTransition(R.transition.change_image_transform);
        holder.prayer_name.setText(prayernames.get(position));
        holder.short_info.setText(short_info.get(position));
        holder.imageView.setImageResource(prayer_image.get(position));
        holder.icon_image.setImageResource(prayer_image_icon.get(position));

        holder.imageView.setOnClickListener(v->{
            Bundle bundle=new Bundle();
            bundle.putString("prayer_name",prayernames.get(position));
            bundle.putString("short_info",short_info.get(position));
            bundle.putInt("audio",prayer_audio.get(position));
            bundle.putInt("prayer_image",prayer_image.get(position));
            bundle.putInt("image_icon",prayer_image_icon.get(position));
            bundle.putString("prayer_description",prayer_description.get( position));

            SharedPreferences.Editor editor = mcontext.getSharedPreferences("recycler_position", MODE_PRIVATE).edit();
            editor.putInt("position",position);
            editor.apply();

            FragmentNavigator.Extras.Builder extras = new FragmentNavigator.Extras.Builder();
            extras.addSharedElement(holder.imageView, "my_image");
            FragmentNavigator.Extras build = extras.build();
            Navigation.findNavController(v).navigate(R.id.action_home2_to_prayerDetail,bundle,null,build);

        });



    }//onBindViewHolder

    @Override
    public int getItemCount() {
        return prayer_image.size();
    }



    public static class BusinessCategoryVH extends RecyclerView.ViewHolder {

        private final TextView prayer_name,short_info;
        private final ImageView imageView,icon_image;


        public BusinessCategoryVH(@NonNull @NotNull View itemView, Context context) {
            super(itemView);


            prayer_name = itemView.findViewById(R.id.prayer_name);
            short_info = itemView.findViewById(R.id.shortdesc);
            imageView = itemView.findViewById(R.id.image);
            icon_image = itemView.findViewById(R.id.icon);

        }
    }//VH


}
