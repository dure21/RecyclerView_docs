package io.yagus.recyclerview.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.yagus.recyclerview.R;

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_VIEW_TYPE = 0;
    public static final int HEADER_VIEW_TYPE = 1;
    private List<String> mDataset;

    @Override
    public int getItemViewType(int position) {

        if (mDataset.get(position).startsWith("■")) {
            return HEADER_VIEW_TYPE;
        }

        return ITEM_VIEW_TYPE;
    }

    public GridAdapter(List<String> myDataset) {mDataset = myDataset;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        switch (viewType) {
            // 컨텐츠용 ViewHolder 작성
            case ITEM_VIEW_TYPE: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_row_card_view, parent, false);
                return new ItemViewHolder(view);
            }
            // 헤더용 ViewHolder 작성
            case HEADER_VIEW_TYPE: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.header_row, parent, false);
                return new HeaderViewHolder(view);
            }
            default:
                throw new RuntimeException("예측되지 않는 ViewType입니다");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String text = mDataset.get(position);

        switch (holder.getItemViewType()) {
            case ITEM_VIEW_TYPE: {
                // 아이템용으로 그대로 문자열을 설정한다
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                itemViewHolder.textView.setText(text);
            }
            case HEADER_VIEW_TYPE: {
                // 헤더라면 타이틀용 문자열을 설정한다.
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.titleTextView.setText("시리즈:" + text);
                headerViewHolder.detailTextView.setText(text + "시리즈입니다.");
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // 아이템용 ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.simple_text_view);

        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public final TextView titleTextView;
        public final TextView detailTextView;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title_text_view);
            detailTextView = itemView.findViewById(R.id.detail_text_view);
        }
    }
}
