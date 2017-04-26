package com.example.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uibestpractice.entity.Msg;
import com.example.uibestpractice.util.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private  EditText editText;
    private   Button button;
    private RecyclerView recyclerView;
    private MsgAdapter msgAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        editText=(EditText)findViewById(R.id.edit_text);
        editText.setSingleLine(false);
        editText.setHorizontallyScrolling(false);
        button=(Button)findViewById(R.id.send_button);
        recyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        msgAdapter=new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=editText.getText().toString();
                if(!content.equals("")) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    editText.setText("");
                }
            }
        });

    }
    private void initMsg(){
        Msg msg1=new Msg("hello guy",Msg.TYPE_RECEIVED);
        Msg msg2=new Msg("hello.who is that?",Msg.TYPE_SEND);
        Msg msg3=new Msg("This is Tom.Nice to meet you.",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}
