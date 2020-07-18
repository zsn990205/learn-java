import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Card implements Comparable<Card> {
    //comparable是让card类来实现comparable
    public String suit;
    public String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        //对象之间的身份比较
        //前4个步骤是固定操作

        //如果this和obj的身份相同
        if(this==obj) {
            return true;
        }
        //看看obj为空吗
        if(obj==null) {
            return false;
        }
        //看看obj可不可以转换为Card
        if(!(obj instanceof Card)) {
            return false;
        }
        //类型转换 将其转换成card类型
        Card other=(Card) obj;
        //根据你想要的比较结果进行比较
        return this.rank.equals(other.rank);
    }

    @Override
    public int compareTo(Card o) {
        //按照扑克牌的点数进行比较
        int rank1=this.convertRank();
        int rank2=o.convertRank();
    //升序排列
        return rank1-rank2;
    }
    public int convertRank() {
        //将扑克牌中的字母全部转换成数字
        if("A".equals(rank)) {
            return 14;
        }
        if("J".equals(rank)) {
            return 11;
        }
        if("Q".equals(rank)) {
            return 12;
        }
        if("K".equals(rank)) {
            return 13;
        }
    return Integer.parseInt(rank);
    }
}

class CardComparator implements Comparator<Card> {
    //comparator是新建一个新的类 让这个类来实现comparator
    @Override
    public int compare(Card o1, Card o2) {
        int rank1=o1.convertRank();
        int rank2=o2.convertRank();
        return rank1-rank2;
    }
}
public class Compare {
    public static void main(String[] args) {
        List<Card> card=new ArrayList<>();
        card.add(new Card("♥","10"));
        card.add(new Card("♥","A"));
        card.add(new Card("♠","Q"));
        card.add(new Card("♣","3"));
        card.add(new Card("♦","J"));

        //Collections.sort(card,new CardComparator());
        Collections.sort(card, new Comparator<Card>() {
        //使用匿名内部类构建
            @Override
            public int compare(Card o1, Card o2) {
                return 0;
            }
        });
        System.out.println(card);

    }
    public static void main1(String[] args) {
        Card card1=new Card("♥","10");
        Card card2=new Card("♠","10");
        Card card3=card1;
    //没做特殊规定的时候 比较的是身份
        System.out.println(card1.equals(card2));
    //比较的是身份
        System.out.println(card1==card2);
        System.out.println(card1==card3);
        System.out.println(card1.compareTo(card2));
    }
}
