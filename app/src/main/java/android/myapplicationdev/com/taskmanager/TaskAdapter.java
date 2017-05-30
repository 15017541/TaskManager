package android.myapplicationdev.com.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017541 on 30/5/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task>taskArrayList;
    private Context context;
    private TextView tvName, tvDescription;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);

        taskArrayList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        Task currentTask = taskArrayList.get(position);

        tvName.setText((position+1) + " " + currentTask.getName());
        tvDescription.setText(currentTask.getDescription());

        return rowView;
    }
}
