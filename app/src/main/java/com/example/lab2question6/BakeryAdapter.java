package com.example.lab2question6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class BakeryAdapter extends ArrayAdapter<Product> {

    private final Activity context;
    private final List<Product> products;

    public BakeryAdapter(Activity context, List<Product> products) {
        super(context, R.layout.product_item, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the contact for the current position
        Product currentContact = products.get(position);

        // Inflate the view
        LayoutInflater inflater = context.getLayoutInflater();
        View contactView = inflater.inflate(R.layout.product_item, parent, false);

        // Get the views
        ImageView productImageView = contactView.findViewById(R.id.product_img);
        TextView productNameTextView = contactView.findViewById(R.id.product_name);
        TextView priceTextView = contactView.findViewById(R.id.price);
        Spinner quantitySpinner = contactView.findViewById(R.id.quantity_spinner);

        // Set the data
        productImageView.setImageResource(currentContact.getImageResourceId());
        productNameTextView.setText(currentContact.getName());
        priceTextView.setText(currentContact.getPrice());

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(context,
                R.array.quantity_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(spinnerAdapter);
        quantitySpinner.setSelection(currentContact.getQuantity() - 1); // Default selection


        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                currentContact.setQuantity(i + 1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });
        // Return the prepared view
        return contactView;
    }
}