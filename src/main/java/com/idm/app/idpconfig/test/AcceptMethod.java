package com.idm.app.idpconfig.test;

import org.apache.http.impl.client.AIMDBackoffManager;

import java.util.Arrays;
import java.util.List;

/**
 * @author: pl
 * @desc:
 * @date: 2020/8/3
 */
public class AcceptMethod {


        public static void  printValur(String str){
            System.out.println("print value : "+str);
        }

        public static void main(String[] args) {
            List<String> al = Arrays.asList("a","b","c","d");
//            for (String a: al) {
//                AcceptMethod.printValur(a);
//            }
               List<Integer> dd =  Arrays.asList(1,2,3);
            System.out.println(dd);
            System.out.println(al);

            al.forEach(AcceptMethod::printValur);

        }
}
