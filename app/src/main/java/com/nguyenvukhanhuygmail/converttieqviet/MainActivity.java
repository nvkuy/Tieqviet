package com.nguyenvukhanhuygmail.converttieqviet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit_input;
    TextView tv_result;
    String result;
    String[] arr_token;
    final String dict = "ch:c," +
            "Ch:C," +
            "đ:d," +
            "Đ:d," +
            "tr:c," +
            "Tr:C," +
            "gh:g," +
            "Gh:G," +
            "Ph:F," +
            "ph:f," +
            "c:k," +
            "C:K," +
            "q:k," +
            "Q:K," +
            "Ng:Q," +
            "ng:q," +
            "ngh:q," +
            "Ngh:Q," +
            "Kh:X," +
            "kh:x," +
            "Th:W," +
            "th:w," +
            "d:z," +
            "D:Z," +
            "gi:z," +
            "Gi:Z," +
            "R:Z," +
            "r:z," +
            "nh:n'," +
            "Nh:N'";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start();

        edit_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                result = edit_input.getText().toString();
                if (!result.isEmpty()) {
                    arr_token = dict.split(",");
                    for (String element : arr_token) {
                        String[] arr_element = element.split(":");
                        try {
                            //khi phần tử đó cần convert
                            result = result.replace(arr_element[0], arr_element[1]);
                        } catch (Exception e) {
                            //khi phần tử đó ko cần thay đổi
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tv_result.setText(result);
            }
        });

    }

    private void start() {
        getSupportActionBar().setTitle("Phần mềm chuyển đổi 'Tiêq Việt'");
        edit_input = (EditText) findViewById(R.id.edit_input);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

}
