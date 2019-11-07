/**
 * @author: zephxu
 * @email: zephaniaxu0701@gmail.com
 * PACKAGE: com.zephxu.crowdfunding.manager.controller
 * PROJECT: Atcrowdfundingparent
 * Date: 2019-11-05 19:41
 * @module: 类所属模块
 * @describe:
 * @version: v1.0
 */
package com.zephxu.crowdfunding.manager.dao;

import com.zephxu.crowdfunding.manager.service.TestService;
import com.zephxu.crowdfunding.manager.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    /**
     *  首先根据byType进行类型查找
     如果查找到一个,直接注入;
     * 		如果查找到多个:
     * 			根据byName进行注入:
     * 				将多个对象中其中名称与变量名称一致的那个bean注入进来.
     * 				如果多个对象没有名称是与变量名称一致的:
     * 					可以指定@Qualifier(value="testServiceImpl"),将其中一个注入进来.
     * 					如果	@Qualifier 所指定的名称,没有与任何一个bean的名称一致,会报错.
     * 				如果无法注入,不希望报错:	@Autowired(required=false)
     *  若是
     *     private TestServiceImpl testService;
     *   则
     *   testService.insert();
     *   的事务功能失效，原因是aop动态代理
     *   jdk动态代理需要目标对象有实现接口，
     *   而在容器里找到的对象是代理对象，
     *   跟目标对象只是近似的兄弟关系，并不可以通过父类转为子类导致报错
     *   没有则是cglib动态代理，如果TestServiceImpl不实现接口
     *   AOP原理:动态代理.
     * 	 如果目标对象有接口,那么默认采用JDK动态代理(基于接口(代理类和目标类实现共同的接口.)).
     * 	 如果目标对象 没有接口,那么采用Cglib动态代理(基于继承(代理类是目标类的子类)).
     * 	 推荐,使用JDK动态代理 .也就是我们推荐采用面向接口编程.面向抽象编程.
     *
     *
     */
    @Autowired
    private TestService testService;
    //依赖倒转原则.

    @RequestMapping("/test")
    public String test() {
        System.out.println("TestController");
        testService.insert();
        return "success";
    }
}
