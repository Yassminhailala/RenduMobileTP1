package com.example.excercicecour;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity); // Vérifie que le nom du fichier est bien secondactivity.xml

        // Récupérer les données de l'Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String fullName = extras.getString("fullName");
            String email = extras.getString("email");
            String phone = extras.getString("phone");
            String adresse = extras.getString("adresse");
            String ville = extras.getString("ville");

            // Afficher le récapitulatif
            TextView textSummary = findViewById(R.id.textSummary);
            String summary = "Nom : " + fullName + "\n" +
                    "Email : " + email + "\n" +
                    "Téléphone : " + phone + "\n" +
                    "Adresse : " + adresse + "\n" +
                    "Ville : " + ville;
            textSummary.setText(summary);
        }
    }
}
