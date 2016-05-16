package br.edu.insper.hackathon2;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HeartBeatActivity extends AppCompatActivity {

    private int heartbeat;
    private Random r;
    private final int high = 240;
    private final int low = 140;
    private TextView mensagem;
    private final String frase = "Seu pai pode estar correndo perigo!";
    private View redCircle;
    private View greenCircle;
    private View yellowCircle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat);


        r = new Random();

        this.redCircle = (View) findViewById(R.id.red_circle);
        this.greenCircle = (View) findViewById(R.id.green_circle);
        this.yellowCircle = (View) findViewById(R.id.yellow_circle);


        heartbeat = r.nextInt(180 - low) + low;
        this.mensagem = (TextView) findViewById(R.id.text_heart_beat);

        if(heartbeat >= 200) {
            this.redCircle.setVisibility(View.VISIBLE);
            this.greenCircle.setVisibility(View.INVISIBLE);
            this.yellowCircle.setVisibility(View.INVISIBLE);
        } else if(heartbeat >= 160) {
            this.redCircle.setVisibility(View.INVISIBLE);
            this.greenCircle.setVisibility(View.INVISIBLE);
            this.yellowCircle.setVisibility(View.VISIBLE);
        } else {
            this.redCircle.setVisibility(View.INVISIBLE);
            this.greenCircle.setVisibility(View.VISIBLE);
            this.yellowCircle.setVisibility(View.INVISIBLE);
        }



        assert this.mensagem != null;
        this.mensagem.setText(String.valueOf(heartbeat));

        final CountDownTimer espaco = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onFinish() {
                heartbeat = r.nextInt(high - low) + low;
                System.out.println(heartbeat);
                mensagem.setText(String.valueOf(heartbeat));
                if(heartbeat >= 200) {
                    redCircle.setVisibility(View.VISIBLE);
                    greenCircle.setVisibility(View.INVISIBLE);
                    yellowCircle.setVisibility(View.INVISIBLE);
                } else if(heartbeat >= 160) {
                    redCircle.setVisibility(View.INVISIBLE);
                    greenCircle.setVisibility(View.INVISIBLE);
                    yellowCircle.setVisibility(View.VISIBLE);
                } else {
                    redCircle.setVisibility(View.INVISIBLE);
                    greenCircle.setVisibility(View.VISIBLE);
                    yellowCircle.setVisibility(View.INVISIBLE);
                }


                if (heartbeat > 220) {
                    ligar("996003399");
                    
                } else {
                    this.start();
                }
            }

        }.start();


    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void ligar(String phone) {
        // PC - Código para enviar SMS (basicamente o código do Hashimoto com o fato
        //      de que não é permitido enviar mensagens vazias

        System.out.println("Frase à ser enviada: " + this.frase);
        SmsManager manager = SmsManager.getDefault();

        if (PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
            manager.sendTextMessage(phone, null, this.frase, null, null);
        }
    }
}