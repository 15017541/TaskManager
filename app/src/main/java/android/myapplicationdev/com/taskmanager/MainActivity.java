package android.myapplicationdev.com.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask;
    ListView lv;

    TaskAdapter ta;
    ArrayList<Task> taskArrayList = new ArrayList<Task>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = (Button) findViewById(R.id.btnAddTask);
        lv = (ListView) findViewById(R.id.lv);
        DBHelper dbh = new DBHelper(MainActivity.this);

        taskArrayList = dbh.getTasks();
        ta = new TaskAdapter(this, R.layout.row, taskArrayList);
        lv.setAdapter(ta);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 9);
            }
        });
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == 9) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                taskArrayList.clear();
                taskArrayList.addAll(dbh.getTasks());
                dbh.close();
                ta.notifyDataSetChanged();
                }
            }
        }



