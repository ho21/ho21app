package com.example.test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.R;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class myView extends View{

    public myView(Context context) {
        super(context);
        this.setWillNotDraw(false);
    }

    public myView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.myView,0,0);
//        Log.e("------------", String.valueOf(typedArray.getString(R.styleable.myView_thisText)));
//        Log.e("------------", String.valueOf(typedArray.getBoolean(R.styleable.myView_isShow,false)));
        this.setWillNotDraw(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(600, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint a circle
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(120, 80, 60, paint);

        //paint string
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(20);
        canvas.drawText("My name is Linc!",245,140,paint);

        //draw line
        paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawLine(245,145,500,145,paint);
    }
}
