package br.com.alura.jpa.modelo.util;

public class Util {
	/**
	 * <strong>M�todo:</strong> formataNumero
	 * <br><strong>Par�metros:</strong>
	 * <br><strong>- valor (Tipo: Object): </strong>Valor que deseja formatar.
	 * <br><strong>- valorParaFormatar (Tipo: String): </strong>Valor que deseja concatenar antes do par�metro valor.
	 * <br><strong>Tipo de retorno: </strong>String
	 * <br><strong>Tipos de acesso: </strong>public e static
	 */
	public static String formataNumero(Object valor, String valorParaFormatar) {
		
		return valorParaFormatar + valor;
		
	}
}
