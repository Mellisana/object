package org.example;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;


    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String gettopic() {

        return topic;
    }

    public String getproject() {

        return project;
    }

    public String getstart() {

        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
