package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CanArmTimedCommand extends Command {
	
	private double pow;
	private boolean topLimit;
	int clicks = 0;

	public CanArmTimedCommand(double seconds, double pow, boolean topLimit) {
		if (!topLimit) this.setTimeout(seconds);
		requires(Robot.canArmSubsystem);
		this.pow = pow;
		this.topLimit = topLimit;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (pow < 0) {
			if (Robot.canArmSubsystem.topLimit() && clicks > 25) {
				Robot.canArmSubsystem.set(pow);
				clicks = 0;
			}
			clicks++;
		}
		else {
			Robot.canArmSubsystem.set(pow);
		}
			

	}

	@Override
	protected boolean isFinished() {
		return isTimedOut() || (topLimit && !Robot.canArmSubsystem.topLimit());
	}

	@Override
	protected void end() {
		Robot.canArmSubsystem.set(0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
