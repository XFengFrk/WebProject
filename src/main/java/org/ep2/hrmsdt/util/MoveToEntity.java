package org.ep2.hrmsdt.util;

import lombok.Data;

import java.util.List;

@Data
public class MoveToEntity {
    private List<Integer> from;

    private Integer to;
}
