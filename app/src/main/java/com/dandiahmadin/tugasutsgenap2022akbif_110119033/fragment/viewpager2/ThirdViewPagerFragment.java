package com.dandiahmadin.tugasutsgenap2022akbif_110119033.fragment.viewpager2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdViewPagerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdViewPagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdViewPagerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdViewPagerFragment newInstance(String param1, String param2) {
        ThirdViewPagerFragment fragment = new ThirdViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_view_pager, container, false);
    }
}