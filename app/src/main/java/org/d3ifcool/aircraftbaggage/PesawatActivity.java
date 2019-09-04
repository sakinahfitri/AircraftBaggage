package org.d3ifcool.aircraftbaggage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PesawatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesawat);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("one","lutti", R.drawable.family_mother));

        RecyclerView recyclerView = findViewById(R.id.word_list);
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_pesawaat);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(PesawatActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(PesawatActivity.this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
    }
}
