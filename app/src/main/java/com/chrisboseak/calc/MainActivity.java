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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
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
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //BUTTON DECLARATIONS
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


        //Listens for button clicks of buttons declared above
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bPlus.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bDivide.setOnClickListener(this);
        bMultiply.setOnClickListener(this);
        bEqual.setOnClickListener(this);

        //LONG CLICK of 0 key
        b0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // IF the current number has at lease one character AND if the current number is not a generated one(user input)
                // THEN backspace
                if (numDisplay.length() > 0 && userEnteredNum == true) {
                    String tempText = numDisplay.getText().toString();
                    numDisplay.setText(tempText.substring(0, tempText.length() - 1));
                }
                return true;
            }
        });

        //LONG CLICK of multiplication key
        bMultiply.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // IF there is not already a number entered AND if the current number is not a generated one(user input)
                // THEN add decimal and note that current number already has a decimal.
                if (decimalAlready == false && userEnteredNum == true) {

                    //IF decimal is the first character THEN put zero before it (i.e "0.1" instead of ".1")
                    if(firstTime == true)
                        numClicked("0");
                    numDisplay.append(".");
                    decimalAlready = true;
                }
                return true;
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    //function with all activity universal to a numbered button press.
    //Params: numPressed - string that contains the number pressed
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
    @Override

    // When a button is clicked, the onclick listener feed the button to here
    // where the switch determines the action.
    public void onClick(View v){
        switch (v.getId()){
            //BUTTON 0-9
            case R.id.button0:
                numClicked("0");
                break;
            case R.id.button1:
                numClicked("1");
                break;
            case R.id.button2:
                numClicked("2");
                break;
            case R.id.button3:
                numClicked("3");
                break;
            case R.id.button4:
                numClicked("4");
                break;
            case R.id.button5:
                numClicked("5");
                break;
            case R.id.button6:
                numClicked("6");
                break;
            case R.id.button7:
                numClicked("7");
                break;
            case R.id.button8:
                numClicked("8");
                break;
            case R.id.button9:
                numClicked("9");
                break;

            //Clear Button
            case R.id.buttonClear:
                numDisplay.setText("");
                signDisplay.setText("");
                decimalAlready = false;
                numberOne = 0;
                break;

            //Operation Buttons (+,-,/,*,=)
            case R.id.buttonPlus:
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
                break;
            case R.id.buttonMinus:
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
                break;
            case R.id.buttonDiv:
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
                break;
            case R.id.buttonMult:
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
                break;
            case R.id.buttonEqual:
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
                break;

            default:
                break;
        }
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
