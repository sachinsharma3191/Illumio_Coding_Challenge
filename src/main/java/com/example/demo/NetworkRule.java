package com.example.demo;

public class NetworkRule {
	private String direction;
	private String protocol;
	private Port port;
	private IPAddress ip;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public IPAddress getIp() {
		return ip;
	}

	public void setIp(IPAddress ip) {
		this.ip = ip;
	}

	public NetworkRule(String direction, String protocol, String port, String ipAddress) {
		super();
		this.direction = direction;
		this.protocol = protocol;
		this.port = new Port(port);
		this.ip = new IPAddress(ipAddress);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		NetworkRule inputRule = (NetworkRule) obj;

		return (inputRule.getDirection().equals(this.getDirection())
				&& inputRule.getProtocol().equals(this.getProtocol())
				&& inputRule.getPort().checkPortInRange(this.getPort())
				&& inputRule.getIp().checkIPInRange(this.getIp()));
	}
}
