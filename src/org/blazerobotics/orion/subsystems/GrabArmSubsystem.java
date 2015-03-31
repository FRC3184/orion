package org.blazerobotics.orion.subsystems;

import org.blazerobotics.orion.RobotMap;
import org.blazerobotics.orion.commands.GrabCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabArmSubsystem extends Subsystem {
	
	public GrabArmSubsystem() {
		
	}

	private DoubleSolenoid piston = RobotMap.fourBarSubsystemSecondaryActuatorSolenoid;
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new GrabCommand());

	}
	public void setGrab(boolean grab) {
		piston.set(grab ? Value.kForward : Value.kReverse);
	}
	public boolean getGrab() {
		return piston.get() == Value.kForward;
	}

}
