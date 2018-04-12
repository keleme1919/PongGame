/** class to handle ball collisions*/
public class BallCollide{
    double x;
    double y;
    double angleIn;
    double angleOut;
    double xMod;
    double yMod;
    boolean xCircled;
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

        //Master if: if collisioin with north/south wall
        if (y < 0 || y > 644){
            //figuring out outut andgle from inut andgle
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
                pixVar = angleOut / 45;
            }
            if (angleOut > 45 && angleOut <= 90) {
                yPlus = -1;
                xPlus = 1;
                xCircled = false;
                angleOut -= 45;
                pixVar = 1 - (angleOut / 45);
            }
            if (angleOut > 90 && angleOut <= 135) {
                yPlus = 1;
                xPlus = 1;
                xCircled = false;
                angleOut -= 90;
                pixVar = angleOut / 45;
            }
            if (angleOut > 135 && angleOut <= 180) {
                yPlus = 1;
                xPlus = 1;
                xCircled = true;
                angleOut -= 135;
                pixVar = 1 - (angleOut / 45);
            }
            if (angleOut > 180 && angleOut <= 225) {
                yPlus = 1;
                xPlus = -1;
                xCircled = true;
                angleOut -= 180;
                pixVar = angleOut / 45;
            }
            if (angleOut > 225 && angleOut <= 270) {
                yPlus = 1;
                xPlus = -1;
                xCircled = false;
                angleOut -= -225;
                pixVar = 1 - (angleOut / 45);
            }
            if (angleOut > 270 && angleOut <= 315) {
                yPlus = -1;
                xPlus = -1;
                xCircled = false;
                angleOut -= 270;
                pixVar = angleOut / 45;
            }
            if (angleOut > 315 && angleOut <= 360) {
                yPlus = -1;
                xPlus = -1;
                xCircled = true;
                angleOut -= -315;
                pixVar = 1 - (angleOut / 45);
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
        x += xMod;
        y += yMod;
    }

    public double getX(){
        return xMod;
    }
    public double getY(){
        return yMod;
    }
    public double getAngle(){
        System.out.println(angleOut);
        return angleOut;
    }
}
