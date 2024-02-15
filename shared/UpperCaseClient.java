package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseClient extends Remote {
    
    /**
     * Method to be called by the server to send the uppercase result back to the client.
     * @param result The string to be converted to uppercase.
     * @throws RemoteException If there is an error during remote method call.
     */
    void upperCaseResult(String result) throws RemoteException;

}
