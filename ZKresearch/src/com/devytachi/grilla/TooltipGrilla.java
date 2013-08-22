package com.devytachi.grilla;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Row;
import org.zkoss.zul.Window;

import com.devytachi.zk.BaseWindow;

@SuppressWarnings("serial")
public class TooltipGrilla extends BaseWindow{
	Grid grdGrillaPaginacion;
	Paging pgTest;
	Popup popi;
	Window estaVentanaFea;
	public void onCreate(){
		grdGrillaPaginacion = (Grid) getFellow("grdGrillaPaginacion");
		popi = (Popup) getFellow("popi");
		estaVentanaFea = this;
		
		List<FakeData> datas = new ArrayList<FakeData>();
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		datas.add(new FakeData());
		
		Row row; 
		for(FakeData data : datas){
			row = new Row();
			final Popup popo = new Popup();
			popo.setWidth("100px");
			popo.appendChild(new Label(data.nickname));
			estaVentanaFea.appendChild(popo);
			Label nombre = new Label(data.nombre);
			nombre.setTooltip(popo);
			row.appendChild(nombre);
			
			
			final Image image = new Image("img/delete.png");
			image.setTooltip(popo);
			row.appendChild(image);
			
			grdGrillaPaginacion.getRows().appendChild(row);
		}
	}
}

class FakeData {
	String nombre;
	String apellido;
	String nickname;
	
	public FakeData() {
		nombre = "Ytalo";
		apellido = "Borja";
		nickname = "lindo pokemon";
	}
	
}