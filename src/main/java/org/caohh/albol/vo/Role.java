package org.caohh.albol.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class Role extends Page{
    private Long id;
    private String name;
    private String desc;
    private Date createdTime;
}
