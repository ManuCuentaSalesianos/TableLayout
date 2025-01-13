package com.example.tablelayout;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tablelayout.databinding.ActivityPantallaintroduccionnumerosBinding;

public class Pantallaintroduccionnumeros extends AppCompatActivity {

    private EditText et1;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaintroduccionnumeros);

        //

        num = (int)(Math.random()*10);
        String cadena = String.valueOf(num);

        Toast notification = Toast.makeText(this, "El numero aleatorio es: " + cadena, Toast.LENGTH_SHORT );
        notification.show();
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_pantallaintroduccionnumeros);
////        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
    }
//}