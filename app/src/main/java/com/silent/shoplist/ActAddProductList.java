package com.silent.shoplist;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import com.silent.shoplist.entidades.Produto;

public class ActAddProductList extends AppCompatActivity {

    private EditText edtQtde, edtNome,edtValor, edtData;
    private CoordinatorLayout layoutContentMain;
    private SQLiteDatabase conexao;
     private Button btnAdiciona;
    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_add_product_list);
        edtQtde = findViewById(R.id.edt_qtde);
        edtNome = findViewById(R.id.edt_nome);
        edtValor = findViewById(R.id.edt_valor);
        edtData = findViewById(R.id.edt_data);
        btnAdiciona = findViewById(R.id.btn_add);


    }

    private boolean validaCampos(){

        boolean res = false;

        String qtde = edtQtde.getText().toString();
        String nome = edtNome.getText().toString();
        String valor = edtValor.getText().toString();
        String data =edtData.getText().toString();

        produto.qtde = Integer.parseInt(qtde);
        produto.produto = nome;
        produto.valor = Double.parseDouble(valor);
        produto.data = data;


        if (res = isCampoVazio(qtde) == true){
            edtQtde.requestFocus();
        }
        else if (res = isCampoVazio(nome)) {
            edtNome.requestFocus();

        }
        else if (res = isCampoVazio(valor)){

            edtValor.requestFocus();
        }
        else if(res = isCampoVazio(data)){
            edtData.requestFocus();

        }
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        if (res == true){

            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.message_campos_invalidos_brancos);
            dlg.setNeutralButton(R.string.lbl_ok, null);
            dlg.show();
        }
        else {
            dlg.setTitle("Concluido!!");
            dlg.setMessage("Cadastrado com sucesso!");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
        return res;

    }


    private boolean isCampoVazio(String valor){

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
        return  resultado;

    }



 }
