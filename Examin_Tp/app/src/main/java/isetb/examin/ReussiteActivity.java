package isetb.examin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReussiteActivity extends AppCompatActivity {
TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussite);

        txt1=findViewById(R.id.ree);
    }
}