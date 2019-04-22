package com.beejee.task.model.search;

import com.beejee.task.model.Status;

public class TaskSearchModel extends BaseSearchModel {

    private Status status;
    private String body;

    // TODO add another search fields


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
