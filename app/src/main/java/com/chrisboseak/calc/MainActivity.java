package com.chrisboseak.calc;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    double numberOne = 0;
    int lastOpTypePressed = 0;
    boolean decimalAlready = false;
    boolean firstTime = true;
    boolean userEnteredNum = true;
    TextView numDisplay;
    TextView signDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b0 = (Button)findViewById(R.id.button0);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);
        Button b4 = (Button)findViewById(R.id.button4);
        Button b5 = (Button)findViewById(R.id.button5);
        Button b6 = (Button)findViewById(R.id.button6);
        Button b7 = (Button)findViewById(R.id.button7);
        Button b8 = (Button)findViewById(R.id.button8);
        Button b9 = (Button)findViewById(R.id.button9);
        Button bClear = (Button)findViewById(R.id.buttonClear);
        Button bPlus = (Button)findViewById(R.id.buttonPlus);
        Button bMinus = (Button)findViewById(R.id.buttonMinus);
        Button bDivide = (Button)findViewById(R.id.buttonDiv);
        Button bMultiply = (Button)findViewById(R.id.buttonMult);
        Button bEqual = (Button)findViewById(R.id.buttonEqual);
        numDisplay = (TextView)findViewById(R.id.numberDisplay);
        signDisplay =(TextView)findViewById(R.id.currSign);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                numClicked("7");
                    }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClicked("0");
            }
        });
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numDisplay.setText("");
                signDisplay.setText("");
                decimalAlready = false;
                numberOne = 0;
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signDisplay.setText("+");
                if(numberOne != 0){
                    numberOne = doMath(numberOne,Double.parseDouble(numDisplay.getText().toString()),lastOpTypePressed);
                }else{
                    numberOne = Double.parseDouble(numDisplay.getText().toString());
                }
                numDisplay.setText(""+numberOne);
                userEnteredNum = false;
                firstTime = true;
                lastOpTypePressed = 1;
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signDisplay.setText("-");
                if(numberOne != 0){
                    numberOne = doMath(numberOne,Double.parseDouble(numDisplay.getText().toString()),lastOpTypePressed);
                }else{
                    numberOne = Double.parseDouble(numDisplay.getText().toString());
                }
                numDisplay.setText(""+numberOne);
                userEnteredNum = false;
                firstTime = true;
                lastOpTypePressed = 2;
            }
        });
        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signDisplay.setText("/");
                if(numberOne != 0){
                    numberOne = doMath(numberOne,Double.parseDouble(numDisplay.getText().toString()),lastOpTypePressed);
                }else{
                    numberOne = Double.parseDouble(numDisplay.getText().toString());
                }
                numDisplay.setText(""+numberOne);
                userEnteredNum = false;
                firstTime = true;
                lastOpTypePressed = 3;
            }
        });
        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signDisplay.setText("x");
                if(numberOne != 0){
                    numberOne = doMath(numberOne,Double.parseDouble(numDisplay.getText().toString()),lastOpTypePressed);
                }else{
                    numberOne = Double.parseDouble(numDisplay.getText().toString());
                }
                numDisplay.setText(""+numberOne);
                userEnteredNum = false;
                firstTime = true;
                lastOpTypePressed = 4;
            }
        });
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signDisplay.setText("=");
                if(numberOne != 0){
                    numberOne = doMath(numberOne,Double.parseDouble(numDisplay.getText().toString()),lastOpTypePressed);
                }else{
                    numberOne = Double.parseDouble(numDisplay.getText().toString());
                }
                numDisplay.setText(""+numberOne);
                userEnteredNum = false;
                firstTime = true;
                lastOpTypePressed = 0;
                /*
                signDisplay.setText("=");
                numberOne = numberOne + 0;
                numDisplay.setText(""+numberOne);*/
            }
        });
        b0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (numDisplay.length() > 0 && userEnteredNum == true) {
                    String tempText = numDisplay.getText().toString();
                    numDisplay.setText(tempText.substring(0, tempText.length() - 1));
                }
                return true;
            }
        });
        bMultiply.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (firstTime == false && decimalAlready == false && userEnteredNum == true) {
                    numDisplay.append(".");
                    decimalAlready = true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void numClicked(String numPressed)
    {
        if(firstTime == true){
            numDisplay.setText("");
            userEnteredNum = true;
            decimalAlready = false;
        }
        numDisplay.append(numPressed);
        firstTime = false;
    }
    public double doMath(double numOne, double numTwo, int opType)
    {
        //do not perform a math operation if there are no numbers to use because they haven't been entered
        if(firstTime == true)
            return numOne;
        else{
            switch(opType)
                {
                    case 1:
                        return numOne + numTwo;
                    case 2:
                        return numOne - numTwo;
                    case 3:
                        try {
                            return numOne / numTwo;
                        }catch(ArithmeticException ex){
                            Context context = getApplicationContext();
                            CharSequence text = "Cannot divide by zero";
                            int duration = Toast.LENGTH_SHORT;
                            Toast zeroDivToast = Toast.makeText(context,text,duration);
                            zeroDivToast.show();
                            return numOne;
                        }
                    case 4:
                        return numOne * numTwo;
                    default:
                        return numOne;
                }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
