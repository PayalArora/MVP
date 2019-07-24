package com.mylearning.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.mylearning.R;
import com.mylearning.databinding.ItemEmployeeBinding;
import com.mylearning.model.EmployeeViewModel;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    private List<EmployeeViewModel> data = new ArrayList<>();
    Context mContext;
    public EmployeeListAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemEmployeeBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final EmployeeViewModel dataObj = data.get(position);
        holder.bind(dataObj);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final TextView employeeName;
        ItemEmployeeBinding binding;

        private EmployeeViewHolder(ItemEmployeeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            employeeName = itemView.findViewById(R.id.txtName);
        }
        public void bind(Object obj) {
            binding.setVariable(BR.viewmodel,obj);
            binding.executePendingBindings();
        }
    }
    public void updateData(List<EmployeeViewModel> data){
        this.data = data;
        Log.d("EMPLOYEE DATA", "Response : " + data.size());
        notifyDataSetChanged();
    }
}
