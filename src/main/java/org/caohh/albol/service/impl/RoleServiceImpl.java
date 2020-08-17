package org.caohh.albol.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.caohh.albol.mapper.RoleDynamicSqlSupport;
import org.caohh.albol.mapper.RoleMapper;
import org.caohh.albol.service.RoleService;
import org.caohh.albol.vo.Result;
import org.caohh.albol.vo.Role;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.WhereApplier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.caohh.albol.mapper.RoleDynamicSqlSupport.*;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Result search(Role role) {
        Result result;
        try {
            WhereApplier whereApplier = abstractWhereDSL ->
                    abstractWhereDSL.where(name, isEqualToWhenPresent(role.getName()))
                            .and(desc, isEqualToWhenPresent(role.getDesc()));
            SelectStatementProvider provider;
            long offset = role.offset();
            if (offset >= role.getMaxOffset()) {
                provider = select(roleMapper.selectList).from(RoleDynamicSqlSupport.role)
                        .where(id, isGreaterThanOrEqualTo(
                                select(id).from(RoleDynamicSqlSupport.role).applyWhere(whereApplier)
                                        .limit(1).offset(offset)
                        )).limit(role.getPageSize()).build().render(RenderingStrategies.MYBATIS3);
            } else {
                provider = select(roleMapper.selectList).from(RoleDynamicSqlSupport.role)
                        .applyWhere(whereApplier).limit(role.getPageSize())
                        .offset(offset).build().render(RenderingStrategies.MYBATIS3);
            }
            result = new Result(Result.Code.SUCCESS, roleMapper.selectMany(provider));
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "search fail");
        }
        return result;
    }

    @Override
    public Result save(Role role) {
        Result result;
        try {
            org.caohh.albol.model.Role record = new org.caohh.albol.model.Role();
            BeanUtils.copyProperties(role, record);
            result = new Result(Result.Code.SUCCESS, roleMapper.insertSelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "save fail");
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        Result result;
        try {
            result = new Result(Result.Code.SUCCESS, roleMapper.deleteByPrimaryKey(id) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "delete fail");
        }
        return result;
    }

    @Override
    public Result update(Role role) {
        Result result;
        try {
            org.caohh.albol.model.Role record = new org.caohh.albol.model.Role();
            BeanUtils.copyProperties(role, record);
            result = new Result(Result.Code.SUCCESS, roleMapper.updateByPrimaryKeySelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "update fail");
        }
        return result;
    }
}
