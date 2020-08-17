package org.caohh.albol.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class Article extends Page {
    private Long id;
    private String name;
    private String category;
    private String createdTime;
    private String content;

    private String search;
}
