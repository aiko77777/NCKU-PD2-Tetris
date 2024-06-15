# Methods

### `public boolean`

### `hasBlock(int x, int y)`

### Return if (x, y) exist block or not

### `public boolean`

### `isFull(int y)`

### Return if row y is full or not

### `public boolean`

### `isEmpty(int y)`

### Return if row y is empty or not

### `public int`

### `add(Tetromino t)`

### add Tetromino to wall, and return FAIL, LOSE, or how many rows have eliminate

#### Example

```java
int signal = wall.add(currentTetromino);
if (signal == Wall.FAIL) {
    System.out.println("Tetromino doesn't touch the wall, using the same Tetromino");
}
else if (signal == Wall.LOSE) {
    System.out.println("Game Over!");
}
else {
    System.out.println("Add Tetromino to wall successfully and eliminate " + signal + " line!");
    currentTetromino = Tetromino.random();
}
```

### `public void`

### `paint(Graphics g)`

### paint wall with each unique picture

#### Example

```java
wall.paint(g);
```