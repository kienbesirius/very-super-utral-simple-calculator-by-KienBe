package com.fetchme.simplecalculatorsdk26demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.StringBufferInputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int FIRST_INDEX = 0;

    private ImageButton button_0;
    private ImageButton button_1;
    private ImageButton button_2;
    private ImageButton button_3;
    private ImageButton button_4;
    private ImageButton button_5;
    private ImageButton button_6;
    private ImageButton button_7;
    private ImageButton button_8;
    private ImageButton button_9;
    private ImageButton button_clear;
    private ImageButton button_decimal;
    private ImageButton button_delete;
    private ImageButton button_divide;
    private ImageButton button_mark;
    private ImageButton button_minus;
    private ImageButton button_multiple;
    private ImageButton button_plus;
    private ImageButton button_result;
    private ImageButton button_percent;

    private TextView textView_Result;

    private String string_number = "0"; // for text display
    private String last_operator = ""; // for calculate operator
    private String first_operator = ""; // for negative | positive

    private boolean is_negative = false; // not negative
    private boolean is_used_dot = false; // not used yet
    // End Initialization

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIDtoVIEW();
        setupVIEWS();
    }

    private void setupVIEWS() {
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_decimal.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_mark.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_result.setOnClickListener(this);
        button_percent.setOnClickListener(this);

        textView_Result.setText("0");
    } // End setupVIEWS()

    private void mapIDtoVIEW() {
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_clear = findViewById(R.id.button_clear);
        button_decimal = findViewById(R.id.button_decimal);
        button_delete = findViewById(R.id.button_delete);
        button_divide = findViewById(R.id.button_divide);
        button_mark = findViewById(R.id.button_mark);
        button_minus = findViewById(R.id.button_minus);
        button_multiple = findViewById(R.id.button_multiple);
        button_plus = findViewById(R.id.button_plus);
        button_result = findViewById(R.id.button_result);
        button_percent = findViewById(R.id.button_percent);

        textView_Result = findViewById(R.id.textView_Result);
    } // End mapIDtoVIEW()


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String current = textView_Result.getText().toString();
        switch(view.getId()){
            case R.id.button_0:{
                setNumber(0);
                break;
            }
            case R.id.button_1:{
               setNumber(1);
                break;
            }
            case R.id.button_2:{
                setNumber(2);
                break;
            }
            case R.id.button_3:{
                setNumber(3);
                break;
            }
            case R.id.button_4:{
                setNumber(4);
                break;
            }
            case R.id.button_5:{
                setNumber(5);
                break;
            }
            case R.id.button_6:{
                setNumber(6);
                break;
            }
            case R.id.button_7:{
                setNumber(7);
                break;
            }
            case R.id.button_8:{
                setNumber(8);
                break;
            }
            case R.id.button_9:{
                setNumber(9);
                break;
            }
            case R.id.button_clear:{
                if(!current.equals("")){
                    textView_Result.setText("");
                    last_operator = "";
                    string_number = "";
                    is_negative = false;
                    is_used_dot = false; // not use yet
                    Toast.makeText(this,"CLEARED!", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.button_decimal:{
                if(!is_used_dot){
                    switch(last_operator){
                        case ".":{
                            break;
                        }
                        case "":{
                            if(current.equals("")){
                                string_number += "0.";
                            }else {
                                string_number += ".";
                            }
                            break;
                        }
                        case "+":
                        case "-":
                        case "x":
                        case ":":{
                            string_number += "0.";
                            break;
                        }
                        default:{

                        }

                    }
                }
                is_used_dot = true;
                break;
            }
            case R.id.button_delete: {
                if (!current.equals("")) {
                    int last_index = string_number.length() - 1;
                    string_number = (String) string_number.subSequence(FIRST_INDEX, last_index);
                    //String lastChar = string_number.substring(last_index);

//                    try {
//                        int number = Integer.parseInt(lastChar);
//                    } catch (Exception e) {
//                        last_operator = lastChar;
//                        switch (last_operator) {
//                            case ":":
//                            case "+":
//                            case "-":
//                            case "x": {
//                                is_used_dot = false;
//                                break;
//                            }
//                            case ".":
//                            case "%": {
//                                is_used_dot = true;
//                                break;
//                            }
//                            default: {
//                                if (current.contains(last_operator)) {
//
//                                }
//                                break;
//                            }
//                        }
//                    }
                }else{
                    is_used_dot = false;
                    is_negative = false;
                    last_operator = "";
                }
                break;
            }
            case R.id.button_divide:{
                if(!current.equals("")){
                    string_number = CALC_for_operator(string_number);
                    switch(last_operator){
                        case "+":
                        case "-":
                        case "x":{
                            string_number = string_number.replace(last_operator, ":");
                            break;
                        }
                        case "%":
                        case "":{
                            string_number += ":";
                            break;
                        }
                        case ".":{
                            string_number += "0:";
                            break;
                        }
                        default:{

                            break;
                        }
                    }
                }

                is_used_dot = false;
                last_operator = ":";
                break;
            }
            case R.id.button_mark:{
                // Positive Number
                switch(current){
                    case "":{
                        break;
                    }

                }
                if(!current.equals("")){
                    is_negative = !is_negative; // Negative Number
                    first_operator = is_negative ? "-" : "";
                    if(is_negative){
                        string_number = first_operator + string_number;
                    }else{
                        string_number = string_number.replaceFirst("^-","");
                    }
                }
                break;
            }
            case R.id.button_minus:{
                if(!current.equals("")){
                    string_number = CALC_for_operator(string_number);
                    switch(last_operator){
                        case "+":
                        case ":":
                        case "x":{
                            string_number = string_number.replace(last_operator, "-");
                            break;
                        }
                        case "%":
                        case "":{
                            string_number += "-";
                            break;
                        }
                        case ".":{
                            string_number += "0-";
                            break;
                        }
                        default:{

                            break;
                        }
                    }
                }
                is_used_dot = false;
                last_operator = "-";
                break;
            }
            case R.id.button_multiple:{
                if(!current.equals("")){
                    string_number = CALC_for_operator(string_number);
                    switch(last_operator){
                        case "+":
                        case "-":
                        case ":":{
                            string_number = string_number.replace(last_operator, "x");
                            break;
                        }
                        case "%":
                        case "":{
                            string_number += "x";
                            break;
                        }
                        case ".":{
                            string_number += "0x";
                            break;
                        }
                        default:{

                            break;
                        }
                    }
                }

                is_used_dot = false;
                last_operator = "x";
                break;
            }
            case R.id.button_plus:{
                if(!current.equals("")){
                    string_number = CALC_for_operator(string_number);
                    switch(last_operator){

                        case ":":
                        case "-":
                        case "x":{
                            string_number = string_number.replace(last_operator, "+");
                            break;
                        }
                        case "%":
                        case "":{
                            string_number += "+";
                            break;
                        }
                        case ".":{
                            string_number += "0+";
                            break;
                        }
                        default:{

                            break;
                        }
                    }
                }
                is_used_dot = false;
                last_operator = "+";
                break;
            }
            case R.id.button_percent:{
                if(!string_number.equals("")){
                    switch(last_operator){
                        case ":":
                        case "-":
                        case "+":
                        case "x":{
                            Toast.makeText(this,"Invalid! Cannot form an expression", Toast.LENGTH_LONG).show();
                            break;
                        }
                        case ".":{
                            string_number += "0%";
                            break;
                        }
                        default:{
                            string_number += "%";
                        }
                    }
                    is_used_dot = true;
                    last_operator = "%";
                    string_number = percentCalculate(string_number);
                }
                break;
            }
            case R.id.button_result:{
                string_number = Calculating(string_number);
                last_operator = "";
                break;
            }
        } // End Switch ViEWS
        textView_Result.setText(string_number);
    } // End onClick()

    private String percentCalculate(String text){
        if(text.contains("%")){
            text = text.replace("%","/100");
            text = Calculating(text);
        }
        return text;
    }

    private String Calculating(String text){
        if(!text.equals("")){
            try{
                String temp = String.valueOf(Double.parseDouble(text));
                if(checkDecimal(Double.parseDouble(text))){
                    temp = String.valueOf((long)Double.parseDouble(text));
                }
                text = temp;
            }catch (Exception e){
                if(is_negative){
                    text = text.substring(1);
                    String[] temp2 = text.split("x|/|-|\\+|:");
                    try{
                        double n1 = Double.parseDouble(temp2[0]);
                        double n2 = Double.parseDouble(temp2[1]);
                        double n3 = 0;
                        if(text.contains("+")){
                            n3 = -n1+n2;
                        }
                        else if(text.contains("-")){
                            n3 = -n1-n2;
                        }
                        else if(text.contains("x")){
                            n3 = -n1*n2;
                        }else if(text.contains("/") || text.contains(":")){
                            n3 = -n1/n2;
                        }
                        text = String.valueOf(n3);
                    }catch (Exception e1 ){

                    }
                }else{
                    String[] temp2 = text.split("x|/|-|\\+|:");
                    try{
                        double n1 = Double.parseDouble(temp2[0]);
                        double n2 = Double.parseDouble(temp2[1]);
                        double n3 = 0;
                        if(text.contains("+")){
                            n3 = n1+n2;
                        }
                        else if(text.contains("-")){
                            n3 = n1-n2;
                        }
                        else if(text.contains("x")){
                            n3 = n1*n2;
                        }else if(text.contains("/") || text.contains(":")){
                            n3 = n1/n2;
                        }
                        text = String.valueOf(n3);
                    }catch (Exception e1 ){

                    }
                }

                try{
                    if(checkDecimal(Double.parseDouble(text))){
                        text = String.valueOf((long)Double.parseDouble(text));
                    }
                    if(text.contains(".")){
                        int value = text.indexOf(".");
                        if(text.length() > value + 5){
                            text = text.substring(FIRST_INDEX,value+5);
                        }
                        is_used_dot = true;
                    }else{
                        is_used_dot = false;
                    }
                    if(text.contains("-")){
                        is_negative = true;
                    }else{
                        is_negative = false;
                    }
                }catch (Exception e3){
                }

            }
        }
        return text;
    }
    private void setNumber(int number){
        string_number += number;
        last_operator = "";
    }

    private boolean checkDecimal(double number){
        if(number%1 == 0){
            return true; // none decimal
        }
        return false;//is decimal
    }
    private String CALC_for_operator(String text){
        String text1 = text;
        if(text.contains(last_operator) && !last_operator.equals(".")){
            text1 = Calculating(text);
        }
        return text1;
    }
}//End Main