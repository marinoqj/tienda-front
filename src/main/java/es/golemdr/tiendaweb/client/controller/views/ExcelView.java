package es.golemdr.tiendaweb.client.controller.views;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import es.golemdr.tiendaweb.client.ext.utils.export.InformeGenericoBean;


public class ExcelView extends AbstractXlsView{
	
	private static Logger logger = LogManager.getLogger(ExcelView.class);

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook wb, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
	
 
			
			Sheet sheet = null;
			
			// Creamos la hoja excel
			sheet = wb.createSheet();
			
			String[] cabeceras = (String[])model.get("cabeceras");
			
			List<InformeGenericoBean> datos = (List<InformeGenericoBean>) model.get("datos");
			
			pintaLista(cabeceras, datos , sheet);
			
			
		} catch (Exception ex) {
			logger.error("Se produjo la excepcion : " + ex.getMessage());			
			throw ex;
		}
    }

    @Override
    public void render(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {


	    String fileName = "resultado.xls";

	    response.setHeader("Content-type", "application/vnd.ms-excel");
	    response.setHeader("Content-Disposition", "attachment; filename=\""
		    + fileName + "\"");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");


	    super.render(model, request, response);
    }

    public static void pintaLista(String[] cabeceras, List<InformeGenericoBean> datos, Sheet sheet){
    	
    	   	
    	// Pintamos la cabecera
    	int fila = 0;
    	Row filaCabecera = sheet.createRow(fila);
    	Cell celda = null;
    	CellStyle estilo = sheet.getWorkbook().createCellStyle();   	
    	estilo.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
    	estilo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    	estilo.setAlignment(HSSFCellStyle.ALIGN_LEFT);      	
    	
    	
    	// Pintamos la cabecera
    	for(int i=0; i < cabeceras.length; i++){
    		celda = filaCabecera.createCell(i);
    		celda.setCellValue(cabeceras[i]);
    		celda.setCellStyle(estilo);    		   		
    	}
    	
    	
  	
    	// Pintamos el contenido
    	Row filaContenido = null;
    	
    	
    	CellStyle estilo2 = sheet.getWorkbook().createCellStyle();
    	estilo2.setAlignment(HSSFCellStyle.ALIGN_RIGHT); 
    	
    	int totalColumnas = cabeceras.length;
    	InformeGenericoBean informeActual = null;
    	
    	Iterator it1 = (Iterator)datos.iterator();
    	while(it1.hasNext()){
    	
    		informeActual = (InformeGenericoBean)it1.next();
    		

    		fila++;
    		filaContenido = sheet.createRow(fila);
    		
    		for (int i = 1; i <= totalColumnas; i++) {
    		
	        	if(i == 1){
	    			celda = filaContenido.createCell(i-1);
	    			celda.setCellValue(informeActual.getValor1());
	    			celda.setCellStyle(estilo2);
	        	}
	        	
	        	if(i == 2){
	    			celda = filaContenido.createCell(i-1);
	    			celda.setCellValue(informeActual.getValor2());
	    			celda.setCellStyle(estilo2);
	        	}
	        	
	        	
	        	if(i == 3){
	    			celda = filaContenido.createCell(i-1);
	    			celda.setCellValue(informeActual.getValor3());
	    			celda.setCellStyle(estilo2);
	        	}
	        	
	        	if(i == 4){
	    			celda = filaContenido.createCell(i-1);
	    			celda.setCellValue(informeActual.getValor4());
	    			celda.setCellStyle(estilo2);
	        	}
	        	
	        	if(i == 5){
	    			celda = filaContenido.createCell(i-1);
	    			celda.setCellValue(informeActual.getValor5());
	    			celda.setCellStyle(estilo2);
	        	}	        	
	        	
    		}
    		
    		
    	}
    	
    	// Ajustamos el tamaño a las cabeceras
    	for(int i = 0; i < cabeceras.length; i++){
    		
    		sheet.autoSizeColumn(i);
    		
    	}

    	
    }


}
