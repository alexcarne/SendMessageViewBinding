package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/**
*Clase encargada de crear un mensaje con el texto que se mete por teclado y enviar dicho mensaje el usuario que ha escrito el mensaje.
*Ademas que aqui es donde se crea y muestra  el menu del about as.
 */

public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;
    public static final String TAG = "SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(view -> {
            sendMessage();
        });
        Log.d(TAG,"SendMessageActivity -> onCreate()");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.menu_aboutas) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendMessage() {
        Intent intent = new Intent(this,ViewActivity.class);
        Bundle bundle = new Bundle();
        Person person = new Person("Alex","Carnero","77673169F");
        bundle.putParcelable(Person.KEY,person);
        Person persone = new Person("Juanlu","Cabrera","5");
        Message message = new Message(binding.edMessage.getText().toString(),person,persone,1);
        bundle.putSerializable(Message.KEY,message);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //region Metodos ciclo vida
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG,"SendMessageActivity -> onDestroy()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessageActivity -> onResume()");
    }
//endregion
}