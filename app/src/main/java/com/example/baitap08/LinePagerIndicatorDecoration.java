package com.example.baitap08;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final float DP;

    private final Paint paintActive = new Paint();
    private final Paint paintInactive = new Paint();

    public LinePagerIndicatorDecoration(RecycleViewActivity shopeeActivity) {
        DP = shopeeActivity.getResources().getDisplayMetrics().density;

        paintActive.setColor(0xFFFFFFFF); // Màu trắng
        paintActive.setStyle(Paint.Style.FILL);
        paintActive.setAntiAlias(true);

        paintInactive.setColor(0x66FFFFFF); // Màu trắng nhạt
        paintInactive.setStyle(Paint.Style.FILL);
        paintInactive.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        float indicatorWidth = DP * 16 * itemCount;
        float indicatorStartX = (parent.getWidth() - indicatorWidth) / 2;
        float indicatorPosY = parent.getHeight() - (DP * 16);

        drawInactiveDots(canvas, indicatorStartX, indicatorPosY, itemCount);
        drawActiveDot(canvas, indicatorStartX, indicatorPosY, parent);
    }

    private void drawInactiveDots(Canvas canvas, float startX, float posY, int itemCount) {
        float itemWidth = DP * 16;
        for (int i = 0; i < itemCount; i++) {
            float x = startX + (i * itemWidth);
            canvas.drawCircle(x, posY, DP * 4, paintInactive);
        }
    }

    private void drawActiveDot(Canvas canvas, float startX, float posY, RecyclerView parent) {
        int activePosition = ((RecyclerView.LayoutManager) parent.getLayoutManager()).getPosition(parent.getFocusedChild());
        float itemWidth = DP * 16;
        float highlightX = startX + (activePosition * itemWidth);

        canvas.drawCircle(highlightX, posY, DP * 4, paintActive);
    }
}
