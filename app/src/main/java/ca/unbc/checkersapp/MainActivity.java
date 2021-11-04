package ca.unbc.checkersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gameboard gameboard = (Gameboard) findViewById(R.id.Gameboard);

        gameboard.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(view instanceof Gameboard) {


                    gameboard.entry.setPaint(Color.BLUE);
                    gameboard.entry.draw(gameboard.canvas);

                    System.out.println("Blah");

                    Toast.makeText(gameboard.getContext(), "Touched layout", Toast.LENGTH_SHORT).show();

                    return true;
                }
                return false;
            }
        });
        //Gameboard gameboard = new Gameboard();
    }
}