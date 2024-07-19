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
    private EditText et_enter_id_value;
    private EditText et_enter_weight_value;
    private EditText et_enter_temp_value;
    private EditText et_enter_note_value;
    private Button btn_enter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EnterViewModel enterViewModel = new ViewModelProvider(this).get(EnterViewModel.class);
        binding = FragmentEnterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        et_enter_id_value = binding.etEnterIdValue;
        et_enter_weight_value = binding.etEnterWeightValue;
        et_enter_temp_value = binding.etEnterTempValue;
        et_enter_note_value = binding.etEnterNoteValue;
        btn_enter = binding.btnEnter;

        btn_enter.setOnClickListener(v -> {
            String et_enter_id = et_enter_id_value.getText().toString();
            String et_enter_weight = et_enter_weight_value.getText().toString();
            String et_enter_temp = et_enter_temp_value.getText().toString();
            String et_enter_note = et_enter_note_value.getText().toString();

            LivestockInfo entity = new LivestockInfo();
            entity.setId(Long.parseLong(et_enter_id));
            entity.setWeight(Float.parseFloat(et_enter_weight));
            entity.setTemp(Float.parseFloat(et_enter_temp));
            entity.setNotes(et_enter_note);
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