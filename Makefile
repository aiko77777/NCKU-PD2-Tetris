SHELL := /bin/bash
SOURCE = src/main/java/com/PD2/Tetris/App/**/*.java
MAIN = com.PD2.Tetris.App.Tetris
BIN =  target

build:
	javac -d $(BIN) $(SOURCE)

run:
	java -cp $(BIN) $(MAIN)

clean:
	rm -rf $(BIN)
