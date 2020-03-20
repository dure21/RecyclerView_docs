package io.yagus.recyclerview.simple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import io.yagus.recyclerview.R;

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.ViewHolder> {

    protected List<String> mDataset;
    private View.OnClickListener onItemViewClickListener;

    public SimpleStringAdapter(List<String> myDataset) {mDataset = myDataset;}

    public void setOnItemViewClickListener(View.OnClickListener onItemViewClickListener) {
        this.onItemViewClickListener = onItemViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_row_card_view, parent, false);

        if (onItemViewClickListener != null) {
            v.setOnClickListener(onItemViewClickListener);
        }

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
}
