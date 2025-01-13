package com.example.tablelayout

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tablelayout.DB.DBConexion
import com.example.tablelayout.databinding.ActivityAgregarContactoBinding

class agregarContacto : AppCompatActivity() {

    private lateinit var botonAceptar: Button
    private lateinit var txtNombre: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtTelefono: EditText

    //Base de datos
    var conexion: DBConexion? = null
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)

        //Obtiene las referencias de los objetos del layout
        txtNombre = findViewById(R.id.txtNombre)
        txtEmail = findViewById(R.id.txtEmail)
        txtTelefono = findViewById(R.id.txtTelefono)
        botonAceptar = findViewById(R.id.botonAceptar)

        //Crea el objeto conexión con la ventana actual
        /* Estas sentencias de conexión y obtención de la base de datos se repiten
        *  en todas las ventanas sobre las que se va a operar en la bbdd */
        conexion = DBConexion(this)
        db = conexion!!.writableDatabase

        botonAceptar.setOnClickListener {
            val intent = Intent()

            //Recoge en variables lo que está escrito en los campos de texto de la ventana
            val nombre = txtNombre.text.toString()
            val email = txtEmail.text.toString()
            val telefono = txtTelefono.text.toString()

            //Creo un nuevo objeto contacto tomando los valores escritos en los campos de texto
            val contactoNuevo = Contacto(nombre, email, telefono, 0)

            //Intenta insertarlos en la base de datos el objeto contactoNuevo
            if(db != null) {
                conexion!!.insertarContacto(db, contactoNuevo)
            }

            //Muestra un aviso de que se ha añadido un nuevo contacto
            Toast.makeText(this, "Se ha añadido un nuevo contacto", Toast.LENGTH_LONG).show()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}