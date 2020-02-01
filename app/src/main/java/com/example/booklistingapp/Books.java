package com.example.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;



/**
 * An {@link Books} object contains information related to a single earthquake.
 */
public class Books implements Parcelable {

    public static final Parcelable.Creator<Books> CREATOR = new Parcelable.Creator<Books>() {
        @Override
        public Books createFromParcel(Parcel origin) {
            return new Books(origin);
        }

        @Override
        public Books[] newArray(int size) {
            return new Books[size];
        }
    };

    /** Magnitude of the earthquake */
    private String mPictureOfTheBook;

    /** Location of the earthquake */
    private String mAuthor;

    /** Time of the earthquake */
    private String mTitle;

    /** Website URL of the earthquake */
    private String mOnWhichLanguage;

    /**
     * Price of the book
     */
    private  Double mPrice;


    /**
     * Url of the book
     */
    private String mUrlBook;

//    /**
//     * Description of the book
//     */
//    private String mDescriptionOfTheBook;

    public Double getmPrice() {
        return mPrice;
    }

    /**
     * Constructs a new {@link Books} object.
//     *  @param pictureOfTheBook is the pictureOfTheBook (size) of the earthquake
     * @param author is the author where the earthquake happened
     * @param title is the time in milliseconds (from the Epoch) when the
 *                           earthquake happened
     * @param onWhichLanguageIsWritten is the website URL to find more details about the earthquake
     */
    public Books( String pictureOfTheBook,String author, String title, String onWhichLanguageIsWritten, Double price, String urlBook) {

      mPictureOfTheBook = pictureOfTheBook;
        mAuthor = author;
        mTitle = title;
        mOnWhichLanguage = onWhichLanguageIsWritten;
        mPrice = price;
        mUrlBook = urlBook;
//        mDescriptionOfTheBook = descriptionOfTheBook;

    }

    // Parcelling part
    protected Books(Parcel in) {
        this.mTitle = in.readString();
        this.mAuthor = in.readString();
        this.mPictureOfTheBook = in.readString();
        this.mPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.mOnWhichLanguage = in.readString();
        this.mUrlBook = in.readString();
//        this.mDescriptionOfTheBook =in.readString();
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public String getPictureOfBook() {
        return mPictureOfTheBook;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the time of the earthquake.
     */
    public String getTitle() {

        return mTitle;
    }

    /**
     * Returns the description of the book.
     */
//    public String getmDescriptionOfTheBook() {

//        return mDescriptionOfTheBook;
//    }
//

    /**
     * Returns the time of the earthquake.
     */
    public String getmUrlBook() {

        return mUrlBook;
    }



    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getLanguageOfTheBook() {
        return  mOnWhichLanguage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.mTitle);
        dest.writeString(this.mAuthor);
        dest.writeString(this.mPictureOfTheBook);
        dest.writeValue(this.mPrice);
        dest.writeString(this.mOnWhichLanguage);
        dest.writeString(this.mUrlBook);

    }
}
