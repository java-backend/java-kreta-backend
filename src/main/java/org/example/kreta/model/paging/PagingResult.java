package org.example.kreta.model.paging;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@JsonSerialize(using = PagingResultSerializer.class)
public class PagingResult {
    private long numberOfItem;
    private int pageSize;
    private int currentPage;
    private int numberOfPage;
}
