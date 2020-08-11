package com.example.androidexam;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.example.androidexam.R;

public class Email_fragment extends  Fragment {
    @Nullable

    private TextView sub;
    private TextView mes;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_email, container, false);

        sub= v.findViewById(R.id.subject);
        mes= v.findViewById(R.id.message);
        Button btn = v.findViewById(R.id.buttonSend);
        String subject= sub.getText().toString();
        String message= mes.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subject= sub.getText().toString();
                String message= mes.getText().toString();

                // 2) sending the inputs using implicit intent
                Intent intent= new Intent(Intent.ACTION_SEND);

                intent.putExtra(intent.EXTRA_EMAIL, new String[] {"pooneh2009@gmail.com"}); //info@studyosc.com
                intent.putExtra(intent.EXTRA_SUBJECT, subject);
                intent.putExtra(intent.EXTRA_TEXT, message);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
        return v;
    }

}

