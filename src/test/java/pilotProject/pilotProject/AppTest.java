package pilotProject.pilotProject;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
   /* public AppTest( String testName )
    {
        super( testName );
    }
*/
    /**
     * @return the suite of tests being tested
     */
   /* public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }*/

    /**
     * Rigourous Test :-)
     * @throws FilloException 
     */
    public void testApp() throws FilloException
    {
        //assertTrue( true );        
        String Parameter1 = "TC_ID", Value1 = "TC001";  
        String Parameter2 = "UserName", Value2 = "jayaramanbala86@gmail.com";
        FilloRead(Parameter1, Value1, Parameter2, Value2);     
    }
    
    public void FilloRead(String vParameter1, String vValue1, String vParameter2, String vValue2) throws FilloException{
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(".\\src\\test\\java\\data\\TestData.xlsx");
       // String strQuery="Select * from Sheet1 where TC_ID='TC001' and UserName='jayaramanbala86@gmail.com'";
        String strQuery="Select * from Sheet1 where " + vParameter1 + "=" + "'" + vValue1 +"'";
       // String strQuery="Select * from Sheet1 where " + vParameter1 + "=" + "'" + vValue1 + "' and " + vParameter2 + "=" + "'" + vValue2 + "'";
        System.out.println("This is the Query :    " + strQuery);
        
        Recordset recordset=connection.executeQuery(strQuery);
         
        while(recordset.next()){
	        System.out.println(recordset.getField("Description"));
	        System.out.println(recordset.getField("Password"));
        }
         
        recordset.close();
        connection.close();
    }
}
