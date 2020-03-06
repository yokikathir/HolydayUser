package com.kathir.holyday.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kathir.holyday.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KeyGenerateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KeyGenerateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KeyGenerateFragment extends Fragment {


    public KeyGenerateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activity_property_view for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
