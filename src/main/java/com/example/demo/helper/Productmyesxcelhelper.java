package com.example.demo.helper;
import com.example.demo.entity.product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Productmyesxcelhelper {

  //check file is part of excel or not
  public static boolean checkExcelFormat(MultipartFile file)
  {
    String contenttype= file.getContentType();
    if(contenttype.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  // convert excel to list of product

  public static List<product> convertExcelToListOfProduct(InputStream is)
  {
    List<product> list=new ArrayList<>();
    try{
      XSSFWorkbook workbook= new XSSFWorkbook(is);
      XSSFSheet sheet = workbook.getSheet("data");

      int rownum=0;
      Iterator<Row> iterator = sheet.iterator();



      while(iterator.hasNext())
      {
        Row row = iterator.next();
        if(rownum==0)
        {
          rownum+=1;
          continue;
        }
        Iterator<Cell> cell = row.iterator();
        int cid=0;
      product p=new product();
        while(cell.hasNext())
        {
          Cell cell1 = cell.next();

          switch(cid)
          {
            case 0:
              p.setId((int)cell1.getNumericCellValue());
              break;
            case 1:
              p.setName(cell1.getStringCellValue());
              break;
            case 2:
              p.setDesc(cell1.getStringCellValue());
              break;
            case 3:
              p.setPrice((int)cell1.getNumericCellValue());
              break;
              default:
                break;
          }
          cid++;

        }
        list.add(p);



      }
    }
    catch(Exception e){

  }

    return list;
  }
}
