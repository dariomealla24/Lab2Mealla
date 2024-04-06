package com.example.lab2mealla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(),ContadorListener {

    var fra1:fragmento1? = null //part 1
    var fra2:fragmento2? = null //part 1
    var button3: Button? = null //part 1
    var button4: Button? = null //part 1

    override fun onCreate(savedInstanceState: Bundle?) { //ya se crea - inicio
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //final

        fra1 = fragmento1() //part 1
        fra2 = fragmento2() //part 1
        fra1?.addContadorListener(this) //part 1
        fra2?.addListener(this) //part 1

        button3 = findViewById(R.id.button3) //part 1
        button4 = findViewById(R.id.button4) //part 1

        val toolbar = findViewById<Toolbar>(R.id.includeToolbar) //part 2
        setSupportActionBar(toolbar) //part 2

        button3?.setOnClickListener(OnClickListener {  //part 1 - inicio
            Toast.makeText(this,"Abriendo Fragmento 1",Toast.LENGTH_SHORT).show()
            val transaction = getSupportFragmentManager().beginTransaction()
            transaction.replace(R.id.fragmentContainer, fra1!!)
            transaction.commit()
        })

        button4?.setOnClickListener(OnClickListener {
            Toast.makeText(this,"Abriendo Fragmento 2",Toast.LENGTH_SHORT).show()
            val transaction = getSupportFragmentManager().beginTransaction()
            transaction.replace(R.id.fragmentContainer, fra2!!)
            transaction.commit()
        }) //final
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //part 2 - inicio
        val infla = menuInflater

        infla.inflate(R.menu.menutoolbar,menu)

        val item = menu?.findItem(R.id.itemBuscar)

        val sv = item?.actionView as android.widget.SearchView?

        sv?.setOnQueryTextListener( object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                val activity = sv.context as MainActivity
                Toast.makeText(activity,newText,Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                val activity = sv.context as MainActivity
                Toast.makeText(activity,"Buscar: "+query,Toast.LENGTH_SHORT).show()
                return true
            }
        })
        return true
    } // Final

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //part 2 - Inicio
        val itemId = item.itemId
        if(itemId == R.id.itemGuardar){
            Toast.makeText(applicationContext,"Hizo clic en el item Guardar",Toast.LENGTH_SHORT).show()
        }else if(itemId == R.id.itemAjustes){
            Toast.makeText(applicationContext,"Hizo clic en el item Ajustes",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    } //Final

    //part 1 - Inicio
        var cont = 0
    override fun incrementar() {
        cont++
    }

    override fun getValorActual(): Int {
        return cont
    }

    override fun resetear() {
        cont=0
    }

    override fun reducir() {
        if (cont >0)cont--
        else cont = 0
    }
    //final
}