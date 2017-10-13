package com.taiji.eap;

public class Test1 {

    public static void main(String[] args){
StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if(i%2==0){
                sb.append("<tr>");
            }
            sb.append(i+1);
            if((i+1)%2==0){
                sb.append("</tr>\n");
            }
        }
        System.out.print(sb.toString());
    }

}
