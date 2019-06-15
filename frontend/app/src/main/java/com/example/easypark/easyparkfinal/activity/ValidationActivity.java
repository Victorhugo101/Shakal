package com.example.easypark.easyparkfinal.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.QrCode;
import com.example.easypark.easyparkfinal.beans.TokenDTO;
import com.example.easypark.easyparkfinal.network.MesaService;
import com.example.easypark.easyparkfinal.network.UsuarioService;
import com.example.easypark.easyparkfinal.utils.MessageBuilder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ValidationActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_code);
        this.barCodeCapture();
    }

    public void barCodeCapture(){
        IntentIntegrator integrator = new IntentIntegrator(ValidationActivity.this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Escaneie o QRCode na mesa");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String barcode = scanResult.getContents();
            validate(barcode);
        }
        else{

        }
    }

    private void validate(String barcode){

        Call call = MesaService.autenticarMesa(new QrCode(barcode));
        call.enqueue(new Callback<Long>() {
                @Override
                public void onResponse(Call<Long> call, Response<Long> response) {
                    callListScreen(response.body().longValue());
                }

                @Override
                public void onFailure(Call<Long> call, Throwable t) {
                    MessageBuilder.exibirMensagem("Código inválido", getApplicationContext(), Toast.LENGTH_LONG);
                }

        });

    }

    private void callListScreen(Long id){
        Intent myIntent = new Intent(this, ListActivity.class);
        myIntent.putExtra("mesaId",id);
        startActivity(myIntent);
    }


}
