package ca.unbc.checkersapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MatrixEntry{

    private Rect square;
    private Paint paint;
    private Piece piece = null;
    private ImageButton button;

    public MatrixEntry(Rect square, Paint paint)
    {
        this.square = square;
        this.paint = paint;
        //button.setBackgroundColor(paint.getColor());

    }

    /**
     *
     * @param canvas
     */
    public void draw(Canvas canvas)
    {
        canvas.drawRect(square, paint);
        //button.setX(square.centerX());
        //button.setY(square.centerY());
    }

    public Rect getSquare() {
        return square;
    }

    public Piece getPiece()
    {
        return piece;
    }

//    public Paint getPaint() { return paint; }

    /**
     * Sets color member variable. Although it is already set in constructor,
     * this method is useful to be able to show the possible moves a piece can
     * take by altering matrix entry colors.
     *
     * @param paint Represents colour of matrix entry as an integer value.
     */
    public void setPaint(Paint paint)
    {
        this.paint = paint;

    }
}
