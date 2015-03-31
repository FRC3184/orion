package org.blazerobotics.orion.commands;

import org.blazerobotics.orion.Robot;
import org.blazerobotics.orion.util.MathUtil;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class DriveToPointCommand extends Command {
	private double setPoint = 0;
	private PIDController gyropid;
	private double turn;
	private PIDController drivepid;
	private double throttle;
	private boolean k = false;
	private double max;
	
	public DriveToPointCommand(double setPoint, double max, double d) {
		this.setPoint = setPoint;
		this.max = max;
		requires(Robot.driveSubsystem);
		if (d != 0) {
			setTimeout(d);
		}
	}

	@Override
	protected void initialize() {
		Robot.driveSubsystem.resetEncoders();
		Robot.genericSensorSubsystem.resetGyro();
		
		gyropid = new PIDController(0.1, 0, 0, new PIDSource() {

			@Override
			public double pidGet() {
				return Robot.genericSensorSubsystem.gyro.getAngle();
			}
			
		}, new PIDOutput() {

			@Override
			public void pidWrite(double output) {
				turn = output;
				System.out.println(turn + ", " + Robot.genericSensorSubsystem.getAngle());
			}
			
		});
		
		double pu = 10;
		double kp = 0.08*0.2; //0.08*0.3 oscillates
		double ki = (1.5*kp)/pu;
		double kd = (kp*pu)/-2; //negative should decrease oscillation
		drivepid = new PIDController(kp, ki, kd, new PIDSource() {

			@Override
			public double pidGet() {
				
				return MathUtil.average(Robot.driveSubsystem.leftEncoder.getDistance(), -Robot.driveSubsystem.rightEncoder.getDistance());
			}}, new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				throttle = -output;
				
			}});
		drivepid.setContinuous(true);
		gyropid.setContinuous(true);
		drivepid.setSetpoint(setPoint);
		gyropid.setSetpoint(0);
		gyropid.enable();
		drivepid.enable();
		k = false;
	}

	@Override
	protected void execute() {
		Robot.driveSubsystem.arcadeDrive(throttle*max, turn);
		k = true;
		
		
	}

	@Override
	protected boolean isFinished() {
		return (Math.abs(drivepid.getError()) < 5000 && k) || isTimedOut();
	}

	@Override
	protected void end() {
		gyropid.disable();
		drivepid.disable();
	}

	@Override
	protected void interrupted() {
		end();
		
	}

}
