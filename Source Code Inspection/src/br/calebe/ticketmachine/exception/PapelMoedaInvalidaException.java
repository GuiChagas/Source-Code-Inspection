package exception;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class PapelMoedaInvalidaException extends Exception {
    public int statusCode;
    public String message;
    
    public PapelMoedaInvalidaException(int _statusCode, String _message){
        statusCode = _statusCode;
        message = _message;
    }
}
