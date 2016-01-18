package com.example.jeff.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> tasks;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );
        ListView list = (ListView) findViewById(R.id.lists);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Remove Function
                tasks.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Task Removed", Toast.LENGTH_SHORT);
                return true;
            }
        });
    }

    public void addToList(View view) {
        String task;
        /* Get text from EditText */
        EditText textfield = (EditText)findViewById(R.id.textfield);
        task = textfield.getText().toString();

        /* Add to ArrayList and update ListView */
        tasks.add(task);
        adapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, "Task Added", Toast.LENGTH_SHORT);
        textfield.setText("");
    }
}
