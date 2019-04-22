package com.beejee.task.bean;

import com.beejee.task.bean.validator.ValidateOnCreate;
import com.beejee.task.bean.validator.ValidateOnUpdate;
import com.beejee.task.model.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class TaskBean implements Serializable {

    private static final long serialVersionUID = -5623713892927180148L;

    @NotNull(groups = {ValidateOnUpdate.class})
    private Long id;

    @NotNull(groups = {ValidateOnUpdate.class, ValidateOnCreate.class})
    private String subject;

    private String body;

    private Status status;

    private MultipartFile file;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
