//
package com.Spring_Core.MainProgram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring_Core.Component.Girl;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 05/06/2020
 */

public class MainProgram {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		System.out.println(context);
		Girl girl = context.getBean("girl", Girl.class);
		System.out.println(girl);
	}
}
