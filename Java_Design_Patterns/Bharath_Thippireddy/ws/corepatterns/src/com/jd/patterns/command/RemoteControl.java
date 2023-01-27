package com.jd.patterns.command;

public class RemoteControl {

	private Command command;
	
	
	public void pressButton()
	{
		command.execute();
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

}
