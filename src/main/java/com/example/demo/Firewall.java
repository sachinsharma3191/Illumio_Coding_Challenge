package com.example.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Firewall implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Set<NetworkRule> networkRules;

	public Firewall() {
		super();
	}

	// Throws IOException If File is not found or File filepath is wrong
	public Firewall(String csvFilepath) throws IOException {
		networkRules = new HashSet<>();
		this.readFile(csvFilepath);
	}

	private void readFile(String csvPath) throws IOException {
		File csvFile = new File(csvPath);
		System.out.println("Creating Firewall Rules");
		// from where to read within the file
		try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(csvFile.toPath(),
				EnumSet.of(StandardOpenOption.READ))) {

			MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
			byte[] buffer = new byte[(int) fileChannel.size()];
			mappedByteBuffer.get(buffer);

			BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)));

			for (String line = in.readLine(); line != null; line = in.readLine()) {
				if (line.length() != 0) {
					String attr[] = line.split(",");
					networkRules.add(new NetworkRule(attr[0], attr[1], attr[2], attr[3]));
				}
			}

		}

		/*
		 * List<String> fileLinesList = FileUtils.readLines(csvFile, "UTF-8");
		 * 
		 * for (String line : fileLinesList) { if (line.length() != 0) { String attr[] =
		 * line.toString().split(","); networkRules.add(new NetworkRule(attr[0],
		 * attr[1], attr[2], attr[3])); } }
		 */
		System.out.println("Rules Creation completed");

	}

	public boolean acceptPacket(String direction, String protocol, int port, String ipAddress) {
		NetworkRule rule = new NetworkRule(direction, protocol, String.valueOf(port), ipAddress);
		for (NetworkRule networkRule : networkRules) {
			if (rule.equals(networkRule)) {
				return true;
			}
		}
		return false;
	}
}
