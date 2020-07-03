package com.project.start.entities;


import java.util.List;

public class PageDtoResults<T> {
    private List<T> content;
    private Long totalPages;
    private Long totalElements;

    public PageDtoResults() {
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }


}
