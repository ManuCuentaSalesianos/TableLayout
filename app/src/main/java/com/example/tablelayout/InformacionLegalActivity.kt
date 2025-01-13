package com.example.tablelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tablelayout.databinding.ActivityInformacionLegalBinding

class InformacionLegalActivity : AppCompatActivity() {

    private lateinit var botonAceptar: Button
    private lateinit var botonCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_legal)

        botonAceptar = findViewById(R.id.btnAceptar)
        botonCancelar = findViewById(R.id.btnCancelar)

        botonAceptar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Usuario", "Manuel")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        botonCancelar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Usuario", "Manuel")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_informacion_legal)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}