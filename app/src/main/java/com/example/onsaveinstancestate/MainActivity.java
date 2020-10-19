package com.example.onsaveinstancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String mFirstName, mTitle;

    private static final String KEY_FIRSTNAME = "firstname_key";
    private static final String KEY_TITLE = "title_key";
    private static String KEY_SWITCH = "false";
    private static final boolean SWITCH_ON  = true;

    private static Bundle bundle = new Bundle();

    TextView txtResult;
    EditText FirstName, Title;
    Switch swtchChecked;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstName = (EditText)findViewById(R.id.edtxtName);
        Title = (EditText)findViewById(R.id.edtxtTitle);
        btnClick = (Button)findViewById(R.id.btnClick);
        txtResult = (TextView)findViewById(R.id.txtResult);
        swtchChecked = (Switch)findViewById(R.id.switchOnOff);

//        if(savedInstanceState != null){
//            String savedFirstName = savedInstanceState.getString(KEY_FIRSTNAME);
//            String savedTitle = savedInstanceState.getString(KEY_TITLE);
//            txtResult.setText(savedFirstName+" "+savedTitle);
//
//            swtchChecked.setChecked(savedInstanceState.getBoolean("ToggleButtonSate", false));
//
//        }else{
//            Toast.makeText(this, " No Entry", Toast.LENGTH_SHORT);
//        }

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(FirstName.getText().toString().trim()+ " "+ Title.getText().toString().trim());
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putString(KEY_FIRSTNAME, FirstName.getText().toString());
//        savedInstanceState.putString(KEY_TITLE, Title.getText().toString());
//        savedInstanceState.putBoolean("ToggleButtonSate", swtchChecked.isChecked());
//    }


    @Override
    protected void onPause() {
        super.onPause();
        String firstName = FirstName.getText().toString();
        bundle.putBoolean("ToggleButtonState", swtchChecked.isChecked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        swtchChecked.setChecked(bundle.getBoolean("ToggleButtonState", false));
    }
}