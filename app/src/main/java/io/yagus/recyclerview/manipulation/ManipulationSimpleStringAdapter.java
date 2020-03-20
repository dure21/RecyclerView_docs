package io.yagus.recyclerview.manipulation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.yagus.recyclerview.R;

public class ManipulationSimpleStringAdapter extends RecyclerView.Adapter<ManipulationSimpleStringAdapter.ViewHolder> {

    protected List<String> mDataset;

    public ManipulationSimpleStringAdapter(List<String> myDataset) {mDataset = myDataset;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_row_card_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = mDataset.get(position);

        holder.textView.setText(text);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.simple_text_view);

        }
    }

    // 데이터를 삽입한다.
    public void addAtPosition(int position, String text) {
        if (position > mDataset.size()) {
            position = mDataset.size();
        }

        mDataset.add(position, text);
        notifyItemInserted(position);
    }

    // 데이터를 삭제한다.
    public void removeAtPosition(int position) {
        if (position < mDataset.size()) {

            mDataset.remove(position);

            notifyItemRemoved(position);
        }
    }

    // 데이터를 이동한다.
    public void move(int fromPosition, int toPosition) {
        final String text = mDataset.get(fromPosition);
        mDataset.remove(fromPosition);
        mDataset.add(toPosition, text);
        notifyItemMoved(fromPosition, toPosition);
    }

}
