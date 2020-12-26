package com.deng.malltiny.controller;

import com.deng.malltiny.common.api.CommonPage;
import com.deng.malltiny.common.api.CommonResult;
import com.deng.malltiny.mbg.model.PmsBrand;
import com.deng.malltiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.deng.malltiny.common.api.CommonPage.restPage;
import static com.deng.malltiny.common.api.CommonResult.success;

/**
 * 管理品牌controller
 * 1.listAllBrand的路经？
 * 2.CommonResult的类型是跟随data的，所以，在其内有data的，定义函数时要写泛型
 */
@Api(tags = "PmsBrandController" ,description = "商品品牌管理")
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {
    @Autowired
    PmsBrandService demoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getBrandList(){
        return  CommonResult.success(demoService.listAllBrand());
    }
    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> brandList(@RequestParam(value = "pageNum",defaultValue = "1")
                                                         @ApiParam("页码，") int pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "3")
                                                         @ApiParam("每页数量")   int pageSize){
        //success里面要的时分页的所有信息，（CommonPage）
        CommonPage<PmsBrand> list = CommonPage.restPage(demoService.listBrand(pageNum,pageSize));
        return CommonResult.success(list);
    }
    @ApiOperation("添加品牌")
    @RequestMapping(value="/creat",method = RequestMethod.GET)
    public CommonResult creatBrand(@RequestBody PmsBrand pmsBrand){
        int count = demoService.creatBrand(pmsBrand);
        CommonResult result;
        if(count==1){
            result = success(pmsBrand);
            LOGGER.debug("creat brand success:{}",pmsBrand);
        }else{
            result = CommonResult.failed("创建失败");
            LOGGER.debug("create brand failed:{}",pmsBrand);
        }
        return result;
    }
    @ApiOperation("更新指定id品牌")
    @RequestMapping(value="/update/{id}",method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id,@RequestBody PmsBrand pmsBrand){
        int count = demoService.updateBrand(id,pmsBrand);
        CommonResult result;
        if(count==1){
            result = success(pmsBrand);
            //默认由成功提示
            LOGGER.debug("update brand success:{}",pmsBrand);
        }else{
            result = CommonResult.failed("更新失败");
            LOGGER.debug("update brand failed:{}",pmsBrand);
        }
        return result;
    }
    @ApiOperation("删除指定id品牌")
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = demoService.deleteBrand(id);
        CommonResult result;
        if(count==1){
            result = success("删除成功",id);
            //注意：这里的message是提示信息，id是响应信息,(是不用响应id的)
            LOGGER.debug("delete brand success:id={}",id);
        }else{
            result = CommonResult.failed("删除失败");
            LOGGER.debug("delete brand failed:id={}",id);
        }
        return result;
    }
    @ApiOperation("获取指定id品牌")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(demoService.getBrand(id));
    }


}
