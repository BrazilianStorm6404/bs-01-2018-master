/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6404.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team6404.robot.RobotMap;
import org.usfirst.frc.team6404.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import utils.Tracao;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriverSubsystem extends PIDSubsystem implements Tracao {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	AHRS navX = RobotMap.Sensores.navX;
	public DriverSubsystem(){
		super("DriverSubsystem", 2.0, 1.0, 1.0);// The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false); //manipulating the raw internal PID Controller

	}
	private DifferentialDrive drive = new DifferentialDrive(frontais, traseiros);
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveCommand());
	}
	
	public void driveRobot(double x, double y) {
		drive.arcadeDrive(y, x);
	}

	@Override
	protected double returnPIDInput() {
		return navX.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		output = output > 0.1? output : 0.5;
		frontalDireito.set(-output);
		frontalEsquerda.set(-output);
		traseiroDireito.set(output);
		traseiroEsquerdo.set(output);
	}
}
