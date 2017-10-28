package com.taiji.eap.common.easypoi.excel.utils;

import com.taiji.eap.biz.qyjcxx.bean.Jcdw;
import com.taiji.eap.biz.qyjcxx.bean.Jcyz;
import com.taiji.eap.biz.qyjcxx.bean.ZfjcJcqk;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import com.taiji.eap.common.utils.DateUtils;
import com.taiji.eap.common.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestUtil1 {

    public static List<String> columnNames = new ArrayList<>();

    public static List<ZfjcJcqk> importExcel(QyjcxxService qyjcxxService, String TBRID, String TBRNAME, String SHENG, String SHI, String XIAN, String PCID, String suffix, int dataRow, InputStream input) throws Exception{
        List<List<String>> lists = new ArrayList<>();
        List<ZfjcJcqk> zfjcJcqks = null;
        if(suffix.equals("xls")){
            lists = parseExcleXLS(dataRow, input);
        }else if(suffix.equals("xlsx")){
            lists = parseExcleXLSX(dataRow, input);
        }
        List<List<String>> tmp = null;
        List<List<List<String>>> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).get(0)!=null&&!StringUtils.isEmpty(lists.get(i).get(0))){
                tmp = new ArrayList<>();
                res.add(tmp);
                tmp.add(lists.get(i));
            }else{
                tmp.add(lists.get(i));
            }
        }

        String nowTime = DateUtils.getNowTimeStr();

        zfjcJcqks = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ZfjcJcqk zfjcJcqk = new ZfjcJcqk();
            zfjcJcqk.setSJID(UUIDUtils.getGUID());
            zfjcJcqk.setJCRQ(res.get(i).get(0).get(0));

            zfjcJcqk.setSHENG(SHENG);
            zfjcJcqk.setSHI(SHI);
            String XIANCode =  qyjcxxService.getCodeByName(res.get(i).get(0).get(3));
            if(res.get(i).get(0).get(3)!=null&&!StringUtils.isEmpty(res.get(i).get(0).get(3))) {
                if (XIANCode == null || StringUtils.isEmpty(XIANCode)) {
                    throw new Exception("错误：未找到" + res.get(i).get(0).get(3) + "对应的区划CODE\r\n位置：" + positionMessage(dataRow, i, 3, input, suffix));
                }
            }else {
                throw new Exception("错误：县（区）不能为空，请检查EXCEL\r\n位置：" + positionMessage(dataRow, i, 3, input, suffix));
            }
            zfjcJcqk.setSHENGNAME(qyjcxxService.getNameByCode(SHENG));
            zfjcJcqk.setSHINAME(qyjcxxService.getNameByCode(SHI));
            zfjcJcqk.setXIANNAME(res.get(i).get(0).get(3));

            zfjcJcqk.setXIAN(XIANCode);
            zfjcJcqk.setQYMC(res.get(i).get(0).get(4));
            zfjcJcqk.setTBSJ(nowTime);
            zfjcJcqk.setTBRID(TBRID);
            zfjcJcqk.setTBRNAME(TBRNAME);
            zfjcJcqk.setHYLX(res.get(i).get(0).get(5));
            zfjcJcqk.setFZSSSFZC(res.get(i).get(0).get(6));
            zfjcJcqk.setFZSSSWTMS(res.get(i).get(0).get(7));
            zfjcJcqk.setSFZJ(res.get(i).get(0).get(8));
            zfjcJcqk.setSFZJMS(res.get(i).get(0).get(9));
            zfjcJcqk.setSFPMDL(res.get(i).get(0).get(10));
            zfjcJcqk.setSFPMDLMS(res.get(i).get(0).get(11));
            zfjcJcqk.setPCID(PCID);
            List<Jcdw> jcdws = new ArrayList<>();
            ArrayList<Integer> row_arr = new ArrayList<>();
            for (int iter = 0; iter < res.get(i).size(); iter++) {
                List<String> tmp_content = res.get(i).get(iter);
                if (tmp_content.get(12)!=null&&!StringUtils.isEmpty(tmp_content.get(12))){
                    row_arr.add(iter);
                }
            }


            for (int j = 0; j < row_arr.size(); j++) {
                Jcdw jcdw = new Jcdw();
                jcdw.setSJID(UUIDUtils.getGUID());
                jcdw.setJCBID(zfjcJcqk.getSJID());
                jcdw.setJCDW(res.get(i).get(row_arr.get(j)).get(12));
                jcdw.setSFKZJC(res.get(i).get(row_arr.get(j)).get(13));
                jcdw.setSFKZJCMS(res.get(i).get(row_arr.get(j)).get(14));
                jcdw.setSFGF(res.get(i).get(row_arr.get(j)).get(15));
                jcdw.setSFGFMS(res.get(i).get(row_arr.get(j)).get(16));
                List<Jcyz> jcyzs = new ArrayList<>();

                int k_end = 0;
                if ((j+1) < row_arr.size()){
                    //-1是不取这一行,下面就是k<=k_end了
                    k_end = row_arr.get(j+1) -1;
                }else{
                    //此时是最后一行..就站到最后一行-1
                    k_end = res.get(i).size()-1;
                }
                for(int k = row_arr.get(j);k<=k_end;k++){

                    Jcyz jcyz = new Jcyz();
                    jcyz.setSJID(UUIDUtils.getGUID());
                    jcyz.setJCRQ(res.get(i).get(0).get(0));
                    jcyz.setQYID(zfjcJcqk.getSJID());

                    zfjcJcqk.setTBSJ(nowTime);
                    zfjcJcqk.setTBRID(TBRID);
                    zfjcJcqk.setTBRNAME(TBRNAME);

                    jcyz.setSHENGNAME(res.get(i).get(0).get(1));
                    jcyz.setSHINAME(res.get(i).get(0).get(2));
                    jcyz.setXIANNAME(res.get(i).get(0).get(3));
                    jcyz.setQYMC(res.get(i).get(0).get(4));
                    jcyz.setHYLX(res.get(i).get(0).get(5));
                    jcyz.setFZSSSFZC(res.get(i).get(0).get(6));
                    jcyz.setFZSSSWTMS(res.get(i).get(0).get(7));
                    jcyz.setSFZJ(res.get(i).get(0).get(8));
                    jcyz.setSFZJMS(res.get(i).get(0).get(9));
                    jcyz.setSFPMDL(res.get(i).get(0).get(10));
                    jcyz.setSFPMDLMS(res.get(i).get(0).get(11));
                    zfjcJcqk.setPCID(PCID);

                    jcyz.setJCDWID(jcdw.getSJID());
                    jcdw.setJCDW(res.get(i).get(row_arr.get(j)).get(12));
                    jcdw.setSFKZJC(res.get(i).get(row_arr.get(j)).get(13));
                    jcdw.setSFKZJCMS(res.get(i).get(row_arr.get(j)).get(14));
                    jcdw.setSFGF(res.get(i).get(row_arr.get(j)).get(15));
                    jcdw.setSFGFMS(res.get(i).get(row_arr.get(j)).get(16));

                    jcyz.setJCYZ(res.get(i).get(k).get(17));
                    jcyz.setHYL(res.get(i).get(k).get(21));
                    jcyz.setSGJCSJ_QS(res.get(i).get(k).get(18));
                    jcyz.setSGJCSJ_JS(res.get(i).get(k).get(19));
                    jcyz.setSGJCJG(res.get(i).get(k).get(20));
                    jcyz.setBZBH(res.get(i).get(k).get(23));
                    jcyz.setBZXZ(res.get(i).get(k).get(25));
                    jcyz.setBZXZ_SX(res.get(i).get(k).get(25));
                    jcyz.setSFCB(res.get(i).get(k).get(26));
                    jcyz.setSFAZZX(res.get(i).get(k).get(27));
                    jcyz.setSFAZZXBZ(res.get(i).get(k).get(28));
                    jcyz.setSFAZZXBZ(res.get(i).get(k).get(29));
                    jcyz.setSFLW(res.get(i).get(k).get(30));
                    jcyz.setSFLWBZ(res.get(i).get(k).get(31));
                    jcyz.setZXHYL(res.get(i).get(k).get(32));
                    jcyz.setZXJG_ZS(res.get(i).get(k).get(33));
                    jcyzs.add(jcyz);
                }
                jcdw.setJcyzs(jcyzs);
                jcdws.add(jcdw);
            }

//            ArrayList<Integer> row2_arr = new ArrayList<>();
//            for (int iter = 0; iter < res.get(i).size(); iter++) {
//                List<String> tmp_content = res.get(i).get(iter);
//                if (tmp_content.get(17)!=null&&!StringUtils.isEmpty(tmp_content.get(17))){
//                    row2_arr.add(iter);
//                }
//            }


            zfjcJcqk.setJcdws(jcdws);
            zfjcJcqks.add(zfjcJcqk);
        }
        return zfjcJcqks;
    }

    private static List<List<String>> parseExcleXLS(int dataRow, InputStream input) throws Exception{
        List<List<String>> lists = new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        HSSFSheet sheet = workbook.getSheetAt(0);

        HSSFRow titleRow = sheet.getRow(dataRow-1);
        columnNames.clear();
        for (int i = 0; i < titleRow.getPhysicalNumberOfCells(); i++) {
            columnNames.add(titleRow.getCell(i).getStringCellValue());
        }

        int rows =  sheet.getPhysicalNumberOfRows();
        for (int i = dataRow; i < rows; i++) {
            List<String> list = new ArrayList<>();
            HSSFRow row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cells; j++) {
                HSSFCell cell = row.getCell(j);
                String value = null;
                if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                {
                    value = String.valueOf(cell.getNumericCellValue());
                }
                else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                {
                    value = cell.getStringCellValue();
                }

                if(j==20||j==21||j==22||j==25||j==31||j==32||j==33){
                    try {
                        if(value!=null&&StringUtils.isEmpty(value)) {
                            Double.valueOf(value);
                        }
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("错误：值'"+value+"'为无效数字，请检查Excle\r\n位置："+positionMessage(dataRow,i,j,input,"xls"));
                    }
                }

                list.add(value);
            }
            lists.add(list);
        }
        return lists;
    }

    private static List<List<String>> parseExcleXLSX(int dataRow, InputStream input) throws Exception{
        List<List<String>> lists = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow titleRow = sheet.getRow(dataRow-1);
        columnNames.clear();
        for (int i = 0; i < titleRow.getPhysicalNumberOfCells(); i++) {
            columnNames.add(titleRow.getCell(i).getStringCellValue());
        }

        int rows =  sheet.getPhysicalNumberOfRows();
        for (int i = dataRow; i < rows; i++) {
            List<String> list = new ArrayList<>();
            XSSFRow row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cells; j++) {
                XSSFCell cell = row.getCell(j);
                String value = null;
                if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                {
                    value = String.valueOf(cell.getNumericCellValue());
                }
                else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                {
                    value = cell.getStringCellValue();
                }

                if(j==20||j==21||j==22||j==25||j==31||j==32||j==33){
                    try {
                        if(value!=null&&!StringUtils.isEmpty(value)) {
                            Double.valueOf(value);
                        }
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("错误：值'"+lists.get(i).get(3)+"'为无效数字，请检查Excel/r/n位置："+positionMessage(dataRow,i,j,input,"xlsx"));
                    }
                }

                list.add(value);
            }
            lists.add(list);
        }
        return lists;
    }

    public static String positionMessage(int dataRow,int row,int col, InputStream input,String suffix){
        String colName = columnNames.get(col);
        return "列名："+colName+"—行号："+(row+dataRow);
    }

}
