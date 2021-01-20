package com.baidu.shop.service;

import com.baidu.shop.base.Result;
import com.baidu.shop.entity.CategoryEntity;
import com.baidu.shop.validate.group.MingruiOperation;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "商品分类接口")
@Validated
public interface CategoryService {

    //查询
    @ApiOperation(value = "通过查询商品分类")
    @GetMapping(value = "category/list")
    Result<List<CategoryEntity>> getCategoryByPid(@NotNull Integer pid);

    //删除
    @ApiOperation(value ="通过id删除分类")
    @DeleteMapping(value = "category/del")
    Result<JsonObject> delCategory(@NotNull Integer id);

    //修改
    @ApiOperation(value = "修改分类")
    @PutMapping(value = "category/edit")
    Result<JsonObject> editCategory(@Validated({MingruiOperation.Update.class})@RequestBody CategoryEntity categoryEntity);

    //新增
    @ApiOperation(value = "新增分类")
    @PostMapping(value = "category/save")
    Result<JsonObject> saveCategory(@Validated({MingruiOperation.Add.class}) @RequestBody CategoryEntity categoryEntity);

}
