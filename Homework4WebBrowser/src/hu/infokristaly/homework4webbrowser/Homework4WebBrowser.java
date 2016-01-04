package hu.infokristaly.homework4webbrowser;

import java.security.Security;

/*
 * http://www.onjava.com/pub/a/onjava/2001/05/03/java_security.html?page=5
 */
public class Homework4WebBrowser extends Browser {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			args = new String[]{"https://community.oracle.com/thread/1536075"};
		}
		Homework4WebBrowser browser = new Homework4WebBrowser(args[0]);
		browser.run();
	}

	// Construct a SecureBrowser
	public Homework4WebBrowser(String urlString) {
		super(urlString);
		// Register JSSE
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		Security.setProperty( "ssl.SocketFactory.provider", DummySSLSocketFactory.class.getName()); 
		// Here's the trick!
		// Simply set the protocol handler property to use SSL.
		System.setProperty("java.protocol.handler.pkgs",
				"com.sun.net.ssl.internal.www.protocol");
	}
}
