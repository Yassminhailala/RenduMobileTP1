package com.example.excercicecour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerVille;
    private EditText editTextFullname, editTextEmail, editTextPhone, editTextAdresse;
    private Button buttonSend;
    private ArrayList<String> listeVilles;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des éléments du layout
        editTextFullname = findViewById(R.id.editTextFullname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAdresse = findViewById(R.id.editTextAdresse);
        spinnerVille = findViewById(R.id.spinnerVille);
        buttonSend = findViewById(R.id.buttonSend);

        // Initialisation de la liste des villes
        listeVilles = new ArrayList<>();
        listeVilles.add("Sélectionnez une ville");
        listeVilles.add("Agadir");
        listeVilles.add("Marrakech");
        listeVilles.add("Casablanca");
        listeVilles.add("Rabat");

        // Création de l'adaptateur
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listeVilles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVille.setAdapter(adapter);

        // Événement de sélection du Spinner
        spinnerVille.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String villeSelectionnee = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Ville sélectionnée : " + villeSelectionnee, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Rien à faire ici
            }
        });

        // Bouton pour envoyer les informations et aller vers SecondActivity
        buttonSend.setOnClickListener(v -> {
            String fullname = editTextFullname.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String adresse = editTextAdresse.getText().toString().trim();
            String villeSelectionnee = spinnerVille.getSelectedItem().toString();

            if (fullname.isEmpty() || email.isEmpty() || phone.isEmpty() || adresse.isEmpty() || villeSelectionnee.equals("Sélectionnez une ville")) {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                // Création de l'Intent pour passer à SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("fullName", fullname);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("adresse", adresse);
                intent.putExtra("ville", villeSelectionnee);
                startActivity(intent);
            }
        });
    }
}
