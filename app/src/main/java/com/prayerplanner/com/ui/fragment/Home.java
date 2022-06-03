package com.prayerplanner.com.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.prayerplanner.com.R;
import com.prayerplanner.com.adapter.AdapterRecycler;
import com.prayerplanner.com.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Home extends Fragment {

    private FragmentHomeBinding binding;
    List<String > prayer_names=new ArrayList<>();
    List<String > prayer_description=new ArrayList<>();
    List<Integer> audio=new ArrayList<Integer>();

    List<String > short_info=new ArrayList<>();
    List<Integer> images=new ArrayList<>();
    List<Integer> images_icon=new ArrayList<>();
    int position=0;
    LinearLayoutManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        SharedPreferences prefs = requireContext().getSharedPreferences("recycler_position", MODE_PRIVATE);
//        position = prefs.getInt("position", 0);
//        Toast.makeText(requireContext(),position+ "", Toast.LENGTH_SHORT).show();
        //prayers names
        prayer_names.add("Morning offering");
        prayer_names.add("Guardian Angel");
        prayer_names.add("Gospel of the Day");
        prayer_names.add("Angelus");
        prayer_names.add("The Holy Rosary");
        prayer_names.add("St Bridget");
        prayer_names.add("Deliverance Prayers");
        prayer_names.add("Personal Prayers");
        prayer_names.add("Memorare");
        prayer_names.add("The Magnificiant");
        prayer_names.add("Prayer for England");
        prayer_names.add("Night Prayer");
        prayer_names.add("St Joseph Memorare");
        prayer_names.add("Divine Mercy Chaplet");
        prayer_names.add("Holy Spirit Prayer");
        prayer_names.add("Act of Faith");
        prayer_names.add("Holy Souls Prayers");


        audio.add(R.raw.morning_offering);
        audio.add(R.raw.guardian_angel);
        audio.add(R.raw.guardian_angel);
        audio.add(R.raw.angelus);
        audio.add(R.raw.holy_souls);
        audio.add(R.raw.angelus);
        audio.add(R.raw.deliverance);
        audio.add(R.raw.personal_prayers);
        audio.add(R.raw.memorare);
        audio.add(R.raw.magnificat);
        audio.add(R.raw.prayer_for_england);
        audio.add(R.raw.night_offering);
        audio.add(R.raw.memorare_to_st_joseph);
        audio.add(R.raw.guardian_angel);
        audio.add(R.raw.holy_spirit_prayer);
        audio.add(R.raw.act_of_faith);
        audio.add(R.raw.holy_souls);





//       prayer images
        images.add(R.drawable.morning_offset);
        images.add(R.drawable.guardian_angel);
        images.add(R.drawable.gospel_of_day);
        images.add(R.drawable.angelus);
        images.add(R.drawable.holy_rosary);
        images.add(R.drawable.st_bridget);
        images.add(R.drawable.deliverance_prayers);
        images.add(R.drawable.personal_prayers);
        images.add(R.drawable.memorare);
        images.add(R.drawable.magnificant);
        images.add(R.drawable.prayer_england);
        images.add(R.drawable.night_prayer);
        images.add(R.drawable.st_joseph_momorare);
        images.add(R.drawable.divine_mercy_chaplet);
        images.add(R.drawable.holy_spirit_prayer);
        images.add(R.drawable.act_of_faith);
        images.add(R.drawable.holy_souls_prayer);

//        prayer images icon
        images_icon.add(R.drawable.morning_offer_icon);
        images_icon.add(R.drawable.guardian_icon);
        images_icon.add(R.drawable.gospal_icon);
        images_icon.add(R.drawable.angelous_icon);
        images_icon.add(R.drawable.holy_rosary_icon);
        images_icon.add(R.drawable.st_bridget_icon);
        images_icon.add(R.drawable.deliverence_prayers_icon);
        images_icon.add(R.drawable.personal_prayers_icon);
        images_icon.add(R.drawable.memorare_icon);
        images_icon.add(R.drawable.magnificiant_icon);
        images_icon.add(R.drawable.england_prayrer_icon);
        images_icon.add(R.drawable.morning_offer_icon);
        images_icon.add(R.drawable.st_joseph_memorare_icon);
        images_icon.add(R.drawable.divine_mersy_chaplet_icon);
        images_icon.add(R.drawable.holy_spirit_prayer_icon);
        images_icon.add(R.drawable.act_of_faith_icon);
        images_icon.add(R.drawable.holy_souls_prayers_icon);

        //        prayer description

        prayer_description.add(getResources().getString(R.string.morningoffer));
        prayer_description.add(getResources().getString(R.string.guardianangel));
        prayer_description.add(getResources().getString(R.string.gospel_of_day));
        prayer_description.add(getResources().getString(R.string.angelous));
        prayer_description.add(getResources().getString(R.string.holy_rosary));
        prayer_description.add(getResources().getString(R.string.st_bridget));
        prayer_description.add(getResources().getString(R.string.deliverence_prayers));
        prayer_description.add(getResources().getString(R.string.personal_prayers));
        prayer_description.add(getResources().getString(R.string.memorare));
        prayer_description.add(getResources().getString(R.string.magnificiant));
        prayer_description.add(getResources().getString(R.string.england_prayer));
        prayer_description.add(getResources().getString(R.string.night_prayer));
        prayer_description.add(getResources().getString(R.string.st_joseph_memorare));
        prayer_description.add(getResources().getString(R.string.divine_mercy_chaplet));
        prayer_description.add(getResources().getString(R.string.holy_spirit_prayer));
        prayer_description.add(getResources().getString(R.string.act_of_faith));
        prayer_description.add(getResources().getString(R.string.holy_souls_prayer));



        //prayers short info
        short_info.add("Start your day by giving everything to God");
        short_info.add("Ask your Guardian angel to protect and guide you");
        short_info.add("Daily Bible readings to meditate on Jesus");
        short_info.add("Devotion commemorating the Incarnation");
        short_info.add("Within this prayer lies the story of our salvation");
        short_info.add("Honouring the wounds of Chris");
        short_info.add("Powerful prayers for spiritual healing");
        short_info.add("In conversation with God");
        short_info.add("Seek the intercession of the Blessed Virgin Mary");
        short_info.add("The Magnificat is also known as the Song of Mary");
        short_info.add("Mary, look down in mercy upon England");
        short_info.add("Night prayers calm the spirit and purify the soul");
        short_info.add("Entrust yourself to St Joseph's paternal care");
        short_info.add("Enter into the abundant Mercy of God");
        short_info.add("Come, Holy Spirit, fill the hearts of your faithful");
        short_info.add("Invoke the virtues of Faith, Hope, Charity");
        short_info.add("Prayers for the holy souls in purgatory");


        AdapterRecycler adapter = new AdapterRecycler(prayer_names,images,images_icon,short_info,prayer_description,audio,requireContext());

        manager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        binding.rvCard.setLayoutManager(manager);

        binding.rvCard.setAdapter(adapter);




    }
}