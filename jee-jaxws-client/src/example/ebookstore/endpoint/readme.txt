If you look at the above program, we are using the server code itself. However web services just expose WSDL and third party applications don’t have access to these classes. 
So in that case, we can use wsimport utility to generate the client stubs. This utility comes with standard installation of JDK. 
Below image shows what all java classes we get when we run this utility.

In Eclipse Kepler it is very easy to generate Web Service Client classes,You can achieve this by following steps .

RightClick on any Project->Create New Other ->Web Services->Web Service Client->Then paste the wsdl url(or location) in Service Definition->Next->Finish

You will see the generated classes are inside your src folder.

NOTE :Without eclipse also you can generate client classes from wsdl file by using wsimport command utility which ships with JDK.