package io.yagus.recyclerview.simple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import io.yagus.recyclerview.DummyDataGenerator;
import io.yagus.recyclerview.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SimpleStringAdapter simpleStringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.simple_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        simpleStringAdapter = new SimpleStringAdapter(DummyDataGenerator.generateStringListData());
        simpleStringAdapter.setOnItemViewClickListener((v) -> {
            Toast.makeText(v.getContext(),"Position:" + recyclerView.getChildAdapterPosition(v) + "가 클릭됐습니다", Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(simpleStringAdapter);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, RecyclerViewActivity.class);
    }
}
