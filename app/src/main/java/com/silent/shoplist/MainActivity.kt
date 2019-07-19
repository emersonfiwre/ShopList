package com.silent.shoplist

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton


//import com.silent.shoplist.database.DadosOpenHelper;

class MainActivity : AppCompatActivity() {
    private var fabAdd: FloatingActionButton? = null
    private val layoutContentMain: CoordinatorLayout? = null
    private val conexao: SQLiteDatabase? = null
    //    private DadosOpenHelper dadosOpenHelper;
    private var lstFav: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        fabAdd = findViewById(R.id.add_list)
        lstFav = findViewById(R.id.list_fav)

        //        criarConexao();
    }

    //    private void criarConexao(){
    //        try{
    //
    //            dadosOpenHelper = new DadosOpenHelper(this);
    //
    //            conexao = dadosOpenHelper.getWritableDatabase();
    //
    //            Snackbar.make(layoutContentMain, "CONEXÃO CRIADA COM SUCESSO!", Snackbar.LENGTH_SHORT)
    //                    .setAction("OK",null).show();
    //
    //
    //        }catch (SQLException ex){
    //            AlertDialog.Builder  dlg = new AlertDialog.Builder(this);
    //            dlg.setTitle("ERRO!");
    //            dlg.setMessage(ex.getMessage());
    //            dlg.setNeutralButton("OK",null);
    //            dlg.show();
    //
    //        }
    //    }

    //    public void showAddProductList(View view){
    //        Intent intent = new Intent(MainActivity.this, ActAddProductList.class );
    //        startActivity(intent);
    //    }


}
