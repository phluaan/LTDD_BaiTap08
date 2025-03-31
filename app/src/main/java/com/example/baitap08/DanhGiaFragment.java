
package com.example.baitap08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baitap08.databinding.FragmentDanhgiaBinding;

public class DanhGiaFragment extends Fragment {

    FragmentDanhgiaBinding binding;

    public DanhGiaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDanhgiaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}