package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;
import org.blazerobotics.orion.RobotMap;
import org.blazerobotics.orion.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class LinearLiftCommand extends Command {
	
	private double setPoint = 0;
	
	public LinearLiftCommand(double setPoint) {
		this.setPoint = setPoint;
		requires(Robot.driveSubsystem);
		requires(Robot.linearLiftSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.driveSubsystem.resetEncoders();	
		Robot.driveSubsystem.setPTO(true);		
		Robot.linearLiftSubsystem.setSetpoint(setPoint);
		Robot.linearLiftSubsystem.enable();
	}

	@Override
	protected void execute() {
		
		
		
		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.linearLiftSubsystem.getSetpoint() - Robot.linearLiftSubsystem.getPosition()) < 0.1;
	}

	@Override
	protected void end() {
		Robot.driveSubsystem.setPTO(false);
		Robot.linearLiftSubsystem.disable();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
