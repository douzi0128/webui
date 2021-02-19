package com.ym.webui.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {


    /**
     * 加载用例文件封装进入list
     *
     * @param pathName
     * @param sheetName
     * @param clazz
     * @param <T>
     */
    public static <T> List<T> load(String pathName, String sheetName, Class<T> clazz) {
        Log4jUtil.logger.info("开始加载用例文件:["+pathName+"],工作表名:["+sheetName+"],要封装的类:["+clazz+"]");
        List<T> list = new ArrayList<T>();
        try {
            //Class<Case> clazz = Case.class ;
            Sheet sheet = WorkbookFactory.create(new File(pathName)).getSheet(sheetName);
            Row row = sheet.getRow(0);
            int lastNum = row.getLastCellNum();
            //System.out.println(lastNum);
            String[] titleName = new String[lastNum];
            //获取第一行每一个titlename.放入titleName数组中
            for (int i = 0; i < lastNum; i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String cellValue = cell.getStringCellValue();
                //System.out.println("==--==--"+cellValue);
                cellValue = cellValue.substring(0,cellValue.indexOf("("));
                //System.out.println(cellValue);
                titleName[i] = cellValue;
            }
            //获取第二行开始的所有数据封装进入caseList

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row caseRow = sheet.getRow(i);

                T obj = clazz.newInstance();
                //通过反射每一列的数据封装到obj上
//                System.out.println(sheet.getLastRowNum());

//                System.out.println(caseRow.getLastCellNum());
                for (int j = 0; j < caseRow.getLastCellNum(); j++) {
                    Cell caseCell = caseRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    caseCell.setCellType(CellType.STRING);
                    String caseValue = caseCell.getStringCellValue();
                    Method method = clazz.getMethod("set" + titleName[j], String.class);
                    method.invoke(obj, caseValue);
                }
                list.add(obj);
            }
            return list;

        } catch (Exception e) {
            Log4jUtil.logger.error("用例文件加载失败");
            e.printStackTrace();
        }
        return list;
    }



}



