package com.taiji.eap;

/**
 * @author 潘宏智
 * @date
 */
public class Test2 {

    public static void main(String[] args){
        String s = "";
        for (int i = 0; i < 10; i++) {
            if(i==0){
                s+=i;
            }else {
                s+=","+i;
            }
        }
        System.out.print(s);
    }

}
