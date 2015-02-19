// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.blazerobotics.orion.subsystems;

import org.blazerobotics.orion.Robot;
import org.blazerobotics.orion.RobotMap;
import org.blazerobotics.orion.commands.*;
import org.blazerobotics.orion.util.MathUtil;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LinearLiftSubsystem extends PIDSubsystem {
    public LinearLiftSubsystem(double p, double i, double d) {
		super(p, i, d);
		getPIDController().setContinuous(true);
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput bottomLimitSwitch = RobotMap.linearLiftSubsystemBottomLimitSwitch;
    DigitalInput topLimitSwitch = RobotMap.linearLiftSubsystemTopLimitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public boolean hit() {
		// TODO Auto-generated method stub
		return bottomLimitSwitch.get() || topLimitSwitch.get();
	}

	@Override
	protected double returnPIDInput() {
		return MathUtil.average(Robot.driveSubsystem.rightEncoder.getDistance(), Robot.driveSubsystem.leftEncoder.getDistance());
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveSubsystem.tankDrive(output*-1, output*-1);
		System.out.println("Out "+ output);
	}
}

