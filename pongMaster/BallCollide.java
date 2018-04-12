/** class to handle ball collisions*/
public class BallCollide{
    double x;
    double y;
    double angleIn;
    double angleOut;
    double xMod;
    double yMod;
    boolean xCircled;
    double usableAngle;
    double movementVar = 5;

    //previously booleans
    int yPlus;
    int xPlus;
    //keeps the value by which x or y needs to be modified, while the other value is modified by 1
    double pixVar;

    /** constructor */
    public BallCollide(double x, double y){
        this.x = x;
        this.y = y;
        xMod = 0.125;
        yMod = -1;
        angleOut = 5.625;
    }

    /** if there is a collision, sets outgoing angle and xMod yMod cariables, if no collision,
    *returns zeros and outgoing angle
    */
    public void collision(double angleIn){
        this.angleIn = angleIn;
        if (y < -1.0) {
            y = -1.0;
        }
        if (y > 645.0) {
            y = 645.0;
        }
        //Master if: if collisioin with north/south wall
        if (y < 0 || y > 644){
            //figuring out outut andgle from input andgle
            //System.out.println("Yes, it do go in here!");
            if (angleIn < 270 && angleIn > 90){
                angleOut = (270 - angleIn) + 270;
                if (angleOut > 360) {
                    angleOut -= 360;
                }
                if (angleOut < 0) {
                    angleOut += 360;
                }
            } else {
                angleOut = (90 - angleIn) + 90;
                if (angleOut < 0) {
                    angleOut += 360;
                }
                if (angleOut > 360) {
                    angleOut -= 360;
                }
            }
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

        } else {

        }
        //x and y values get stored in variables
        x += (xMod * movementVar);
        y += (yMod * movementVar);
    }

    public double getX(){
        return xMod;
    }
    public double getY(){
        return yMod;
    }
    public double getAngle(){
        System.out.println(angleOut);
        System.out.println(x);
        System.out.println(y);
        return angleOut;
    }
}
