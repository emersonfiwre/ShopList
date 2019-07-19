package com.silent.shoplist


import android.database.sqlite.SQLiteDatabase

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout


import com.silent.shoplist.Beans.Produto

class ActAddProductList : AppCompatActivity() {

    private var edtQtde: EditText? = null
    private var edtNome: EditText? = null
    private var edtValor: EditText? = null
    private var edtData: EditText? = null
    private val layoutContentMain: CoordinatorLayout? = null
    private val conexao: SQLiteDatabase? = null
    private var btnAdiciona: Button? = null
    private val produto: Produto? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_add_product_list)
        edtQtde = findViewById(R.id.edt_qtde)
        edtNome = findViewById(R.id.edt_nome)
        edtValor = findViewById(R.id.edt_valor)
        edtData = findViewById(R.id.edt_data)
        btnAdiciona = findViewById(R.id.btn_add)


    }

    private fun validaCampos(): Boolean {

        var res = false

        val qtde = edtQtde!!.text.toString()
        val nome = edtNome!!.text.toString()
        val valor = edtValor!!.text.toString()
        val data = edtData!!.text.toString()

        produto!!.qtde = Integer.parseInt(qtde)
        produto.produto = nome
        produto.valor = java.lang.Double.parseDouble(valor)
        produto.data = data


        if (res = isCampoVazio(qtde) == true) {
            edtQtde!!.requestFocus()
        } else if (res = isCampoVazio(nome)) {
            edtNome!!.requestFocus()

        } else if (res = isCampoVazio(valor)) {

            edtValor!!.requestFocus()
        } else if (res = isCampoVazio(data)) {
            edtData!!.requestFocus()

        }
        val dlg = AlertDialog.Builder(this)

        if (res == true) {

            dlg.setTitle(R.string.title_aviso)
            dlg.setMessage(R.string.message_campos_invalidos_brancos)
            dlg.setNeutralButton(R.string.lbl_ok, null)
            dlg.show()
        } else {
            dlg.setTitle("Concluido!!")
            dlg.setMessage("Cadastrado com sucesso!")
            dlg.setNeutralButton("OK", null)
            dlg.show()

        }
        return res

    }


    private fun isCampoVazio(valor: String): Boolean {

        return TextUtils.isEmpty(valor) || valor.trim { it <= ' ' }.isEmpty()

    }


}
