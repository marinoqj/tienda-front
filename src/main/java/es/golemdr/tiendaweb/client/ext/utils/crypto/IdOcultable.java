package es.golemdr.tiendaweb.client.ext.utils.crypto;

public interface IdOcultable {
	
	public String idEncriptado = null;
	
	public abstract String getIdEncriptado();
	
	public abstract void setIdEncriptado(String idEncriptado);
	
	public abstract Long getId();

}
