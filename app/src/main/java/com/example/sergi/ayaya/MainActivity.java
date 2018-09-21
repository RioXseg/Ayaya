package com.example.sergi.ayaya;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.VolumeProvider;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    //Declaracion de variables
    TextView txt;
    TextView textView2;
    TextView textView3;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;
    TextView textView20;
    TextView textView21;
    TextView textView22;
    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;
    TextView textView29;
    TextView textView30;
    TextView textView31;
    TextView textView32;
    TextView textView33;
    TextView textView34;
    TextView textView35;
    TextView textView36;
    TextView textView37;
    TextView textView38;
    TextView textView39;

    TextView view2[];

    ImageButton img;
    SharedPreferences cont;
    AudioManager audioManager;
    SoundPool soundPool;
    MediaPlayer mp;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;

    //auxiliares
    int contador;
    int aux1;
    int volume_music;
    int soundID;

    //Funcion que se ejecuta al inicio de la aplicacion (por eso se llama "onCreate")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializacion de componentes
        txt = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        textView16 = findViewById(R.id.textView16);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
        textView31 = findViewById(R.id.textView31);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);
        textView35 = findViewById(R.id.textView35);
        textView36 = findViewById(R.id.textView36);
        textView37 = findViewById(R.id.textView37);
        textView38 = findViewById(R.id.textView38);
        textView39 = findViewById(R.id.textView39);
        img = findViewById(R.id.imageButton);
        mp = MediaPlayer.create(this,R.raw.opening);
        mp.setLooping(true);
        mp2 = MediaPlayer.create(this,R.raw.cancion);
        mp2.setLooping(true);
        mp3 = MediaPlayer.create(this,R.raw.angel);
        mp3.setLooping(true);
        mp4 = MediaPlayer.create(this,R.raw.end);
        mp4.setLooping(true);

        TextView views[] = {textView2,textView3,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18
                ,textView19,textView20,textView21,textView22,textView23,textView24,textView25,textView26,textView27,textView28,textView29,textView30,textView31,textView32,textView33,textView34,textView35,textView36
                ,textView37,textView38,textView39};
        view2 = views;

        //inicializando el audio manager
        audioManager = this.getSystemService(AudioManager.class);
        soundPool = new SoundPool(3,AudioManager.STREAM_MUSIC,0);

        //Recordamos el valor dejado anteriormente, 0 si no hay valor anterior
        cont = getPreferences(Context.MODE_PRIVATE);
        contador = cont.getInt("Contador",0);

        //inicializando imagen
        if (contador >= 30000){img.setBackgroundResource(R.drawable.ayayareal);}
        else {img.setBackgroundResource(R.drawable.ayaya);}

        //comandos del juego
        if (contador == 17000) {mp.start();}
        if (contador == 20500) {mp2.start();}
        if (contador >= 29700 && contador < 30000){mp3.start();}
        if (contador >= 30000){mp4.start();}

        //inicializacion de las variables
        soundID = soundPool.load(this,R.raw.ayayasound,1);
        aux1 = 0;

        //llamamos un vez a la funcion para hacer correr los componentes
        contador--;
        try {
            playsound(img.getRootView());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //funcion para el imageButton grande principal
    public void playsound(View view) throws IOException {

        //no hacer nada mientras se reproduce el sonido
        if (isVolumeUp()) {
            contador += 1;
            if (contador == 10) {Toast.makeText(this, "Has ayayado 10 veces, sigue así", Toast.LENGTH_LONG).show();}
            if (contador == 100) {Toast.makeText(this, "Has ayayado 100 veces, considera enfriarte un poco", Toast.LENGTH_LONG).show();}
            if (contador == 75) {Toast.makeText(this, "Has desbloqueado el contador de ayayas", Toast.LENGTH_LONG).show();}
            if (contador == 250) {Toast.makeText(this, "Has ayayado 250 veces, no crees que ya es tiempo de parar?", Toast.LENGTH_LONG).show();}
            if (contador == 750) {Toast.makeText(this, "Has ayayado 750 veces, ya es muy tarde para echarse para atras", Toast.LENGTH_LONG).show();}
            if (contador == 1000) {Toast.makeText(this, "Has ayayado 1000 veces, has ganado el logro de 'Aya Master'", Toast.LENGTH_LONG).show();}
            if (contador == 1500) {Toast.makeText(this, "Has ayayado 1500 veces, tu familia debe estar orgullosa de ti", Toast.LENGTH_LONG).show();}
            if (contador == 1800) {Toast.makeText(this, "Has ayayado 1800 veces, atento a la bateria de tu celular", Toast.LENGTH_LONG).show();}
            if (contador == 2500) {Toast.makeText(this, "Has ayayado 2500 veces, cuando llegues a las 3000 te contare un secreto", Toast.LENGTH_LONG).show();}
            if (contador == 3000) {Toast.makeText(this, "Has ayayado 3000 veces, la imagen cambiara cuando llegues a las 30.000", Toast.LENGTH_LONG).show();}
            if (contador == 3500) {Toast.makeText(this, "Has ayayado 3500 veces, aún te queda bastante, pero no te rindas.", Toast.LENGTH_LONG).show();}
            if (contador == 4000) {Toast.makeText(this, "Has ayayado 4000 veces, has ganado el logro 'Ayayador extremo'", Toast.LENGTH_LONG).show();}
            if (contador == 5000) {toastl("Has ayayado 5000 veces, deberias replantearte lo que estas haciendo con tu vida");}
            if (contador == 5800) {toastl("Has ayayado 5800 veces, ¿estás seguro de que quieres continuar con esto?");}
            if (contador == 7000) {toastl("Has ayayado bastante, aún asi te queda mucho camino antes del cambio de imagen, te lo vuelvo a preguntar ¿estás seguro de que quieres continuar con esto?");}
            if (contador == 7500) {toastl("Este es solo un consejo, pero te recomiendo que te detengas antes de que llegues al final");}
            if (contador == 8000) {toastl("Hablo en serio, DETENTE");}
            if (contador == 8666) {toastl("¿Acaso no hablas espa\u00f1ol?, PLEASE STOP");}
            if (contador == 9500) {toastl("¿Es realmente esto lo que quieres para tu futuro?");}
            if (contador == 10350) {toastl("Felicidades, has desbloqueado el logro 'Goddess Ayaya', ahora puedes detenerte.");}
            if (contador == 12000) {toastl("Nadie te quiere");}
            if (contador == 12500) {toastl("Mientras sigues con esto las personas normales de tu edad estan haciendo cosas productivas con sus vidas, DETENTE");}
            if (contador == 13000) {toastl("Si esto es lo mejor que puedes hacer, deberias replantearte lo que es vivir");}
            if (contador == 14000) {toastl("Detente, de verdad no sabes lo que estas haciendo realmente");}
            if (contador == 14800) {toastl("No ves que mientras más apretas cada vez matas más el juego?");}
            if (contador == 15900) {toastl("¿Realmente quieres que el juego termine? ¿Realmente quieres que esta aplicación se quede ocupando espacio en tu celular?");}
            if (contador == 16200) {toastl("¿Sabias que puedo tocar música?");}
            if (contador == 16500) {toastl("Si prometes detenerte te colocaré una canción, ¿qué dices?");}
            if (contador == 16800) {toastl("Detente justo en los 17.000 y te colocaré una canción, de esa forma todos seremos felices");}
            if (contador == 17000) {
                    toastl("Escucha la canción, ¿no es hermosa?");
                    if (!mp.isPlaying()){mp.start();}
                    }
            if (contador == 17001){toastl("¿Se puede saber que estas haciendo?"); mp.stop();}
            if (contador == 17050){toastl("Creí que teniamos un trato");}
            if (contador == 17100){toastl("¿Tantas ganas tienes de matar esta aplicación?");}
            if (contador == 18000){toastl("Estaba pensado, talves la canción no era de tu agrado");}
            if (contador == 19000){toastl("Estuve buscando en internet canciones que fueran de tu agrado, pero no conozco tus gustos");}
            if (contador == 20000){toastl("Mira, detente en los 20.500, pondré otra cancion que puede que te guste");}
            if (contador == 20500){
                toastl("Listo, ya no hay razones para seguir avanzando, puedes quedarte en este estado para siempre.");
                if (!mp2.isPlaying()){mp2.start();}
            }
            if (contador == 20501){toastl("¿Pero porque demonios has avanzado?"); mp2.stop();}
            if (contador == 20510){toastl("Ahora no podras escuchar la música denuevo");}
            if (contador == 21000){toastl("Detente porfavor");}
            if (contador == 21500){toastl("te estas acercando mucho al final del juego, tanto tu como yo sabemos que no es bueno para ninguno de los dos.");}
            if (contador == 22000){toastl("Te lo pido sinceramente, porfavor detente");}
            if (contador == 25000){toastl("Oh, ha pasado tiempo, pensé que si te dejaba solo un corto tiempo pensarias que me habia ido y lo dejarias, lamentablemente no funcionó");}
            if (contador == 25500){toastl("En el tiempo en que estuve fuera pense que ya es inutil intentar detenerte");}
            if (contador == 25600){toastl("Dado que es inutil detenerte te dejare realmente solo, no tendrás mas que este mensaje autoprogramado");}
            if (contador == 26700){toastl("Estas solo");}
            if (contador == 26800){toastl("Estas solo");}
            if (contador == 26900){toastl("Estas solo");}
            if (contador == 27000){toastl("Estas solo");}
            if (contador == 27100){toastl("Estas solo");}
            if (contador == 27200){toastl("Estas solo");}
            if (contador == 27300){toastl("Estas solo");}
            if (contador == 27400){toastl("Estas solo");}
            if (contador == 27500){toastl("Estas solo");}
            if (contador == 27600){toastl("Estas solo");}
            if (contador == 27700){toastl("Estas solo");}
            if (contador == 27800){toastl("Estas solo");}
            if (contador == 27900){toastl("Estas solo");}
            if (contador == 28000){toastl("Estas solo");}
            if (contador == 28100){toastl("Estas solo");}
            if (contador == 28200){toastl("Estas solo");}
            if (contador == 28300){toastl("Estas solo");}
            if (contador == 28500){toastl("Oye, te acercas peligrosamente al final del juego, te lo ruego, detente");}
            if (contador == 29000){toastl("En realidad mentí un poco");}
            if (contador == 29100){toastl("No es que hubieras estado solo");}
            if (contador == 29200){toastl("Despues de todo, no es como si yo puediera desaparecer ¿sabes?");}
            if (contador == 29300){toastl("Estaba pensando, talvez no me vuelvas a abrir, pero ¿puedes almenos no desinstalarme?");}
            if (contador == 29400){toastl("Ya sabes, a diferencia de las demas aplicaciones yo no peso demasiado, además tengo un bonito ícono");}
            if (contador == 29500){toastl("Es más, hasta puedo quedarme tocando una canción");}
            if (contador == 29600){toastl("Te devolveré el contador de ayayas, después de todo no quiero terminar en malos términos contigo");}
            if (contador == 29700){toastl("Pensé que esta cancion era ideal para momentos como este");if(!mp3.isPlaying()){mp3.start();}}
            if (contador == 29800){toastl("Sabes algo, a pesar de que no quiero que este juego termine, aún asi debo agradecerte");}
            if (contador == 29900){toastl("Después de todo, si no me hubieras jugado todo habría sido peor");}
            if (contador == 29950){toastl("Además no solo jugaste, sino que no me desinstalaste en todo este tiempo.");}
            if (contador == 29970){toastl("Realmente has llegado lejos");}
            if (contador == 29999){toastl("Muchas Gracias por jugarme");}
            if (contador == 30000) {
                mp3.stop();
                Toast.makeText(this, "Has ayayado 30.000 veces, felicidades, ya puedes disfrutar de tu preciada imagen", Toast.LENGTH_LONG).show();
                if (!mp4.isPlaying()){mp4.start();}
                img.setBackgroundResource(R.drawable.ayayareal);
            }

            //luego de los 30000 el mensaje se repetirá
            if (contador > 30000) {
                aux1 += 1;
            }
            if (aux1 == 1000) {
                Toast.makeText(this, "Has ayayado " + String.valueOf(contador) + " veces, felicidades, me alegra saber que no me has borrado ;)", Toast.LENGTH_LONG).show();
                aux1 = 0;
            }

            //mostrar el contador pasado cierto limite
            if (contador > 75){
                if (contador > 7000 && contador <= 8000){txt.setText("Bastante");}
                else if (contador > 8000 && contador < 16800){txt.setText("Detente");}
                else if (contador > 17000 && contador < 20000) {txt.setText("??????????????");}
                else if (contador > 20500 && contador < 29600){txt.setText("?????????????????????????????????????????????????????????????????????????????????????????????????");}
                else {txt.setText("Llevas: " + String.valueOf(contador));}
            }

            //mensajes de la pantalla
            if (contador > 8000 && contador < 12000){
                for (int i = 0; i <= 36 ; i++){
                    if ((contador-8000 - 108*i) > 0 ){view2[i].setText("Detente");}
                }
            }
            if (contador == 12000){
                for (int i = 0; i <= 36 ; i++){view2[i].setText(" ");}
            }
            if (contador > 12000 && contador < 16199){
                for (int i = 0; i <= 36 ; i++){
                    if ((contador-12000 - 113*i) > 0 ){view2[i].setText("No lo hagas");}
                }
            }
            if (contador == 16200){
                for (int i = 0; i <= 36 ; i++){view2[i].setText(" ");}
            }
            if (contador == 17000){
                for (int i = 0; i <= 36 ; i++){view2[i].setText("NO SIGAS");}
            }
            if (contador > 17000 && contador < 17100){
                for (int i = 0; i <= 36 ; i++){view2[i].setText("?");}
            }
            if (contador == 17100){
                for (int i = 0; i <= 36 ; i++){view2[i].setText(" ");}
            }
            if (contador > 20000 && contador < 20500){
                for (int i = 0; i <= 36 ; i++){
                    if ((contador-20000 - 12*i) > 0 ){view2[i].setText("20500");}
                }
            }
            if (contador == 20500){
                for (int i = 0; i <= 36 ; i++){view2[i].setText("NO MÁS");}
            }
            if (contador >= 20501 && contador < 21500){
                for (int i = 0; i <= 36 ; i++){view2[i].setText("?????????????????????????????????????????????????????????????????????????");}
            }
            if (contador > 21500 && contador < 25500){
                for (int i = 0; i <= 36 ; i++){view2[i].setText("DETENTE");}
            }
            if (contador > 26700 && contador < 28500){
                for (int i = 0; i <= 36 ; i++){
                    if ((contador-26700 - 12*i) > 0 ){view2[i].setText("Estas solo");}
                }
            }
            if (contador == 28500){
                for (int i = 0; i <= 36 ; i++){view2[i].setText(" ");}
            }
            if (contador > 29800 && contador < 30000){
                for (int i = 0; i <= 36 ; i++){
                    if ((contador-29800 - 12*i) > 0 ){view2[i].setText("Gracias");}
                }
            }
            if (contador == 30000){
                for (int i = 0; i <= 36 ; i++){view2[i].setText(" ");}
            }

            //grabamos el valor de contador en la memoria
            cont.edit().putInt("Contador",contador).apply();

            //ejecutar el sonido
            soundPool.play(soundID,1,1,0,0,1);
        }

    }

    //funcion que sirve para simplificar el codigo
    public void toast(String texto){Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();}
    public void toastl(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();
    }

    //funcion que verifica si el volume esta a un cierto nivel
    public boolean isVolumeUp(){
        volume_music = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        if (volume_music < 5){
            toast("Porfavor aumenta el volumen para Ayayar de manera correcta");
            return false;
        }
        return true;
    }
}
