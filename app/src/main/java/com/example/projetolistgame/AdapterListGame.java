package com.example.projetolistgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListGame extends RecyclerView.Adapter<AdapterListGame.ViewHolder> {
        private List<String> mData;

        public AdapterListGame(List<String> data) {
            mData = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_layout, parent, false);
            return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull AdapterListGame.ViewHolder holder, int position) {

    }

    @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String item = mData.get(position);
            holder.textView.setText(item);
        }

    @NonNull
    @Override
    public AdapterListGame.AdapterListGame.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
        public int getItemCount() {
            return mData.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
                textView = view.findViewById(R.id.text_view);
            }
        }
    }
}
