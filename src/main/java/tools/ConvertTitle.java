package tools;

import java.util.Scanner;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/8 12:03 PM
 */
public class ConvertTitle {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner in = new Scanner(System.in);

/*        while(flag){
//            String originInput = in.next();
//
//            if(originInput.trim().toLowerCase().equals("exit")){
//                break;
//            }

            String originInput = "https://leetcode-cn.com/problems/intersection-of-two-linked-lists/";
            convertTitle(originInput);
        }*/

        String originInput = "https://leetcode-cn.com/problems/intersection-of-two-linked-lists/";
        convertTitle(originInput);
    }

    public static void convertTitle(String originInput){
        String originTitle = originInput.substring(30);

        StringBuilder aimTitle = new StringBuilder();

        String[] subTitles = originTitle.split("-");
        for(int i=0;i<subTitles.length;i++){
            char[] subs = subTitles[i].toCharArray();
            subs[0] = (char) (subs[0]-32);
            aimTitle.append(subs);
        }

        System.out.println(aimTitle);
    }
}
