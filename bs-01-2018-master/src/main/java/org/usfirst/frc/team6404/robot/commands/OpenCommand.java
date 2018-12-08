package org.usfirst.frc.team6404.robot.commands;


import org.usfirst.frc.team6404.robot.Robot;
import org.usfirst.frc.team6404.robot.subsystems.DoorSubsystem;
 
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenCommand extends Command {

    public OpenCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.door_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!isFinished()) 
    		
    		Robot.door_subsystem.openOrClose(0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.door_subsystem.getState() == DoorSubsystem.STATE.OPEN;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	new StopDoorCommand().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
