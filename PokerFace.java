import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PokerFace {
    static class Card {
        public String suit; //花数
        public String rank; //点数

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return String.format(("%s%s"),suit,rank);
        }
    }
    public static List<Card> buyPoker() {
    List<Card> poker=new ArrayList<>();
    String[] suits= {"♥","♠","♣","♦"};
    for(int i=0;i<4;i++) {
       for(int j=2;j<=10;j++) {
           Card card=new Card(suits[i],""+j);
           poker.add(card);
       }
        poker.add(new Card(suits[i],"J"));
        poker.add(new Card(suits[i],"Q"));
        poker.add(new Card(suits[i],"K"));
        poker.add(new Card(suits[i],"A"));
    }
       return poker;
    }

    public static void main(String[] args) {
    //1.买一副牌
    List<Card> poker=buyPoker();
    //2.洗牌
    Collections.shuffle(poker);
     System.out.print(poker);
     //3.发牌
     //总共三个人 一个人发5张牌
        List<List<Card>> players=new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());

     for(int card=0;card<5;card++) {
         for(int playerCount=0;playerCount<3;playerCount++) {

             //先获取玩家链表 并且让玩家获得牌
            List<Card> player=players.get(playerCount);
             //把poker最前面的元素发给玩家
             Card top=poker.remove(0);
             player.add(top);
         }
     }
        System.out.println("玩家1的手牌是: ");
        System.out.println(players.get(0));
        System.out.println("玩家2的手牌是: ");
        System.out.println(players.get(1));
        System.out.println("玩家3的手牌是: ");
        System.out.println(players.get(2));
    }
}