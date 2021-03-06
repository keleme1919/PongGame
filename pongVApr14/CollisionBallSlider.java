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
    double movementVar;

    /** constructor */
    public CollisionBallSlider(){
    }

    public void collisionSlid(double ballX, double ballY, double sliderLY, double sliderRY, double movementVar){
        this.movementVar = movementVar;
        this.ballX = ballX;
        this.ballY = ballY;
        this.sliderLY = sliderLY;
        this.sliderRY = sliderRY;
        //checks if left slider is blocking path of ball
        absPos = ballY + 9;
        //left slider collision
        if (sliderLY <= absPos && absPos <= (sliderLY + 120)){
            if (ballX <= sliderLFrontX){
                if (ballX > sliderLFrontX - 25){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderLY;
                    //calculate angle
                    angleOut = (relPos * 1.3125) + 11.25;
                    //System.out.println(angleOut);
                }
            }



        }
        //if ball hits top or bottom of slider


        //right slider collision

        if (sliderRY <= absPos && absPos <= (sliderRY + 120)){
            if ((ballX + 18) >= sliderRFrontX){
                if ((ballX + 18) < sliderRFrontX + 25){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderRY;
                    //calculate angle
                    angleOut = (relPos * -1.3125) + 348.75;
                    //System.out.println(angleOut);
                }
            }
        }
        //if ball hits top or bottom of slider

        //set variables based on the angle
        Collision coli = new Collision();
        coli.angleToXYmod(angleOut);
        xMod = coli.getX();
        yMod = coli.getY();

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
