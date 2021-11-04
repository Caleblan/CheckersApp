package ca.unbc.checkersapp;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LogPrinter;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Gameboard extends View
{
    private int boardSize;
    private int[] color = {Color.RED, Color.BLACK};
    private MatrixEntry[][] board = null;
    private GridLayout grid;
    private Context context;
    public Canvas canvas = null;
    public MatrixEntry entry;


    public Gameboard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        boardSize = 8;
    }

    public Gameboard(int boardSize, Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        this.boardSize = boardSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

        MatrixEntry[][] board = new MatrixEntry[boardSize][boardSize];

        View parentView = findViewById(R.id.MainLayout);

        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        //parentView.measure(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);

        //int width = parentView.getMeasuredWidth();

//        int viewWidth = findViewById(R.id.MainLayout).getMeasuredWidth();
//        int viewHeight = findViewById(R.id.MainLayout).getMeasuredHeight();

        //Creates board rows.
        for(int i = 0; i < boardSize; i++)
        {
            //Creates board columns.
            for(int j = 0; j < boardSize; j++)
            {
                Paint paint = new Paint();

                //Determines / Sets paint value of block
                if((i+j) % 2 == 0)
                {
                    paint.setColor(color[(i+j) % 2]);
                }
                else {
                    paint.setColor(color[(i+j) % 2]);
                }

                board[i][j] = new MatrixEntry((new Rect(j * width / boardSize, i * width / boardSize,
                        (j+1) * width / boardSize,(i+1)* width / boardSize)), paint);
                board[i][j].draw(canvas);
                entry = board[i][j];

//                ImageButton button = new ImageButton(context);
//                button.setBackgroundColor(color[(i+j) % 2]);
            }
        }
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }
}