package com.example.livestockweightandtempims.ui.enter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockweightandtempims.databinding.FragmentEnterBinding;
import com.example.livestockweightandtempims.entity.LivestockInfo;

public class EnterFragment extends Fragment {

    private FragmentEnterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EnterViewModel enterViewModel = new ViewModelProvider(this).get(EnterViewModel.class);
        binding = FragmentEnterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText et_enter_id_value = binding.etEnterIdValue;
        final EditText et_enter_weight_value = binding.etEnterWeightValue;
        final EditText et_enter_temp_value = binding.etEnterTempValue;
        final EditText et_enter_note_value = binding.etEnterNoteValue;
        final Button btn_enter = binding.btnEnter;

        btn_enter.setOnClickListener(v -> {
            LivestockInfo entity = new LivestockInfo();
            entity.setId(Integer.parseInt(et_enter_id_value.getText().toString()));
            entity.setWeight(Float.parseFloat(et_enter_weight_value.getText().toString()));
            entity.setTemp(Float.parseFloat(et_enter_temp_value.getText().toString()));
            entity.setNotes(et_enter_note_value.getText().toString());
            enterViewModel.insertLivestock(entity);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}