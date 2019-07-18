package com.silent.shoplist.database;

/**
 * Created by Emerson on 08/10/2017.
 */

public class ScriptDLL {

    public static String getCreateTableCliente(){

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS PRODUTO( ");
        sql.append(     "CODIGO INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append(     "QUANTIDADE INTEGER NOT NULL DEFAULT('1'),");
        sql.append(     "NOME VARCHAR(200) NOT NULL DEFAULT (''), ");
        sql.append(     "VALOR DECIMAL(10,2) DEFAULT (''), ");
        sql.append(     "DATA_VENCIMENTO DATE  DEFAULT ('') ) ");

        return  sql.toString();

    }

}
