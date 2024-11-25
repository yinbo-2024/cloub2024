package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@RestController
@Api(tags = "/${table.name}")
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${table.entityPath}Service;

<#list table.fields as field>
    <#if field.keyFlag>
        /**
        *  根据主键${field.propertyName}查询表${table.name}信息
        *  @param ${field.propertyName}
        */
    @PostMapping("/find${entity}By${field.propertyName}")
    public ${entity} find${entity}By${field.propertyName}(@Param("${field.propertyName}") ${field.propertyType} ${field.propertyName}) {
        return ${table.entityPath}Service.find${entity}By${field.propertyName}(${field.propertyName});
    }
    </#if>
</#list>

    /**
    *  根据条件查询表${table.name}信息
    *  @param ${table.entityPath}
    */
    @PostMapping("/find${entity}ByCondition(${entity} ${table.entityPath}")
    public List<${entity}> find${entity}ByCondition(${entity} ${table.entityPath}) {
        return ${table.entityPath}Service.find${entity}ByCondition(${table.entityPath});
    }

<#list table.fields as field>
    <#if field.keyFlag>
        /**
        *  根据主键${field.propertyName}查询表${table.name}信息
        *  @param ${field.propertyName}
        */
    @PostMapping("/delete${entity}By${field.propertyName}")
    public Integer delete${entity}By${field.propertyName}(@Param("${field.propertyName}") ${field.propertyType} ${field.propertyName}) {
        return ${table.entityPath}Service.delete${entity}By${field.propertyName}(${field.propertyName});
    }
    </#if>
</#list>

<#list table.fields as field>
    <#if field.keyFlag>
        /**
        *  根据主键${field.propertyName}更新表${table.name}信息
        *  @param ${table.entityPath}
        */
    @PostMapping("/update${entity}By${field.propertyName}")
    public Integer update${entity}By${field.propertyName}(${entity} ${table.entityPath}) {
        return ${table.entityPath}Service.update${entity}By${field.propertyName}(${table.entityPath});
    }
    </#if>
</#list>

<#list table.fields as field>
    <#if field.keyFlag>
        /**
        *  新增表${table.name}信息
        *  @param ${table.entityPath}
        */
    @PostMapping("/add${entity}(${entity}")
    public Integer add${entity}(${entity} ${table.entityPath}) {
        return ${table.entityPath}Service.add${entity}(${table.entityPath});
    }
    </#if>
</#list>
}


