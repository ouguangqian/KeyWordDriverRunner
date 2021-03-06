package com.ogq;

import java.io.*;
import java.util.*;

public class FileUtil {
    static List<String> fileList = new ArrayList<String>();
    /**
     * 用例文件转用例列表
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<String > caseToList(String filePath) throws IOException {
        List<String> caseList = new ArrayList<String>();
        File caseFile = new File(filePath);

        // 判断文件是否存在
        if (!caseFile.isFile() || !caseFile.exists()){
            throw new FileNotFoundException("用例文件《 " + filePath + "》不存在！");
        }

        // 读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(caseFile));
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            caseList.add(line);
        }
        return caseList;
    }

    public static List<String> pathToFileList(String filePath){
        File file = new File(filePath);
        if (file.isFile()){
            fileList.add(filePath);
        }else if (file.isDirectory()){
            String[] files = file.list();
            for (String f: files){
                String path = filePath + File.separator + f;
                pathToFileList(path);
            }
        }
        return fileList;
    }

    public static List<Map<String, List<String>>> fileToCaseMap(String filePath) throws IOException {
        List<Map<String, List<String>>> caseLists = new ArrayList<Map<String,List<String>>>();
        List<String> fileList = pathToFileList(filePath);
        for (String file: fileList) {
            List<String> caseList = caseToList(file);
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map.put("file", Arrays.asList(file));
            map.put("case", caseList);
            caseLists.add(map);
        }
        return caseLists;
    }
    public static void main(String[] args){
        List<String> aa = pathToFileList("E:\\IdeaProjects\\fortest\\src\\main\\resources");
        System.out.println(aa);
    }
}
