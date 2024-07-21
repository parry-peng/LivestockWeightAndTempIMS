package com.example.livestockweightandtempims.ui.query;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockweightandtempims.databinding.FragmentQueryBinding;
import com.example.livestockweightandtempims.entity.LivestockInfo;
import com.example.livestockweightandtempims.util.ToastUtil;

public class QueryFragment extends Fragment {

    private FragmentQueryBinding binding;
    private Button btn_query;
    private EditText query_id_value;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        QueryViewModel queryViewModel = new ViewModelProvider(this).get(QueryViewModel.class);
        binding = FragmentQueryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btn_query = binding.btnQuery;
        query_id_value = binding.queryIdValue;
        btn_query.setOnClickListener(v->{
            String query_id = query_id_value.getText().toString();
            LivestockInfo entity = queryViewModel.queryLivestock(Long.parseLong(query_id));

            float query_weight = entity.getWeight();
            float query_temp = entity.getTemp();
            String query_note = entity.getNotes();
            Log.d("rick", String.valueOf(query_weight));
            Log.d("rick", String.valueOf(query_temp));
            Log.d("rick", query_note);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}