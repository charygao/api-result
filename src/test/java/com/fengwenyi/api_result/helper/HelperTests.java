package com.fengwenyi.api_result.helper;

import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.api_result.model.PageResultModel;
import com.fengwenyi.api_result.model.ResultModel;
import org.junit.Test;

/**
 * Helper测试
 * @author Erwin Feng
 * @since 2019-08-21 10:58
 */
public class HelperTests {

    // 测试 ResultHelper
    @Test
    public void testResultHelper() {
        // 成功，无数据
        ResultModel resultModel = ResultHelper.success("Success");
        System.out.println(resultModel); // resultModel {"success":true, "message":"Success"}

        // 成功，有数据
        ResultModel resultModel2 = ResultHelper.success("Success", "this is data");
        System.out.println(resultModel2); // resultModel {"success":true, "message":"Success", "data":"this is data"}

        // 失败
        ResultModel resultModel3 = ResultHelper.error("This is error info");
        System.out.println(resultModel3); // resultModel {"success":false, "message":"This is error info"}
    }

    // 测试 ApiResultHelper
    @Test
    public void testApiResultHelper() {
        // 成功，无数据
        ApiResultModel apiResultModel1 = ApiResultHelper.success(0, "Success");
        System.out.println(apiResultModel1); // resultModel {"code":0, "success":true, "message":"true"}

        // 成功，有数据
        ApiResultModel apiResultModel2 = ApiResultHelper.success(0, "Success", "This is data");
        System.out.println(apiResultModel2); // resultModel {"code":0, "success":true, "message":"true", "data":"This is data"}

        // 失败
        ApiResultModel apiResultModel3 = ApiResultHelper.success(1000000, "This is error info");
        System.out.println(apiResultModel3); // resultModel {"code":1000000, "success":true, "message":"true"}
    }

    @Test
    public void testPageResultHelper() {
        // 成功，返回分页数据
        String [] data = {"user1", "user2", "user3", "user4", "user5", "user6"};
        PageResultModel<Object> pageResultModel1 = PageResultHelper.success("Success", data, 60, 6, 10, 1);
        System.out.println(pageResultModel1);
        // PageResultModel {"success":true, "message":"true", "data":"[Ljava.lang.String;@6aa8ceb6", "total":60, "size":6, "pages":10, "current":1}

        // 出错
        PageResultModel error = PageResultHelper.error("网络异常，数据获取失败");
        System.out.println(error); //PageResultModel {"success":false, "message":"false"}
    }

}
