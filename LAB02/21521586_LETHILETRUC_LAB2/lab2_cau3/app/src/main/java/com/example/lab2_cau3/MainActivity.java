package com.example.lab2_cau3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvEmployee;
    private ArrayList<Employee> EmployeeList;
    private ArrayAdapter<Employee> adapter;
    private TextView tvSelection;
    private Button btnAdd;
    private EditText etId;
    private EditText etName;
    private Employee NewEmployee;
    private RadioGroup rgType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeList = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee> (this, android.R.layout.simple_list_item_1, EmployeeList);

        rgType = findViewById(R.id.rg_prop);
        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        btnAdd = findViewById(R.id.btn_input);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (etId.getText() != null && etName.getText() != null )
                {
                    int radId = rgType.getCheckedRadioButtonId();
                    String id = etId.getText().toString();
                    String name = etName.getText().toString();
                    if (radId == R.id.rbtn_fulltime) {
                        //tạo instance là FullTime
                        NewEmployee = new FulltimeEmployee();
                    } else {
                        //Tạo instance là Partime
                        NewEmployee = new ParttimeEmployee();
                    }
                    //FullTime hay Partime thì cũng là NewEmployee nên có các hàm này là hiển nhiên
                    NewEmployee.setId(id);
                    NewEmployee.setName(name);
                    //Đưa NewEmployee vào ArrayList
                    EmployeeList.add(NewEmployee);
                    //Cập nhập giao diện
                    adapter.notifyDataSetChanged();
                }
            }
        });

        lvEmployee = (ListView) findViewById (R.id.lv_employee);
        lvEmployee.setAdapter(adapter);


    }
}