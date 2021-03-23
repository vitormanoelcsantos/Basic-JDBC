package com.one.innovation.digital.jdbcbasic.queriesexecution;

public class Student {

    private int id;
    private String name;
    private int agesold;
    private String state;

    public Student(int id, String name, int agesold, String state) {
        this.id = id;
        this.name = name;
        this.agesold = agesold;
        this.state = state;
    }

    public Student(String name, int agesold, String state) {
        this.name = name;
        this.agesold = agesold;
        this.state = state;
    }

    public Student() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgesold() {
        return agesold;
    }

    public void setAgesold(int agesold) {
        this.agesold = agesold;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(name).append('\'');
        sb.append(", idade=").append(agesold);
        sb.append(", estado='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
