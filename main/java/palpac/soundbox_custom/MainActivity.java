package palpac.soundbox_custom;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import static android.graphics.drawable.Drawable.createFromPath;

public class MainActivity extends AppCompatActivity {

    Button VB01 = null;      // Bouttons
    Button VB02 = null;
    Button VB03 = null;
    Button VB04 = null;
    Button VB05 = null;
    Button VB06 = null;
    Button VB07 = null;
    Button VB08 = null;
    Button VB09 = null;
    Button VB10 = null;
    Button VB11 = null;
    Button VB12 = null;
    Button VB13 = null;
    Button VB14 = null;
    Button VB15 = null;
    Button VB16 = null;
    Button VB17 = null;
    Button VB18 = null;
    Button VB19 = null;
    Button VB20 = null;
    Button VB21 = null;

    public MediaPlayer media1;     // Mediaplayer
    public boolean BooleanMedia1IsPlaying; // Flag lecture = true, stopped = false
    public int INTENT_RETURN_ID = 0; // L'identifiant de la chaîne de caractères qui contient le résultat de l'intent
    public int bouton_en_cours = 0; // Flag numéro bouton en cours pour mise à jour après prédérence
    public String Audio_File_Path = ""; // Chemin fichier audio sdcard
    public String Image_File_Path = ""; // Chemin fichier image sdcard
    public String No_sound = "No_sound";
    public String No_image = "No_image";
    public String sdcard_res_path; // Chemin SDcard
    public String sdcard_images_path; // Chemin SDcard images
    public String sdcard_sounds_path; // Chemin SDcard sounds
    public String waouh_son_path; // Chemin waouh sounds
    public String waouh_image_path; // Chemin waouh image
    public String first_run = null;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar); // handle toolbar from id
        setSupportActionBar(toolbar); // Set toolbar as an actionbar

        VB01 = findViewById(R.id.B01);     // Rattachement boutton à ceux du layouts
        VB02 = findViewById(R.id.B02);
        VB03 = findViewById(R.id.B03);
        VB04 = findViewById(R.id.B04);
        VB05 = findViewById(R.id.B05);
        VB06 = findViewById(R.id.B06);
        VB07 = findViewById(R.id.B07);
        VB08 = findViewById(R.id.B08);
        VB09 = findViewById(R.id.B09);
        VB10 = findViewById(R.id.B10);
        VB11 = findViewById(R.id.B11);
        VB12 = findViewById(R.id.B12);
        VB13 = findViewById(R.id.B13);
        VB14 = findViewById(R.id.B14);
        VB15 = findViewById(R.id.B15);
        VB16 = findViewById(R.id.B16);
        VB17 = findViewById(R.id.B17);
        VB18 = findViewById(R.id.B18);
        VB19 = findViewById(R.id.B19);
        VB20 = findViewById(R.id.B20);
        VB21 = findViewById(R.id.B21);

        VB01.setOnClickListener(VB01Listener); // Déclaration d'un listener pour chaque bouton
        VB02.setOnClickListener(VB02Listener);
        VB03.setOnClickListener(VB03Listener);
        VB04.setOnClickListener(VB04Listener);
        VB05.setOnClickListener(VB05Listener);
        VB06.setOnClickListener(VB06Listener);
        VB07.setOnClickListener(VB07Listener);
        VB08.setOnClickListener(VB08Listener);
        VB09.setOnClickListener(VB09Listener);
        VB10.setOnClickListener(VB10Listener);
        VB11.setOnClickListener(VB11Listener);
        VB12.setOnClickListener(VB12Listener);
        VB13.setOnClickListener(VB13Listener);
        VB14.setOnClickListener(VB14Listener);
        VB15.setOnClickListener(VB15Listener);
        VB16.setOnClickListener(VB16Listener);
        VB17.setOnClickListener(VB17Listener);
        VB18.setOnClickListener(VB18Listener);
        VB19.setOnClickListener(VB19Listener);
        VB20.setOnClickListener(VB20Listener);
        VB21.setOnClickListener(VB21Listener);

        VB01.setOnLongClickListener(VB01LongListener); // Déclaration d'un listener clic long
        VB02.setOnLongClickListener(VB02LongListener);
        VB03.setOnLongClickListener(VB03LongListener);
        VB04.setOnLongClickListener(VB04LongListener);
        VB05.setOnLongClickListener(VB05LongListener);
        VB06.setOnLongClickListener(VB06LongListener);
        VB07.setOnLongClickListener(VB07LongListener);
        VB08.setOnLongClickListener(VB08LongListener);
        VB09.setOnLongClickListener(VB09LongListener);
        VB10.setOnLongClickListener(VB10LongListener);
        VB11.setOnLongClickListener(VB11LongListener);
        VB12.setOnLongClickListener(VB12LongListener);
        VB13.setOnLongClickListener(VB13LongListener);
        VB14.setOnLongClickListener(VB14LongListener);
        VB15.setOnLongClickListener(VB15LongListener);
        VB16.setOnLongClickListener(VB16LongListener);
        VB17.setOnLongClickListener(VB17LongListener);
        VB18.setOnLongClickListener(VB18LongListener);
        VB19.setOnLongClickListener(VB19LongListener);
        VB20.setOnLongClickListener(VB20LongListener);
        VB21.setOnLongClickListener(VB21LongListener);

        sdcard_res_path = Environment.getExternalStorageDirectory().toString() + "/Android/data/SoundBoxCustom";
        sdcard_images_path = sdcard_res_path + "/Images";
        sdcard_sounds_path = sdcard_res_path + "/Sounds";
        waouh_son_path = sdcard_res_path + "/Sounds/Waouh.mp3";
        waouh_image_path = sdcard_res_path + "/Images/Waouh.png";

        copy_res_to_sd (); // Mise à dispo fichiers images et sons dans SDcard pour utilisateur
        first_run_void (); // Modifier Bouton 1 seulement au premier lancement pour exemple à l'utilisateur
        maj_preferences (); // Mise à jour libellés et images des bouttons

    }

    //////////////////////////////////////////////////////////////////////////////////////////////// Fonctions MEDIAPlAYER
    protected void VerifMedia1Paying (){  // Vérif si mediaplayer en lecture
        if (BooleanMedia1IsPlaying) { // Si lecture en cours
            media1.stop(); // Arret lecture
            media1.release(); // Libere Mediplayer
        }
    }
    protected void LanceMedia1 (){ // Lance mediaplayer
        media1.start(); // Lecture
        BooleanMedia1IsPlaying = media1.isPlaying(); // A utiliser après start
    }

    /////////////////////////////////////////////////////////////////////////////////////////////// Simple click listeners
    private View.OnClickListener VB01Listener = new View.OnClickListener() { // Listener image 1
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); // Déclaration préférences pour lecture/ecriture
            Audio_File_Path = SP.getString("B01_son", No_sound); // Lecture son bouton B01
            if (!No_sound.equals(Audio_File_Path)) { // Si son existe
                VerifMedia1Paying (); // Appel fonction verif si lecture en cours
                try { // Tentative preparation Mediaplayer
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path)); // Chargement du son
                    LanceMedia1 (); // Appel fonction lecture son
                }
                catch (Exception e) { // Si échec
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show(); // Alerte
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); // Dans préférence
                    SharedPreferences.Editor editor = preferences.edit(); // Mode edition
                    editor.putString("B01_son", No_sound); // Suppression son existant
                    editor.apply(); // Sauvegarde
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh); // Chargement d'un son correct pour debugger Mediaplayer
                }
            }
        }
    };
    private View.OnClickListener VB02Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B02_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B02_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };
    private View.OnClickListener VB03Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B03_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B03_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };
    private View.OnClickListener VB04Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B04_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B04_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };
    private View.OnClickListener VB05Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B05_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B05_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };
    private View.OnClickListener VB06Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B06_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B06_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB07Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B07_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B07_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB08Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B08_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B08_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB09Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B09_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B09_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB10Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B10_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B10_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB11Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B11_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B11_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB12Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B12_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B12_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB13Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B13_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B13_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB14Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B14_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B14_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB15Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B15_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B15_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB16Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B16_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B16_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB17Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B17_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B17_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB18Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B18_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B18_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB19Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B19_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B19_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB20Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B20_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B20_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    private View.OnClickListener VB21Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            Audio_File_Path = SP.getString("B21_son", No_sound);
            if (!No_sound.equals(Audio_File_Path)) {
                VerifMedia1Paying ();
                try {
                    media1 = MediaPlayer.create(getBaseContext(), Uri.parse(Audio_File_Path));
                    LanceMedia1 ();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.sound_file_error) + " " + Audio_File_Path, Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("B21_son", No_sound);
                    editor.apply();
                    media1 = MediaPlayer.create(getBaseContext(), R.raw.waouh);
                }
            }
        }
    };

    /////////////////////////////////////////////////////////////////////////////////////////////// LONG click listeners
    private View.OnLongClickListener VB01LongListener = new View.OnLongClickListener() { // Long clic Listener image 1
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 1; // declaration bouton 1 pour maj apres preference
            sauv_libelle(); // sauvegarde libelle actuel pour affichage dans EditText de modif bouton
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB02LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 2;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB03LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 3;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB04LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 4;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB05LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 5;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB06LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 6;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB07LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 7;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB08LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 8;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB09LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 9;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB10LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 10;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB11LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 11;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB12LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 12;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB13LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 13;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB14LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 14;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB15LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 15;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB16LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 16;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB17LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 17;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB18LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 18;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB19LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 19;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB20LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 20;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };
    private View.OnLongClickListener VB21LongListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            bouton_en_cours = 21;
            sauv_libelle();
            lance_preferences();
            return false;
        }
    };



    //////////////////////////////////////////////////////////////////////////////////////////////// PREFERENCES
    protected  void  maj_preferences () {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); // Dans préférence
        SharedPreferences.Editor editor = preferences.edit(); // Mode edition
        String B01_libelle = preferences.getString("B01_libelle", "Button 01"); // Lecture libellé boutons perso
        String B02_libelle = preferences.getString("B02_libelle", "Button 02");
        String B03_libelle = preferences.getString("B03_libelle", "Button 03");
        String B04_libelle = preferences.getString("B04_libelle", "Button 04");
        String B05_libelle = preferences.getString("B05_libelle", "Button 05");
        String B06_libelle = preferences.getString("B06_libelle", "Button 06");
        String B07_libelle = preferences.getString("B07_libelle", "Button 07");
        String B08_libelle = preferences.getString("B08_libelle", "Button 08");
        String B09_libelle = preferences.getString("B09_libelle", "Button 09");
        String B10_libelle = preferences.getString("B10_libelle", "Button 10");
        String B11_libelle = preferences.getString("B11_libelle", "Button 11");
        String B12_libelle = preferences.getString("B12_libelle", "Button 12");
        String B13_libelle = preferences.getString("B13_libelle", "Button 13");
        String B14_libelle = preferences.getString("B14_libelle", "Button 14");
        String B15_libelle = preferences.getString("B15_libelle", "Button 15");
        String B16_libelle = preferences.getString("B16_libelle", "Button 16");
        String B17_libelle = preferences.getString("B17_libelle", "Button 17");
        String B18_libelle = preferences.getString("B18_libelle", "Button 18");
        String B19_libelle = preferences.getString("B19_libelle", "Button 19");
        String B20_libelle = preferences.getString("B20_libelle", "Button 20");
        String B21_libelle = preferences.getString("B21_libelle", "Button 21");
        VB01.setText(B01_libelle); // mise à jour libellé bouton perso 1
        VB02.setText(B02_libelle);
        VB03.setText(B03_libelle);
        VB04.setText(B04_libelle);
        VB05.setText(B05_libelle);
        VB06.setText(B06_libelle);
        VB07.setText(B07_libelle);
        VB08.setText(B08_libelle);
        VB09.setText(B09_libelle);
        VB10.setText(B10_libelle);
        VB11.setText(B11_libelle);
        VB12.setText(B12_libelle);
        VB13.setText(B13_libelle);
        VB14.setText(B14_libelle);
        VB15.setText(B15_libelle);
        VB16.setText(B16_libelle);
        VB17.setText(B17_libelle);
        VB18.setText(B18_libelle);
        VB19.setText(B19_libelle);
        VB20.setText(B20_libelle);
        VB21.setText(B21_libelle);
        //B01
        String B01_son = preferences.getString("B01_son", No_sound); // Lecture son bouton 01
        File B01_file_test_son = new File(B01_son); // Déclaration chemin son pour verification existance fichier
        if (!No_sound.equals(B01_son)) { // Si pas no_sound
            if(!B01_file_test_son.exists()) { // Si fichier existe pas
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show(); // Alerte son existe pas!
                editor.putString("B01_son", No_sound); // Sauvegarde no_sound bouton 1
            }
        }
        String B01_image = preferences.getString("B01_image", No_image); // Lecture image bouton 01
        if (No_image.equals(B01_image)) { // Si no_image
            VB01.setBackgroundResource(R.drawable.blue); // Chargement image par defaut bouton 01
        }
        else { // Sinon
            File B01_file_test_image = new File(B01_image); // Déclaration chemin image pour verification existance fichier
            if(B01_file_test_image.exists()) { // Si fichier existe
                BitmapFactory.Options options = new BitmapFactory.Options(); // Declaration BitmapFactory pour test fichier image
                options.inJustDecodeBounds = true; // Option decodage image
                Bitmap bitmap1 = BitmapFactory.decodeFile(B01_image, options); // Tentative decodate fichier image
                if (options.outWidth != -1 && options.outHeight != -1) { // Si décodage réussi
                    VB01.setBackground(createFromPath(B01_image)); // Maj image Bouton1
                }
                else { // Si decodage image en échec
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B01_image, Toast.LENGTH_SHORT).show(); // Alerte fichier non image
                    editor.putString("B01_image", No_image); // Suppression chemin image en erreur
                    VB01.setBackgroundResource(R.drawable.blue); // Chargement image par defaut bouton 01
                }
            }
            else { // Si fichier existe pas
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show(); // Alerte image existe pas !
                editor.putString("B01_image", No_image); // Sauvegarde no_image
                VB01.setBackgroundResource(R.drawable.blue); // Chargement image par defaut bouton 01
            }
        }
        //B02
        String B02_son = preferences.getString("B02_son", No_sound);
        File B02_file_test_son = new File(B02_son);
        if (!No_sound.equals(B02_son)) {
            if(!B02_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B02_son", No_sound);
            }
        }
        String B02_image = preferences.getString("B02_image", No_image);
        if (No_image.equals(B02_image)) {
            VB02.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B02_file_test_image = new File(B02_image);
            if(B02_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap2 = BitmapFactory.decodeFile(B02_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB02.setBackground(createFromPath(B02_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B02_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B02_image", No_image);
                    VB02.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B02_image", No_image);
                VB02.setBackgroundResource(R.drawable.blue);
            }
        }
        //B03
        String B03_son = preferences.getString("B03_son", No_sound);
        File B03_file_test_son = new File(B03_son);
        if (!No_sound.equals(B03_son)) {
            if(!B03_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B03_son", No_sound);
            }
        }
        String B03_image = preferences.getString("B03_image", No_image);
        if (No_image.equals(B03_image)) {
            VB03.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B03_file_test_image = new File(B03_image);
            if(B03_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap3 = BitmapFactory.decodeFile(B03_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB03.setBackground(createFromPath(B03_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B03_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B03_image", No_image);
                    VB03.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B03_image", No_image);
                VB03.setBackgroundResource(R.drawable.blue);
            }
        }
        //B04
        String B04_son = preferences.getString("B04_son", No_sound);
        File B04_file_test_son = new File(B04_son);
        if (!No_sound.equals(B04_son)) {
            if(!B04_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B04_son", No_sound);
            }
        }
        String B04_image = preferences.getString("B04_image", No_image);
        if (No_image.equals(B04_image)) {
            VB04.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B04_file_test_image = new File(B04_image);
            if(B04_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap4 = BitmapFactory.decodeFile(B04_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB04.setBackground(createFromPath(B04_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B04_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B04_image", No_image);
                    VB04.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B04_image", No_image);
                VB04.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B05
        String B05_son = preferences.getString("B05_son", No_sound);
        File B05_file_test_son = new File(B05_son);
        if (!No_sound.equals(B05_son)) {
            if(!B05_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B05_son", No_sound);
            }
        }
        String B05_image = preferences.getString("B05_image", No_image);
        if (No_image.equals(B05_image)) {
            VB05.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B05_file_test_image = new File(B05_image);
            if(B05_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap5 = BitmapFactory.decodeFile(B05_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB05.setBackground(createFromPath(B05_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B05_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B05_image", No_image);
                    VB05.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B05_image", No_image);
                VB05.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B06
        String B06_son = preferences.getString("B06_son", No_sound);
        File B06_file_test_son = new File(B06_son);
        if (!No_sound.equals(B06_son)) {
            if(!B06_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B06_son", No_sound);
            }
        }
        String B06_image = preferences.getString("B06_image", No_image);
        if (No_image.equals(B06_image)) {
            VB06.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B06_file_test_image = new File(B06_image);
            if(B06_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap6 = BitmapFactory.decodeFile(B06_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB06.setBackground(createFromPath(B06_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B06_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B06_image", No_image);
                    VB06.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B06_image", No_image);
                VB06.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B07
        String B07_son = preferences.getString("B07_son", No_sound);
        File B07_file_test_son = new File(B07_son);
        if (!No_sound.equals(B07_son)) {
            if(!B07_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B07_son", No_sound);
            }
        }
        String B07_image = preferences.getString("B07_image", No_image);
        if (No_image.equals(B07_image)) {
            VB07.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B07_file_test_image = new File(B07_image);
            if(B07_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap7 = BitmapFactory.decodeFile(B07_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB07.setBackground(createFromPath(B07_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B07_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B07_image", No_image);
                    VB07.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B07_image", No_image);
                VB07.setBackgroundResource(R.drawable.blue);
            }
        }
        //B08
        String B08_son = preferences.getString("B08_son", No_sound);
        File B08_file_test_son = new File(B08_son);
        if (!No_sound.equals(B08_son)) {
            if(!B08_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B08_son", No_sound);
            }
        }
        String B08_image = preferences.getString("B08_image", No_image);
        if (No_image.equals(B08_image)) {
            VB08.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B08_file_test_image = new File(B08_image);
            if(B08_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap8 = BitmapFactory.decodeFile(B08_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB08.setBackground(createFromPath(B08_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B08_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B08_image", No_image);
                    VB08.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B08_image", No_image);
                VB08.setBackgroundResource(R.drawable.blue);
            }
        }
        //B09
        String B09_son = preferences.getString("B09_son", No_sound);
        File B09_file_test_son = new File(B09_son);
        if (!No_sound.equals(B09_son)) {
            if(!B09_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B09_son", No_sound);
            }
        }
        String B09_image = preferences.getString("B09_image", No_image);
        if (No_image.equals(B09_image)) {
            VB09.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B09_file_test_image = new File(B09_image);
            if(B09_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap9 = BitmapFactory.decodeFile(B09_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB09.setBackground(createFromPath(B09_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B09_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B09_image", No_image);
                    VB09.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B09_image", No_image);
                VB09.setBackgroundResource(R.drawable.blue);
            }
        }
        //B10
        String B10_son = preferences.getString("B10_son", No_sound);
        File B10_file_test_son = new File(B10_son);
        if (!No_sound.equals(B10_son)) {
            if(!B10_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B10_son", No_sound);
            }
        }
        String B10_image = preferences.getString("B10_image", No_image);
        if (No_image.equals(B10_image)) {
            VB10.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B10_file_test_image = new File(B10_image);
            if(B10_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap10 = BitmapFactory.decodeFile(B10_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB10.setBackground(createFromPath(B10_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B10_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B10_image", No_image);
                    VB10.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B10_image", No_image);
                VB10.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B11
        String B11_son = preferences.getString("B11_son", No_sound);
        File B11_file_test_son = new File(B11_son);
        if (!No_sound.equals(B11_son)) {
            if(!B11_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B11_son", No_sound);
            }
        }
        String B11_image = preferences.getString("B11_image", No_image);
        if (No_image.equals(B11_image)) {
            VB11.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B11_file_test_image = new File(B11_image);
            if(B11_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap11 = BitmapFactory.decodeFile(B11_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB11.setBackground(createFromPath(B11_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B11_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B11_image", No_image);
                    VB11.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B11_image", No_image);
                VB11.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B12
        String B12_son = preferences.getString("B12_son", No_sound);
        File B12_file_test_son = new File(B12_son);
        if (!No_sound.equals(B12_son)) {
            if(!B12_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B12_son", No_sound);
            }
        }
        String B12_image = preferences.getString("B12_image", No_image);
        if (No_image.equals(B12_image)) {
            VB12.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B12_file_test_image = new File(B12_image);
            if(B12_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap12 = BitmapFactory.decodeFile(B12_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB12.setBackground(createFromPath(B12_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B12_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B12_image", No_image);
                    VB12.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B12_image", No_image);
                VB12.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B13
        String B13_son = preferences.getString("B13_son", No_sound);
        File B13_file_test_son = new File(B13_son);
        if (!No_sound.equals(B13_son)) {
            if(!B13_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B13_son", No_sound);
            }
        }
        String B13_image = preferences.getString("B13_image", No_image);
        if (No_image.equals(B13_image)) {
            VB13.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B13_file_test_image = new File(B13_image);
            if(B13_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap13 = BitmapFactory.decodeFile(B13_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB13.setBackground(createFromPath(B13_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B13_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B13_image", No_image);
                    VB13.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B13_image", No_image);
                VB13.setBackgroundResource(R.drawable.blue);
            }
        }
        //B14
        String B14_son = preferences.getString("B14_son", No_sound);
        File B14_file_test_son = new File(B14_son);
        if (!No_sound.equals(B14_son)) {
            if(!B14_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B14_son", No_sound);
            }
        }
        String B14_image = preferences.getString("B14_image", No_image);
        if (No_image.equals(B14_image)) {
            VB14.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B14_file_test_image = new File(B14_image);
            if(B14_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap14 = BitmapFactory.decodeFile(B14_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB14.setBackground(createFromPath(B14_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B14_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B14_image", No_image);
                    VB14.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B14_image", No_image);
                VB14.setBackgroundResource(R.drawable.blue);
            }
        }
        //B15
        String B15_son = preferences.getString("B15_son", No_sound);
        File B15_file_test_son = new File(B15_son);
        if (!No_sound.equals(B15_son)) {
            if(!B15_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B15_son", No_sound);
            }
        }
        String B15_image = preferences.getString("B15_image", No_image);
        if (No_image.equals(B15_image)) {
            VB15.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B15_file_test_image = new File(B15_image);
            if(B15_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap15 = BitmapFactory.decodeFile(B15_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB15.setBackground(createFromPath(B15_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B15_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B15_image", No_image);
                    VB15.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B15_image", No_image);
                VB15.setBackgroundResource(R.drawable.blue);
            }
        }
        //B16
        String B16_son = preferences.getString("B16_son", No_sound);
        File B16_file_test_son = new File(B16_son);
        if (!No_sound.equals(B16_son)) {
            if(!B16_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B16_son", No_sound);
            }
        }
        String B16_image = preferences.getString("B16_image", No_image);
        if (No_image.equals(B16_image)) {
            VB16.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B16_file_test_image = new File(B16_image);
            if(B16_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap16 = BitmapFactory.decodeFile(B16_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB16.setBackground(createFromPath(B16_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B16_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B16_image", No_image);
                    VB16.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B16_image", No_image);
                VB16.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B17
        String B17_son = preferences.getString("B17_son", No_sound);
        File B17_file_test_son = new File(B17_son);
        if (!No_sound.equals(B17_son)) {
            if(!B17_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B17_son", No_sound);
            }
        }
        String B17_image = preferences.getString("B17_image", No_image);
        if (No_image.equals(B17_image)) {
            VB17.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B17_file_test_image = new File(B17_image);
            if(B17_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap17 = BitmapFactory.decodeFile(B17_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB17.setBackground(createFromPath(B17_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B17_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B17_image", No_image);
                    VB17.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B17_image", No_image);
                VB17.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B18
        String B18_son = preferences.getString("B18_son", No_sound);
        File B18_file_test_son = new File(B18_son);
        if (!No_sound.equals(B18_son)) {
            if(!B18_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B18_son", No_sound);
            }
        }
        String B18_image = preferences.getString("B18_image", No_image);
        if (No_image.equals(B18_image)) {
            VB18.setBackgroundResource(R.drawable.crystal);
        }
        else {
            File B18_file_test_image = new File(B18_image);
            if(B18_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap18 = BitmapFactory.decodeFile(B18_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB18.setBackground(createFromPath(B18_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B18_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B18_image", No_image);
                    VB18.setBackgroundResource(R.drawable.crystal);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B18_image", No_image);
                VB18.setBackgroundResource(R.drawable.crystal);
            }
        }
        //B19
        String B19_son = preferences.getString("B19_son", No_sound);
        File B19_file_test_son = new File(B19_son);
        if (!No_sound.equals(B19_son)) {
            if(!B19_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B19_son", No_sound);
            }
        }
        String B19_image = preferences.getString("B19_image", No_image);
        if (No_image.equals(B19_image)) {
            VB19.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B19_file_test_image = new File(B19_image);
            if(B19_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap19 = BitmapFactory.decodeFile(B19_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB19.setBackground(createFromPath(B19_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B19_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B19_image", No_image);
                    VB19.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B19_image", No_image);
                VB19.setBackgroundResource(R.drawable.blue);
            }
        }
        //B20
        String B20_son = preferences.getString("B20_son", No_sound);
        File B20_file_test_son = new File(B20_son);
        if (!No_sound.equals(B20_son)) {
            if(!B20_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B20_son", No_sound);
            }
        }
        String B20_image = preferences.getString("B20_image", No_image);
        if (No_image.equals(B20_image)) {
            VB20.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B20_file_test_image = new File(B20_image);
            if(B20_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap20 = BitmapFactory.decodeFile(B20_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB20.setBackground(createFromPath(B20_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B20_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B20_image", No_image);
                    VB20.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B20_image", No_image);
                VB20.setBackgroundResource(R.drawable.blue);
            }
        }
        //B21
        String B21_son = preferences.getString("B21_son", No_sound);
        File B21_file_test_son = new File(B21_son);
        if (!No_sound.equals(B21_son)) {
            if(!B21_file_test_son.exists()) {
                Toast.makeText(getApplicationContext(), R.string.sound_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B21_son", No_sound);
            }
        }
        String B21_image = preferences.getString("B21_image", No_image);
        if (No_image.equals(B21_image)) {
            VB21.setBackgroundResource(R.drawable.blue);
        }
        else {
            File B21_file_test_image = new File(B21_image);
            if(B21_file_test_image.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap21 = BitmapFactory.decodeFile(B21_image, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    VB21.setBackground(createFromPath(B21_image));
                }
                else {
                    Toast.makeText(getApplicationContext(), getBaseContext().getString(R.string.image_file_error) + " " + B21_image, Toast.LENGTH_SHORT).show();
                    editor.putString("B21_image", No_image);
                    VB21.setBackgroundResource(R.drawable.blue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), R.string.image_not_exist, Toast.LENGTH_SHORT).show();
                editor.putString("B21_image", No_image);
                VB21.setBackgroundResource(R.drawable.blue);
            }
        }
        editor.apply(); // Validation edition préférences
    }

    protected void lance_preferences() {
        Intent i = new Intent(MainActivity.this, Modif_Bouton.class); // Déclaration appel Modif bouton
        startActivityForResult(i, INTENT_RETURN_ID); // Appel preference avec retour attendu pour mise à jour valeur
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //  Dans préférences
        String maj_bouton_texte = preferences.getString("bouton_texte", "Libelle par defaut"); // Lecture libellé bouton
        String maj_bouton_image = preferences.getString("bouton_image", No_image); // Lecture image bouton
        String maj_bouton_son = preferences.getString("bouton_son", No_sound); // Lecture son bouton
        SharedPreferences.Editor editor = preferences.edit(); // Mode edition
        if (bouton_en_cours == 1) { // Si bouton 1
            editor.putString("B01_libelle", maj_bouton_texte); // Sauvegarde libelle bouton 1
            editor.putString("B01_son", maj_bouton_son); // Sauvegarde son bouton 1
            editor.putString("B01_image", maj_bouton_image); // Sauvegarde image bouton 1
        }
        if (bouton_en_cours == 2) {
            editor.putString("B02_libelle", maj_bouton_texte);
            editor.putString("B02_son", maj_bouton_son);
            editor.putString("B02_image", maj_bouton_image);
        }
        if (bouton_en_cours == 3) {
            editor.putString("B03_libelle", maj_bouton_texte);
            editor.putString("B03_son", maj_bouton_son);
            editor.putString("B03_image", maj_bouton_image);
        }
        if (bouton_en_cours == 4) {
            editor.putString("B04_libelle", maj_bouton_texte);
            editor.putString("B04_son", maj_bouton_son);
            editor.putString("B04_image", maj_bouton_image);
        }
        if (bouton_en_cours == 5) {
            editor.putString("B05_libelle", maj_bouton_texte);
            editor.putString("B05_son", maj_bouton_son);
            editor.putString("B05_image", maj_bouton_image);
        }
        if (bouton_en_cours == 6) {
            editor.putString("B06_libelle", maj_bouton_texte);
            editor.putString("B06_son", maj_bouton_son);
            editor.putString("B06_image", maj_bouton_image);
        }
        if (bouton_en_cours == 7) {
            editor.putString("B07_libelle", maj_bouton_texte);
            editor.putString("B07_son", maj_bouton_son);
            editor.putString("B07_image", maj_bouton_image);
        }
        if (bouton_en_cours == 8) {
            editor.putString("B08_libelle", maj_bouton_texte);
            editor.putString("B08_son", maj_bouton_son);
            editor.putString("B08_image", maj_bouton_image);
        }
        if (bouton_en_cours == 9) {
            editor.putString("B09_libelle", maj_bouton_texte);
            editor.putString("B09_son", maj_bouton_son);
            editor.putString("B09_image", maj_bouton_image);
        }
        if (bouton_en_cours == 10) {
            editor.putString("B10_libelle", maj_bouton_texte);
            editor.putString("B10_son", maj_bouton_son);
            editor.putString("B10_image", maj_bouton_image);
        }
        if (bouton_en_cours == 11) {
            editor.putString("B11_libelle", maj_bouton_texte);
            editor.putString("B11_son", maj_bouton_son);
            editor.putString("B11_image", maj_bouton_image);
        }
        if (bouton_en_cours == 12) {
            editor.putString("B12_libelle", maj_bouton_texte);
            editor.putString("B12_son", maj_bouton_son);
            editor.putString("B12_image", maj_bouton_image);
        }
        if (bouton_en_cours == 13) {
            editor.putString("B13_libelle", maj_bouton_texte);
            editor.putString("B13_son", maj_bouton_son);
            editor.putString("B13_image", maj_bouton_image);
        }
        if (bouton_en_cours == 14) {
            editor.putString("B14_libelle", maj_bouton_texte);
            editor.putString("B14_son", maj_bouton_son);
            editor.putString("B14_image", maj_bouton_image);
        }
        if (bouton_en_cours == 15) {
            editor.putString("B15_libelle", maj_bouton_texte);
            editor.putString("B15_son", maj_bouton_son);
            editor.putString("B15_image", maj_bouton_image);
        }
        if (bouton_en_cours == 16) {
            editor.putString("B16_libelle", maj_bouton_texte);
            editor.putString("B16_son", maj_bouton_son);
            editor.putString("B16_image", maj_bouton_image);
        }
        if (bouton_en_cours == 17) {
            editor.putString("B17_libelle", maj_bouton_texte);
            editor.putString("B17_son", maj_bouton_son);
            editor.putString("B17_image", maj_bouton_image);
        }
        if (bouton_en_cours == 18) {
            editor.putString("B18_libelle", maj_bouton_texte);
            editor.putString("B18_son", maj_bouton_son);
            editor.putString("B18_image", maj_bouton_image);
        }
        if (bouton_en_cours == 19) {
            editor.putString("B19_libelle", maj_bouton_texte);
            editor.putString("B19_son", maj_bouton_son);
            editor.putString("B19_image", maj_bouton_image);
        }
        if (bouton_en_cours == 20) {
            editor.putString("B20_libelle", maj_bouton_texte);
            editor.putString("B20_son", maj_bouton_son);
            editor.putString("B20_image", maj_bouton_image);
        }
        if (bouton_en_cours == 21) {
            editor.putString("B21_libelle", maj_bouton_texte);
            editor.putString("B21_son", maj_bouton_son);
            editor.putString("B21_image", maj_bouton_image);
        }
        editor.apply(); // Validation edition préférences
        maj_preferences (); // Maj affichage
    }

    private void sauv_libelle() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //  Dans préférences
        SharedPreferences.Editor editor = preferences.edit(); // Mode edition
        if (bouton_en_cours == 1) { // Si c'est bouton1
            String libelle_en_cours = VB01.getText().toString();  // Recup libelle actuel pour sauvegarde
            editor.putString("bouton_texte", libelle_en_cours); // Sauvegarde libellé bouton1 pour affichage dans EditText
            Image_File_Path = preferences.getString("B01_image", No_image); // Lecture chemin image existant
            editor.putString("bouton_image", Image_File_Path); // Sauvegarde chemin image existant
            Audio_File_Path = preferences.getString("B01_son", No_sound); // Lecture chemin son existant
            editor.putString("bouton_son", Audio_File_Path); // Sauvegarde chemin son existant

        }
        if (bouton_en_cours == 2) {
            String libelle_en_cours = VB02.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B02_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B02_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 3) {
            String libelle_en_cours = VB03.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B03_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B03_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 4) {
            String libelle_en_cours = VB04.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B04_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B04_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 5) {
            String libelle_en_cours = VB05.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B05_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B05_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 6) {
            String libelle_en_cours = VB06.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B06_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B06_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 7) {
            String libelle_en_cours = VB07.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B07_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B07_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 8) {
            String libelle_en_cours = VB08.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B08_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B08_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 9) {
            String libelle_en_cours = VB09.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B09_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B09_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 10) {
            String libelle_en_cours = VB10.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B10_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B10_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 11) {
            String libelle_en_cours = VB11.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B11_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B11_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 12) {
            String libelle_en_cours = VB12.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B12_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B12_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 13) {
            String libelle_en_cours = VB13.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B13_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B13_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 14) {
            String libelle_en_cours = VB14.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B14_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B14_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 15) {
            String libelle_en_cours = VB15.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B15_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B15_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 16) {
            String libelle_en_cours = VB16.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B16_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B16_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 17) {
            String libelle_en_cours = VB17.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B17_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B17_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 18) {
            String libelle_en_cours = VB18.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B18_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B18_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 19) {
            String libelle_en_cours = VB19.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B19_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B19_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 20) {
            String libelle_en_cours = VB20.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B20_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B20_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        if (bouton_en_cours == 21) {
            String libelle_en_cours = VB21.getText().toString();
            editor.putString("bouton_texte", libelle_en_cours);
            Image_File_Path = preferences.getString("B21_image", No_image);
            editor.putString("bouton_image", Image_File_Path);
            Audio_File_Path = preferences.getString("B21_son", No_sound);
            editor.putString("bouton_son", Audio_File_Path);
        }
        editor.apply(); // Sauvegarde modifications
    }

    //////////////////////////////////////////////////////////////////////////////////////////////// Action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if (res_id == R.id.action_1)
        {
            //Toast.makeText(getApplicationContext(), "Help text here", Toast.LENGTH_SHORT).show();
            CharSequence[] items = {"Long click on buttons to set sounds and others options.", "Simple click on buttons to play selected sounds.", " ", "Credits : Freepik.com"};
            AlertDialog.Builder my_builder = new AlertDialog.Builder(MainActivity.this);
            my_builder
                    //.setMessage("Use message instead of items")
                    .setCancelable(true)
                    .setTitle("Help")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // On click item action here
                        }
                    })
                    .setPositiveButton("Enjoy!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = my_builder.create();
            alert.show();
        }
        return true;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////// COPIE RESSOURCES SUR SDCARD
    private void copy_res_to_sd() { // Copie les fichiers images et son dans répertoire SoundBoxCustom sur SDcard pour dispo à l'utilisateur
        // REPRETOIRES
        File rep_images = new File(sdcard_res_path, "Images"); // Create Images directory in SDcard if needed
        if (!rep_images.exists()){
            rep_images.mkdirs();
        }
        File rep_sounds = new File(sdcard_res_path, "Sounds"); // Create Sounds directory in SDcard if needed
        if (!rep_sounds.exists()){
            rep_sounds.mkdirs();
        }
        // WAOUH IMAGE
        Bitmap waouh_image = BitmapFactory.decodeResource( getResources(), R.drawable.waouh); // Creation bitmap depuis drawable
        File waouh_file = new File(sdcard_images_path, "Waouh.PNG"); // Declaration fichier destination
        if (!waouh_file.exists()){ // Si fichier existe pas
            try { // On essaye
                FileOutputStream outStream = new FileOutputStream(waouh_file); // De créer un flux pour écrire dedans
                waouh_image.compress(Bitmap.CompressFormat.PNG, 100, outStream); // au format PNG
                outStream.flush();
                outStream.close(); // On ferme le flux
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // WAOUH SON
        File waouh_audiofile = new File(sdcard_sounds_path, "Waouh.mp3"); // Declaration fichier audio destination
        if (!waouh_audiofile.exists()) { // Si fichier existe pas déjà
            InputStream waouh_audio = getResources().openRawResource(R.raw.waouh); // Creation stream audio depuis raw
            try {
                FileOutputStream waouh_audio_out = new FileOutputStream(sdcard_sounds_path + "/Waouh.mp3"); // Declaration flux audio destination
                byte[] buff = new byte[1024]; // taille buffer
                int read = 0;
                try {
                    while ((read = waouh_audio.read(buff)) > 0) {
                        waouh_audio_out.write(buff, 0, read); // Ecriture fichier
                    }
                } finally {
                    waouh_audio.close(); // Fermeture flux
                    waouh_audio_out.close(); // Et fichier son
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // AARG IMAGE
        Bitmap aargh_image = BitmapFactory.decodeResource( getResources(), R.drawable.aarg);
        File aargh_file = new File(sdcard_images_path, "Aarg.PNG");
        if (!aargh_file.exists()){
            try {
                FileOutputStream outStream = new FileOutputStream(aargh_file);
                aargh_image.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                outStream.flush();
                outStream.close();
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // AARG SON
        File aargh_audiofile = new File(sdcard_sounds_path, "Aarg.mp3");
        if (!aargh_audiofile.exists()) {
            InputStream aargh_audio = getResources().openRawResource(R.raw.aargh);
            try {
                FileOutputStream aargh_audio_out = new FileOutputStream(sdcard_sounds_path + "/Aarg.mp3");
                byte[] buff = new byte[1024];
                int read = 0;
                try {
                    while ((read = aargh_audio.read(buff)) > 0) {
                        aargh_audio_out.write(buff, 0, read);
                    }
                } finally {
                    aargh_audio.close();
                    aargh_audio_out.close();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // APPLAUSE IMAGE
        Bitmap applause_image = BitmapFactory.decodeResource( getResources(), R.drawable.applause);
        File applause_file = new File(sdcard_images_path, "Applause.PNG");
        if (!applause_file.exists()){
            try {
                FileOutputStream applause_outStream = new FileOutputStream(applause_file);
                applause_image.compress(Bitmap.CompressFormat.PNG, 100, applause_outStream);
                applause_outStream.flush();
                applause_outStream.close();
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // APPLAUSE SON
        File applause_audiofile = new File(sdcard_sounds_path, "Applause.mp3");
        if (!applause_audiofile.exists()) {
            InputStream applause_audio = getResources().openRawResource(R.raw.applause);
            try {
                FileOutputStream applause_audio_out = new FileOutputStream(sdcard_sounds_path + "/Applause.mp3");
                byte[] buff = new byte[1024];
                int read = 0;
                try {
                    while ((read = applause_audio.read(buff)) > 0) {
                        applause_audio_out.write(buff, 0, read);
                    }
                } finally {
                    applause_audio.close();
                    applause_audio_out.close();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // YAAHOU IMAGE
        Bitmap yaahoo_image = BitmapFactory.decodeResource( getResources(), R.drawable.yaahoo);
        File yaahoo_file = new File(sdcard_images_path, "Yaahou.PNG");
        if (!yaahoo_file.exists()){
            try {
                FileOutputStream yaahoo_outStream = new FileOutputStream(yaahoo_file);
                yaahoo_image.compress(Bitmap.CompressFormat.PNG, 100, yaahoo_outStream);
                yaahoo_outStream.flush();
                yaahoo_outStream.close();
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
        // YAAHOU SON
        File yaahoo_audiofile = new File(sdcard_sounds_path, "Yahoo.mp3");
        if (!yaahoo_audiofile.exists()) {
            InputStream yaahoo_audio = getResources().openRawResource(R.raw.yaahoo);
            try {
                FileOutputStream yaahoo_audio_out = new FileOutputStream(sdcard_sounds_path + "/Yaahoo.mp3");
                byte[] buff = new byte[1024];
                int read = 0;
                try {
                    while ((read = yaahoo_audio.read(buff)) > 0) {
                        yaahoo_audio_out.write(buff, 0, read);
                    }
                } finally {
                    yaahoo_audio.close();
                    yaahoo_audio_out.close();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "File not found exception", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void first_run_void () {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //  Dans préférences
        first_run = preferences.getString("first_run", "true");
        if (first_run.equals("true")) {
            SharedPreferences.Editor editor = preferences.edit(); // Mode edition
            editor.putString("B01_libelle", ""); // Ecriture Libelle boutton 01 en blanc
            editor.putString("B01_son", waouh_son_path); // Ecriture Waouh image
            editor.putString("B01_image", waouh_image_path); // Ecriture Waouh son
            editor.putString("first_run", "false"); // Modification first run en false
            editor.apply(); // Sauvegarde modifications
        }
    }
    // End of voids
} // End
