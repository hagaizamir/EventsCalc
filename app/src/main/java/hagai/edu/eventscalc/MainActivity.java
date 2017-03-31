package hagai.edu.eventscalc;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //properties:
    private TextView tvResult;
    private String lastOperator = "=";
    private double firstOperand = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tvResult);
        double x = 10.0202002;

        String s = String.format("%2.0f", x);
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    //if 0 clear and set the new number.
    //else append the new number
    public void numberTapped(View view) {
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        if (getTvResult().equals("0"))
            tvResult.setText(buttonText);
        else
            tvResult.setText(getTvResult() + buttonText);
    }
    public void dotTapped(View v){
        //if . does not exist yet, append it
        //else if .. ignore
    }
    @NonNull
    private String getTvResult() {
        return tvResult.getText().toString();
    }

    //1) remember the operator
    //2)remember the operand
    //3) clear the text:
    public void operatorTapped(View view) {
        //1) remember the operator
        Button op = (Button) view;
        lastOperator = op.getText().toString();

        //2)remember the operand
        firstOperand = getCurrentOperand();

        //3) clear the text:
        tvResult.setText("0");
    }

    //find first Operator
    //find 2nd Operator
    //find the operand
    //do the math
    //set text (Consider formatting)
    //forget the operand.
    public void equalsTapped(View view) {
        double firstOp = firstOperand;
        double secOp = getCurrentOperand();

        Double result = 0.0;
        //switch:
        switch (lastOperator){
            case "/":
                result = firstOp / secOp;
                break;
            case "+":
                result = firstOp + secOp;
                break;
            case "-":
                result = firstOp - secOp;
                break;
            case "*":
                result = firstOp * secOp;
                break;
        }
        lastOperator = "=";
        tvResult.setText(result.toString());
    }


    //computed properties:
    private Double getCurrentOperand(){
        try {
            return Double.valueOf(getTvResult());
        }
        catch (Exception e){
            e.printStackTrace();
            return null;}
    }
}