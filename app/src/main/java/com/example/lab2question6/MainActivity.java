package com.example.lab2question6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products = new ArrayList<>();
        products.add(new Product("bread", "Price: 3$", R.drawable.bread,1));
        products.add(new Product("cake", "Price 20$", R.drawable.cake,1));
        products.add(new Product("cookies", "Price 5$", R.drawable.cookies,1));

        BakeryAdapter bakeryAdapter = new BakeryAdapter(this, products);

        // Get the ListView from the layout
        ListView productListView = findViewById(R.id.product_list_view);
        productListView.setAdapter(bakeryAdapter);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}