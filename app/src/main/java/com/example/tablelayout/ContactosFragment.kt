package com.example.tablelayout

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tablelayout.DB.DBConexion

class ContactosFragment : Fragment() {
    protected var mRecyclerView: RecyclerView? = null
    protected var mAdapter: ControladorRecyclerView? = null
    protected var mLayoutManager: RecyclerView.LayoutManager? = null
    var listaContactos = ArrayList<Contacto>()

    var conexion1: DBConexion? = null
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conexion1 = DBConexion(this.context)
        db = conexion1!!.writableDatabase

        if (db != null) {
            inciarRecogidaDatos(conexion1, db)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_contactos, container, false)
        rootView.tag = "Contactos Fragment"

        //Creamos el objeto controlador del recycler View, programado anteriormente
        mAdapter = ControladorRecyclerView(listaContactos)


        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycleViewListaContactos)

        //Este sería para definir el deslizamineto de los items reciclerview
        recyclerView.layoutManager = LinearLayoutManager(context)

        /* El controlador del recyclerView particular, va a ser el controlador arriba definido
        * que se ha creado a partir de la lista de contactos.
        * Donde se vincula el componente gráfico widget recycler view con el controlador adapter
        * para mostrar los datos */
        recyclerView.adapter = mAdapter

        return rootView
    }

    private fun inciarRecogidaDatos(conexion: DBConexion?, db: SQLiteDatabase?) {
        if (conexion != null) {
            listaContactos = conexion.selectContactos(db) as ArrayList<Contacto>
        }
    }
}
