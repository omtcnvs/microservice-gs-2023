package br.com.fiap.rm87097.gs.assembler;

public interface AssemblerMapper<R, M> {
	R toResource(M model);
	M toModel(R resource);
}
