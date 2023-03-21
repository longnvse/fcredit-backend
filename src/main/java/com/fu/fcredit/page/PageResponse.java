package com.fu.fcredit.page;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResponse {
    private List<?> items;
    private int page;
    private int size;
    private long totalCount;
}
