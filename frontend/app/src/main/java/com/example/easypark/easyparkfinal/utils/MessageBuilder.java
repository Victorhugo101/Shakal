package com.example.easypark.easyparkfinal.utils;

import android.content.Context;
import android.widget.Toast;

public class MessageBuilder {

    public static void exibirMensagem(String mensagem, Context context){
        Toast.makeText(context,mensagem,Toast.LENGTH_SHORT).show();
    }
}
