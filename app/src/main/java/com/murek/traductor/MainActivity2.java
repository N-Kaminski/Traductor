package com.murek.traductor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.murek.traductor.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private TraduccionViewModel traduccionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Inicializo el viewModel
        traduccionViewModel = new ViewModelProvider(this).get(TraduccionViewModel.class);

        //Obtengo la palabra de Intent
        String palabraOriginal = getIntent().getStringExtra("palabra");

        //hago la traduccion
        traduccionViewModel.traducirPalabra(palabraOriginal);

        traduccionViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabraTraducida) {
                binding.tvPalabraTraducida.setText(palabraTraducida);
            }
        });

        traduccionViewModel.getImagenResId().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagenResId) {
                binding.imgPalabra.setImageResource(imagenResId);
            }
        });

    }
}