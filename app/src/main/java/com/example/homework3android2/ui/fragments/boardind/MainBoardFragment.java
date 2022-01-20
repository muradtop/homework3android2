package com.example.homework3android2.ui.fragments.boardind;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.homework3android2.R;
import com.example.homework3android2.adapter.ViewPagerAdapter;
import com.example.homework3android2.databinding.FragmentMainBoardBinding;
import com.example.homework3android2.interfaces.OnItemClickListener;
import com.example.homework3android2.model.ViewPagerModel;

import java.util.ArrayList;


public class MainBoardFragment extends Fragment implements OnItemClickListener {
    private FragmentMainBoardBinding binding;
    ViewPagerAdapter adapter;

    ArrayList<ViewPagerModel> list = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShow();
        list.add(new ViewPagerModel("Welcome to productive life!", "You can plan your time,add and organize tasks. Reminders so that you don't forget a thing - we take care of it.", R.drawable.todo1));
        list.add(new ViewPagerModel("Collaboration with students", "You can create a common study schedule,group tasks,manage them and communicate with other members.", R.drawable.todo2));
        list.add(new ViewPagerModel("How to keep up everything?", "You can track your productivity, see your results and progress. Also,this is a great opportunity to track how much time you spend studying", R.drawable.todo3));
        adapter = new ViewPagerAdapter(list, this);
        binding.viewpager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewpager);
    }


    public void checkOnShow() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("isShow", false);
        if (isShow) {
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);

        }
    }

    public void onItemClick() {

        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isShow", true).apply();

    }

}