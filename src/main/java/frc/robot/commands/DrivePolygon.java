// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DrivePolygon extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public DrivePolygon(int nsides,Drivetrain drivetrain) {
    for(int i=1;i<=nsides;i++){
    addCommands(
        new DriveDistanceTank(1, 12, drivetrain),
        new TurnDegreesTank(0.8, 360/nsides, drivetrain));
    }
  }
}
