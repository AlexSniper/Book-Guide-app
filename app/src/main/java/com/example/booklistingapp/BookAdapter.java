package com.example.booklistingapp;
import android.content.Context;
import android.graphics.Picture;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import com.squareup.picasso.Picasso;

import java.text.Format;
import java.util.Date;

import java.util.List;


/**
 * {@link BookAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Books} objects.
 */

public class BookAdapter extends ArrayAdapter<Books> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();


    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books   is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Books> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Get the current position of Book
         final Books currentBooks = getItem(position);
        Log.i(LOG_TAG, "Item position: " + position);

        // Find the TextView in the list_item.xml (mapping)
        TextView bookTextView = (TextView) listItemView.findViewById(R.id.book_title);
        TextView authorBookTextView = (TextView) listItemView.findViewById(R.id.author);
        ImageView coverImageView = (ImageView) listItemView.findViewById(R.id.cover_image);
        TextView priceBookTextView = (TextView) listItemView.findViewById(R.id.book_price);
        TextView languageTextView = (TextView) listItemView.findViewById(R.id.country_code);
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_of_the_book);


        assert currentBooks != null;
        bookTextView.setText(currentBooks.getNameOfTheBook());
        authorBookTextView.setText(currentBooks.getAuthor());
        Picasso.with(getContext()).load(currentBooks.getPictureOfBook()).into(coverImageView);
        priceBookTextView.setText(String.valueOf(formatPrice(currentBooks.getmPrice())));
        languageTextView.setText(currentBooks.getLanguageOfTheBook());
        descriptionTextView.setText(currentBooks.getmDescriptionOfTheBook());


        Log.i(LOG_TAG, "ListView has been returned");
        return listItemView;
    }



        // Format with two decimal places for price value
        private String formatPrice(double price) {
            DecimalFormat bookPriceFormat = new DecimalFormat("0.00");
            return bookPriceFormat.format(price);
        }


    }