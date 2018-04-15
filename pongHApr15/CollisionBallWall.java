/** class to handle ball to wall collisions*/
public class CollisionBallWall{
    double x;
    double y;
    double angleIn;
    double angleOut;
    double xMod;
    double yMod;
    double movementVar;

    /** constructor */
    public CollisionBallWall(double x, double y, double xMod, double yMod, double angleOut){
        this.x = x;
        this.y = y;
        this.xMod = xMod;
        this.yMod = yMod;
        this.angleOut = angleOut;
    }

    /** if there is a collision, sets outgoing angle and xMod yMod cariables, if no collision,
    *returns zeros and outgoing angle
    */
    public void collision(double angleIn, double newXMod, double newYMod, double movementVar){
        this.movementVar = movementVar;
        this.angleIn = angleIn;
        //System.out.println(angleIn);
        if (y < -1.0) {
            y = -1.0;
        }
        if (y > 645.0) {
            y = 645.0;
        }
        //System.out.println(y);
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
            Collision coli = new Collision();
            coli.angleToXYmod(angleOut);
            xMod = coli.getX();
            yMod = coli.getY();

        } else {
            angleOut = angleIn;
            this.xMod = newXMod;
            this.yMod = newYMod;
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
        //System.out.println("IN: " + angleIn);
        //System.out.println("OUT: " + angleOut);
        return angleOut;
    }
}
