package org.androidtown.holgabun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Search extends AppCompatActivity {

    Spinner spinner;
    private ArrayAdapter adapter;
    Intent intent;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        intent=getIntent();
        editText=(EditText)findViewById(R.id.search_tutname);
        editText.setText(intent.getStringExtra("name"));
        spinner = (Spinner) findViewById(R.id.search_si);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(intent.getIntExtra("si",0));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 8:
                        spinner = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                        break;
                    default:
                        spinner = (Spinner) findViewById(R.id.search_gu);
                        adapter = ArrayAdapter.createFromResource(Search.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);



                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}