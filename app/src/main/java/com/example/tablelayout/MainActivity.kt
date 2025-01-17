package com.example.tablelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.viewpager.widget.ViewPager
import com.example.tablelayout.ui.theme.TableLayoutTheme
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var ventanaDeslizante: ViewPager
    private lateinit var tablayout: TabLayout
    private lateinit var txtTexto: TextView
    private lateinit var barra: Toolbar

    //private lateinit var barra: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos las referencias de los objetos del layout
        ventanaDeslizante = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tabLayout)
        txtTexto = findViewById(R.id.txtTextoInformacion)

        /* Inicia el controlador de deslizamineto de ventanas
        *  que recibe como parametro un objeto llamado supportFragmentManager
        *  que es el que gestiona los fragmentos en las actividades
        *  se llama así el objeto supportFragmentManager
        *  seria el equivalente en Java a  */
        val controlador = ControladorVentanaDeslizante(supportFragmentManager)

        controlador.addFragments(CorreosFragment(), "Correos")
        controlador.addFragments(ContactosFragment(), "Contactos")

        ventanaDeslizante.adapter = controlador
        //Vincula el controlador al tablayout
        tablayout.setupWithViewPager(ventanaDeslizante)

        tablayout.getTabAt(0)?.setIcon(R.drawable.baseline_email_24)
        tablayout.getTabAt(1)?.setIcon(R.drawable.baseline_contacts_24)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true

            R.id.btnInformacionApp -> {
                lanzarInformacionDe()
                true
            }

            R.id.btnAniadirContacto -> {
                abrirVentanaAniadirContacto()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun abrirVentanaAniadirContacto(view: View? = null) {
        val i = Intent(this, agregarContacto::class.java)
        //startActivity(i)
        resultLauncher.launch(i)
    }

    fun lanzarInformacionDe(view: View? = null) {
        val i = Intent(this, InformacionLegalActivity::class.java)
        //startActivity(i)
        resultLauncher.launch(i)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        val intent = result
        var nombre = result.data?.getStringExtra("Usuario")

        if (result.resultCode == Activity.RESULT_OK) {
            txtTexto.setText("El usuario " + nombre + " ha aceptado los terminos legales")
        } else {
            txtTexto.setText("El usuario " + nombre + " ha rechazado los terminos")
        }
    }
}
//Hola
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TableLayoutTheme {
        Greeting("Android")
    }
}