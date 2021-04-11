package com;

import dataStructure.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/3/9 11:12 AM
 */
@Test(groups = "ClassGroup") // 类分组测试
public class TestNGAnnotation {
    @Test(groups = "Parameter", enabled = false)
    @Parameters({"annotation", "caseName"})
    public void testParameters(String annotation, String caseName){
        System.out.println(annotation + " " + caseName);
    }

    @Test(dataProvider = "dataProviderTest", groups = "DataProvider")
    public void testDataProvider(String annotation, String caseName){
        System.out.println(annotation + " " + caseName);
    }

    @Test(dataProvider = "dataProviderMethod", groups = "DataProvider")
    public void testDataProviderMethod1(String annotation, String caseName){
        System.out.println(annotation + " " + caseName);
    }

    @Test(dataProvider = "dataProviderMethod", groups = "DataProvider")
    public void testDataProviderMethod2(String annotation, String caseName){
        System.out.println(annotation + " " + caseName);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ExpectedExceptions", enabled = false)
    public void testExpectedExceptionsFail(){
        int i = 1 + 2;
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ExpectedExceptions")
    public void testExpectedExceptionsSuccess(){
        System.out.println("这是一个成功的异常测试");
        int i = 1 / 0;
    }

    @Test(expectedExceptions = IllegalAccessError.class, groups = "ExpectedExceptions", enabled = false)
    public void testExpectedExceptionsUnexpected(){
        int i = 1 / 0;
        System.out.println("这是一个与预期不一样的异常测试");
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        return root;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        return res;
    }



    @Test
    public void testDependOnMethods1(){
        System.out.println("testDependOnMethods1");
    }

    // 执行有依赖的method，会一起执行被依赖的method
    // 执行结果：
    // testDependOnMethods1
    // 依赖testDependOnMethods1
    @Test(dependsOnMethods = "testDependOnMethods1")
    public void testDependOnMethods2(){
        System.out.println("依赖testDependOnMethods1");
    }

    @Test(timeOut = 1)
    public void testTimeOut() throws InterruptedException {
        sleep(2);
        System.out.println("执行失败");
    }

    @DataProvider(name = "dataProviderTest")
    public Object[][] provider(){
        Object[][] o = new Object[][]{
                {"dataProvider1", "testDataProvider"},
                {"dataProvider2", "testDataProvider"}
        };

        return o;
    }

    @DataProvider(name = "dataProviderMethod")
    public Object[][] methodProvider(Method method){
        Object[][] o = null;
        if(method.getName().equals("testDataProviderMethod1")){
            o = new Object[][]{
                    {"dataProvider1", method.getName()},
                    {"dataProvider2", method.getName()}
            };
        }else if(method.getName().equals("testDataProviderMethod2")) {
            o = new Object[][]{
                    {"dataProvider1", method.getName()},
                    {"dataProvider2", method.getName()}
            };
        }

        return o;
    }
}
