package org.blazerobotics.orion.subsystems;

import org.blazerobotics.orion.RobotMap;
import org.blazerobotics.orion.commands.IntakeBarCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeBarSubsystem extends Subsystem {

	private Talon intakeMotor = RobotMap.intakeBarMotor;
	
	public IntakeBarSubsystem() {
		
	}
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new IntakeBarCommand());

	}
	public void setSpeed(double speed) {
		intakeMotor.set(speed);
	}

}
