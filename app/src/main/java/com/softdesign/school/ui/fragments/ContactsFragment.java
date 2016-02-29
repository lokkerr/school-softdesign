package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.UsersAdapter;
import com.softdesign.school.utils.Lg;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

    private static final String TAG = "CONTACTS_FRAGMENT";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<User> mUsers;

    public ContactsFragment() {
        super();
        mUsers = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View temp = inflater.inflate(R.layout.fragment_contacts, null, false);
        return temp;
    }

    private void generateData() {
        mUsers.add(new User("Ustinov", "Sir Peter Alexander", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Suchet", "David", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Moran", "Pauline", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Jackson", "Philip", getResources().getDrawable(R.drawable.ic_face_24dp)));

        mUsers.add(new User("Cruijff", "Hendrik Johannes", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Maradona", "Diego Armando", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Блохин", "Олег", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Яшин", "Лев", getResources().getDrawable(R.drawable.ic_face_24dp)));

        mUsers.add(new User("Малкин", "Евгений", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Харламов", "Валерий", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Семин", "Александр", getResources().getDrawable(R.drawable.ic_face_24dp)));
        mUsers.add(new User("Быков", "Вячеслав", getResources().getDrawable(R.drawable.ic_face_24dp)));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(getResources().getString(R.string.drawer_contacts));
        MainActivity activity = (MainActivity) getActivity();

        generateData();

        mRecyclerView = (RecyclerView) activity.findViewById(R.id.recycle_view);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new UsersAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);

        FloatingActionButton actionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) actionButton.getLayoutParams();
        params.setAnchorId(R.id.coordinator);
        params.anchorGravity = Gravity.RIGHT | Gravity.BOTTOM;
        actionButton.setImageResource(R.drawable.ic_add_24dp);
        actionButton.setLayoutParams(params);
        actionButton.show();

        activity.lockAppBar(true);
    }
}
