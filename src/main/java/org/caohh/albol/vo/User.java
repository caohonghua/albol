package org.caohh.albol.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Page {
    private Long id;
    private String name;
    private String password;
    private Date createdTime;
    private String username;
    private String avatar;
}
