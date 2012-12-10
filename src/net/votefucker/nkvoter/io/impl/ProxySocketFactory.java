/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.votefucker.nkvoter.io.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import net.votefucker.nkvoter.io.HttpProxySocket;
import net.votefucker.nkvoter.io.SocketFactory;
import net.votefucker.nkvoter.util.RequestBuilder;

/**
 *
 * @author bla
 */
public class ProxySocketFactory  extends SocketFactory{
    	private InetSocketAddress proxyAddress;
        private boolean httpProxy;

    public ProxySocketFactory(InetSocketAddress proxyAddress)
    {
	this.proxyAddress = proxyAddress;
        httpProxy = false;
    }

    @Override
    public Socket createSocket(InetSocketAddress address) throws IOException {
        Proxy proxy;
        Socket socket;
        
        if(!httpProxy){
            try{
                proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
                socket = new Socket(proxy);
                socket.setSoTimeout(15000);

                socket.connect(address);
                return socket;
            } catch(SocketException se)
            {
                try{
                    System.setProperty("http.proxyHost", proxyAddress.getHostName());
                    System.setProperty("http.proxyPort", Integer.toString(proxyAddress.getPort()));
                    socket = httpConnect(address);
                    httpProxy = true;
                    return socket;
                } catch(IOException e)
                {
                    socket = new Socket();
                    socket.setSoTimeout(15000);
                    socket.connect(new InetSocketAddress(proxyAddress.getHostName(), proxyAddress.getPort()));
                    RequestBuilder builder = new RequestBuilder("CONNECT", address.getHostName(), address);
                    socket.getOutputStream().write(builder.build().getBytes());
                    socket.getOutputStream().flush();
        
        /* Read the response sent from the server */
        Scanner scanner = new Scanner(socket.getInputStream());
        String response = "";
        while(scanner.hasNextLine()) {
            response += scanner.nextLine() + "\n";
        }
        
        /* Check if the response was a success */
        if(!response.contains("Connection established")) {
            throw new IOException();
        }
        
        return socket;
                }
            }
        }
        
        System.out.println("The whole thing's fucked.");
        return new Socket();
    }
    
    private Socket httpConnect(InetSocketAddress address) throws IOException
    {
        HttpProxySocket hSock =  new HttpProxySocket(new Proxy(Proxy.Type.HTTP, proxyAddress));
        
        hSock.connect(address, 15000);
        
        return hSock;
    }
}
