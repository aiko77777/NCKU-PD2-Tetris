package com.PD2.Tetris.block;
import java.awt.Image.*;
import java.awt.image.BufferedImage;

public class Cell {
    public  int  row;
    public  int column;
    public BufferedImage cell_image;

    public  Cell(int row,int column,BufferedImage cell_image){
        this.row=row;
        this.column=column;
        this.cell_image=cell_image;
    }
    public void move_right(){
        this.column=this.column+1;
    }
    public  void move_left(){
        this.column=this.column-1;
    }
    public  void move_down(){
        this.row=this.row+1;
    }

}
