package utils;

import edu.wpi.first.wpilibj.Spark;

public class ImprovedMotor extends Spark{
	private double scale;
	public ImprovedMotor(int channel, double scale) {
		super(channel);
		this.scale = scale;
	}
	
	public ImprovedMotor(int channel) {
		this(channel, 1);
	}
	public void set(double vel) {
		super.set(vel * scale);
	}
	

}
