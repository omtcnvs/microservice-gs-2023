package br.com.fiap.gs.assembler;

public interface AssemblerMapper<R, M> {
	R toResource(M model);
	M toModel(R resource);
}
