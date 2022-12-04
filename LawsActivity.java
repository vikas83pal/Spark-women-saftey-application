package com.example.sparkwomen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class LawsActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LawsActivity.this,MainActivity.class));
        LawsActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_item);
       // RecyclerView recyclerView = findViewById(R.id.recycleLaws);
        String[] laws = new String[]{"The Prohibition of Child Marriage Act, 2006","Special Marriage Act, 1954","Dowry Prohibition Act, 1961","Indian Divorce Act, 1969","Maternity Benefit Act,1861","Medical Termination of Pregnancy Act,1971","Sexual Harassment of Women at Workplace (Prevention, Prohibition and Redress) Act, 2013","Indecent Representation of Women(Prevention) Act,1986","National Commission for Women Act, 1990","Equal Remuneration Act, 1976"};

       // MyAdapter adapter = new MyAdapter(this, laws, this::onItemClicked);



        findViewById(R.id.backBtn).setOnClickListener(view -> {
            startActivity(new Intent(LawsActivity.this,MainActivity.class));
            LawsActivity.this.finish();
        });
    }

//    private void onItemClicked(int position) {
//        Intent intent = new Intent(LawsActivity.this, finishActivity();
//        intent.putExtra("position", position);
//        startActivity(intent);
//    }
}