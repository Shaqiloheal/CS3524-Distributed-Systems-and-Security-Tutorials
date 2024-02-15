package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.UpperCaseClient;
import shared.UpperCaseServer;

// This class implements the server interface
public class ServerImpl implements UpperCaseServer {
    
    // Using the constructor,
    // the server must export objects to be remotely available.
    // Implement the code here:
    public ServerImpl() throws RemoteException {
        // to export this remote object to make it available
        // to receive incoming calls, 
        // using the particular supplied port.
        // port: the port to export the object on
        UnicastRemoteObject.exportObject(this, 0);
    }

    // The method defined in the interface must be implmented.
    @Override
    public void toUpperCase(String lowercaseStr, UpperCaseClient client) throws RemoteException {
        
        String result = lowercaseStr.toUpperCase(); 

        try {
            System.out.println("Computing " + lowercaseStr + "...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("Interrupted.");
            return;
        }

        try {
            client.upperCaseResult(result);
        } catch (RemoteException e) {
            //e.printStackTrace();
            System.out.println("Client disconnected.");
        }

    }
    
}
