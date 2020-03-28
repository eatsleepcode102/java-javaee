package example.ebookstore.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import example.ebookstore.endpoint.EBookStore;
import example.ebookstore.endpoint.EBookStoreImplServiceLocator;

public class EbookStoreClient {

	public static void main(String[] args) throws ServiceException, RemoteException {
		EBookStoreImplServiceLocator implService=new EBookStoreImplServiceLocator();
		EBookStore eBookStore=implService.getEBookStoreImplPort();
		System.out.println(eBookStore.welcomeMessage("Andrew"));
	}

}
