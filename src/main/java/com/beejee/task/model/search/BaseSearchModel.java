package com.beejee.task.model.search;

import java.io.Serializable;

public class BaseSearchModel implements Serializable {

    private static final long serialVersionUID = 5274454098645655526L;

    private Long first;
    private Long pageSize;
    private String sortParam;
    private boolean ascending;

    public Long getFirst() {
        return first;
    }

    public void setFirst(Long first) {
        this.first = first;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortParam() {
        return sortParam;
    }

    public void setSortParam(String sortParam) {
        this.sortParam = sortParam;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
