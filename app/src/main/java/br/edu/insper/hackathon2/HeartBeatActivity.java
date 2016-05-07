package br.edu.insper.hackathon2;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HeartBeatActivity extends AppCompatActivity {

    private int heartbeat;
    private Random r;
    private final int high = 260;
    private final int low = 100;
    private TextView mensagem;
    private final String frase = "Seu pai morreu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat);


        r = new Random();

        heartbeat = r.nextInt(140 - low) + low;
        this.mensagem = (TextView) findViewById(R.id.text_heart_beat);

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

                if (heartbeat > 250) {
                    mensagem.setText("0");
                    Toast.makeText(HeartBeatActivity.this, "Morreu!", Toast.LENGTH_SHORT).show();
                    ligar("996003399");
                    this.cancel();
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