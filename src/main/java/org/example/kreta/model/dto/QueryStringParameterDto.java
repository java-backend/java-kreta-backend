package org.example.kreta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class QueryStringParameterDto {
    final int defaultPageSize=10;

    private int currentPage;
    private int pageSize;
    private String orderBy;
    private String filter;
    private String fields;

    public Boolean isPaging() {
        return pageSize!=0;
    }

    public Boolean isSorting() {
        if (orderBy!=null)
            return true;
        else
            return false;
    }

    public Boolean isFiltered() {
        if (filter!=null)
            return true;
        else
            return false;
    }

    public int getPageSize() {
        if (pageSize!=0)
            return pageSize;
        else
            return defaultPageSize;
    }
}
