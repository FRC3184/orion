package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CanArmCommand extends Command {
	double lastSpeed;

	public CanArmCommand() {
		requires(Robot.canArmSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		double direction = 0;
    	double scale = 0.6;
    	if (Robot.oi.winchDown() && Robot.canArmSubsystem.topLimit()) { // TODO limit switches
    		direction = -1;
    	}
    	if (Robot.oi.winchUp()) {
    		direction = 1;
    	}
    	if (Robot.oi.winchHighPower()) {
    		scale = 1;
    	}
    	Robot.canArmSubsystem.set(direction * scale, !Robot.oi.leftControl(), !Robot.oi.rightControl());
    	lastSpeed = direction * scale;

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
