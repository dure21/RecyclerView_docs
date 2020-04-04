package io.yagus.recyclerview.manipulation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.yagus.recyclerview.DummyDataGenerator;
import io.yagus.recyclerview.R;

public class ManipulationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ManipulationSimpleStringAdapter simpleStringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulation);

        setupRecyclerView();

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleStringAdapter.addAtPosition(3, "새 아이템");
            }
        });
        findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleStringAdapter.removeAtPosition(3);
            }
        });

    }

    private void setupRecyclerView() {

        recyclerView = findViewById(R.id.simple_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        simpleStringAdapter = new ManipulationSimpleStringAdapter(DummyDataGenerator.generateStringListData());
        recyclerView.setAdapter(simpleStringAdapter);


        // 드래그앤드롭이나 스와이프로 아이템 이동이나 삭제 등을 할 수 있게 된다.
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                simpleStringAdapter.move(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                simpleStringAdapter.removeAtPosition(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
    }

}
