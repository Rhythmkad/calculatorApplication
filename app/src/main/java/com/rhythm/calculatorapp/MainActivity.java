package com.rhythm.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEdt;
    private TextView resultTv;
    private String operator = "", InputStringValue = "";
    private boolean isAddition,isSubtraction,isMultiply, isDivide,isDecimal;
    private int inputTextLength = 0;
    private double firstValue, secondValue, resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeIds();
    }

    private void initializeIds() {

        inputEdt = findViewById(R.id.valueEdt);  // input edit text where user enters the number
        resultTv = findViewById(R.id.resultTv); // text view where result will show

        // fetching button Ids
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button raiseToPowerBtn = findViewById(R.id.raiseToPowerBtn);
        Button squareRoot = findViewById(R.id.btnSqRoot);
        Button cubeRoot = findViewById(R.id.btnCubeRoot);
        Button btnClear = findViewById(R.id.btnClear); // clear button to clear everything
        Button btnEqual = findViewById(R.id.equalBtn); // equal button to get the result
        Button btnDelete = findViewById(R.id.btnDelete); // delete button to remove single digit
        Button btnAdd = findViewById(R.id.btnAdd); // add button
        Button btnSubtract = findViewById(R.id.btnSubtract); // subtract button
        Button btnDivide = findViewById(R.id.btnDiv); // divide button
        Button btnMultiply = findViewById(R.id.btnMultiply); // multiply button
        Button btnDecimal = findViewById(R.id.btnDecimal); // decimal button

        // button's click listener
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        raiseToPowerBtn.setOnClickListener(this);
        squareRoot.setOnClickListener(this);
        cubeRoot.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "DefaultLocale"})
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                // adding 0 to previous edit text value when user press 0 button
                setEditText(inputEdt.getText().toString() + "0");
                // this will count the length of the input value
                inputTextLength +=1;
                break;
            case R.id.btn1:
                // adding 1 to previous edit text value when user press 1 button
                setEditText(inputEdt.getText().toString() + "1");
                inputTextLength +=1;
                break;
            case R.id.btn2:
                // adding 2 to previous edit text value when user press 2 button
                setEditText(inputEdt.getText().toString()+ "2");
                inputTextLength +=1;
                break;
            case R.id.btn3:
                // adding 3 to previous edit text value when user press 3 button
                setEditText(inputEdt.getText().toString() + "3");
                inputTextLength +=1;
                break;
            case R.id.btn4:
                // adding 4 to previous edit text value when user press 4 button
                setEditText(inputEdt.getText().toString() + "4");
                inputTextLength +=1;
                break;
            case R.id.btn5:
                // adding 5 to previous edit text value when user press 5 button
                setEditText(inputEdt.getText().toString() + "5");
                inputTextLength +=1;
                break;
            case R.id.btn6:
                // adding 6 to previous edit text value when user press 6 button
                setEditText(inputEdt.getText().toString() + "6");
                inputTextLength +=1;
                break;
            case R.id.btn7:
                // adding 7 to previous edit text value when user press 7 button
                setEditText(inputEdt.getText().toString() + "7");
                inputTextLength +=1;
                break;
            case R.id.btn8:
                // adding 8 to previous edit text value when user press 8 button
                setEditText(inputEdt.getText().toString() + "8");
                inputTextLength +=1;
                break;
            case R.id.btn9:
                // adding 9 to previous edit text value when user press 9 button
                setEditText(inputEdt.getText().toString() + "9");
                inputTextLength +=1;
                break;
            case R.id.btnClear:
                // it clears all the values to default or empty
                inputEdt.setText("");
                resultTv.setText("");
                firstValue = 0;
                secondValue = 0;
                resultValue = 0;
                inputTextLength = 0;
                isDecimal = false;
                isAddition = false;
                isSubtraction = false;
                isDivide = false;
                isMultiply = false;
                break;
            case R.id.equalBtn:
                if (!inputEdt.getText().toString().isEmpty()) {
                    String firstValueString;
                    String secondValueString;
                    InputStringValue = inputEdt.getText().toString();
                    // here we are getting the input value by the user
                    // and breaking it into 2 substrings,
                    // firstValueString and secondValueString through Strings' subString method
                    // which takes perimeters begin index and end index
                    // then converting those subStrings into Double type value.
                    switch (operator) {
                        case "+":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("+"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("+")+1);
                            firstValue = Double.parseDouble(firstValueString);
                            if(!secondValueString.isEmpty()) {
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = firstValue + secondValue;
                            }else{
                                // here if second Value is empty than only firstValue will print
                                // in the result.
                                resultValue = firstValue;
                            }
                            break;
                        case "-":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("-"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("-")+1);
                            firstValue = Double.parseDouble(firstValueString);
                            if(!secondValueString.isEmpty()) {
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = firstValue - secondValue;
                            }else{
                                // here if second Value is empty than only firstValue will print
                                // in the result.
                                resultValue = firstValue;
                            }
                            break;
                        case "/":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("\u00F7"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("\u00F7")+1);
                            firstValue = Double.parseDouble(firstValueString);
                            if(!secondValueString.isEmpty()) {
                                secondValue = Double.parseDouble(secondValueString);
                                if (secondValue != 0) {
                                    resultValue = firstValue / secondValue;
                                } else {
                                    resultTv.setText("Cannot be divided by 0");
                                }
                            }else{
                                // here if second Value is empty than only firstValue will print
                                // in the result.
                                resultValue = firstValue;
                            }
                            break;
                        case "*":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("*"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("*")+1);
                            firstValue = Double.parseDouble(firstValueString);
                            if(!secondValueString.isEmpty()) {
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = firstValue * secondValue;
                            }else{
                                // here if second Value is empty than only firstValue will print
                                // in the result.
                                resultValue = firstValue;
                            }
                            break;
                        case "^":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("^"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("^")+1);
                            firstValue = Double.parseDouble(firstValueString);
                            if(!secondValueString.isEmpty()) {
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = Math.pow(firstValue,secondValue);
                            }else{
                                // here if secondValue is null than by default the
                                // raise to the power value set to 0.
                                // 5^0 and result will be 1, because anything raise to power 0 is 1.
                                resultValue = Math.pow(firstValue,0);
                            }
                            break;
                        case "\u221a":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("\u221a"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("\u221a")+1);
                            if(!firstValueString.isEmpty()) {
                                firstValue = Double.parseDouble(firstValueString);
                                secondValue = Double.parseDouble(secondValueString);
                                // here if a value is there before square root then we will multiply the first value
                                // with the result of square root.
                                resultValue = firstValue * Math.sqrt(secondValue);
                            }else if (!secondValueString.isEmpty()){
                                // if value is not there before square root than only
                                // square root value will be printed.
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = Math.sqrt(secondValue);
                            }else{
                                // here if user didn't enter the sq. root value
                                // it will show expression error
                                resultTv.setText("Expression error");
                            }
                            break;
                        case "\u221b":
                            firstValueString = InputStringValue.substring(0, InputStringValue.indexOf("\u221b"));
                            secondValueString = InputStringValue.substring(InputStringValue.indexOf("\u221b")+1);
                            if(!firstValueString.isEmpty()) {
                                firstValue = Double.parseDouble(firstValueString);
                                secondValue = Double.parseDouble(secondValueString);
                                // here if a value is there before cube root then we will multiply the first value
                                // with the result of cube root.
                                resultValue = firstValue * Math.cbrt(secondValue);
                            }else if (!secondValueString.isEmpty()){
                                // if value is not there before cube root than only
                                // cube root value will be printed.
                                secondValue = Double.parseDouble(secondValueString);
                                resultValue = Math.cbrt(secondValue);
                            }else{
                                // here if user didn't enter the cube root value
                                // it will show expression error
                                resultTv.setText("Expression error");
                            }
                            break;
                    }
                    int resultValueInteger;

                    // all integers are module of 1, so if double value have zero after decimal
                    // we will convert it into integer value, else we will set the decimal value upto 6 digits.
                    if (resultValue != 0) {
                        // here if resultValue length is greater than 10
                        // we will change the size of textView to 32
                        if (String.valueOf(resultValue).length() > 10) {
                            resultTv.setTextSize(24);
                        } else {
                            resultTv.setTextSize(32);
                        }

                        if (resultValue % 1 == 0) {
                            DecimalFormat decimalFormat = new DecimalFormat("0");
                            resultTv.setText(decimalFormat.format(resultValue) + "");
                        } else {
                            resultTv.setText(String.valueOf(new BigDecimal(resultValue).round(new MathContext(6)).doubleValue()));
                        }
                    }

                    // resetting values to 0
                    firstValue = 0;
                    secondValue = 0;
                    resultValue = 0;
                    inputTextLength = 0;
                }
                break;
            case R.id.btnDelete:
                // here we are removing the last character of the input string,
                // when user clicks the delete button, first we get the length of the string
                // then if the last character is operator, we will reset the boolean value of operators
                // and then remove the last character using String methods
                int removeLastCharacter = inputEdt.getText().toString().length();
                if (removeLastCharacter > 0) {
                    if (String.valueOf(inputEdt.getText().toString().charAt(removeLastCharacter - 1)).equals(operator)) {
                        isDecimal = false;
                        isAddition = false;
                        isSubtraction = false;
                        isDivide = false;
                        isMultiply = false;
                    }
                    setEditText(inputEdt.getText().toString().substring(0, removeLastCharacter - 1));
                }
                break;
            case R.id.raiseToPowerBtn:
                // here when user click ^ button we set the Operator value to "^"
                // and then add the ^ operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    operator = "^";
                    // here when user press ^ button we don't want to add other operators in the string
                    // so we set all other operators boolean value to true.
                    isAddition = true;
                    isSubtraction = true;
                    isDivide = true;
                    isMultiply = true;
                    isDecimal = false;
                    inputTextLength = 0;
                    if (!inputEdt.getText().toString().isEmpty()) {
                        InputStringValue = inputEdt.getText().toString() + "^";
                        inputEdt.setText(InputStringValue);
                    }
                }
                break;
            case R.id.btnSqRoot:
                // here when user click ^ button we set the Operator value to "^"
                // and then add the ^ operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    operator = "\u221a";
                    // here when user press ^ button we don't want to add other operators in the string
                    // so we set all other operators boolean value to true.
                    isAddition = true;
                    isSubtraction = true;
                    isDivide = true;
                    isMultiply = true;
                    isDecimal = false;
                    inputTextLength = 0;
                    InputStringValue = inputEdt.getText().toString() + "\u221a";
                    inputEdt.setText(InputStringValue);

                }
                break;
            case R.id.btnCubeRoot:
                // here when user click ^ button we set the Operator value to "^"
                // and then add the ^ operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    operator = "\u221b";
                    // here when user press ^ button we don't want to add other operators in the string
                    // so we set all other operators boolean value to true.
                    isAddition = true;
                    isSubtraction = true;
                    isDivide = true;
                    isMultiply = true;
                    isDecimal = false;
                    inputTextLength = 0;
                    InputStringValue = inputEdt.getText().toString() + "\u221b";
                    inputEdt.setText(InputStringValue);
                }
                break;
            case R.id.btnAdd:
                // here when user click add button we set the Operator value to "+"
                // and then add the + operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    operator = "+";
                    isAddition = true;
                    isDecimal = false;
                    inputTextLength = 0;
                    if (!inputEdt.getText().toString().isEmpty()) {
                        InputStringValue = inputEdt.getText().toString() + "+";
                        inputEdt.setText(InputStringValue);
                    }
                }
                break;
            case R.id.btnSubtract:
                // here when user click add button we set the Operator value to "-"
                // and then add the - operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    isSubtraction = true;
                    operator = "-";
                    isDecimal = false;
                    inputTextLength = 0;
                    if (!inputEdt.getText().toString().isEmpty()) {
                        InputStringValue = inputEdt.getText().toString() + "-";
                        inputEdt.setText(InputStringValue);
                    }
                }
                break;
            case R.id.btnDiv:
                // here when user click add button we set the Operator value to "/"
                // and then add the / operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    isDivide = true;
                    isDecimal = false;
                    operator = "/";
                    inputTextLength = 0;
                    if (!inputEdt.getText().toString().isEmpty()) {
                        InputStringValue = inputEdt.getText().toString() + "\u00F7";
                        inputEdt.setText(InputStringValue);
                    }
                }
                break;
            case R.id.btnMultiply:
                // here when user click add button we set the Operator value to "*"
                // and then add the * operator in existing input string.
                if (!isSubtraction && !isAddition && !isDivide && !isMultiply) {
                    isDecimal = false;
                    isMultiply = true;
                    operator = "*";
                    inputTextLength = 0;
                    if (!inputEdt.getText().toString().isEmpty()) {
                        InputStringValue = inputEdt.getText().toString() + "*";
                        inputEdt.setText(InputStringValue);
                    }
                }
                break;
            case R.id.btnDecimal:
                // here if user click decimal button we want to add decimal button only once in the number
                // until unless user clicks any of the Operator button.
                if (!isDecimal) {
                    inputEdt.setText(inputEdt.getText() + ".");
                    isDecimal = true;
                }
                break;
        }
    }

    // setting editText values when user clicks number button
    // and checking if the inputTextLength for 1st value is less than 10 or not
    // when user clicks operator button we will reset the inputTextLength to zero
    // which checks the length of the 2nd value.
    private void setEditText(String getValues){
        if (inputTextLength < 10){
            inputEdt.setText(getValues);
        }else{
            Toast.makeText(this, "Maximum number of digits (10) exceeds", Toast.LENGTH_SHORT).show();
        }

        // here if EditText length reaches greater than 32 we will change the size of the text,
        // so that it fits into the screen.
        if(inputEdt.length() > 32){
            inputEdt.setTextSize(14);
        }else{
            inputEdt.setTextSize(24);
        }
    }
}