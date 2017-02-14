package com.junly.controller.common;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class Controller {
	//@Transactional(propagation=Propagation.MANDATORY)//必须需要
	//@Transactional(propagation=Propagation.NEVER)//绝不需要
	//@Transactional(propagation=Propagation.REQUIRED)//需要 如果调用bean有则加入 没有新建
	//@Transactional(propagation=Propagation.REQUIRES_NEW)//不管是否存在事物都新建一个事物 原来的挂起，新的执行完毕后，继续执行老的
	//@Transactional(propagation=Propagation.SUPPORTS)//如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
    //@Transactional(propagation=Propagation.NOT_SUPPORTED)//容器不为这个方法开启事务
     @Transactional(propagation=Propagation.NESTED)
     
     public void get()
    {
    	
    }
}
