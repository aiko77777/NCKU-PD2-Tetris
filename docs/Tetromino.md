# Methods

### `static Tetromino`

### `random()`

### Create a random shape of Tetromino

#### Example

```java
Tetromino currentTetromino = Tetromino.random();
// do something
```

### `public void`

### `moveLeft()`

### `moveDown()`

### `moveRight()`

### `rotate()`

### Move the Tetromino as the function name says

#### Example

```java
currentTetromino.moveLeft();
currentTetromino.moveDown();
currentTetromino.moveRight();
currentTetromino.rotate();
```

### `public BufferedImage`

### `getImage()`

### Return the reference of current shape picture

#### Example

```java
BufferedImage image = currentTetromino.getImage();
g.drawImage(image, 0, 0, null);
```

### `public int[][]`

### `getBlockPositions()`

### Return 2D array of int with every block position in the Tetromino

#### Example

```java
int[][] positions = currentTetromino.getBlockPositions();
for (int[] p : positions) {
    System.out.println("x = " + p[0] + ", y = " + p[1]);
}
/* output
x = 5, y = 0
x = 5, y = 1
x = 4, y = 2
x = 5, y = 2
*/
```

### `public void`

### `paint(Graphics g)`

### Require a Graphics type argument and paint every block in the right position

#### Example

```java
currentTetromino.paint(g);
```

### `public String`

### `toString()`

### Return a String with center block position and Tetromino shape

#### Example

```java
String positionAndShape = currentTetromino.toString()
System.out.print(positionAndShape);
/* output
(5, 1)
   [ ]
   [ ]
[ ][ ]
*/
```
