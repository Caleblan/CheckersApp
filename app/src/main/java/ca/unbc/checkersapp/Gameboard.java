package ca.unbc.checkersapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class Gameboard extends View
{
    private int boardSize;
    private int[] color = {Color.BLUE, Color.GREEN};
    private MatrixEntry[][] board = null;
    private GridLayout grid;
    private Context context;


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

        MatrixEntry[][] board = new MatrixEntry[boardSize][boardSize];

        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;

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
                    paint.setColor(Color.BLACK);
                }
                else {
                    paint.setColor(Color.DKGRAY);
                }

                board[i][j] = new MatrixEntry((new Rect(j * width / boardSize, i * width / boardSize,
                        (j+1) * width / boardSize,(i+1)* width / boardSize)), paint);
                board[i][j].draw(canvas);

//                ImageButton button = new ImageButton(context);
//                button.setBackgroundColor(color[(i+j) % 2]);
            }
        }



    }


}