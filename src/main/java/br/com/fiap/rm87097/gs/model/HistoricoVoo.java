package br.com.fiap.rm87097.gs.model;

import java.util.ArrayList;
import java.util.List;

public class HistoricoVoo {

	public List<DadosVoo> dados = new ArrayList<>();
	
	public void add(DadosVoo model) {
		dados.add(model);
	}
	
}
