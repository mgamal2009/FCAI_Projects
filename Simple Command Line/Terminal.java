/*
package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Terminal {
    Parser parser;
    File path ;
    public Terminal() throws IOException {
        parser = new Parser();
        path = new File(System.getProperty("user.dir"));
        while (true){
            System.out.print(path + " ");
            Scanner input = new Scanner(System.in);
            String toParse = input.nextLine();
            if(toParse.equals("exit")){
                return;
            }

            try{
                if(parser.parse(toParse)){
                    chooseCommandAction();
                }
            }catch (Exception e){
                System.out.println("Please enter a valid command");
            }

        }
    }
    public String pwd(){
        return path.toString();
    }
    public void echo(ArrayList<String> arg){
        String arg2="";
        for(int i=0;i<arg.size();i++){
            arg2+= arg.get(i) + ' ';
        }
        System.out.println(arg2);
    }
    public void cd(ArrayList<String> args) throws IOException{
        if(args.isEmpty()){
            path = new File(System.getProperty("user.dir"));
            return;
        }
        if(args.get(0).equals("..")){
            path=new File(path.getParent());
        }
        else{
            String fileName = "";
            for (int i=0; i<args.size(); i++){
                if(i < args.size() && i > 0){
                    fileName += " ";
                }
                fileName += args.get(i);
            }
            File file=new File(fileName);
            if (!file.isAbsolute()) {

                file = new File(path.getPath() + File.separator + fileName);
            }
            if(file.exists()){
                path=file;
            }else {
                System.out.println("The system cannot find the path specified.");
            }
        }
    }
    public String ls() {
        String[] fileList = path.list();
        String mySortedlist = "";
        for (int i = 0; i < fileList.length; ++i) {
            mySortedlist += fileList[i] + '\n';
        }
        return mySortedlist;
    }
    public String ls_r() throws IOException {
        String[] fileList = path.list();
        String myReversedList = "";
        for (int i = fileList.length - 1; i >= 0; --i) {
            myReversedList += fileList[i] + '\n';
        }
        return myReversedList;
    }
    public void mkdir(ArrayList<String> args){
        for(int i=0;i<args.size();i++){
            File file=new File(args.get(i));
            if(!file.isAbsolute()){
                file = new File(path.getPath() + "\\" + args.get(i));
            }
            if(!file.exists()){
                file.mkdir();
            }
            else{
                System.out.println("Directory already exists.");
            }
        }
    }
    public void rmdir(String arg){
        if(arg.equals("*")){
            boolean flag=false;
            File[] fileL=path.listFiles();
            for(int i=0;i< fileL.length;i++){
                if(fileL[i].length()==0 && fileL[i].isDirectory()){
                    fileL[i].delete();
                }
            }
        }
        else{
            File file=new File(arg);
            if(!file.isAbsolute()){
                file=new File(path.getPath()+File.separator+arg);
            }
            if(file.exists()){
                if(file.length()==0 && file.isDirectory()){
                    file.delete();
                }
                else{
                    System.out.print("There is No Empty Directories");
                }
            }else{
                System.out.print("NOT found Directories");
            }
        }
    }
    public void touch(String arg) throws IOException{
        File file;
        if(new File(arg).isAbsolute()){
            file=new File(arg);
        }
        else{
            file=new File(path.getPath()+File.separator+arg);
        }
        if(file.exists()){
            System.out.println("File already exists");
        }
        file.createNewFile();
    }
    public void cp(ArrayList<String> args) throws IOException{
        File file1;
        File file2;
        file1 = new File(args.get(0));
        file2 = new File(args.get(1));
        if(!file1.isAbsolute()){
            file1 = new File(path + "\\" + args.get(0));
        }
        if(!file2.isAbsolute()){
            file2 = new File(path + "\\" + args.get(1));
        }
        Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public void cp_r(ArrayList<String> args) throws IOException {
        File file1;
        File file2;
        file1 = new File(args.get(1));
        file2 = new File(args.get(2));
        if(!file1.isAbsolute()){
            file1 = new File(path + "\\" + args.get(1));
        }
        if(!file2.isAbsolute()){
            file2 = new File(path + "\\" + args.get(2));
        }
        if(file1.isDirectory() && file2.isDirectory()){
            File temp = new File(file2.toPath() + "\\" + file1.getName() );
            copyDir(file1.toPath(), temp.toPath());
        }
    }
    public void rm(String arg){
        File file = new File(arg);
        if(!file.isAbsolute()){
            file = new File(path + "\\" + arg);
        }
        if(file.exists()){
            file.delete();
        }else{
            System.out.println("The file isn't existed");
        }
    }
    public void cat(ArrayList<String> args) throws IOException {
        BufferedReader myReader;
        if(args.size() == 1){
            File file = new File(args.get(0));
            if(!file.isAbsolute()){
                file = new File(path + "\\" + args.get(0));
            }
            myReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = myReader.readLine()) != null){
                System.out.println(line);
            }
        }else{
            File file1 = new File(args.get(0));
            File file2 = new File(args.get(1));
            if(!file1.isAbsolute()){
                file1 = new File(path + "\\" + args.get(0));
            }
            if(!file2.isAbsolute()){
                file2 = new File(path + "\\" + args.get(1));
            }
            myReader = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = myReader.readLine()) != null){
                System.out.println(line);
            }
            myReader = new BufferedReader(new FileReader(file2));
            while ((line = myReader.readLine()) != null){
                System.out.println(line);
            }
        }
    }
    public void chooseCommandAction() throws IOException {
        String command = parser.getCommandName();
        ArrayList<String> args = new ArrayList<>(parser.getArgs());
        if(command.equals("pwd")){
            pwd();
        }
        else if(command.equals("echo")){
            echo(args);
        }
        else if (command.equals("cd")){
            cd(args);
            System.out.println();
        }
        else if (command.equals("ls")){
            if(args.isEmpty()){
                System.out.println(ls());
            }else if (args.get(0).equals("-r")){
                System.out.printf(ls_r());
            }else {
                System.out.println("This is not recognized as an internal or external command");
            }
            System.out.println();
        }
        else if (command.equals("mkdir")){
            mkdir(args);
        }
        else if (command.equals("rmdir")){
           if(args.size() > 1 || args.size()==0){
               System.out.println("Please enter a valid command argument");
           }else{
               rmdir(args.get(0));
           }
        }
        else if (command.equals("touch")){
            if(args.size() > 1 || args.size()==0){
                System.out.println("Please enter a valid command argument");
            }else{
                touch(args.get(0));
            }
        }
        else if (command.equals("cp") && !(args.get(0).equals("-r"))){
            if(args.size() != 2 ){
                System.out.println("Please enter a valid command argument");
            }else{
                cp(args);
            }
        }
        else if(command.equals("cp") && args.get(0).equals("-r")){
            if(args.size() != 3){
                System.out.println("Please enter a valid command argument");
            }else{
                cp_r(args);
            }
        }
        else if(command.equals("rm")){
            if(args.isEmpty()){
                System.out.println("Please enter an argument");
            }else{
                rm(args.get(0));
            }
        }
        else if(command.equals("cat")){
            if(args.size() == 1 || args.size()==2){
                cat(args);
            }else{
                System.out.println("Please enter a valid arguments");
            }
        }
        else{
            System.out.println("Please enter a valid command");
        }
    }
    public static void copyDir(Path src, Path dest) throws IOException {
        List<Path> sources = Files.walk(src).collect(Collectors.toList());
        for (Path source: sources)
        {
            Files.copy(source, dest.resolve(src.relativize(source)),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
*/
