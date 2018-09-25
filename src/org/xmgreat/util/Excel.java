package org.xmgreat.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.xmgreat.bean.PhyCardBean;


public class Excel {
	/**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
   /* public static List<PhyCardBean> getAllByExcel(String file){
        List<PhyCardBean> list=new ArrayList<PhyCardBean>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    
                    
                    System.out.println("id:"+id+" name:"+name);
                    Long phyCardId=Long.valueOf(id);
                    Integer parameterId=Integer.valueOf(id);
                    list.add(new PhyCardBean(phyCardId,parameterId));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }*/
	  private int totalRows = 0;  
	    //总条数
	    private int totalCells = 0; 
	    //错误信息接收器
	    private String errorMsg;
	    //构造方法
	    public Excel(){}
	    //获取总行数
	    public int getTotalRows()  { return totalRows;} 
	    //获取总列数
	    public int getTotalCells() {  return totalCells;} 
	    //获取错误信息
	    public String getErrorInfo() { return errorMsg; }  
	    List<PhyCardBean> list;
	  /**
	   * 读EXCEL文件，获取信息集合
	   * @param fielName
	   * @return
	   */
		public List<PhyCardBean> getExcelInfo(MultipartFile mFile) {
			String fileName = mFile.getOriginalFilename();//获取文件名
			
			try {
				if (!validateExcel(fileName)) {// 验证文件名是否合格
					return null;
				}
				boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
				if (isExcel2007(fileName)) {
					isExcel2003 = false;
				}
				 list = createExcel(mFile.getInputStream(), isExcel2003);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	  
	  /**
	   * 根据excel里面的内容读取客户信息
	   * @param is 输入流
	   * @param isExcel2003 excel是2003还是2007版本
	   * @return
	   * @throws IOException
	   */
		public List<PhyCardBean> createExcel(InputStream is, boolean isExcel2003) {
			try{
				Workbook wb = null;
				if (isExcel2003) {// 当excel是2003时,创建excel2003
					wb = new HSSFWorkbook(is);
				} else {// 当excel是2007时,创建excel2007
					wb = new XSSFWorkbook(is);
				}
				 list = readExcelValue(wb);// 读取Excel里面客户的信息
			} catch (IOException e) {
				e.printStackTrace();
			}
			return list;
		}
	  
	  /**
	   * 读取Excel里面客户的信息
	   * @param wb
	   * @return
	   */
		private List<PhyCardBean> readExcelValue(Workbook wb) {
			// 得到第一个shell
			Sheet sheet = wb.getSheetAt(0);
			// 得到Excel的行数
			this.totalRows = sheet.getPhysicalNumberOfRows();
			// 得到Excel的列数(前提是有行数)
			if (totalRows > 1 && sheet.getRow(0) != null) {
				this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			}
			List<PhyCardBean> userList = new ArrayList<PhyCardBean>();
			// 循环Excel行数
			for (int r = 1; r < totalRows; r++) {
				Row row = sheet.getRow(r);
				if (row == null){
					continue;
				}
				PhyCardBean user = new PhyCardBean();
				// 循环Excel的列
				for (int c = 0; c < this.totalCells; c++) {
					Cell cell = row.getCell(c);
					if (null != cell) {
						if (c == 0) {
							//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
							if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
								String name = String.valueOf(cell.getNumericCellValue());
								System.out.println("体检卡号"+name);
								/*user.setPhyCardId(name.substring(0, name.length()-2>0?name.length()-2:1));//名称
*/							}else{
								/*user.setName(cell.getStringCellValue());//名称
*/							}
						} else if (c == 1) {
							if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
								String sex = String.valueOf(cell.getNumericCellValue());
								System.out.println("体检"+sex);
							/*	user.setSex(sex.substring(0, sex.length()-2>0?sex.length()-2:1));//性别
*/							}else{
								/*user.setSex(cell.getStringCellValue());//性别
*/							}
						} 
					}
				}
				// 添加到list
				userList.add(user);
			}
			return userList;
		}
		
		/**
		 * 验证EXCEL文件
		 * 
		 * @param filePath
		 * @return
		 */
		public boolean validateExcel(String filePath) {
			if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
				errorMsg = "文件名不是excel格式";
				return false;
			}
			return true;
		}
		
		// @描述：是否是2003的excel，返回true是2003 
	    public static boolean isExcel2003(String filePath)  {  
	         return filePath.matches("^.+\\.(?i)(xls)$");  
	     }  
	   
	    //@描述：是否是2007的excel，返回true是2007 
	    public static boolean isExcel2007(String filePath)  {  
	         return filePath.matches("^.+\\.(?i)(xlsx)$");  
	     }  


	

}
