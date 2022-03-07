package com.example.geometricshapes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner shapes = findViewById(R.id.spinner_shapes);
        LinearLayout linear_rectangle = findViewById(R.id.linear_rectangle);
        LinearLayout linear_triangle = findViewById(R.id.linear_triangle);
        EditText square_side = findViewById(R.id.et_square_side);
        EditText rectangle_height = findViewById(R.id.et_rectangle_height);
        EditText rectangle_width = findViewById(R.id.et_rectangle_width);
        EditText triangle_sideA = findViewById(R.id.et_triangle_sideA);
        EditText triangle_base = findViewById(R.id.et_triangle_base);
        EditText triangle_sideC = findViewById(R.id.et_triangle_sideC);
        EditText triangle_height = findViewById(R.id.et_triangle_height);
        EditText circle_radius = findViewById(R.id.et_circle_radius);
        TextView area_result = findViewById(R.id.tv_area_result);
        TextView size_result = findViewById(R.id.tv_size_result);
        Button calculate = findViewById(R.id.btn_calculate);

        shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0 :  square_side.setVisibility(View.GONE);
                        linear_rectangle.setVisibility(View.GONE);
                        linear_triangle.setVisibility(View.GONE);
                        circle_radius.setVisibility(View.GONE);
                        break;
                    case 1: square_side.setVisibility(View.VISIBLE);
                            linear_rectangle.setVisibility(View.GONE);
                            linear_triangle.setVisibility(View.GONE);
                            circle_radius.setVisibility(View.GONE);
                            break;
                    case 2: square_side.setVisibility(View.GONE);
                        linear_rectangle.setVisibility(View.VISIBLE);
                        linear_triangle.setVisibility(View.GONE);
                        circle_radius.setVisibility(View.GONE);
                        break;
                    case 3: square_side.setVisibility(View.GONE);
                        linear_rectangle.setVisibility(View.GONE);
                        linear_triangle.setVisibility(View.VISIBLE);
                        circle_radius.setVisibility(View.GONE);
                        break;
                    case 4: square_side.setVisibility(View.GONE);
                        linear_rectangle.setVisibility(View.GONE);
                        linear_triangle.setVisibility(View.GONE);
                        circle_radius.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        calculate.setOnClickListener(view -> {
            int itemIndex = shapes.getSelectedItemPosition();
            double area = 0;
            double size = 0;
            switch (itemIndex){
                case 1:
               double squareSide = Double.parseDouble(square_side.getText().toString());
               area = squareSide * 4;
               size = squareSide * squareSide;
               break;
               case 2:
               double recHeight = Double.parseDouble(rectangle_height.getText().toString());
               double recWidth = Double.parseDouble(rectangle_width.getText().toString());
               area =(recHeight+recWidth)*2;
               size = recHeight * recWidth;
               break;
                case 3:
                    double triHeight = Double.parseDouble(triangle_height.getText().toString());
                    double triSideA = Double.parseDouble(triangle_sideA.getText().toString());
                    double triBase = Double.parseDouble(triangle_base.getText().toString());
                    double triSideC = Double.parseDouble(triangle_sideC.getText().toString());
                    area =triSideA+triBase+triSideC;
                    size =(0.5*triBase)*triHeight;
                    break;
                case 4:
                    double circleRadius = Double.parseDouble(circle_radius.getText().toString());
                    area =2*circleRadius*Math.PI;
                    size = Math.PI *Math.pow(circleRadius,2);
                    break;



            }
            area_result.setText(""+area);
            size_result.setText(""+size);
        });
    }
}