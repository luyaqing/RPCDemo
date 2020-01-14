package com.company;

import RpcExporter.RpcExporter;
import RpcImporter.RpcImporter;
import Service.EchoService;
import Service.EchoServiceImpl;

import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {
	// write your code here

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8081);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8081));
        System.out.print(echo.echo("Are you ok ?"));

    }
}
