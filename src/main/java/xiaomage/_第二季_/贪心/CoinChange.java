package xiaomage._第二季_.贪心;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        Integer[] faces = {25,10,5,1};
        Arrays.sort(faces,(f1,f2)-> f2-f1 );//倒序

        int money = 41,coins = 0 ,i = 0;
        while (i < faces.length){
            if (money < faces[i]){
                i++;
                continue;
            }
            System.out.println(faces[i]);
            money-=faces[i];
            coins++;
        }

        System.out.println(coins);

    }

    static void solve1(){
        int[] faces = {25,10,5,1};
        Arrays.sort(faces);

        int money = 41, coins = 0;
        for (int i = faces.length; i>= 0; i--) {
            if (money< faces[i]) continue;
            money -= faces[i];
            coins++;
            //每次从最大的开始选；
            i = faces.length;
        }
    }
}
