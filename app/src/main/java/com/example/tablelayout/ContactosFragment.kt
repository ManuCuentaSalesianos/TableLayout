package com.example.tablelayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactosFragment : Fragment() {
    protected var mRecyclerView: RecyclerView? = null
    protected var mAdapter: ControladorRecyclerView? = null
    protected var mLayoutManager: RecyclerView.LayoutManager? = null
    val listaContactos = ArrayList<Contacto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inciarRecogidaDatos()
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

    private fun inciarRecogidaDatos() {
        val cont1 = Contacto("Contacto 1","contacto1@gmail.com","125454356", R.drawable.contacto)
        val cont2 = Contacto("Contacto 2","contacto2@gmail.com","321445453",R.drawable.contacto)
        val cont3 = Contacto("Contacto 3","contacto3@gmail.com","125454356", R.drawable.contacto)
        val cont4 = Contacto("Contacto 4","contacto4@gmail.com","321445453",R.drawable.contacto)
        val cont5 = Contacto("Contacto 5","contacto5@gmail.com","125454376", R.drawable.contacto)
        val cont6 = Contacto("Contacto 6","contacto6@gmail.com","321449463",R.drawable.contacto)
        val cont7 = Contacto("Contacto 7","contacto7@gmail.com","225434376", R.drawable.contacto)
        val cont8 = Contacto("Contacto 8","contacto8@gmail.com","311475453",R.drawable.contacto)
        val cont9 = Contacto("Contacto 9","contacto9@gmail.com","135464376", R.drawable.contacto)
        val cont10 = Contacto("Contacto 10","contacto10@gmail.com","321745453",R.drawable.contacto)

        listaContactos.add(cont1)
        listaContactos.add(cont2)
        listaContactos.add(cont3)
        listaContactos.add(cont4)
        listaContactos.add(cont5)
        listaContactos.add(cont6)
        listaContactos.add(cont7)
        listaContactos.add(cont8)
        listaContactos.add(cont9)
        listaContactos.add(cont10)
    }
}
