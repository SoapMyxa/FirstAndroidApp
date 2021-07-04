package com.example.test.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.test.R;


public class CircleView extends View {

    Paint paint = new Paint();
    int radius;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircleView);
        int count = typedArray.getInt(R.styleable.CircleView_fcv_count,0);
        radius = typedArray.getInt(R.styleable.CircleView_fcv_radius,100);
        typedArray.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {

        int x = getWidth() /2;
        int y = getHeight() /2;

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(x, y, radius, paint);

        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        int desiredWidth = 400;
        int desiredHeight = 400;

        /**
         * EXACTLY - если в layout_width(height) указали размер в dp(sp итд)
         * AT_MOST - если указали match_parent
         * UNSPECIFIED - если указали wrap_content
         */

        if (widthMode == View.MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == View.MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        if (heightMode == View.MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == View.MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        if (width < 0) {
            width = 0;
        }

        if (height < 0) {
            height = 0;
        }

        this.setMeasuredDimension(width, height);

    }
}
