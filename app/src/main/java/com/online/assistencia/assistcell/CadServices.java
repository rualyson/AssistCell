package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadServices extends AppCompatActivity implements View.OnClickListener {

    private EditText nomeCli, Marca, Modelo,Imei, EstadoF, Relato, Contato, Email, Horario, txtOutros;
    private RadioButton ac_chip;
    private RadioButton ac_cardSD;
    private RadioButton ac_Carregador;
    private RadioButton ac_Outros;
    private RadioButton ac_sem;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_services);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Cadastro de serviços");

        nomeCli = (EditText) findViewById(R.id.editNomeS);
        Marca = (EditText) findViewById(R.id.editMarcaS);
        Modelo = (EditText) findViewById(R.id.editModeloS);
        Imei = (EditText) findViewById(R.id.editImei);
        EstadoF = (EditText) findViewById(R.id.editEstadoFisicoS);
        Relato = (EditText) findViewById(R.id.editProblemaS);
        Contato = (EditText) findViewById(R.id.editPhoneS);
        Email = (EditText) findViewById(R.id.editEmailCliS);
        Horario = (EditText) findViewById(R.id.editHorario);
        txtOutros = (EditText) findViewById(R.id.editOutrosText);
        ac_chip = (RadioButton) findViewById(R.id.rbn_chip);
        ac_cardSD = (RadioButton) findViewById(R.id.rbn_cartao);
        ac_Carregador = (RadioButton) findViewById(R.id.rbn_carregador);
        ac_sem = (RadioButton) findViewById(R.id.rbn_sem);
        ac_Outros = (RadioButton) findViewById(R.id.rbn_outros);

        enviar = (Button) findViewById(R.id.btnEnviarS);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeCli.getText().length() == 0 || (Marca.getText().length() == 0) || (Modelo.getText().length() == 0)
                        || Horario.getText().length() == 0 || Imei.getText().length() == 0 || EstadoF.getText().length() == 0 || Relato.getText().length() == 0 || Contato.getText().length() == 0 || Email.getText().length() == 0 ||ac_chip.isChecked() == false && ac_cardSD.isChecked() == false && ac_Carregador.isChecked() == false && ac_sem.isChecked() == false && ac_Outros.isChecked() == false) {
                    Toast.makeText(getApplication(), "Todos os campos devem ser preenchidos!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication(), "Concluido com sucesso!",
                            Toast.LENGTH_LONG).show();
                    limparCampos();
                }
            }
        });

    }

    private void limparCampos() {
        nomeCli.setText("");
        Marca.setText("");
        Modelo.setText("");
        EstadoF.setText("");
        Imei.setText("");
        Relato.setText("");
        Horario.setText("");
        Contato.setText("");
        Email.setText("");
        txtOutros.setText("");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, TabServicos.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
