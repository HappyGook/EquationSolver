package com.example.equationsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ka;
    EditText kb;
    EditText kc;
    EditText kd;
    TextView eqa,eqb;
    Button solve;

    public String Equation(double a, double b, double c){
        double dis=b * b - 4 * a * c;
        if(dis>0){
            double x1, x2;
            x1 = (-b-Math.sqrt(dis))/(2*a);
            x2 = (-b+Math.sqrt(dis))/(2*a);
            return "Корни уравнения:"+x1+" "+x2;
        }
        else if(dis==0){
            double x;
            x =-b/(2*a);
            return "Корень уравнения:"+x;
        }
        else{
            return "У уравнения нет корней, т.к. дискриминант меньше 0";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ka=findViewById(R.id.ka);
        kb=findViewById(R.id.kb);
        kc=findViewById(R.id.kc);
        kd=findViewById(R.id.kd);
        solve=findViewById(R.id.solve);
        eqa=findViewById(R.id.solvea);
        eqb=findViewById(R.id.solveb);
        
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bufa=ka.getText().toString();
                String bufb=kb.getText().toString();
                String bufc=kc.getText().toString();
                String bufd=kd.getText().toString();
                double a=Double.parseDouble(bufa);
                double b=Double.parseDouble(bufb);
                double c=Double.parseDouble(bufc);
                double d=Double.parseDouble(bufd);
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String res=Equation(a,b,c);
                        eqa.setText(res);
                    }
                });
                t.start();
                String res2=Equation(b,c,d);
                eqb.setText(res2);
            }
        });
    }
    }
