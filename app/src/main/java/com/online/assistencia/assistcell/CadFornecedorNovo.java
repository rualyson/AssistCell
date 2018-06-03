package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.online.assistencia.assistcell.R.layout.activity_cad_fornecedor_novo;


public class CadFornecedorNovo extends AppCompatActivity {


    private EditText editCadEmp,editCadRep,editCadEnd,editCadNum,editCadBai,editCadCid,editCadCep,editCadUf,editCadPais,editCadCom,editCadRef,editCadCnpj,editCadEma,editCadTel;
    private Button botCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_cad_fornecedor_novo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Fornecedores");

        editCadEmp = (EditText) findViewById(R.id.editCadEmp);
        editCadRep = (EditText) findViewById(R.id.editCadRep);
        editCadEnd = (EditText) findViewById(R.id.editCadEnd);
        editCadNum = (EditText) findViewById(R.id.editCadNum);
        editCadBai = (EditText) findViewById(R.id.editCadBai);
        editCadCid = (EditText) findViewById(R.id.editCadCid);
        editCadCep = (EditText) findViewById(R.id.editCadCep);
        editCadUf = (EditText) findViewById(R.id.editCadUf);
        editCadPais = (EditText) findViewById(R.id.editCadPais);
        editCadCom = (EditText) findViewById(R.id.editCadCom);
        editCadRef = (EditText) findViewById(R.id.editCadRef);
        editCadCnpj = (EditText) findViewById(R.id.editCadCnpj);
        editCadEma = (EditText) findViewById(R.id.editCadEma);
        editCadTel = (EditText) findViewById(R.id.editCadTel);

        botCad = (Button) findViewById(R.id.botCad);


        botCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editCadEmp.getText().length() == 0) || (editCadRep.getText().length() == 0)||
                        (editCadEnd.getText().length() == 0) || (editCadNum.getText().length() == 0)||
                        (editCadBai.getText().length() == 0) || (editCadCid.getText().length() == 0)||
                        (editCadCep.getText().length() == 0) || (editCadUf.getText().length() == 0)||
                        (editCadPais.getText().length() == 0) || (editCadCom.getText().length() == 0)||
                        (editCadRef.getText().length() == 0) || (editCadCnpj.getText().length() == 0)||
                        (editCadEma.getText().length() == 0) || editCadTel.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Todos os campos são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                }


                else {

                    AlertDialog show = new AlertDialog.Builder(CadFornecedorNovo.this)
                            .setTitle("Sucesso")
                            .setMessage("Fornecedor cadastrado com Sucesso!")
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    CadFornecedorNovo.this.finish();
                                }
                            })
                            .show();
                    limparCampos();
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, EscFornecedor.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    private void limparCampos() {
        editCadEmp.setText("");
        editCadRep.setText("");
        editCadEnd.setText("");
        editCadNum.setText("");
        editCadBai.setText("");
        editCadCid.setText("");
        editCadCep.setText("");
        editCadUf.setText("");
        editCadPais.setText("");
        editCadCom.setText("");
        editCadRef.setText("");
        editCadCnpj.setText("");
        editCadEma.setText("");
        editCadTel.setText("");

    }

}