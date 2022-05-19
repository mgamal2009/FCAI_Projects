/*
package com.company;

import java.util.ArrayList;

public class Parser {

    String commandName;
    ArrayList<String> args = new ArrayList<>();

    String temp ;
    boolean quotes;

    public boolean parse(String input){
        temp = "";
        quotes = false;
        args.clear();
        commandName = "";

        for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' ' && !quotes){
                if (!temp.equals("")) {
                    args.add(temp);
                    temp = "";
                }
                continue;
            }else if(input.charAt(i) == '"' && quotes){
                quotes = false;
                args.add(temp);
                temp = "";
                i++;
                continue;
            }else if(input.charAt(i) == '"' && !quotes){
                quotes = true;
                continue;
            }
            temp += input.charAt(i);

            if(i == input.length() - 1){
                args.add(temp);
            }
        }
        commandName = args.get(0);
        args.remove(0);
        return true;
    }

    public String getCommandName(){
        return commandName;
    }

    public ArrayList<String> getArgs(){
        return args;
    }
}
*/
