package br.edu.insper.hackathon2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonHeart = (Button) findViewById(R.id.btn_heartbeat);
        Button buttonTemp = (Button) findViewById(R.id.btn_temp);
        Button buttonMove = (Button) findViewById(R.id.btn_move);
        Button buttonOxigen = (Button) findViewById(R.id.btn_oxigen);
//        View redCircle = (View) findViewById(R.id.red_circle_main);

        assert buttonHeart != null;

        buttonHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HeartBeatActivity.class));
            }
        });

        assert buttonTemp != null;
        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TempActivity.class));
            }
        });


        assert buttonMove != null;
        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MoveActivity.class));
            }
        });


        assert buttonOxigen != null;
        buttonOxigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OxigenActivity.class));
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nurse:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
