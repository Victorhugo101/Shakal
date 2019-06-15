package easypark.com.mobiletruck.utils

import android.content.Context
import android.widget.Toast


class MessageBuilder {

    companion object{
        fun exibirMensagem(mensagem: String, context: Context) {
            Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
        }
    }
}