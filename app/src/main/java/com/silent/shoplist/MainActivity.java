package com.silent.shoplist;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


//import com.silent.shoplist.database.DadosOpenHelper;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAdd;
    private CoordinatorLayout layoutContentMain;
    private SQLiteDatabase conexao;
//    private DadosOpenHelper dadosOpenHelper;
    private RecyclerView lstFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabAdd = findViewById(R.id.add_list);
        lstFav = findViewById(R.id.list_fav);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
