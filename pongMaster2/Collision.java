package pongpackage;
public class Collision{
    double angleOut;
    double xMod;
    double yMod;
    boolean xCircled;
    double usableAngle;
    //previously booleans
    int yPlus;
    int xPlus;
    //keeps the value by which x or y needs to be modified, while the other value is modified by 1
    double pixVar;
    /** constructor */
    public Collision(){
    }
    /** method to set variable mods based on outgoing angle */
    public void angleToXYmod(double angleOut){
        this.angleOut = angleOut;

        //setting variables based on the angle and
        //Utilizing the variables set above, calculate output xMod and yMod
        if (angleOut > 0 && angleOut <= 90) {
            usableAngle = angleOut;
            yMod = -1 * Math.cos(Math.toRadians(usableAngle));
            xMod = Math.sin(Math.toRadians(usableAngle));
        }
        if (angleOut > 90 && angleOut <= 180) {
            usableAngle = angleOut;
            usableAngle = 180 - usableAngle;
            yMod = Math.cos(Math.toRadians(usableAngle));
            xMod = Math.sin(Math.toRadians(usableAngle));

        }
        if (angleOut > 180 && angleOut <= 270) {
            usableAngle = angleOut;
            usableAngle = usableAngle - 180;
            yMod = Math.cos(Math.toRadians(usableAngle));
            xMod = -1 * Math.sin(Math.toRadians(usableAngle));

        }
        if (angleOut > 270 && angleOut <= 360) {
            usableAngle = angleOut;
            usableAngle = 360 - usableAngle;
            yMod = -1 * Math.cos(Math.toRadians(usableAngle));
            xMod = -1 * Math.sin(Math.toRadians(usableAngle));
        }


    }
    public double getX(){
        return xMod;
    }
    public double getY(){
        return yMod;
    }



}
