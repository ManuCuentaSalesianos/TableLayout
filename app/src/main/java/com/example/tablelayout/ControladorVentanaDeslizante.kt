package com.example.tablelayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ControladorVentanaDeslizante(supportFragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(supportFragmentManager) {

        private val listaFragmentos = ArrayList<Fragment>()
        private val listaTitulosFragmentos = ArrayList<String>()

        //Agrega el fragmento y su título a la lista de fragmentos y lista de titulos
        fun addFragments(fragment: Fragment, title: String) {
                listaFragmentos.add(fragment)
                listaTitulosFragmentos.add(title)
        }

        //Devolvemos un item en una posicion determinada
        override fun getItem(position: Int): Fragment {
                return listaFragmentos[position]
        }

        //Devolvemos el número de fragmentos
        override fun getCount(): Int {
                return listaFragmentos.size
        }

        //Devolvemos el titulo de la pagina
        override fun getPageTitle(position: Int): String {
                return listaTitulosFragmentos[position]
        }
}
