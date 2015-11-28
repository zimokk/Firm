/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.firmserver.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteValidatedCommand extends Remote {
    public<T> boolean execute(T... args) throws RemoteException;
    <T> boolean validate(T... args) throws RemoteException;
}
