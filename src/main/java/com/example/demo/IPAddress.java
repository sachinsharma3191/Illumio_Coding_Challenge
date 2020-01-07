package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPAddress {
	private List<Integer> startAddress;
	private List<Integer> endAddress;

	public List<Integer> getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(List<Integer> startAddress) {
		this.startAddress = startAddress;
	}

	public List<Integer> getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(List<Integer> endAddress) {
		this.endAddress = endAddress;
	}

	public IPAddress() {
		super();
	}

	public IPAddress(String ipString) {
		super();
		this.initIPAddress(ipString);
	}

	public void initIPAddress(String ipString) {
		if (ipString.contains(ApplicationConstants.HYPHEN)) {
			String[] ipRange = ipString.split(ApplicationConstants.HYPHEN);
			this.startAddress = Arrays.stream(ipRange[0].split("\\.")).map(e -> Integer.parseInt(e))
					.collect(Collectors.toList());

			this.endAddress = Arrays.stream(ipRange[1].split("\\.")).map(e -> Integer.parseInt(e))
					.collect(Collectors.toList());
		} else {
			this.startAddress = this.endAddress = Arrays.stream(ipString.split("\\.")).map(e -> Integer.parseInt(e))
					.collect(Collectors.toList());
		}
	}

	public boolean checkIPInRange(IPAddress ip) {
		for (int index = 0; index < 4; index++) {
			if (ip.getStartAddress().get(index) < this.startAddress.get(index)
					|| ip.getEndAddress().get(index) > ip.getEndAddress().get(index)) {
				return false;
			}
		}
		return true;
	}

}
