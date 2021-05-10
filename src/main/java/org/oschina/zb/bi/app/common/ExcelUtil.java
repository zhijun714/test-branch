package org.oschina.zb.bi.app.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.oschina.zb.bi.app.ErrorCode;
import org.oschina.zb.platform.core.exception.BusinessException;
import org.oschina.zb.platform.utils.logger.LoggerUtils;

public class ExcelUtil {
	
	private static final LoggerUtils logger = LoggerUtils.getLogger(ExcelUtil.class);
	
	public static void downloadExcelFile(String fileName, Map<String, String> header, List<Map<String, Object>> data,HttpServletResponse response) {
		List<Object[]> all = new ArrayList<>(data.size()+1);
		
		Object[] headerValues = new Object[header.size()];
		String[] headerKeys = new String[header.size()];
		Iterator<Entry<String, String>> hit = header.entrySet().iterator();
		int i=0;
		while (hit.hasNext()) {
			Entry<String, String> headerEntry = hit.next();
			headerValues[i] = headerEntry.getValue();
			headerKeys[i] = headerEntry.getKey();
			i++;
		}
		
		all.add(headerValues);
		
		data.forEach(d -> {
			Object[] dataValue = new Object[header.size()];
			for (int j=0; j<header.size(); j++) {
				dataValue[j] = d.get(headerKeys[j]);
			}
			all.add(dataValue);
		});
		
		downloadExcelFile(fileName, all, response);
	}
	
    /**
     * 导出Excel
     * 
     * @param data
     *            数据源
     * @param out
     *            文件流
     * @throws IOException
     */
    public static void exportExcel(List<Object[]> data, OutputStream out) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < data.size(); i++) {
            HSSFRow dataRow = sheet.createRow(i);
            if (data.get(i) == null) {
                continue;
            }
            for (int j = 0; j < data.get(i).length; j++) {
                HSSFCell newCell = dataRow.createCell(j);
                newCell.setCellValue(data.get(i)[j] == null ? "" : data.get(i)[j].toString());
            }
        }
        workbook.write(out);
    }
    
    
    //Web 导出excel
    public static void downloadExcelFile(String fileName,List<Object[]> data,HttpServletResponse response){
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ExcelUtil.exportExcel(data,os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"); 
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName+ ".xls").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
           
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        }catch (Exception e) {
            logger.error("[bi-app] - [导出excel失败] - " + e.getMessage(), e);
            throw new BusinessException(ErrorCode.ERROR, e.getMessage());
        }
    }

//    public static void main(String[] args) throws IOException {
//        int count = 1000;
//        List<Object[]> data = new ArrayList<>();
//        data.add(new String[] { "姓名", "年龄", "生日", "身高", "体重", "性别" });
//        for (int i = 0; i < count; i++) {
//            data.add(new String[] { "ljw", "22", "19920428", "180", "80", "男" });
//        }
//        OutputStream outXlsx = new FileOutputStream("C://Users//ljw//b.xls");
//        ExcelUtil.exportExcel(data, outXlsx);
//        outXlsx.close();
//    }
    
    
    
    public static void main(String[] args) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }
    }
    
    
   /* static HSSFWorkbook book = new HSSFWorkbook();
    public static void exportExcel(HSSFSheet sheet, LinkedHashMap<String, String> head, List<HashMap<String, Object>> body, OutputStream out) {
        // 处理表头
        HSSFRow headRow = sheet.createRow(0);//1为表头
        Iterator<String> headIterator = head.keySet().iterator();
        int i = 0;
        while (headIterator.hasNext()) {
            String title = headIterator.next();
            HSSFCell cell = headRow.createCell(i);
            cell.setCellValue(title);
            i++;
        }
        // 处理数据
        for (int j = 1; j <= body.size(); j++) {
            HSSFRow bodyRow = sheet.createRow(i);//1为表头
            HashMap<String, Object> rowData = body.get(j-1);
            while (headIterator.hasNext()) {
                HSSFCell cell = bodyRow.createCell(j);                
                cell.setCellValue(rowData.get(headIterator.next()).toString());
            }
        }
    }*/
}