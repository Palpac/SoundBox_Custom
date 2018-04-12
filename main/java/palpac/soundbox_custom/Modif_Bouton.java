package palpac.soundbox_custom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modif_Bouton extends AppCompatActivity {

    EditText VeditText1 = null;                             // Declaration objets
    Button dirChooserButton2 = null;
    Button dirChooserButton3 = null;
    TextView TextVimg, TextVson = null;
    Button raz_img, raz_son = null;
    Switch switch1 = null;
    Button record, stop, play = null;
    Button save, cancel = null ;
    public String image_chosen; // Image path
    public String son_chosen; // Son path

    private MediaRecorder myAudioRecorder; // Record audio
    private String outputFile; // Audio recorded file path
    private String sdcard_path; // SDcard path
    //private String app_path; // Application path

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_bouton);     // Layout attaché à l'activity

        VeditText1 = findViewById(R.id.button1);             // Rattache objets à ceux du layout
        dirChooserButton2 = findViewById(R.id.button2);
        dirChooserButton3 = findViewById(R.id.button3);
        TextVimg = findViewById(R.id.TextVimg);
        TextVson = findViewById(R.id.TextVson);
        raz_img = findViewById(R.id.raz_img);
        raz_son = findViewById(R.id.raz_son);
        switch1 = findViewById(R.id.switch1);
        record = findViewById(R.id.button4);
        stop = findViewById(R.id.button5);
        play = findViewById(R.id.button6);
        cancel = findViewById(R.id.button7);
        save = findViewById(R.id.button8);

        record.setEnabled(false);
        stop.setEnabled(false);
        play.setEnabled(false);

        dirChooserButton2.setOnClickListener(dirChooserButton2Listener);
        dirChooserButton3.setOnClickListener(dirChooserButton3Listener);
        raz_img.setOnClickListener(raz_imgListener);
        raz_son.setOnClickListener(raz_sonListener);
        switch1.setOnCheckedChangeListener(switch1Listener);
        record.setOnClickListener(recordListener);
        stop.setOnClickListener(stopListener);
        play.setOnClickListener(playListener);
        save.setOnClickListener(saveListener);
        cancel.setOnClickListener(cancelListener);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); // Dans préférence
        String recup_libelle = preferences.getString("bouton_texte", "Button"); // Lecture libellé
        String recup_image = preferences.getString("bouton_image", "No_image"); // Lecture image
        String recup_son = preferences.getString("bouton_son", "No_sound"); // Lecture son
        VeditText1.setText(recup_libelle);  // Actualisation libelle
        TextVimg.setText(recup_image); // Actualisation chemin image
        TextVson.setText(recup_son); // Actualisation chemin son

        //app_path = getFilesDir().getAbsolutePath(); // Internal path
        sdcard_path = Environment.getExternalStorageDirectory().getPath(); // SD card path
        File file_app = new File(sdcard_path + "/Android/data/", "SoundBoxCustom"); // Create directory in SDcard if needed
        if (!file_app.exists()){
            file_app.mkdirs();
        }

    }
    private View.OnClickListener dirChooserButton2Listener = new View.OnClickListener() { // Listener bouton 2 image
        @Override
        public void onClick(View v) {
            // SimpleFileChooser
            SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(Modif_Bouton.this, "FileOpen",
                    new SimpleFileDialog.SimpleFileDialogListener() {
                        @Override
                        public void onChosenDir(String chosenDir) { // The code in this function will be executed when the dialog OK button is pushed
                            image_chosen = chosenDir;
                            TextVimg.setText(image_chosen);
                            //update_pref_image(); // Sauvegade path choisi dans preferences
                        }
                    });
            FileOpenDialog.Default_File_Name = ""; //You can change the default filename using the public variable "Default_File_Name"
            FileOpenDialog.chooseFile_or_Dir(); // Fin SimpleFileChooser
        }
    };
    private View.OnClickListener dirChooserButton3Listener = new View.OnClickListener() { // Listener bouton 3 son
        @Override
        public void onClick(View v) {
            // SimpleFileChooser
            SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(Modif_Bouton.this, "FileOpen",
                    new SimpleFileDialog.SimpleFileDialogListener() {
                        @Override
                        public void onChosenDir(String chosenDir) { // The code in this function will be executed when the dialog OK button is pushed
                            son_chosen = chosenDir;
                            TextVson.setText(son_chosen);
                            //update_pref_son(); // Sauvegade path choisi dans preferences
                        }
                    });
            FileOpenDialog.Default_File_Name = ""; //You can change the default filename using the public variable "Default_File_Name"
            FileOpenDialog.chooseFile_or_Dir(); // Fin SimpleFileChooser
        }
    };
    private View.OnClickListener raz_imgListener = new View.OnClickListener() { // Listener raz image
        @Override
        public void onClick(View v) {
            AlertDialog.Builder my_builder = new AlertDialog.Builder(Modif_Bouton.this, AlertDialog.THEME_HOLO_DARK);
            my_builder
                    .setCancelable(true)  // Demande validation pour quitter
                    .setTitle(R.string.title_clear)
                    .setMessage(R.string.delete_img)
                    .setPositiveButton(R.string.clear, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TextVimg.setText(R.string.raz_img);
                            dialogInterface.cancel();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = my_builder.create();
            alert.show();
        }
    };
    private View.OnClickListener raz_sonListener = new View.OnClickListener() { // Listener raz son
        @Override
        public void onClick(View v) {
            AlertDialog.Builder my_builder = new AlertDialog.Builder(Modif_Bouton.this, AlertDialog.THEME_HOLO_DARK);
            my_builder
                    .setCancelable(true)  // Demande validation pour quitter
                    .setTitle(R.string.title_clear)
                    .setMessage(R.string.delete_son)
                    .setPositiveButton(R.string.clear, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            TextVson.setText(R.string.raz_son);
                            dialogInterface.cancel();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = my_builder.create();
            alert.show();
        }
    };
    private CompoundButton.OnCheckedChangeListener switch1Listener = new CompoundButton.OnCheckedChangeListener() { // Listener SWITCH
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //Log.v("Switch State=", "Switch1 "+isChecked);
            if (isChecked) {
                //Toast.makeText(getApplicationContext(), "True.",Toast.LENGTH_SHORT).show();
                record.setEnabled(true);
                dirChooserButton3.setEnabled(false);
            } else {
                //Toast.makeText(getApplicationContext(), "False.",Toast.LENGTH_SHORT).show();
                record.setEnabled(false);
                dirChooserButton3.setEnabled(true);
            }
        }
    };
    private View.OnClickListener recordListener = new View.OnClickListener() { // Listener RECORD
        @Override
        public void onClick(View v) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); // Get Date and Time
            String currentDateandTime = sdf.format(new Date());
            //File file = new File(sdcard_path, "MediaRecorder"); // Create repertory in SDcard if needed
            File file = new File(sdcard_path + "/Android/data/SoundBoxCustom", "Records");
            if (!file.exists()){
                file.mkdirs();
            }
            outputFile = (file.getAbsolutePath() + "/" + currentDateandTime + ".3pg"); // Set PATH for recorded audio
            try {
                myAudioRecorder = new MediaRecorder(); // MediaRecorder declaration
                myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                myAudioRecorder.setOutputFile(outputFile);
                myAudioRecorder.prepare();
                myAudioRecorder.start();
                Toast.makeText(getApplicationContext(), "Recording...",Toast.LENGTH_SHORT).show();
            }
            catch (IllegalStateException e) {
                // On Exception Action
            }
            catch (IOException e) {
                // On Exception Action
            }
            record.setEnabled(false);
            switch1.setEnabled(false);
            stop.setEnabled(true);
        }
    };
    private View.OnClickListener stopListener = new View.OnClickListener() { // Listener STOP
        @Override
        public void onClick(View v) {
            myAudioRecorder.stop(); // Stop recording
            myAudioRecorder.release();
            switch1.setEnabled(true);
            play.setEnabled(true);
            record.setEnabled(true);
            stop.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Saved in Records directory.",Toast.LENGTH_SHORT).show();
            TextVson.setText(outputFile);
        }
    };
    private View.OnClickListener playListener = new View.OnClickListener() { // Listener PLAY
        @Override
        public void onClick(View v) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(outputFile);
                mediaPlayer.prepare();
                mediaPlayer.start(); // Start playing
                //Toast.makeText(getApplicationContext(), "Playing recorded audio.",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                // On Exception Action
            }
        }
    };
    private View.OnClickListener saveListener = new View.OnClickListener() { // Listener SAVE
        @Override
        public void onClick(View v) {
            save_values();
            onBackPressed(); // Sortie activité Modif_Boutons
        }
    };
    private View.OnClickListener cancelListener = new View.OnClickListener() { // Listener CANCEL
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    //////////////////////////////////////////////////////////////////////////////////////////////// Voids
    private void save_values() {
        String texte_saisie = VeditText1.getText().toString();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); //  Dans préférences
        SharedPreferences.Editor editor = preferences.edit(); // Mode edition
        editor.putString("bouton_texte", texte_saisie); // Sauvegarde libellé bouton1
        image_chosen = TextVimg.getText().toString();  // Lecture chemin image choisi
        editor.putString("bouton_image", image_chosen); // Sauvegarde chemin image
        outputFile = TextVson.getText().toString(); // Lecture chemin son choisi
        editor.putString("bouton_son", outputFile); // Sauvegarde chemin son
        editor.apply(); // Validation edition préférences
    }
    // End voids
} // End
