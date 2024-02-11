package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="data")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xlu = new XLUtility(path);
		
		int totalrows = xlu.getRowCount("sheet1");
		int totalcells=xlu.getCellCount("sheet1",1);
		
		String apidata[][]=new String [totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				apidata[i-1][j]=xlu.getCellData("sheet1",i,j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUsernames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xlu = new XLUtility(path);
		
		int totalrows = xlu.getRowCount("sheet1");
		
		String apidata[]= new String[totalrows];
		
		for (int i=1;i<=totalrows;i++)
		{
			apidata[i-1]=xlu.getCellData("sheet1", i,1);
		}
		return apidata;
	}
}
