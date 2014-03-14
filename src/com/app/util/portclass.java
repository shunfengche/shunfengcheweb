package com.app.util;

public final class portclass {
 private static  int  port=30000;

public static int getPort() {
	return ++port;
}

public static void setPort(int port) {
      portclass.port = port;
}
   
}
