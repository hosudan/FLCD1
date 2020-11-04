package ubbcluj.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiniteAutomata {
    private List<String> States;
    private List<String> input;
    private String Start;
    private String[][] transitionTable;
    private String FAname;

    public FiniteAutomata(String Fname){
        this.FAname=Fname;
        States = new ArrayList<>();
        input = new ArrayList<>();
        readFA();
    }

    public void check(String value){
        boolean flag = false; // accepted or not
        int strcount = 0;
        char Ch;
        int state = 1;

        String curSt = transitionTable[0][1];
        while(strcount<value.length()){
            Ch = value.charAt(strcount);
            int inputcount = 1;
            while(inputcount<input.size()){
                    if(transitionTable[0][inputcount].compareTo(Character.toString(Ch))==0){
                        curSt = transitionTable[state][inputcount];
                        for(int i = 0;i<States.size(); i++){
                            if(transitionTable[i][0].compareTo(curSt)==0){
                                state = i;
                            }
                        }
                        break;
                     }
                     inputcount++;
            }
            if(inputcount>input.size()){
                flag = true;
                break;
            }
            strcount++;
        }

    }

    public void readFA(){
        try{
            File file = new File("/Users/Dan/IdeaProjects/FLCD/src/resources/" + this.FAname);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str; String[] list;
            str = br.readLine();
            list = str.split(" ");
            for (String s: list){
                States.add(s);
            }
            str = br.readLine();
            list = str.split(" ");
            for (String s: list){
                input.add(s);
            }
            str = br.readLine();
            Start = str;

            transitionTable = new String[States.size()][input.size()+1];
            int  i = 0; int j = 0;
            while ((str = br.readLine()) != null) {
                list = str.split(" ");
                System.out.println(list);
                for(String s: list ){
                    transitionTable[i][j] = s;
                    j++;
                }
                i++;
            }
            System.out.println(States);
            System.out.println(input);
            System.out.println(Start);
            System.out.println(transitionTable);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception while reading from table file!");
        }
    }
}
