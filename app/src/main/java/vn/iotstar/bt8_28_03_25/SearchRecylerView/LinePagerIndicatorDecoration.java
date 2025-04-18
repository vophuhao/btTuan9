package vn.iotstar.bt8_28_03_25.SearchRecylerView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {

    private static final float INDICATOR_HEIGHT = 16;
    private static final float INDICATOR_ITEM_LENGTH = 8;
    private static final float INDICATOR_ITEM_PADDING = 8;

    private final Paint paintInactive = new Paint();
    private final Paint paintActive = new Paint();

    public LinePagerIndicatorDecoration() {
        paintInactive.setStrokeCap(Paint.Cap.ROUND);
        paintInactive.setStrokeWidth(4);
        paintInactive.setStyle(Paint.Style.STROKE);
        paintInactive.setAntiAlias(true);
        paintInactive.setColor(0x66FFFFFF);

        paintActive.setStrokeCap(Paint.Cap.ROUND);
        paintActive.setStrokeWidth(4);
        paintActive.setStyle(Paint.Style.FILL);
        paintActive.setAntiAlias(true);
        paintActive.setColor(0xFFFFFFFF);
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        if (itemCount == 0) return;

        float totalLength = INDICATOR_ITEM_LENGTH * itemCount;
        float paddingBetweenItems = Math.max(0, itemCount - 1) * INDICATOR_ITEM_PADDING;
        float indicatorTotalWidth = totalLength + paddingBetweenItems;
        float indicatorStartX = (parent.getWidth() - indicatorTotalWidth) / 2f;
        float indicatorPosY = parent.getHeight() - INDICATOR_HEIGHT;

        drawInactiveIndicators(canvas, indicatorStartX, indicatorPosY, itemCount);

        View activeChild = parent.getLayoutManager().findViewByPosition(((RecyclerView.LayoutParams) parent.getChildAt(0).getLayoutParams()).getViewAdapterPosition());
        if (activeChild == null) return;
        int activePosition = parent.getChildAdapterPosition(activeChild);
        drawActiveIndicator(canvas, indicatorStartX, indicatorPosY, activePosition);
    }

    private void drawInactiveIndicators(Canvas canvas, float startX, float posY, int itemCount) {
        float itemWidth = INDICATOR_ITEM_LENGTH + INDICATOR_ITEM_PADDING;
        float x = startX;
        for (int i = 0; i < itemCount; i++) {
            canvas.drawRoundRect(new RectF(x, posY, x + INDICATOR_ITEM_LENGTH, posY + 4), 2, 2, paintInactive);
            x += itemWidth;
        }
    }

    private void drawActiveIndicator(Canvas canvas, float startX, float posY, int highlightPosition) {
        float itemWidth = INDICATOR_ITEM_LENGTH + INDICATOR_ITEM_PADDING;
        float highlightX = startX + itemWidth * highlightPosition;
        canvas.drawRoundRect(new RectF(highlightX, posY, highlightX + INDICATOR_ITEM_LENGTH, posY + 4), 2, 2, paintActive);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.set(0, 0, 0, (int) INDICATOR_HEIGHT);
    }
}
