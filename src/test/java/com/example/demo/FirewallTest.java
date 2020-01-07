package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FirewallTest {

	@Test
	void testAcceptPacket() throws IOException {
		String filePath = "src/main/resources/firewall.csv";
		Firewall firewall = new Firewall(filePath);
		long start = System.currentTimeMillis();
		assertEquals(true, firewall.acceptPacket("inbound", "udp", 53, "192.168.2.1"));
		assertEquals(true, firewall.acceptPacket("outbound", "tcp", 10234, "192.168.10.11"));
		assertEquals(false, firewall.acceptPacket("inbound", "tcp", 81, "192.168.1.2"));
		assertEquals(false, firewall.acceptPacket("inbound", "udp", 24, "52.12.48.92"));
		
		System.out.print("Total Execution time is:" + (System.currentTimeMillis() - start));
	}

}
