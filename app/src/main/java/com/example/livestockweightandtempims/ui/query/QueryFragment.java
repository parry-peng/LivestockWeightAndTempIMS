package com.example.livestockweightandtempims.ui.query;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockweightandtempims.databinding.FragmentQueryBinding;

public class QueryFragment extends Fragment {

    private FragmentQueryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QueryViewModel queryViewModel =
                new ViewModelProvider(this).get(QueryViewModel.class);

        binding = FragmentQueryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textQuery;
        queryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}