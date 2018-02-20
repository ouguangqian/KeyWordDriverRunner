package com.ogq;

import java.util.List;

import static com.ogq.RunKeyWord.runKeyWord;

public class RunLoopStep {

    public static void runLoopSteps(List<String> stepList, int loopTimes) throws NoSuchMethodException {
        for (int i = 0; i < loopTimes; i++) {
            System.out.println("执行第" + i + "次循环...");
            for (int j = 0; j < stepList.size(); j++) {
                if (stepList.get(j).startsWith("loop")){
                    int startIndex = j;
                    int endIndex = stepList.lastIndexOf("end");
                    runLoopSteps(stepList.subList(startIndex+1, endIndex), Integer.parseInt(stepList.get(j).split("\\s+")[1]));
                    j = endIndex;
                }else {
                    RunStep.runStep(stepList.get(j));
                }
            }
            System.out.println("执行第" + i + "次循环结束");
        }
    }
}
