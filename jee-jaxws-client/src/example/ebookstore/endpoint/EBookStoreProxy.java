package example.ebookstore.endpoint;

public class EBookStoreProxy implements example.ebookstore.endpoint.EBookStore {
  private String _endpoint = null;
  private example.ebookstore.endpoint.EBookStore eBookStore = null;
  
  public EBookStoreProxy() {
    _initEBookStoreProxy();
  }
  
  public EBookStoreProxy(String endpoint) {
    _endpoint = endpoint;
    _initEBookStoreProxy();
  }
  
  private void _initEBookStoreProxy() {
    try {
      eBookStore = (new example.ebookstore.endpoint.EBookStoreImplServiceLocator()).getEBookStoreImplPort();
      if (eBookStore != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eBookStore)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eBookStore)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eBookStore != null)
      ((javax.xml.rpc.Stub)eBookStore)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public example.ebookstore.endpoint.EBookStore getEBookStore() {
    if (eBookStore == null)
      _initEBookStoreProxy();
    return eBookStore;
  }
  
  public java.lang.String welcomeMessage(java.lang.String arg0) throws java.rmi.RemoteException{
    if (eBookStore == null)
      _initEBookStoreProxy();
    return eBookStore.welcomeMessage(arg0);
  }
  
  public java.lang.String[] findEBooks(java.lang.String arg0) throws java.rmi.RemoteException{
    if (eBookStore == null)
      _initEBookStoreProxy();
    return eBookStore.findEBooks(arg0);
  }
  
  public example.ebookstore.endpoint.EBook takeBook(java.lang.String arg0) throws java.rmi.RemoteException{
    if (eBookStore == null)
      _initEBookStoreProxy();
    return eBookStore.takeBook(arg0);
  }
  
  public void saveBook(example.ebookstore.endpoint.EBook arg0) throws java.rmi.RemoteException{
    if (eBookStore == null)
      _initEBookStoreProxy();
    eBookStore.saveBook(arg0);
  }
  
  public example.ebookstore.endpoint.EBook addAppendix(example.ebookstore.endpoint.EBook arg0, int arg1) throws java.rmi.RemoteException{
    if (eBookStore == null)
      _initEBookStoreProxy();
    return eBookStore.addAppendix(arg0, arg1);
  }
  
  
}