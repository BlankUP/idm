package com.idm.filter;

import org.springframework.util.AntPathMatcher;

public class Test {
    public static void main(String args[]){
        AntPathMatcher pathMatcher = new AntPathMatcher();
        //System.out.println(pathMatcher.match("/login*","/login"));
        //System.out.println(pathMatcher.match("/public/**/*","/public/bootstrap/css/bootstrap.min.css"));
        new Thread() {
            public void run() {
            	System.out.println("hello!!!!!!");
            };
        }.start();
        double a = (10462572/1024)/(12463116/1024);
        double t = 10462572/1024;
        double b = 12463116/1024;
        System.out.println(t);
        System.out.println(b);
        System.out.println(t/b);
        
        String result = "";// 返回的结果
        StringBuffer sbf = new StringBuffer();
        result = sbf.toString();
        System.out.println("result:"+result);
        
    }
}
