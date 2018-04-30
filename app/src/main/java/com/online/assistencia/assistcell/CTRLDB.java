package com.online.assistencia.assistcell;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CTRLDB {

    private SQLiteDatabase db;
    private DBAssist banco;

    public CTRLDB(Context context){
        banco = new DBAssist(context);
    }

    public String insereDado(String nome, String telefone,String email, String data){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DBAssist.NOME, nome);
        valores.put(DBAssist.TELEFONE, telefone);
        valores.put(DBAssist.EMAIL, email);
        valores.put(DBAssist.DATA, data);

        resultado = db.insert(DBAssist.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }
}