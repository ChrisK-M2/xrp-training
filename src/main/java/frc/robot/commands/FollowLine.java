// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

public class FollowLine extends Command {
  private final Drivetrain m_drive;
  private final double m_speed;

  /**
   * Creates a new DriveDistanceTank, using tank drive to control the robot. 
   * This command will drive your your robot for a desired distance at a desired speed.
   *
   * @param speed The speed at which the robot will drive
   * @param drive The drivetrain subsystem on which this command will run
   */
  public FollowLine(double speed, Drivetrain drive) {
    m_speed = speed;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.tankDrive(0, 0);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double basespeed=0.5;
    double reflect=m_drive.getLeftReflective()-0.5;                                         //ranges from -0.5 for white to 0.5 for right
    m_drive.tankDrive(m_speed*(basespeed-0.5*reflect), m_speed*(basespeed+0.5*reflect));    //drive with steering proportional to how much we are off
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return false;
  }
}
