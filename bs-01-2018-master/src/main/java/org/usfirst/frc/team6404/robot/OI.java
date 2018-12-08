/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6404.robot;

import org.usfirst.frc.team6404.robot.commands.CloseDoorCommand;
import org.usfirst.frc.team6404.robot.commands.OpenCommand;
import org.usfirst.frc.team6404.robot.commands.StopDoorCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick stick = new Joystick(0);
	static JoystickButton A = new JoystickButton(stick, 1);
	static JoystickButton B = new JoystickButton(stick, 2);
	
	public OI() {
		A.whenActive(new CloseDoorCommand());
		B.whileActive(new OpenCommand());
		A.whenReleased(new StopDoorCommand());
		B.whenReleased(new StopDoorCommand());
	}

}
		
