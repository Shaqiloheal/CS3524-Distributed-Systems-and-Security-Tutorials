package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import shared.UpperCaseClient;
import shared.UpperCaseServer;
import shared.UpperCaseServer;

public class RMIClient implements UpperCaseClient {

    private UpperCaseServer server; // this is my stub

    public RMIClient() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    // public RMIClient() throws RemoteException, NotBoundException{
    //     // to make connect to the server
    //     // getRegistry returns a reference or a stub to 
    //     // the remote object registry
    //     // host - host for the remote registry
    //     // port - port on which the registry accepts requests
    //     Registry registry = LocateRegistry.getRegistry("localhost",1099);

    //     // name - the name for the remote reference to look up
    //     // returns a reference to a remote object
    //     // Registry returns a Remote object (UpperCaseServer extends
    //     // from Remote)
    //     server = (UpperCaseServer) registry.lookup("Server");
    // }

    public void startClient() throws RemoteException, NotBoundException {
        // to make connect to the server
        // getRegistry returns a reference or a stub to 
        // the remote object registry
        // host - host for the remote registry
        // port - port on which the registry accepts requests
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        // name - the name for the remote reference to look up
        // returns a reference to a remote object
        // Registry returns a Remote object (UpperCaseServer extends
        // from Remote)
        server = (UpperCaseServer) registry.lookup("Server");

    }

    // the method to print uppercase
    public void toUpperCase(String argument) throws RemoteException {
        
        // After the client connects to the server, we can call
        // the remote method.
        server.toUpperCase(argument, this);
    }
    
    public void upperCaseResult(String result) throws RemoteException {
        System.out.println("Result > " + result);
    }
}
