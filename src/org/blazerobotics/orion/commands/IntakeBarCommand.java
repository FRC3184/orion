package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBarCommand extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.intakeBarSubsystem.setSpeed(Robot.oi.joystickSpecial.getY());

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
