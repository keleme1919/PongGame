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

        //set variables based on the angle
        if (angleOut > 0 && angleOut <= 45) {
            yPlus = -1;
            xPlus = 1;
            xCircled = true;
            usableAngle = angleOut;
            pixVar = usableAngle / 45;
        }
        if (angleOut > 45 && angleOut <= 90) {
            yPlus = -1;
            xPlus = 1;
            xCircled = false;
            usableAngle = angleOut;
            usableAngle -= 45;
            pixVar = 1 - (usableAngle / 45);
        }
        if (angleOut > 90 && angleOut <= 135) {
            yPlus = 1;
            xPlus = 1;
            xCircled = false;
            usableAngle = angleOut;
            usableAngle -= 90;
            pixVar = usableAngle / 45;
        }
        if (angleOut > 135 && angleOut <= 180) {
            yPlus = 1;
            xPlus = 1;
            xCircled = true;
            usableAngle = angleOut;
            usableAngle -= 135;
            pixVar = 1 - (usableAngle / 45);
        }
        if (angleOut > 180 && angleOut <= 225) {
            yPlus = 1;
            xPlus = -1;
            xCircled = true;
            usableAngle = angleOut;
            usableAngle -= 180;
            pixVar = usableAngle / 45;
        }
        if (angleOut > 225 && angleOut <= 270) {
            yPlus = 1;
            xPlus = -1;
            xCircled = false;
            usableAngle = angleOut;
            usableAngle -= 225;
            pixVar = 1 - (usableAngle / 45);
        }
        if (angleOut > 270 && angleOut <= 315) {
            yPlus = -1;
            xPlus = -1;
            xCircled = false;
            usableAngle = angleOut;
            usableAngle -= 270;
            pixVar = usableAngle / 45;
        }
        if (angleOut > 315 && angleOut <= 360) {
            yPlus = -1;
            xPlus = -1;
            xCircled = true;
            usableAngle = angleOut;
            usableAngle -= 315; //bug bug bug bug bug
            pixVar = 1 - (usableAngle / 45);
        }
        //Utilizing the variables set above, calculate output xMod and yMod
        if (xCircled == true) {
            xMod = pixVar * xPlus;
            yMod = 1 * yPlus;
        }
        if (xCircled == false) {
            xMod = 1 * xPlus;
            yMod = pixVar * yPlus;
    }
    }
    public double getX(){
        return xMod;
    }
    public double getY(){
        return yMod;
    }



}
