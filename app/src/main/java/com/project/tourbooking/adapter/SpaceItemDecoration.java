package com.project.tourbooking.adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int space; // Khoảng cách giữa các mục

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;

        // Thêm margin trên cùng cho mục đầu tiên
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = space;
        }

        // Thêm margin dưới cùng cho mục cuối cùng (nếu muốn)
        if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            outRect.right = space;
        }
    }
}
