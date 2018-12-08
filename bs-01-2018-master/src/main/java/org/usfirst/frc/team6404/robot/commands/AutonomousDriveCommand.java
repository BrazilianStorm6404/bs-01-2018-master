/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6404.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team6404.robot.Robot;
import org.usfirst.frc.team6404.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousDriveCommand extends Command {
  
  Encoder enc = new Encoder(9, 8);
  private double angle;
  private double distance;
  private Timer t;
  
  public AutonomousDriveCommand(double angle, double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.angle = angle;
    this.distance = distance;
    requires(Robot.driver_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.driver_subsystem.setSetpoint(angle);
    //Robot.driver_subsystem.enable();
    //navX.resetDisplacement();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return getDistance() > distance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.driver_subsystem.disable();
    //Robot.driver_subsystem.driveRobot(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.driver_subsystem.disable();
    Robot.driver_subsystem.driveRobot(0, 0);
  }

  public double getDistance(){
    //double currentDistance = Math.sqrt(Math.pow(navX.getDisplacementX(),2) + Math.pow(navX.getDisplacementY(), 2));
    return 0;

  }
}
