package models.databasemodels;

import lombok.Data;

@Data
public class Student {

    private int id;
    private String name;
    private int groupId;

    public Student() {}

    public Student(String name, int groupId) {
        this.name = name;
        this.groupId = groupId;
    }
}
