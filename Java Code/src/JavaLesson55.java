/* Java OOP Design Principles
 
Features of SpaceShip

1. Move the ship around the screen
2. Rotate the ship clockwise when D is pressed
3. Rotate the ship counter clockwise when A is pressed
4. I want the ship to rotate in any direction 360 degrees
5. Increase velocity slowly when W is pressed
6. If the ship goes off the board have it appear on the opposite side of the board
7. If the ship hits something it explodes
8. I want to be able to rotate the ship while it continues on its current path
9. Use encapsulation so the application is more flexible

Use Case Diagram

The Player

1. Starts the game
2. Moves the ship
	a. Rotates the ship
	b. Increases velocity on ship
3. If ship crashes start over

Risks / Problem Code

1. 360 degree rotation means we have to use doubles
2. Polygons are built using int arrays
3. Floating point calculations lose precision
4. How do we slowly increase velocity
5. How can they rotate the ship while maintaining the current course
6. How do we move the ship when it goes off the board

We've already solved collision problems, so put that on the back burner

AffineTransform allows us to:

1. Use doubles for rotation
2. Let the polygon be an int[] but have the center be a double
3. When the ship goes off the board just change the center point
 
Solves: 1, 2, 3, 6

Create velocity methods that increase and decrease velocity
Solves: 4

Have a rotation angle for current movement angle and one for ship rotation
Solves: 5

Scenario

1. Draw polygon in the center of the screen with points surrounding the center points.

a. GameBoard width and height
b. Center points for polygon x & y
c. Polygon x & y int array
d. Might need upper left hand x & y?

2. Player increase the ship velocity

a. x & y velocity 

3. Player rotates the ship after acceleration

a. Rotation angle
b. Movement angle
c. Calculate movement angle on the fly

4. Player hits a rock and blows up

a. GetBounds method

SpaceShip : UML Class Diagram

gBWidth : int
gBHeight : int
centerX : double
centerY : double
polyXArray : int[]
polyYArray : int[]
shipWidth : int
shipHeight : int
uLeftXPos : double
uLeftYPos : double
xVelocity : double
yVelocity : double
rotationAngle : double
movingAngle : double

SpaceShip( int[], int[], int)

getXCenter() : double
getYCenter() : double
setXCenter(double) : void
setYCenter(double) : void
increaseXPos(double) : void
increaseYPos(double) : void
getuLeftXPos() : double
getuLeftYPos() : double
setuLeftXPos(double) : void
setuLeftYPos(double) : void
getShipWidth() : int
getShipHeight() : int
getXVelocity() : double
getYVelocity() : double
setXVelocity(double) : void
setYVelocity(double) : void
increaseXVelocity(double) : void
increaseYVelocity(double) : void
decreaseXVelocity(double) : void
decreaseYVelocity(double) : void
setMovingAngle(double) : void
getMovingAngle() : double
increaseMovingAngle(double) : void
shipXMoveAngle(double) : double
shipYMoveAngle(double) : double
getRotationAngle() : double
increaseRotationAngle() : void
decreaseRotationAngle() : void
getBounds() : Rectangle
move() : void

*/