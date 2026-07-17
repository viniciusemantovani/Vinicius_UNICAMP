package base.controle;

import base.Jogada;
import base.Mesa;
import base.service.ProcessadorService;

public class ProcessadorControle{
	
	ProcessadorService processadorService;
	
	ProcessadorControle(ProcessadorService processadorService){
		this.processadorService = processadorService;
	}
	
	ProcessadorControle(){
		
	}
	
	public boolean processar(Jogada jog, Mesa mesa) {
		
		return processadorService.processar(jog, mesa);
		
	}
	
}
