package pilotProject.pilotProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelDataReader {
	
	public static void readExcelData(String vParameter1, String vValue1, String vParameter2, String vValue2) throws FilloException{
		
		Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(".\\src\\test\\java\\data\\TestData.xlsx");
        // String strQuery="Select * from Sheet1 where TC_ID='TC001' and UserName='jayaramanbala86@gmail.com'";
  
        String strQuery="Select * from Sheet1 where " + vParameter1 + "=" + "'" + vValue1 + "' and " + vParameter2 + "=" + "'" + vValue2 + "'";
        System.out.println("This is the Query :    " + strQuery);

        Recordset recordset=connection.executeQuery(strQuery);
        while(recordset.next()){

          System.out.println(recordset.getField("Description"));
          System.out.println(recordset.getField("Password"));
        }

        recordset.close();
        connection.close();
	}
	
     public static String getDatafromExcel(Map<String, String> test,String colName) throws FilloException{
		
		Fillo fillo=new Fillo();
		String outputdata = null;
        Connection connection=fillo.getConnection(".\\src\\test\\resources\\testdata\\TestData.xlsx");
        
        String queryToExecute="Select * from Sheet1 where ";
        for(Entry<String, String> a: test.entrySet()) {
        	if(queryToExecute.trim().endsWith("where")) {
        		queryToExecute+=a.getKey()+"="+"'"+a.getValue()+"'";
        	}else {
        		queryToExecute+=" and "+a.getKey()+"="+"'"+a.getValue()+"'";
        	}
        }
        //String strQuery="Select * from Sheet1 where " + vParameter1 + "=" + "'" + vValue1 + "' and " + vParameter2 + "=" + "'" + vValue2 + "'";
        System.out.println("This is the Query :    " + queryToExecute);

        Recordset recordset=connection.executeQuery(queryToExecute);
       
        //recordset.get
        while(recordset.next()){

          outputdata=recordset.getField(colName);
          //System.out.println(recordset.getField("Password"));
        }

        recordset.close();
        connection.close();
        
        return outputdata;
	}

}
