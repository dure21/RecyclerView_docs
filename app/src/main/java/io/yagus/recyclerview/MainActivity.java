package io.yagus.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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
            Intent intent = RecyclerViewActivity.createIntent(MainActivity.this);
            startActivity(intent);
        });


        findViewById(R.id.manipulation_execute_button).setOnClickListener((v) -> {
            Intent intent = ManipulationActivity.createIntent(MainActivity.this);
            startActivity(intent);
        });
    }
}
