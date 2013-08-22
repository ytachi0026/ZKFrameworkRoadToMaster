package com.devytachi.grilla;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Row;
import org.zkoss.zul.event.PagingEvent;

import com.devytachi.zk.BaseWindow;

@SuppressWarnings("serial")
public class PaginacionGrilla extends BaseWindow{
	Grid grdTest;
	Paging pgTest;
	public void onCreate(){
		grdTest = (Grid) getFellow("grdTest");
		pgTest = (Paging) getFellow("pgTest");
		
		grdTest.setPaginal(pgTest);
		System.out.println("XXXXXXXXXX: "+Executions.getCurrent().getBrowser());
		System.out.println("XXXXXXXXXX: "+Executions.getCurrent().getContextPath());
		System.out.println("XXXXXXXXXX: "+Executions.getCurrent().getDesktop().getRequestPath());
		System.out.println("XXXXXXXXXX: "+Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + ":"+Executions.getCurrent().getServerPort()+ Executions.getCurrent().getContextPath() +  Executions.getCurrent().getDesktop().getRequestPath());
		
		pgTest.addEventListener("onPaging", new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				int pgno = ((PagingEvent)event).getActivePage();
				System.out.println("PAGINA: " + pgno);
				System.out.println("PAGE SIZE: " + pgTest.getPageSize());
				Row row = (Row)grdTest.getRows().getChildren().get(pgno);
				
				Label label = (Label)row.getChildren().get(0);
				System.out.println("PPP>: "+label.getValue()); 
				
				
			}
		});
//		Clients.evalJavaScript("window.open('/hola/test.zul','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");

	}
}
