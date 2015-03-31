package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabCommand extends Command {
	
	int tick = 0;
	
	public GrabCommand() {
		requires(Robot.grabSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		tick++;
		if (tick >= 10 && Robot.oi.joystickSpecial.getRawButton(2)) {
			Robot.grabSubsystem.setGrab(!Robot.grabSubsystem.getGrab());
			tick = 0;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
