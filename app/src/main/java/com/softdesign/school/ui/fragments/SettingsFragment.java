package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

<<<<<<< HEAD
public class SettingsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View temp = inflater.inflate(R.layout.fragment_settings, null, false);
        getActivity().setTitle(getResources().getString(R.string.drawer_setting));
        ((MainActivity) getActivity()).lockAppBar(true);
        return temp;
=======

public class SettingsFragment extends Fragment {

    private MainActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, null, false);
        mActivity = (MainActivity) getActivity();
        mActivity.setTitle("Настройки");
        mActivity.setMenuCheck(R.id.navigation_settings);
        return view;
>>>>>>> master
    }
}
