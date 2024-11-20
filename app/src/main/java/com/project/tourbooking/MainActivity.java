package com.project.tourbooking;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.project.tourbooking.adapter.SpaceItemDecoration;
import com.project.tourbooking.adapter.TourViewMainAdapter;
import com.project.tourbooking.dto.TourViewMain;
import com.project.tourbooking.entity.Company;
import com.project.tourbooking.dao.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private static final String ID_COLUMN = "id";
//    private static final String WORD_COLUMN = "word";
//    private static final String MEAN_COLUMN = "mean";
    MyDatabaseHelper db=null;
    private RecyclerView recyclerViewTours;
    private TourViewMainAdapter tourAdapter;
    private List<TourViewMain> tourList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        db = MyDatabaseHelper.getInstance(this);
        recyclerViewTours = findViewById(R.id.recyclerViewTours);

        // Sử dụng LinearLayoutManager với hướng nằm ngang
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTours.setLayoutManager(layoutManager);

        // Áp dụng SpaceItemDecoration để thêm khoảng cách giữa các mục
        int space = getResources().getDimensionPixelSize(R.dimen.item_spacing);
        recyclerViewTours.addItemDecoration(new SpaceItemDecoration(space));

        tourList = new ArrayList<>();
        // Lấy dữ liệu từ DB và cập nhật adapter
        List<TourViewMain> tourList = db.getAllToursWithCompany();

        tourAdapter = new TourViewMainAdapter(this, tourList);
        recyclerViewTours.setAdapter(tourAdapter);
    }
}