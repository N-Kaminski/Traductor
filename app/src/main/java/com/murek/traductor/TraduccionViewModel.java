package com.murek.traductor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.HashMap;

public class TraduccionViewModel extends ViewModel {

    private final MutableLiveData<String> palabraTraducida = new MutableLiveData<>();
    private final MutableLiveData<Integer> imagenResId = new MutableLiveData<>();

    //Mapa (gracias Ari!) que tiene palabras en español y su traduccion
    private final HashMap<String, Traduccion> diccionario = new HashMap<>();
    //hashmap: clave(palabra en español)-valor(instancia de Traduccion que tiene la palabra en ingres y el id de imagen)

    public TraduccionViewModel(){
        //llenar el diccionario:
        diccionario.put("casa", new Traduccion("cat", R.drawable.casa));
        diccionario.put("conejo", new Traduccion("rabbit", R.drawable.conejo));
        diccionario.put("gato", new Traduccion("cat", R.drawable.gato));
        diccionario.put("manzana", new Traduccion("manzana", R.drawable.manzana));
        diccionario.put("nada", new Traduccion("nada", R.drawable.nada));
        diccionario.put("ñoña", new Traduccion("ninth", R.drawable.nono));
        diccionario.put("perro", new Traduccion("dog", R.drawable.perro));
    }

    //traducir la palabra
    public void traducirPalabra(String palabraEnEspanol){
        Traduccion traduccion = diccionario.get(palabraEnEspanol.toLowerCase());

        if (traduccion!=null){
            palabraTraducida.setValue(traduccion.palabraEnIngles);
            imagenResId.setValue(traduccion.imagenId);
        } else{
            palabraTraducida.setValue("No sepo tanto :(");
            imagenResId.setValue(R.drawable.nada);
        }
    }

    public LiveData<String> getPalabraTraducida() {
        return palabraTraducida;
    }

    public LiveData<Integer> getImagenResId() {
        return imagenResId;
    }

    // Clase para contener la palabra en inglés y el ID de la imagen
    private static class Traduccion {
        String palabraEnIngles;
        int imagenId;

        Traduccion(String palabraEnIngles, int imagenId) {
            this.palabraEnIngles = palabraEnIngles;
            this.imagenId = imagenId;
        }
    }
}
