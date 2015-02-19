package org.blazerobotics.orion.commands;

import edu.wpi.first.wpilibj.command.Command;

public class WaitCommand extends Command {
	public WaitCommand(double time) {
		setTimeout(time);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
