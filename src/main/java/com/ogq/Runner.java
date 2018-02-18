package com.ogq;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void Runner(String filePath) throws IOException {

        List<Map<String, List<String>>> caseLists =  FileUtil.fileToCaseMap(filePath);

        for (Map<String, List<String>> clMap: caseLists){
            List<String> cl = clMap.get("case");
            String caseName = String.valueOf(clMap.get("file").get(0));
            System.out.println(caseName);
            for (int i = 0; i < cl.size(); i++){
                if (cl.get(i).startsWith("loop")) {
                    int startIndex = i;
                    int endIndex = cl.lastIndexOf("end");
                    RunLoopKeyWord.runLoopKeyWords(cl.subList(startIndex+1, endIndex), Integer.parseInt(cl.get(i).split("\\s+")[1]));
                    i = endIndex;
                }else {
                    RunKeyWord.runKeyWord(cl.get(i));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        Runner.Runner("E:\\IdeaProjects\\fortest\\src\\main\\resources");
    }
}
