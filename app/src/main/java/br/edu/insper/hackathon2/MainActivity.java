package br.edu.insper.hackathon2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text_title);

        Button buttonHeart = (Button) findViewById(R.id.btn_heartbeat);
        Button buttonTemp = (Button) findViewById(R.id.btn_temp);
        Button buttonMove = (Button) findViewById(R.id.btn_move);
        Button buttonOxigen = (Button) findViewById(R.id.btn_oxigen);

        assert buttonHeart != null;

        buttonHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HeartBeatActivity.class));
            }
        });



    }
}
