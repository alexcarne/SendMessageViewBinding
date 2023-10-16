package com.example.sendmessageviewbinding;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

/**
*Activity donde se muestra la información del mensaje mandado y el usuario.
 */
public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding binding;

    private Message message;
    public static final String TAG = "ViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        message = bundle.getParcelable(Message.KEY);
        inicialiceView();
    }

    /**
     * Método que inicializa todas las vistas o widgets de la interfaz o layout
     */
    private void inicialiceView() {
        binding.tvUserInfo.setText(message.getSender().toString());
        binding.tvMessage.setText(message.getContext());
    }
    //region Metodos ciclo vida
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG,"ViewActivity -> onDestroy()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ViewActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ViewActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ViewActivity -> onResume()");
    }
//endregion
}