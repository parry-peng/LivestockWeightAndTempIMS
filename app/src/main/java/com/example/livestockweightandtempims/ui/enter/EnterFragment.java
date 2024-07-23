package com.example.livestockweightandtempims.ui.enter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockweightandtempims.databinding.FragmentEnterBinding;
import com.example.livestockweightandtempims.entity.ArchiveInfo;
import com.example.livestockweightandtempims.entity.LivestockInfo;
import com.example.livestockweightandtempims.util.ToastUtil;

public class EnterFragment extends Fragment {

    private FragmentEnterBinding binding;
    private long et_id;
    private int et_purchase_date;
    private float et_purchase_price;
    private float et_purchase_weight;
    private String et_color;
    private String et_purchase_unit;
    private String et_contact;
    private int et_telephone;
    private int et_vaccination_status;
    private int et_vaccination_date;
    private String et_note;

    private Button btn_enter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EnterViewModel enterViewModel = new ViewModelProvider(this).get(EnterViewModel.class);
        binding = FragmentEnterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btn_enter = binding.btnEnter;

        btn_enter.setOnClickListener(v -> {
            if (!enterViewModel.existsArchive(et_id))
            {
                et_id = Long.parseLong(binding.etEnterId.getText().toString());
                et_purchase_date = Integer.parseInt(binding.etEnterPurchaseDate.getText().toString());
                et_purchase_price = Float.parseFloat(binding.etEnterPurchasePrice.getText().toString());
                et_purchase_weight = Float.parseFloat(binding.etEnterPurchaseWeight.getText().toString());
                et_color = binding.etEnterColor.getText().toString();
                et_purchase_unit = binding.etEnterPurchaseUnit.getText().toString();
                et_contact = binding.etEnterContact.getText().toString();
                et_telephone = Integer.parseInt(binding.etEnterTelephone.getText().toString());
                et_vaccination_status = Integer.parseInt(binding.spinnerEnterVaccinationStatus.getSelectedItem().toString());
                et_vaccination_date = Integer.parseInt(binding.etEnterVaccinationDate.getText().toString());
                et_note = binding.etEnterNote.getText().toString();

                ArchiveInfo entity = new ArchiveInfo(et_id,et_purchase_date,et_purchase_price,
                        et_purchase_weight,et_color,et_purchase_unit,et_contact,
                        et_telephone,et_vaccination_status,et_vaccination_date,et_note);
                if (entity.checkArchive())
                {
                    enterViewModel.insertArchive(entity);
                    clearInputs();
                    ToastUtil.show(getContext(),"数据录入成功！！！");
                }else{
                    ToastUtil.show(getContext(),"请检查数据是否正确！！！");
                }


            }else{
                ToastUtil.show(getContext(),"该数据已经被录入！！！");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void clearInputs() {
        // 遍历并清空所有 EditText 控件的文本
        binding.etEnterId.setText("");
        binding.etEnterPurchaseDate.setText("");
        binding.etEnterPurchasePrice.setText("");
        binding.etEnterPurchaseWeight.setText("");
        binding.etEnterColor.setText("");
        binding.etEnterPurchaseUnit.setText("");
        binding.etEnterContact.setText("");
        binding.etEnterTelephone.setText("");
        // 对于 Spinner，我们需要设置选中项为 null 或者第一个项（如果有的话）
        binding.spinnerEnterVaccinationStatus.setSelection(0, false);
        binding.etEnterVaccinationDate.setText("");
        binding.etEnterNote.setText("");
    }

}