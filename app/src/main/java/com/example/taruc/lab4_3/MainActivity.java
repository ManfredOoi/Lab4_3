package com.example.taruc.lab4_3;

import android.content.*;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewRecords;
    UserSQLHelper userSQLHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewRecords = (ListView)findViewById(R.id.listViewRecords);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        //Retrieve records from SQLite
        userSQLHelper = new UserSQLHelper(this);

        final List<UserRecord> values = userSQLHelper.getAllUsers();

        if(values.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.no_record_message), Toast.LENGTH_SHORT).show();
        }

        UserRecordAdapter adapter = new UserRecordAdapter(this, R.layout.user_record, values);

        //Link adapter to ListView
        listViewRecords.setAdapter(adapter);
    }


}
