package io.yagus.recyclerview.grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import io.yagus.recyclerview.DummyDataGenerator;
import io.yagus.recyclerview.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        /*참고 사이트: https://medium.com/@jsuch2362/android-%EA%B9%A8%EC%95%8C-%ED%8C%81-3-adapter-view-type-46b3fd071fff*/
        //TODO 레벨업 교과서 참조 후 수정
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.simple_recycler_view);

        recyclerView.setHasFixedSize(true);

        // 열을 3으로 설정한 GridLayoutManager의 인스턴을 생성하고 설정
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        // SpanSizeLookup으로 위치별로 차지할 폭을 결정한다
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getItemViewType(position) == GridAdapter.HEADER_VIEW_TYPE) {
                    // 헤더는 3열을 차지해서 표시한다(표시 되는 것은 1열)
                    return gridLayoutManager.getSpanCount();
                }
                // 나머지는 1열을 사용한다 (표시되는 것은 3열)
                return 1;
            }
        };

        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new GridAdapter(DummyDataGenerator.generateStringListData());
        recyclerView.setAdapter(adapter);


    }
}
