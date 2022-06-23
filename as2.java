import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Match_Mismatch {
	public static void main(String [] args) throws IOException
	{

	//b) Develop a utility for finding matches vs mismatches across two data sources (Reconciliation).

	String file_path1="C:\\Users\\SGEDDAM\\eclipse-workspace\\Assgnmnt\\emp1.xlsx";

	String file_path2="C:\\Users\\SGEDDAM\\eclipse-workspace\\Assgnmnt\\emp2.xlsx";


	Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();
	Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();

	FileInputStream ip1= new FileInputStream(file_path1);

	XSSFWorkbook wb1 = new XSSFWorkbook(ip1);

	XSSFSheet sheet1=wb1.getSheet("Sheet1");

	int rowCount_1= sheet1.getPhysicalNumberOfRows();
	int colCount_1= sheet1.getRow(0).getPhysicalNumberOfCells();
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<Integer> list11 = new ArrayList<Integer>();
	for(int i=1;i<rowCount_1;i++)
	{
	for(int j=1;j<colCount_1;j++)
	{
	if(j==1)
	{
	list1.add(sheet1.getRow(i).getCell(j).getStringCellValue());
	}
	else if(j==2)
	{
	list11.add((int)sheet1.getRow(i).getCell(j).getNumericCellValue());
	}
	}

	}
	//System.out.println(list1);
	//System.out.println(list11);


	for(int str=0;str<list1.size();str++)
	{

	map1.put(list1.get(str),list11.get(str));

	}

	//System.out.println(map1);


	wb1.close();

	FileInputStream ip2= new FileInputStream(file_path2);

	XSSFWorkbook wb2 = new XSSFWorkbook(ip2);

	XSSFSheet sheet2=wb2.getSheet("Sheet1");

	int rowCount_2= sheet2.getPhysicalNumberOfRows();
	int colCount_2= sheet2.getRow(0).getPhysicalNumberOfCells();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<Integer> list22 = new ArrayList<Integer>();
	for(int i=1;i<rowCount_2;i++)
	{
	for(int j=1;j<colCount_2;j++)
	{
	if(j==1)
	{
	list2.add(sheet2.getRow(i).getCell(j).getStringCellValue());
	}
	else if(j==2)
	{
	list22.add((int)sheet2.getRow(i).getCell(j).getNumericCellValue());
	}
	}

	}
	//System.out.println(list2);
	//System.out.println(list22);


	for(int str=0;str<list2.size();str++)
	{

	map2.put(list2.get(str),list22.get(str));

	}

	//System.out.println(map2);

	wb2.close();



	Set<String> set=map1.keySet();
	System.out.println(set);

	Set<String> set2 = map2.keySet();
	System.out.println(set2);


	ArrayList<String> names1 =new ArrayList<String>(set);
	ArrayList<String> names2 =new ArrayList<String>(set2);
	if(names1.size()==names2.size())
	{
	for(int i=0;i<names1.size();i++)
	{
	if(names1.get(i).equalsIgnoreCase(names2.get(i)))
	{
	System.out.println(names1.get(i)+" equals "+names2.get(i));
	}
	else
	{
	System.out.println(names1.get(i)+" not equals "+names2.get(i));
	}
	}
	}

	for(int i=0;i<list11.size();i++)
	{
	int j=list11.get(i)-list22.get(i);
	System.out.println("sal of first excel : "+list11.get(i)+" Sal of second excel : "+list22.get(i)+" Diff of sal : "+j);
	}

	}

	}

