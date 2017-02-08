package fr.everydaysapps.vitesse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {



    TextView firstTap;
    TextView secondTap;
    TextView vitesse;
    LinearLayout clickvitesse;


    boolean firstClick = true;


    long firstValue;
    long secondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstTap = (TextView)findViewById(R.id.first_tap);
        secondTap = (TextView)findViewById(R.id.second_tap);
        vitesse = (TextView)findViewById(R.id.speed);
        clickvitesse = (LinearLayout) findViewById(R.id.tap_zone);



        clickvitesse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (firstClick)
                {
                    firstClick = false;
                    firstValue = System.currentTimeMillis() ;
                    firstTap.setText(firstValue+"");

                }else {

                    secondValue = System.currentTimeMillis() ;
                    secondTap.setText( secondValue+ "");
                    firstClick = true;

                    double reste = (secondValue - firstValue);
                    double restefinal = reste/1000;
                    double timeinHeure = restefinal/3600;
                    double distanceinKM = (2.57 / 1000);
                    double vitesse1 = distanceinKM/ timeinHeure;

                    vitesse.setText(vitesse1+"");
                }
            }
        });


    }
}
