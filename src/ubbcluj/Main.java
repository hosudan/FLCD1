package ubbcluj;

import ubbcluj.Model.FiniteAutomata;
import ubbcluj.Model.HHashTable;
import ubbcluj.Model.Node;
import ubbcluj.Model.Scanner;

public class Main {

    public static void main(String[] args) {
    /*    HHashTable<Integer, String> map = new HHashTable();
        map.put (512, "pizza");
        map.put (2, "dwadwadawdadsdz");
        map.put (510, "junge");
        System.out.println(map.get(2));
        System.out.println(map.get(510));
        map.remove(510);
        System.out.println(map.get(510)); */

       /* Scanner sc = new Scanner("p1example.txt","codificationtable.txt");
        System.out.println(sc.isIdentifier("1"));
        System.out.println(sc.isCharacter("'a'"));
        sc.outputSTPIF(); */
        FiniteAutomata fa = new FiniteAutomata("FA.txt");
        fa.readFA();
    }
}
