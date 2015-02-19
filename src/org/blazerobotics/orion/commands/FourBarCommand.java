package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;
import org.blazerobotics.orion.util.MathUtil;

import edu.wpi.first.wpilibj.command.Command;

public class FourBarCommand extends Command {
	
	boolean lastDir;
	int count = 0;
	
	public FourBarCommand() {
		requires(Robot.fourBarSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if (Robot.oi.fourBarOut()) {
			if (count > 25) {
				Robot.fourBarSubsystem.drive(0.8, !Robot.fourBarSubsystem.getLeft(), !Robot.fourBarSubsystem.getRight());
				count = 0;
			}
			else {
				count++;
			}
		}
		else if (Robot.oi.fourBarIn()) {
			if (count > 25) {
				Robot.fourBarSubsystem.drive(-0.8, !Robot.fourBarSubsystem.getLeft(), !Robot.fourBarSubsystem.getRight());
				count = 0;
			}
			else {
				count++;
			}
		}
		else {
			double pow = MathUtil.cube(Robot.oi.joystickSpecial.getY()*0.8);
		
			Robot.fourBarSubsystem.drive(pow, !Robot.oi.leftControl(), !Robot.oi.rightControl());
			count = 0;
		}
		Robot.fourBarSubsystem.setSecondary(Robot.oi.joystickSpecial.getRawButton(1));
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
