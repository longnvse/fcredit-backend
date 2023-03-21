package com.fu.fcredit.util;

import com.fu.fcredit.page.PageResponse;
import org.springframework.data.domain.Page;

public class MapperUtil {
    public static PageResponse mapPageResponseFromPage(Page<?> from) {
        PageResponse to = new PageResponse();

        to.setItems(from.getContent());
        to.setPage(from.getNumber());
        to.setSize(from.getSize());
        to.setTotalCount(from.getTotalElements());

        return to;
    }
}
