import com.ogq.RunKeyWord;
import com.ogq.RunLoopStep;
import com.ogq.RunStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    static  List<String> STEPS = new ArrayList<String>(Arrays.asList("打开", "开始循环 5", "点击", "滑动", "点击", "开始循环 3", "点击", "返回", "结束", "输入", "结束", "主界面"));
    static int LOOP_TIMES = 0;
    static int LOOP_LEVELS = 0;
    static boolean FLAG = false;

    public static void runKeyWord(String keyWord){
        System.out.println("执行步骤信息===>" + keyWord);
    }

    public static void runLoopKeyWord(List<String> stepList, int loopTimes){
        for (int i = 0; i < loopTimes; i++) {
            for (int j = 0; j < stepList.size(); j++) {
                if (stepList.get(j).startsWith("开始循环")){
                    int startIndex = j;
                    int endIndex = stepList.lastIndexOf("结束");
                    runLoopKeyWord(stepList.subList(startIndex+1, endIndex), Integer.parseInt(stepList.get(j).split("\\s+")[1]));
                    j = endIndex;
                }else {
                    runKeyWord(stepList.get(j));
                }

            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {

        // 处理循环
        for (int i = 0; i < STEPS.size(); i++){
            if (STEPS.get(i).startsWith("开始循环")) {
                int startIndex = i;
                int endIndex = STEPS.lastIndexOf("结束");
//                runLoopKeyWord(STEPS.subList(startIndex+1, endIndex), Integer.parseInt(STEPS.get(i).split("\\s+")[1]));
                RunLoopStep.runLoopSteps(STEPS.subList(startIndex+1, endIndex), Integer.parseInt(STEPS.get(i).split("\\s+")[1]));
                i = endIndex;
            }else {
//                runKeyWord(STEPS.get(i));
                RunStep.runStep(STEPS.get(i));
            }


        }

    }
}
