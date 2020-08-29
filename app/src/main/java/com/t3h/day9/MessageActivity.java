package com.t3h.day9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.t3h.day9.adapter.MessageAdapter;
import com.t3h.day9.model.Message;


import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private List<Message> arrMessages;
    private ListView lvMessage;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        arrMessages = new ArrayList<>();
        arrMessages.add(new Message("asdf1","fasdf"));
        arrMessages.add(new Message("asdf2","fasdf"));
        arrMessages.add(new Message("asdf3","fasdf"));
        arrMessages.add(new Message("asdf4","fasdf"));
        arrMessages.add(new Message("asdf5","fasdf"));
        arrMessages.add(new Message("asdf6","fasdf"));
        arrMessages.add(new Message("asdf7","fasdf"));
        arrMessages.add(new Message("asdf8","fasdf"));
        arrMessages.add(new Message("asdf9","fasdf"));
        arrMessages.add(new Message("asdf10","fasdf"));
        arrMessages.add(new Message("asdf11","fasdf"));
        arrMessages.add(new Message("asdf12","fasdf"));
        lvMessage = findViewById(R.id.lv_messages);
        adapter = new MessageAdapter(arrMessages, this);
        lvMessage.setAdapter(adapter);
        lvMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message message = arrMessages.get(position);
                //same with snackbar
                Toast.makeText(MessageActivity.this,
                        "Hello" + message.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        lvMessage.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrMessages.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}