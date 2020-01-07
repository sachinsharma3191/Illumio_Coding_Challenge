package com.example.demo;

public class Port {
	private int start;
	private int end;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Port() {
		super();
	}

	public Port(String port) {
		super();
		// TODO Auto-generated constructor stub
		this.init(port);
	}

	public void init(String port) {
		if (port.contains("-")) {
			String portString[] = port.split("-");

			this.start = Integer.parseInt(portString[0]);
			this.end = Integer.parseInt(portString[1]);
		} else {
			this.start = Integer.parseInt(port);
			this.end = Integer.parseInt(port);
		}
	}

	public boolean checkPortInRange(Port port) {
		return port.getStart() >= this.getStart() && port.getEnd() <= this.getEnd();
	}

}
