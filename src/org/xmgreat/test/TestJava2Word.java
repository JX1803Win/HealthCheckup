package org.xmgreat.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmgreat.util.WordUtil;

public class TestJava2Word {

	public static void main(String[] args) throws IOException {
		//createWord();
		createReport();
		//String BASE64 = WordUtil.getImageString("D://doc//friend.jpg");
		//System.out.println(BASE64);
	}
	
	public static void createWord() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        /** 组装数据 */
        dataMap.put("userName","张三");
        dataMap.put("sex","男");
        dataMap.put("age","18");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        dataMap.put("birth",sdf.format(new Date()));
        dataMap.put("phone","12345678910");
        dataMap.put("date",sdf.format(new Date()));
        
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i", i);
			map.put("officeName", "科室"+i);
			map.put("projectName", "项目"+i);
			newsList.add(map);
		}
        dataMap.put("myListData",newsList);  
        
        //文件路径
        String filePath= "E:\\培训\\项目\\健康体检散检系统项目\\我的文档";
        
        //文件名称
        String fileName = "体检导检单" + System.currentTimeMillis()+".doc";
        
        /** 生成word */
        WordUtil.createWord(dataMap, "体检导检单.ftl", filePath, fileName);
    }
	
	public static void createReport() {
		// 组装数据 
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			dataMap.put("barcode", WordUtil.getImageString("2345678"));// 条形码
		} catch (IOException e) {
			e.printStackTrace();
		}
 
        dataMap.put("userName","张三");
        
        List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i", i);
			map.put("officeName", "科室"+i);
			map.put("projectName", "项目"+i);
			newsList.add(map);
		}
        dataMap.put("myListData",newsList);  
        
        List<Map<String,List<Map<String, Object>>>> projectList = new ArrayList<>();
        for(int j = 1; j <= 2; j++) {
        	Map<String,List<Map<String, Object>>> project = new HashMap<>();
        	List<Map<String, Object>> detailList  = new ArrayList<>();
        	for(int i = 1; i <= 3; i++) {
        		Map<String, Object> detail = new HashMap<>();
        		detail.put("i", i);
        		detail.put("detailName", "细项"+i);
        		detail.put("result", "结果"+i);
        		detail.put("unit", "单位"+i);
        		detail.put("reference", "参考值"+i);
        		detail.put("hint", "提示"+i);
        		detailList.add(detail);
        	}
        	project.put("项目"+j, detailList);
        	List<Map<String, Object>> list  = new ArrayList<>();
        	Map<String, Object> info = new HashMap<>();
        	info.put("officeName", "检查室" + j);
        	info.put("manageName", "医生" + j);
        	list.add(info);
        	project.put("info", list);
        	projectList.add(project);
        }
        dataMap.put("projects", projectList);
        //System.out.println(projectList.toString());
        //文件路径
        String filePath= "E:\\培训\\项目\\健康体检散检系统项目\\我的文档";
        
        //文件名称
        String fileName = "体检报告" + System.currentTimeMillis()+".doc";
        
        /** 生成word */
        WordUtil.createWord(dataMap, "体检报告.ftl", filePath, fileName);
	}
	
	
	
}