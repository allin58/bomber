package com.codenjoy.dojo.bomberman.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private Dice dice;
    private Board board;
    boolean isInvert = false;


    public YourSolver(Dice dice) {
        this.dice = dice;
    }


    @Override
    public String get(Board board) {
        this.board = board;
        if (board.isMyBombermanDead()) return "";

      String directional = isInvert?myDirectionInverted(board):myDirection(board);

       if (isBarrier(board,directional)) {
           if (directional.equals("UP")) directional = "ACT,DOWN";
           if (directional.equals("DOWN")) directional = "ACT,UP";
           if (directional.equals("RIGHT")) directional = "ACT,LEFT";
           if (directional.equals("LEFT")) directional = "ACT,RIGHT";
           if(isInvert) isInvert = false;
           else isInvert = true;

       }
        System.out.println(board.getBomberman()+" _________+++");

    return directional;
}









    public boolean isBarrier(Board board, String directional) {

       Point point = board.getBomberman();
       int x = point.getX();
       int y = point.getY();

        if (directional.equals("UP")) {
            x = point.getX();
            y = point.getY();
            y++;
            for (Point point1 : board.getDestroyableWalls()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getOtherBombermans()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getMeatChoppers()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
                    }

        if (directional.equals("DOWN")) {
            x = point.getX();
            y = point.getY();
            y--;
            for (Point point1 : board.getDestroyableWalls()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getOtherBombermans()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getMeatChoppers()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
        }

        if (directional.equals("LEFT")) {
            x = point.getX();
            y = point.getY();
            x--;
            for (Point point1 : board.getDestroyableWalls()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getOtherBombermans()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getMeatChoppers()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
        }
        if (directional.equals("RIGHT")) {
            x = point.getX();
            y = point.getY();
            x++;
            for (Point point1 : board.getDestroyableWalls()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getOtherBombermans()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
            for (Point point1 : board.getMeatChoppers()) {
                if (point1.getX() == x && point1.getY() == y) return true;
            }
        }


return false;

    }


    public String myDirectionInverted(Board board) {

        Point point = board.getBomberman();



        if (point.getX() == 31 || point.getX() == 1 || point.getY() == 31 || point.getY() == 1) {

            if (point.getX() == 1 &&  point.getY() == 1) return "RIGHT";
            if (point.getX() == 1 &&  point.getY() == 31) return "UP";
            if (point.getX() == 31 &&  point.getY() == 31) return "LEFT";
            if (point.getX() == 31 &&  point.getY() == 1) return "DOWN";

            if (point.getX() == 1) return "DOWN";
            if (point.getX() == 31) return "UP";
            if (point.getY() == 1) return "RIGHT";
            if (point.getY() == 31) return "LEFT";

        }

        if(point.getX()%2 != 0) {
            if( point.getY() >16)
                return "DOWN";
            else return "UP";
        }

        if(point.getY()%2 != 0) {
            if( point.getX() >16)
                return "LEFT";
            else return "RIGHT";
        }

        return "none";
    }




    public String myDirection(Board board) {

       Point point = board.getBomberman();



       if (point.getX() == 31 || point.getX() == 1 || point.getY() == 31 || point.getY() == 1) {

           if (point.getX() == 1 &&  point.getY() == 1) return "UP";
           if (point.getX() == 1 &&  point.getY() == 31) return "RIGHT";
           if (point.getX() == 31 &&  point.getY() == 31) return "DOWN";
           if (point.getX() == 31 &&  point.getY() == 1) return "LEFT";

           if (point.getX() == 1) return "UP";
           if (point.getX() == 31) return "DOWN";
           if (point.getY() == 1) return "LEFT";
           if (point.getY() == 31) return "RIGHT";

       }

       if(point.getX()%2 != 0) {
           if( point.getY() >16)
               return "UP";
           else return "DOWN";
       }

        if(point.getY()%2 != 0) {
            if( point.getX() >16)
                return "RIGHT";
            else return "LEFT";
        }

return "none";
    }



    public static void main(String[] args) {


        WebSocketRunner.runClient(
                // paste here board page url from browser after registration

                "http://codenjoy.com:80/codenjoy-contest/board/player/w09n5e9o6bsnx4jqx0w2?code=4967357740528040382",
                new YourSolver(new RandomDice()),
                new Board());
    }



}
