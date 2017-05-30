package android.myapplicationdev.com.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask;
    ListView lv;

    TaskAdapter ta;
    ArrayList<Task> taskArrayList = new ArrayList<Task>();
    int requestCode = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = (Button) findViewById(R.id.btnAddTask);
        lv = (ListView) findViewById(R.id.lv);
        ta = new TaskAdapter(this, R.layout.row, taskArrayList);
        lv.setAdapter(ta);
        displayTask();

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, requestCode);
            }
        });
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK) {
                if (data != null) {
                    displayTask();
                }
            }
        }

    public void displayTask() {
        taskArrayList.clear();
        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Task> task = db.getTasks();
        db.close();
        for (int i = 0; i < task.size(); i++){
            taskArrayList.add(new Task(task.get(i).getName(), task.get(i).getDescription()));
        }
        ta.notifyDataSetChanged();
    }
}


