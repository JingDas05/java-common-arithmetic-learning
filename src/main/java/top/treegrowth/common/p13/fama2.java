package top.treegrowth.common.p13;

import java.util.ArrayList;

public class fama2 {
    private int count;
    private ArrayList A = new ArrayList();
    private ArrayList B = new ArrayList();

    fama2(int count) {
        if (count > 0) {
            this.count = count;
        }
    }

    public void prtGroup() {
        int Left, Inserted, temp;
        Left = count;
        Inserted = 0;
        temp = Inserted * 2 + 1;
        int index = 0;
        int i;
        while (Left > 0) {
            temp = Math.min(temp, Left);
            A.add(index, new Integer(temp));
            for (i = Inserted + 1; i <= Inserted + temp; i++) {
                if (i < temp) {
                    B.add(i - 1, new String(temp + "-( " + B.get(temp - i - 1) + ") "));
                } else if (i == temp) {
                    B.add(i - 1, Integer.toString(temp));
                } else if (i > temp) {
                    B.add(i - 1, new String(temp + "+( " + B.get(i - temp - 1) + ") "));
                }
            }
            Inserted = Inserted + temp;
            Left = Left - temp;
            temp = Inserted * 2 + 1;
            index++;
        }
        for (i = 0; i < A.size(); i++) {
            System.out.println(A.get(i));
        }
        for (i = 0; i < B.size(); i++) {
            System.out.println((i + 1) + "= " + B.get(i));
        }
    }

    public static void main(String[] args) {
        int count = 40;
        fama2 PS = new fama2(count);
        PS.prtGroup();
    }
}