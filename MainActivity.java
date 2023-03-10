package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private Button one,two,three,four,five,six,seven,eight,nine,zero,equal,add,sub,multi,divide,percent,cancel,dot,bracket;
    private ImageButton backspace;
    boolean checkbracket=false;
    private TextView tvr,tvi;
    String process;
    private Object Script;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.ONE);
        two = findViewById(R.id.TWO);
        three = findViewById(R.id.THREE);
        four = findViewById(R.id.FOUR);
        five = findViewById(R.id.FIVE);
        six = findViewById(R.id.SIX);
        seven = findViewById(R.id.SEVEN);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.NINE);
        zero = findViewById(R.id.ZERO);
        equal = findViewById(R.id.EQUAL);
        cancel = findViewById(R.id.CLEAR);
        add = findViewById(R.id.PLUS);
        sub = findViewById(R.id.MINUS);
        multi = findViewById(R.id.MUL);
        divide = findViewById(R.id.DIV);
        percent = findViewById(R.id.PERC);
        dot = findViewById(R.id.DOT);
        bracket = findViewById(R.id.BRACKET);
        tvi = findViewById(R.id.v1);
        tvr = findViewById(R.id.v2);
        backspace = findViewById(R.id.BACK);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvi.setText("");
                tvr.setText("");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CharSequence process = tvi.getText().toString();
                tvi.setText(process + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              CharSequence process= tvi.getText().toString();
                tvi.setText(process + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "3");
            }
        });
       four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "4");
            }
        });
   five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "5");
            }
        });
    six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "9");
            }
        });
      add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "-");
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "*");
            }
        });
    divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "/");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + ".");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence process= tvi.getText().toString();
                tvi.setText(process + "%");
            }
        });
bracket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(checkbracket==true){
            process=tvi.getText().toString();
            tvi.setText(process+")");
            checkbracket=false;
        }
        else {
            process=tvi.getText().toString();
            tvi.setText(process+"(");
            checkbracket=true;
        }
    }
});
equal.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        process=tvi.getText().toString();
        process=process.replaceAll("%","/100");
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);

        String finalresult= "";
        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalresult = rhino.evaluateString(scriptable,process,"javascript",1, null).toString();
        }
        catch(Exception e)
        {
            finalresult="0";
        }
        tvr.setText(finalresult);
        }
});
backspace.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(!process.equals("")){
            process=tvi.getText().toString();
            if(process.length()>0){
                process=process.substring(0,process.length()-1);
                tvi.setText(process);
            }
        }
    }
});
    }

}