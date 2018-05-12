package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormularioOrcamento extends AppCompatActivity {

    EditText nome_orc, marca_orc, modelo_orc, estFisico_orc, problem_orc, telefone_orc, email_orc, feedback_orc;
    RadioButton rb_sms, rb_email, rb_buscarAssist;
    Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);

        // Adicionando vínculo dos objetos aos id's

        nome_orc = (EditText) findViewById(R.id.editNome);
        marca_orc =(EditText) findViewById(R.id.editMarca);
        modelo_orc = (EditText) findViewById(R.id.editModelo);
        estFisico_orc = (EditText) findViewById(R.id.editEstadoFisico);
        problem_orc = (EditText) findViewById(R.id.editProblema);
        telefone_orc = (EditText) findViewById(R.id.editPhone);
        email_orc = (EditText) findViewById(R.id.editEmailOrc);
        final RadioGroup rg = findViewById(R.id.radioGroup);
        rb_sms = (RadioButton) findViewById(R.id.rbSMS);
        rb_email = (RadioButton) findViewById(R.id.rbEmail);

        rb_buscarAssist = (RadioButton)findViewById(R.id.rbBuscarAssist);

        btEnviar = (Button) findViewById(R.id.btnEnviar);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean radioGroup;
                if (nome_orc.getText().length() == 0 ||marca_orc.getText().length() == 0 ||modelo_orc.getText().length() == 0 ||
                        (telefone_orc.getText().length() == 0) || (email_orc.getText().length() == 0)) {
                    Toast.makeText(getApplication(), "Os campos Marca do produto, Modelo, Seu Nome, " +
                                    "Telefone, Email e Data da reserva são obrigatórios!", Toast.LENGTH_LONG).show();
                } if(radioGroup = rg.isSelected()){

                } else {
                }
            }
        });
    }
}
