package org.caohh.albol.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class Resource extends Page {
    private Long id;
    private String name;
    private String link;
    private Long pid;
    private Date createdTime;
}
