package base.service;

import base.Jogada;
import base.Mesa;

public interface ProcessadorService{

	boolean processar(Jogada jog, Mesa mesa);
}
