package com.project.tourbooking.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.project.tourbooking.R;
import com.project.tourbooking.dto.TourViewMain;
import com.project.tourbooking.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyDatabaseHelper";
    private static final String DATABASE_NAME = "BOOKINGTOUR_DB";
    private static final int DATABASE_VERSION = 1;

    // Table names and columns
    private static final String TABLE_COMPANY = "COMPANY";
    private static final String COLUMN_ID_COMPANY = "id";
    private static final String COLUMN_NAME_COMPANY = "name";
    private static final String COLUMN_RATE = "rate";
    private static final String COLUMN_NUMBER_RATE = "numberRate";

    // Table tour
    private static final String TABLE_TOUR = "TOUR";
    private static final String COLUMN_ID_TOUR = "id";
    private static final String COLUMN_NAME_TOUR = "nameTour";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_DESCRIBE = "describe";
    private static final String COLUMN_SERVICE = "service";
    private static final String COLUMN_PICTURE1 = "picture1";
    private static final String COLUMN_PICTURE2 = "picture2";
    private static final String COLUMN_PICTURE3 = "picture3";
    private static final String COLUMN_PICTURE4 = "picture4";
    private static final String COLUMN_START_DATE = "startDate";
    private static final String COLUMN_END_DATE = "endDate";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_LAT = "lat";
    private static final String COLUMN_ING = "ing";
    private static final String COLUMN_NUMBER_PASSENGER_LEFT = "numberPassengerLeft";
    private static final String COLUMN_ID_COMPANY_FK = "idCompany";

    private static final String TABLE_TOUR_BOOKING = "TOUR_BOOKING";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME_CUSTOMER = "nameCustomer";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NUMBER_PASSENGER = "numberPassenger";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_NOTE = "note";
    private static final String COLUMN_NUMBER_AMOUNT = "numberAmount";
    private static final String COLUMN_ID_TOUR_FK = "idTour";

    private static final String TABLE_NOTIFICATION = "NOTIFICATION";
    private static final String COLUMN_ID_NOTIFICATION = "id";
    private static final String COLUMN_ANNOUNCE_DATE = "announceDate";
    private static final String COLUMN_ID_TOUR_BOOKING_FK = "idTourBooking";

    private static MyDatabaseHelper sInstance;

    public static MyDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MyDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String CREATE_COMPANY = "CREATE TABLE IF NOT EXISTS " + TABLE_COMPANY + " ("
                    + COLUMN_ID_COMPANY + " INTEGER PRIMARY KEY, "
                    + COLUMN_NAME_COMPANY + " TEXT, "
                    + COLUMN_RATE + " REAL, "
                    + COLUMN_NUMBER_RATE + " INTEGER)";

            String CREATE_TOUR = "CREATE TABLE IF NOT EXISTS " + TABLE_TOUR + " ("
                    + COLUMN_ID_TOUR + " INTEGER PRIMARY KEY, "
                    + COLUMN_NAME_TOUR + " TEXT NOT NULL, "
                    + COLUMN_PRICE + " REAL, "
                    + COLUMN_DESCRIBE + " TEXT, "
                    + COLUMN_SERVICE + " TEXT, "
                    + COLUMN_PICTURE1 + " TEXT, "
                    + COLUMN_PICTURE2 + " TEXT, "
                    + COLUMN_PICTURE3 + " TEXT, "
                    + COLUMN_PICTURE4 + " TEXT, "
                    + COLUMN_START_DATE + " TEXT, "
                    + COLUMN_END_DATE + " TEXT, "
                    + COLUMN_LOCATION + " TEXT, "
                    + COLUMN_CITY + " TEXT, "
                    + COLUMN_LAT + " TEXT, "
                    + COLUMN_ING + " TEXT, "
                    + COLUMN_NUMBER_PASSENGER_LEFT + " INTEGER, "
                    + COLUMN_ID_COMPANY_FK + " INTEGER, "
                    + "FOREIGN KEY (" + COLUMN_ID_COMPANY_FK + ") REFERENCES " + TABLE_COMPANY + "(" + COLUMN_ID_COMPANY + "))";

            String CREATE_TABLE_TOUR_BOOKING = "CREATE TABLE IF NOT EXISTS " + TABLE_TOUR_BOOKING + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_NAME_CUSTOMER + " TEXT NOT NULL, "
                    + COLUMN_PHONE + " TEXT, "
                    + COLUMN_EMAIL + " TEXT, "
                    + COLUMN_NUMBER_PASSENGER + " INTEGER, "
                    + COLUMN_STATUS + " TEXT, "
                    + COLUMN_NOTE + " TEXT, "
                    + COLUMN_NUMBER_AMOUNT + " INTEGER, "
                    + COLUMN_ID_TOUR_FK + " INTEGER, "
                    + "FOREIGN KEY (" + COLUMN_ID_TOUR_FK + ") REFERENCES " + TABLE_TOUR + "(" + COLUMN_ID_TOUR + "))";

            String CREATE_TABLE_NOTIFICATION = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTIFICATION + " ("
                    + COLUMN_ID_NOTIFICATION + " INTEGER PRIMARY KEY, "
                    + COLUMN_ANNOUNCE_DATE + " TEXT, "
                    + COLUMN_ID_TOUR_BOOKING_FK + " INTEGER, "
                    + "FOREIGN KEY (" + COLUMN_ID_TOUR_BOOKING_FK + ") REFERENCES " + TABLE_TOUR_BOOKING + "(" + COLUMN_ID + "))";

            db.execSQL(CREATE_COMPANY);
            db.execSQL(CREATE_TOUR);
            db.execSQL(CREATE_TABLE_TOUR_BOOKING);
            db.execSQL(CREATE_TABLE_NOTIFICATION);

            addSampleData(db);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOUR_BOOKING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOUR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        onCreate(db);
    }

    public boolean AddCompany(Company company) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(ID_COLUMN, company.getId());
        values.put(COLUMN_RATE, company.getRate());
        values.put(COLUMN_NAME_COMPANY, company.getName());
        values.put(COLUMN_NUMBER_RATE, company.getNumberRate());

        long rowId = db.insert(TABLE_COMPANY, null, values);
        db.close();
        if (rowId != -1)
            return true;
        return false;
    }

    public boolean addTour(String nameTour, double price, String describe, String service,
                           String picture1, String startDate, String endDate, String location, String city,
                           String lat, String lng, int numberPassengerLeft, int companyId) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME_TOUR, nameTour);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_DESCRIBE, describe);
        values.put(COLUMN_SERVICE, service);
        values.put(COLUMN_PICTURE1, picture1);
        values.put(COLUMN_START_DATE, startDate);
        values.put(COLUMN_END_DATE, endDate);
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_LAT, lat);
        values.put(COLUMN_ING, lng);
        values.put(COLUMN_NUMBER_PASSENGER_LEFT, numberPassengerLeft);
        values.put(COLUMN_ID_COMPANY_FK, companyId);

        long rowId = db.insert(TABLE_TOUR, null, values);
        db.close();
        return rowId != -1;
    }

    @SuppressLint("Range")
    public List<Company> getAllCompany() {
        SQLiteDatabase db = getReadableDatabase();
        List<Company> companies = new ArrayList<Company>();
        String sql = "SELECT * FROM " + TABLE_COMPANY;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                companies.add(new Company(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_COMPANY)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_COMPANY)),
                        cursor.getFloat(cursor.getColumnIndex(COLUMN_RATE)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_NUMBER_RATE))));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return companies;
    }

    @SuppressLint("Range")
    public List<TourViewMain> getAllToursWithCompany() {
        List<TourViewMain> tourList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT TOUR.nameTour as nameTour, COMPANY.name as nameCompany, TOUR.price as price, TOUR.picture1 as picture1 " +
                "FROM TOUR " +
                "INNER JOIN COMPANY ON TOUR.idCompany = COMPANY.id " +
                "LIMIT 5";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String tourName = cursor.getString(cursor.getColumnIndex("nameTour"));
                String companyName = cursor.getString(cursor.getColumnIndex("nameCompany"));
                String price = cursor.getInt(cursor.getColumnIndex("price")) + " đ";
                int imageResId = R.drawable.image_1; // Dynamic image resource if available

                tourList.add(new TourViewMain(tourName, companyName, price, imageResId));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return tourList;
    }

    private void addSampleData(SQLiteDatabase db) {
        // Thêm 5 Company
        db.execSQL("INSERT INTO " + TABLE_COMPANY + " VALUES (1, 'cong ty 1', 4.5, 120)");
        db.execSQL("INSERT INTO " + TABLE_COMPANY + " VALUES (2, 'cong ty 2',4.0, 90)");
        db.execSQL("INSERT INTO " + TABLE_COMPANY + " VALUES (3, 'cong ty 3',4.8, 150)");
        db.execSQL("INSERT INTO " + TABLE_COMPANY + " VALUES (4, 'cong ty 4',3.9, 100)");
        db.execSQL("INSERT INTO " + TABLE_COMPANY + " VALUES (5, 'cong ty 5',4.7, 130)");

        // Thêm 10 Tour
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (1, 'Tour Đà Nẵng', 3000000, 'Trải nghiệm thành phố biển', 'Khách sạn 5 sao', 'image1', 'image2', 'image3', 'image4', '2024-11-01', '2024-11-05', 'Đà Nẵng', 'Đà Nẵng', '16.0544', '108.2022', 20, 1)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (2, 'Tour Nha Trang', 3500000, 'Tham quan biển đảo', 'Resort', 'image1', 'image2', 'image3', 'image4', '2024-12-10', '2024-12-15', 'Nha Trang', 'Khánh Hòa', '12.2458', '109.1957', 25, 2)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (3, 'Tour Đà Lạt', 2500000, 'Khám phá thành phố hoa', 'Khách sạn 4 sao', 'image1', 'image2', 'image3', 'image4', '2024-10-05', '2024-10-08', 'Đà Lạt', 'Lâm Đồng', '11.9404', '108.4583', 15, 3)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (4, 'Tour Sapa', 2800000, 'Khám phá văn hóa vùng cao', 'Khách sạn 3 sao', 'image1', 'image2', 'image3', 'image4', '2024-09-01', '2024-09-04', 'Sapa', 'Lào Cai', '22.3402', '103.8448', 18, 4)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (5, 'Tour Phú Quốc', 4000000, 'Tận hưởng thiên đường biển', 'Resort 5 sao', 'image1', 'image2', 'image3', 'image4', '2024-08-20', '2024-08-25', 'Phú Quốc', 'Kiên Giang', '10.227', '103.963', 22, 5)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (6, 'Tour Cần Thơ', 2200000, 'Khám phá vùng sông nước', 'Nhà nghỉ 3 sao', 'image1', 'image2', 'image3', 'image4', '2024-08-01', '2024-08-03', 'Cần Thơ', 'Cần Thơ', '10.0452', '105.7469', 16, 1)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (7, 'Tour Hà Nội', 2700000, 'Tham quan thủ đô', 'Khách sạn 4 sao', 'image1', 'image2', 'image3', 'image4', '2024-10-10', '2024-10-13', 'Hà Nội', 'Hà Nội', '21.0285', '105.8542', 18, 2)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (8, 'Tour Hạ Long', 3200000, 'Khám phá vịnh Hạ Long', 'Resort 4 sao', 'image1', 'image2', 'image3', 'image4', '2024-11-20', '2024-11-23', 'Hạ Long', 'Quảng Ninh', '20.9501', '107.0422', 14, 3)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (9, 'Tour Huế', 2600000, 'Tham quan cố đô Huế', 'Khách sạn 3 sao', 'image1', 'image2', 'image3', 'image4', '2024-09-10', '2024-09-13', 'Huế', 'Thừa Thiên Huế', '16.4628', '107.5847', 20, 4)");
        db.execSQL("INSERT INTO " + TABLE_TOUR + " VALUES (10, 'Tour Quy Nhơn', 3000000, 'Tham quan vùng đất võ', 'Khách sạn 5 sao', 'image1', 'image2', 'image3', 'image4', '2024-12-01', '2024-12-04', 'Quy Nhơn', 'Bình Định', '13.7793', '109.2232', 17, 5)");}
}
