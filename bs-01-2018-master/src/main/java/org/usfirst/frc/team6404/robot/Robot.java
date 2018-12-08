/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6404.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team6404.robot.commands.AutonomousDriveCommand;
import org.usfirst.frc.team6404.robot.subsystems.DoorSubsystem;
import org.usfirst.frc.team6404.robot.subsystems.DriverSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriverSubsystem driver_subsystem = new DriverSubsystem();
	public static final DoorSubsystem door_subsystem = new DoorSubsystem();
	public static OI m_oi;
	AHRS navX = RobotMap.Sensores.navX;
	AutonomousDriveCommand testComm;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		LiveWindow.add(driver_subsystem.getPIDController());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
				/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putBoolean("Limite superior: ", RobotMap.Sensores.limiteSuperior.get());
		SmartDashboard.putBoolean("Limite inferior: ", RobotMap.Sensores.limiteInferior.get());
		SmartDashboard.putString("Valor porta", door_subsystem.getState().name());
		SmartDashboard.putNumber("X", navX.getDisplacementX());
		SmartDashboard.putNumber("Y", navX.getDisplacementY());
		Scheduler.getInstance().run();  
	}
	@Override
	public void testInit() {
		SmartDashboard.putString("PASSOU", "SIM");
		testComm = new AutonomousDriveCommand(0, 2);
		Scheduler.getInstance().add(testComm);
		LiveWindow.setEnabled(true);
		LiveWindow.add(driver_subsystem);
		LiveWindow.add(driver_subsystem.getPIDController());

	}
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		LiveWindow.run();
		LiveWindow.updateValues();
		SmartDashboard.putData(driver_subsystem);
	}
}