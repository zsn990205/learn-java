
/*

杨辉三角
1.第一行固定都是1
2.第二行固定只有两个1
3.后面的所有行 第一列最后一列都是1
4.第i行有第i列
5.第i行的第j列=第i-1行的第j-1列+第i行的第j列
 */

import java.util.ArrayList;
import java.util.List;

public class generate {
public List<List<Integer>> generate(int numRows) {
    //先创建一个返回结果
    List<List<Integer>> ret=new ArrayList<>();
    if(numRows<=0) {
        return ret; //直接返回空的ret
    }
    //处理第一行
    ArrayList<Integer> firstLine=new ArrayList<>();
    firstLine.add(1);
    //第一行加入到顺序表中
    ret.add(firstLine);
    if(numRows==1) {
        return ret;
    }
    //处理第二行的情况
    ArrayList<Integer> secondLine=new ArrayList<>();
    secondLine.add(1);
    secondLine.add(1);
    ret.add(secondLine);
    if(numRows==2) {
        return ret;
    }
    //处理后面行
    //后面的所有行 第一列最后一列都是1
    //第i行有第i列
    //第i行的第j列=第i-1行的第j-1列+第i行的第j列
    //(i,j)=(i-1,j-1)+(i-1,j)

    for(int row=3;row<=numRows;row++) {
    //第row行得知道前一行
    //row从1开始计算 但是下标是从0开始的
    //把行数转换成下标 row-1得到row-1行
    List<Integer> prevLine=ret.get(row-1-1);
    List<Integer> curLine=new ArrayList<>(); //当前行
    curLine.add(1);
    for(int col=2;col<=row-1;col++) {
    //第一行和最后一行不用考虑
    //第一列和最后一列都是1
    int tmp1=prevLine.get(col-1-1); //相当于j-1
    int tmp2=prevLine.get(col-1);  //相当于j
    curLine.add(tmp1+tmp2);
    }
    curLine.add(1);
    ret.add(curLine);
    }

    return ret;
}
}
