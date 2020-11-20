package br.com.alura.jpa.modelo.util;

public class Util {
	/**
	 * <strong>Método:</strong> formataNumero
	 * <br><strong>Parâmetros:</strong>
	 * <br><strong>- valor (Tipo: Object): </strong>Valor que deseja formatar.
	 * <br><strong>- valorParaFormatar (Tipo: String): </strong>Valor que deseja concatenar antes do parâmetro valor.
	 * <br><strong>Tipo de retorno: </strong>String
	 * <br><strong>Tipos de acesso: </strong>public e static
	 */
	public static String formataNumero(Object valor, String valorParaFormatar) {
		
		return valorParaFormatar + valor;
		
	}
}
