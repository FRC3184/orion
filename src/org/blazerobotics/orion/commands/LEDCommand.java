package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDCommand extends Command {

    private int tick;

	public LEDCommand() {
        requires(Robot.ledSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	tick = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation ds = DriverStation.getInstance();
    	
    	if (ds.getMatchTime() < 20 && tick % 10 == 0) {
    		Robot.ledSubsystem.Off();
    	}    	
    	else if (ds.isBrownedOut()) {
    		Robot.ledSubsystem.Yellow();
    	}
    	else {
    		if (ds.isAutonomous()) {
    			Robot.ledSubsystem.Green();
    		}
    		else {
    			switch (ds.getAlliance()) {
    			case Blue:
    				Robot.ledSubsystem.Blue(); break;
    			case Red:
    				Robot.ledSubsystem.Red(); break;
    			default:
    			case Invalid:
    				Robot.ledSubsystem.White(); break;
    			}
    		}
    	}
    	tick ++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
