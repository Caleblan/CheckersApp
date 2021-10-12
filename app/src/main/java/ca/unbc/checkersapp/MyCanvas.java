package ca.unbc.checkersapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.*;

public class MyCanvas extends View {

    public MyCanvas(Context context) {
        super(context);
    }
    public MyCanvas(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setColor(Color.BLUE);

        Rect rectangle = new Rect();
        rectangle.set(100, 200, 200, 100);
        Rect rectangle2 = new Rect();
        rectangle2.set(200, 200, 300, 100);


        canvas.drawRect(rectangle, paint);

        paint.setColor(Color.GREEN);
        canvas.drawRect(rectangle2, paint);

    }
}
