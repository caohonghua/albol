package org.caohh.albol.vo;

import lombok.Data;

@Data
public class Page {
    //最大偏移量，大于此值,优化sql limit
    private Long maxOffset = 2000L;

    //分页大小
    private Integer pageSize = 10;
    //当前页码
    private Integer currentPage = 1;

    //偏移地址
    public Long offset(){
        return (long)(currentPage - 1) * pageSize;
    }
    
    public Long getMaxOffset(){
        return maxOffset;
    }
}
