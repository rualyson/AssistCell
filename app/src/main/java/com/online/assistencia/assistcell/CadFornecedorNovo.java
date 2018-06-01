package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.online.assistencia.assistcell.R.layout.activity_cad_fornecedor_novo;


public class CadFornecedorNovo extends AppCompatActivity {


    private EditText editCadEmp;
    private EditText editCadRep;
    private EditText editCadEnd;
    private EditText editCadNum;
    private EditText editCadBai;
    private EditText editCadCid;
    private EditText editCadCep;
    private EditText editCadUf;
    private EditText editCadPais;
    private EditText editCadCom;
    private EditText editCadRef;
    private EditText editCadCnpj;
    private EditText editCadEma;
    private EditText editCadTel;

    private Button botCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_cad_fornecedor_novo);


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
                    Toast.makeText(getApplication(),
                            "Fornecedor cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}