package com.murek.traductor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.murek.traductor.databinding.ActivityMainBinding;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //boton traducir
        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = binding.etPalabra.getText().toString();

                //Enviar palabra al main2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("palabra", palabra);
                startActivity(intent);
            }
        });

    }
}