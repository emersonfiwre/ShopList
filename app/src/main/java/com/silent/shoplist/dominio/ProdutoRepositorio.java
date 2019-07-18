package com.silent.shoplist.dominio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.silent.shoplist.dominio.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {

    private SQLiteDatabase conexao;

    public  ProdutoRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }
    public void inserir(Produto produto){
        ContentValues contentValues = new ContentValues();
        contentValues.put("QUANTIDADE",produto.qtde);
        contentValues.put("NOME",produto.produto);
        contentValues.put("VALOR",produto.valor);
        contentValues.put("DATA_VENCIMENTO",produto.data);

        conexao.insertOrThrow("PRODUTO",null,contentValues);
    }
    public void excluir(Produto produto){

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(produto.codigo);
        conexao.delete("PRODUTO","CODIGO = ?",parametros);

    }
    public void alterar(Produto produto){
        ContentValues contentValues = new ContentValues();
        contentValues.put("QUANTIDADE",produto.qtde);
        contentValues.put("NOME",produto.produto);
        contentValues.put("VALOR",produto.valor);
        contentValues.put("DATA_VENCIMENTO",produto.data);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(produto.codigo);
        conexao.update("PRODUTO",contentValues,"CODIGO = ?",parametros);

    }

    public List<Produto> buscarTodos(){
        List<Produto> listProduto = new ArrayList<Produto>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, QUANTIDADE, NOME, VALOR, DATA_VENCIMENTO");
        sql.append(" FROM PRODUTO");


        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if(resultado.getCount() > 0 ){
            resultado.moveToFirst();

            do{

                Produto produto = new Produto();

                produto.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                produto.qtde = resultado.getInt(resultado.getColumnIndexOrThrow("QUANTIDADE"));
                produto.produto = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                produto.valor = resultado.getDouble(resultado.getColumnIndexOrThrow("VALOR"));
                produto.data = resultado.getString(resultado.getColumnIndexOrThrow("DATA_VENCIMENTO"));

                listProduto.add(produto);

            }while (resultado.moveToNext());

        }

        return listProduto;

    }

    public Produto buscar(int codigo){
        Produto produto = new Produto();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, QUANTIDADE, NOME, VALOR, DATA_VENCIMENTO");
        sql.append(" FROM PRODUTO");
        sql.append(" WHERE CODIGO = ?");

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(produto.codigo);

        Cursor resultado = conexao.rawQuery(sql.toString(), null);
        if(resultado.getCount()>0){


            produto.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
            produto.qtde = resultado.getInt(resultado.getColumnIndexOrThrow("QUANTIDADE"));
            produto.produto = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
            produto.valor = resultado.getDouble(resultado.getColumnIndexOrThrow("VALOR"));
            produto.data = resultado.getString(resultado.getColumnIndexOrThrow("DATA_VENCIMENTO"));

            return produto;

        }while (resultado.moveToNext());



        return null;
    }


}
