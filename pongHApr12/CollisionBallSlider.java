/** class to handle ball to slider collisions*/
public class CollisionBallSlider{
    boolean isCollision;
    double ballX;
    double ballY;
    double sliderLY;
    double sliderRY;
    int sliderLFrontX = 72;
    int sliderRFrontX = 1208;
    double absPos;
    double relPos;
    double angleOut;

    double xMod;
    double yMod;
    boolean xCircled;
    double usableAngle;
    int yPlus;
    int xPlus;
    double movementVar = 16;
    //keeps the value by which x or y needs to be modified, while the other value is modified by 1
    double pixVar;


    /** constructor */
    public CollisionBallSlider(){
    }

    public void collisionSlid(double ballX, double ballY, double sliderLY, double sliderRY){
        this.ballX = ballX;
        this.ballY = ballY;
        this.sliderLY = sliderLY;
        this.sliderRY = sliderRY;
        //checks if left slider is blocking path of ball
        absPos = ballY + 9;
        //left slider collision
        if (sliderLY <= absPos && absPos <= (sliderLY + 120)){
            if (ballX <= sliderLFrontX){
                if (ballX > sliderLFrontX - 17){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderLY;
                    //calculate angle
                    angleOut = (relPos * 1.40625) + 5.625;
                    //System.out.println(angleOut);
                }
            }



        }
        //if ball hits top or bottom of slider


        //right slider collision

        if (sliderRY <= absPos && absPos <= (sliderRY + 120)){
            if ((ballX + 18) >= sliderRFrontX){
                if ((ballX + 18) < sliderRFrontX + 17){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderRY;
                    //calculate angle
                    angleOut = (relPos * -1.40833333) + 354.375;
                    //System.out.println(angleOut);
                }
            }
        }
        //if ball hits top or bottom of slider

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
    public boolean collisionCheck(){
        if (isCollision == true){
            isCollision = false;
            return true;
        }
        else {
            return false;
        }
    }
    /** @return the value by which ball x should be modified*/
    public double getX(){
        return xMod;
    }
    /** @return the value by which ball y should be modified*/
    public double getY(){
        return yMod;
    }
    /**#@return the outgoing angle */
    public double getAngle(){
        //System.out.println(angleOut);
        return angleOut;
    }


}
