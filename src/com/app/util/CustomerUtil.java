package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

	/* Generate PieChart3D*/
	public void generatePieChart(String path,List<Object[]> list){
		//1.convert List to Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		/*2.using chartFactory convert JFreeChart object*/
		JFreeChart chart=ChartFactory.createPieChart3D("Customer Report", dataset, true, true, false);

		//3.Use chartUtils ,convert JFreeChart object to Image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/CustPieA.jpg"), chart,400, 400);
		} catch (IOException e) {
			System.out.println(e);
		}
	}


	public void generateBarChart(String path,List<Object[]> list){
		//1.Create Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		//2.Convert dataset to JFreeChart
		JFreeChart chart=ChartFactory.createBarChart3D("Customer Report", "Customer Type", "COUNT", dataset);

		//3.ChartUtils used to JFreeChart->Image 
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/CustBarB.jpg"), chart, 400, 400);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}


