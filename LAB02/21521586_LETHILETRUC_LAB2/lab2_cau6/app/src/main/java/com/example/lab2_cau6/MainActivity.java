package com.example.lab2_cau6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvEmployee;
    private ArrayList<Employee> EmployeeList;
    private EmployeeAdapter adapter;
    private Button btnAdd;
    private EditText etId;
    private EditText etName;
    private Employee NewEmployee;
    private CheckBox cbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeList = new ArrayList<Employee>();
        adapter = new EmployeeAdapter (this, EmployeeList);

        rvEmployee = findViewById(R.id.rv_employee);

        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        btnAdd = findViewById(R.id.btn_input);
        cbManager = findViewById(R.id.cb_manager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        rvEmployee.setLayoutManager(linearLayoutManager);
        rvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                addNewEmployee();

            }
        });

    }

    protected void addNewEmployee(){
        NewEmployee = new Employee();
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        NewEmployee.setId(id);
        NewEmployee.setName(name);
        NewEmployee.setManager(cbManager.isChecked());
        //FullTime hay Partime thì cũng là NewEmployee nên có các hàm này là hiển nhiên

        //Đưa NewEmployee vào ArrayList
        EmployeeList.add(NewEmployee);
        adapter.notifyDataSetChanged();
        Log.i("", EmployeeList.toString());
        etName.setText("");
        etId.setText("");
        cbManager.setChecked(false);
        //Toast.makeText(MainActivity.this, , Toast.LENGTH_SHORT).show();

    }
}