package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote {
    /**
     * Method to convert a given string to uppercase.
     * @param lowercase The string to be converted to uppercase.
     * @param client The `UpperCaseClient` instance to which the uppercase 
     *               version of the input string will be returned.
     * @throws RemoteException If there is an error during the remote 
     *                         method invocation or callback process.
     */
    void toUpperCase(String lowercase, UpperCaseClient client) throws RemoteException;

}