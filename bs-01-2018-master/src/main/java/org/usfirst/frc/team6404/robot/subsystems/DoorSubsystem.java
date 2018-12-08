package org.usfirst.frc.team6404.robot.subsystems;

import org.usfirst.frc.team6404.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DoorSubsystem extends Subsystem {
	VictorSP door = RobotMap.Motores.Door;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands. 
	public enum STATE{
		OPEN, CLOSED;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void openOrClose(double vel) {
    	door.set(vel);
    }
    public STATE getState() {
    	return RobotMap.Sensores.limiteInferior.get()? STATE.OPEN : STATE.CLOSED;   
    }
}

