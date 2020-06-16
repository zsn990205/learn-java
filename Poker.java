
/*

扑克牌程序

洗牌 发牌
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Poker {
    static class Card {
        //不加static的内部类 创建card对象的时候必须依靠poker
        //加上就不依赖了
        public String suit;//花数
        public String rank;//点数

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
        // return "(" + suit + rank + ")";
        return String.format(("%s%s"),suit,rank);// 更好看
        }
    }
    //构建一副牌
    public static List<Card> buyPoker() {
        //先买一副牌
        List<Card> poker=new ArrayList<>();
        String[] suits={"♥","♠","♣","♦"};
        for (int i = 0; i <4 ; i++) {
            //四种花色
        for(int j=2;j<=10;j++) {
            //从2到10
            Card card=new Card(suits[i],""+j); //字符串+整数还是字符串
            poker.add(card);
        }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));

        }
     return poker;
    }
    public static void shuffle(List<Card> poker) {
        //洗牌思路很简单 每找到一个牌和他前面的交换位置
        Random random=new Random();
        for(int i=poker.size()-1;i>0;i--) {
            int s=random.nextInt(i);
            swap(poker,i,s);
        }
    }
    public static void swap(List<Card> poker ,int i,int j) {
        Card tmp=poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }
    public static void main(String[] args) {
    List<Card> poker=buyPoker();
    //洗牌2(标准库提供的洗牌方法)
        Collections.shuffle(poker);
        System.out.println(poker);
    //洗牌1
    //shuffle(poker);
    //System.out.println(poker);


    //发牌 三个玩家 每个人发5张
    List<List<Card>> players=new ArrayList<List<Card>>();
    //每个玩家的手牌是List 多个玩家再放进一个list中
    //每个玩家也是一个list
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //发牌不是一次性发完的 是玩家1发一张 接下来往后发
        for(int card=0;card<5;card++) {
            for(int playercount=0;playercount<3;playercount++) {
                //先获取玩家
                List<Card> player=players.get(playercount);
                //把poker最前面的元素发给玩家
                Card top=poker.remove(0);
                player.add(top);
            }
        }
        //展示手牌 比大小
        System.out.println("玩家1的手牌 :");
        System.out.println(players.get(0));
        System.out.println("玩家2的手牌 :");
        System.out.println(players.get(1));
        System.out.println("玩家3的手牌 :");
        System.out.println(players.get(2));

    }
}
