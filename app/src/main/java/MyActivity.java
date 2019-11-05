import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.diceroller.R;

import java.util.Random;

public class MyActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView add = (TextView) findViewById(R.id.add);
        final Button button = findViewById(R.id.randGen);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
                Random random = new Random();
                int ran = random.nextInt((6-1)+1)+1;
                String rg = Integer.toString(ran);
                add.setText("" + rg);
            }
        });
    }
}
