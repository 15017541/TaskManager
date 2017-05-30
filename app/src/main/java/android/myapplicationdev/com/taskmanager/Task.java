package android.myapplicationdev.com.taskmanager;

import java.io.Serializable;

/**
 * Created by 15017541 on 30/5/2017.
 */

public class Task implements Serializable{

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private String id;
    private String name;
    private String description;

}
