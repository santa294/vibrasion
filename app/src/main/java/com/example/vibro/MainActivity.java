package com.example.vibro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button vibrate_btn = findViewById(R.id.vibrate_btn);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long[] pattern ={50,50};
        vibrate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vibrate_btn.getText().toString().equals("Начать жёсткую вибрацию")){
                    vibrator.vibrate(pattern,0);
                    Toast.makeText(MainActivity.this,"Начинай",Toast.LENGTH_SHORT).show();
                    vibrate_btn.setText("Остановитесь");
                }
                else{
                    vibrator.cancel();
                    vibrate_btn.setText("Начать жёсткую вибрацию");
                    Toast.makeText(MainActivity.this,"Останавливай",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}