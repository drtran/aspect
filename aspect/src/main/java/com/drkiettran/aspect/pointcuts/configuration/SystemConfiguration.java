package com.drkiettran.aspect.pointcuts.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.drkiettran.aspect.pointcuts")
public class SystemConfiguration {

}
