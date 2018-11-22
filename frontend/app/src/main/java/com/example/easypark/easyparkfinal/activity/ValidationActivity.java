package com.example.easypark.easyparkfinal.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.easypark.easyparkfinal.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ValidationActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_code);
        System.out.println("Shakal seja louvado");
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
            validate();
        }
    }

    private void validate(){
        Intent myIntent = new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }


}
