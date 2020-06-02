package es.golemdr.tiendaweb.client.controller.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import es.golemdr.tiendaweb.client.ext.utils.export.InformeGenericoBean;



public class PDFView extends AbstractPdfView{
	 
		@Override
		protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
			// Recupero los elementos necesarios del model
			String titulo = (String)model.get("titulo");
			
			float[] anchos = (float[])model.get("anchos");
			
			Integer columnasI = (Integer)model.get("columnasI");
			int columnas = columnasI.intValue();
			
			String[] cabeceras = (String[])model.get("cabeceras");
			
	        
			
			document.add(new Paragraph(titulo));
	         
	        PdfPTable table = new PdfPTable(columnas);
	        table.setWidthPercentage(100.0f);
	        table.setWidths(anchos);
	        table.setSpacingBefore(10);
	        
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.gray);
	        
	        for(int i=0; i < cabeceras.length; i++){
	        	
		        cell.setPhrase(new Phrase(cabeceras[i]));
		        table.addCell(cell);
	        	
	        	
	        }
	        
        
	        List<InformeGenericoBean> datos = (List<InformeGenericoBean>) model.get("datos");
	        
	        for (InformeGenericoBean unInforme: datos) {
	            
	        	if(columnas >= 1){
	        		table.addCell(unInforme.getValor1());
	        	}
	        	
	        	if(columnas >= 2){
	        		table.addCell(unInforme.getValor2());
	        	}
	        	
	        	if(columnas >= 3){
	        		table.addCell(unInforme.getValor3());
	        	}
	        	
	        	if(columnas >= 4){
	        		table.addCell(unInforme.getValor4());
	        	}
	        	
	        	if(columnas >= 5){
	        		table.addCell(unInforme.getValor5());
	        	}
	            
	        }
	         
	        document.add(table);
	        
	        
			
		}		

}
