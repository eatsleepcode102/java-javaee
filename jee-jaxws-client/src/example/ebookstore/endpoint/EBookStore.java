/**
 * EBookStore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package example.ebookstore.endpoint;

public interface EBookStore extends java.rmi.Remote {
    public java.lang.String welcomeMessage(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] findEBooks(java.lang.String arg0) throws java.rmi.RemoteException;
    public example.ebookstore.endpoint.EBook takeBook(java.lang.String arg0) throws java.rmi.RemoteException;
    public void saveBook(example.ebookstore.endpoint.EBook arg0) throws java.rmi.RemoteException;
    public example.ebookstore.endpoint.EBook addAppendix(example.ebookstore.endpoint.EBook arg0, int arg1) throws java.rmi.RemoteException;
}
