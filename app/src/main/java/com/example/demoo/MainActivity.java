package com.example.demoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    // we will create array data and store to listview
    // title
    String[] ListviewTitle = new String[]{
            "Apple", "Ball", "Cat", "Donkey", "Elephant",
            "Fish", "Goat", "Hat", "Ink", "Jug",
            "Kite", "Lion", "Monkey", "Nose", "Orange",
            "Potato", "Queen", "Rose", "Sun", "Tree"
    };
    // description
    String[] ListviewDescription = new String[]{
            "Listview Description 1", "Listview Description 2", "Listview Description 3", "Listview Description 4",
            "Listview Description 5", "Listview Description 6", "Listview Description 7", "Listview Description 8",
            "Listview Description 9", "Listview Description 10", "Listview Description 11", "Listview Description 12",
            "Listview Description 13", "Listview Description 14", "Listview Description 15", "Listview Description 16",
            "Listview Description 17", "Listview Description 18", "Listview Description 19", "Listview Description 20"
    };
    // images
    int[] ListviewImages = new int[]{
            R.drawable.apple, R.drawable.ball, R.drawable.cat, R.drawable.donkey,
            R.drawable.elephant, R.drawable.fish, R.drawable.goat, R.drawable.hat,
            R.drawable.ink, R.drawable.jug, R.drawable.kite, R.drawable.lion,
            R.drawable.monkey, R.drawable.nose, R.drawable.orange, R.drawable.potato,
            R.drawable.queen, R.drawable.rose, R.drawable.sun, R.drawable.tree
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ListView using Adapter");


        //hooks for listView
        ListView simpleListview = (ListView) findViewById(R.id.listView);

        //call the adapter
        CustomAdapter adapter = new CustomAdapter();
        simpleListview.setAdapter(adapter);

        simpleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // call the next activity
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtra("name", ListviewTitle[i]);
                intent.putExtra("description", ListviewDescription[i]);
                intent.putExtra("image", ListviewImages[i]);

                startActivity(intent);
            }
        });


    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ListviewImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.item_list, null);

            //getting view in row_data
            TextView name = view1.findViewById(R.id.Title);
            TextView desc = view1.findViewById(R.id.Description);
            ImageView image = view1.findViewById(R.id.listview_images);

            name.setText(ListviewTitle[i]);
            desc.setText(ListviewDescription[i]);
            image.setImageResource(ListviewImages[i]);


            return view1;
        }
    }

}










