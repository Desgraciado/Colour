package at.maliweb.colour;

import android.content.Intent;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nextPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextPageButton = (Button) findViewById(R.id.nextPageButton);

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),ColoursetActivity.class);
                int[] color = ColourThief.getColor("/DCIM/Camera", "tatooed_hand.JPG");

                //Log.i("Colour: ", color[0]+" "+color[1]+" "+color[2]);
                intent.putExtra("room_name","Red" );
                intent.putExtra("user_name","Color#"+color[0]+" "+color[1]+" "+color[2]);
                intent.putExtra("extractedCol", color);
                startActivity(intent);
            }
        });
    }
}
