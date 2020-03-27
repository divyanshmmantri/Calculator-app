package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText result, new_number;
    TextView Operation;

    private Double operand1 = null;
    private Double operand2 = null;
    private String pending_operation = "=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = findViewById(R.id.result);
        new_number = findViewById(R.id.new_number);
        Operation = findViewById(R.id.Operation);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_mul = findViewById(R.id.button_mul);
        Button button_add = findViewById(R.id.button_add);
        Button button_dot = findViewById(R.id.button_dot);
        Button button_equal = findViewById(R.id.button_equal);
        Button button_minus=findViewById(R.id.button_minus);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button) v;
                new_number.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button_dot.setOnClickListener(listener);
        View.OnClickListener oplistener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button) v;
                String op=b.getText().toString();
                String value=new_number.getText().toString();
                if(value.length()!=0)
                {
                    perform_op(value,op);
                }
                pending_operation=op;
                Operation.setText(pending_operation);
            }
        };
        button_equal.setOnClickListener(oplistener);
        button_add.setOnClickListener(oplistener);
        button_divide.setOnClickListener(oplistener);
        button_mul.setOnClickListener(oplistener);
        button_minus.setOnClickListener(oplistener);


        }

        private void perform_op(String value,String operation)
        {
            if(null == operand1)
            {
                operand1=Double.valueOf(value);
            }
            else
            {
                operand2=Double.valueOf(value);
                if(pending_operation.equals("="))
                {
                    pending_operation=operation;
                }
                switch (pending_operation)
                {
                    case "=":
                        operand1=operand2;
                        break;

                    case "*":
                        operand1=operand1*operand2;
                        break;
                    case "+":
                        operand1=operand1+operand2;
                        break;
                    case "-":
                        operand1=operand1-operand2;
                        break;
                    case "/":
                        if(operand2==0)
                        {
                            operand1=0.0;
                        }
                        else{
                            operand1=operand1/operand2;

                        }
                        break;
                }
            }
            result.setText(operand1.toString());
            new_number.setText("");

        }


    }

