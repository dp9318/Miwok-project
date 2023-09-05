package com.example.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miwok.Activities.Colors;
import com.example.miwok.Activities.Family_Members;
import com.example.miwok.Activities.Numbers;
import com.example.miwok.Activities.Phrases;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView numbers = findViewById(R.id.numbers);
        numbers.setOnClickListener(view -> {
            Intent num = new Intent(MainActivity.this, Numbers.class);
            Toast.makeText(view.getContext(), "Openning Numbers...", Toast.LENGTH_SHORT).show();
            startActivity(num);
        }
        );
        TextView familyMember = findViewById(R.id.family);
        familyMember.setOnClickListener(view -> {
            Intent family_mem = new Intent(MainActivity.this, Family_Members.class);
            Toast.makeText(this, "Openning Family Members...", Toast.LENGTH_SHORT).show();
            startActivity(family_mem);
        });
        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(view -> {
            Intent color = new Intent(MainActivity.this, Colors.class);
            Toast.makeText(this, "Openning Colors...", Toast.LENGTH_SHORT).show();
            startActivity(color);
        });
        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(view -> {
            Intent phrase = new Intent(MainActivity.this, Phrases.class);
            Toast.makeText(this, "Openning Phrases...", Toast.LENGTH_SHORT).show();
            startActivity(phrase);
        });
    }
//    public void numbers(View view){
//        Intent num = new Intent(MainActivity.this, Numbers.class);
//        Toast.makeText(this, "Openning Numbers...", Toast.LENGTH_SHORT).show();
//        startActivity(num);
//    }
//    public void family_members(View view){
//        Intent family_mem = new Intent(MainActivity.this, Family_Members.class);
//        Toast.makeText(this, "Openning Family family_members_set...", Toast.LENGTH_SHORT).show();
//        startActivity(family_mem);
//    }
//    public void colors(View view){
//        Intent color = new Intent(MainActivity.this, Colors.class);
//        Toast.makeText(this, "Openning Colors...", Toast.LENGTH_SHORT).show();
//        startActivity(color);
//
//    }
//    public void phrases(View view){
//        Intent phrase = new Intent(MainActivity.this, Phrases.class);
//        Toast.makeText(this, "Openning Phrases...", Toast.LENGTH_SHORT).show();
//        startActivity(phrase);
//
//    }
}
