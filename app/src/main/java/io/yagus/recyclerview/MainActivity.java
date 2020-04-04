package io.yagus.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import io.yagus.recyclerview.grid.GridRecyclerViewActivity;
import io.yagus.recyclerview.manipulation.ManipulationActivity;
import io.yagus.recyclerview.simple.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {

        findViewById(R.id.simple_execute_button).setOnClickListener((v) -> {

            Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.manipulation_execute_button).setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), ManipulationActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.grid_execute_button).setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), GridRecyclerViewActivity.class);
            startActivity(intent);
        });
    }
}
