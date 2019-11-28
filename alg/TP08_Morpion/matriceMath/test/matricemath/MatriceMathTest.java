package matricemath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aclaveau
 */
public class MatriceMathTest {
    @Test
    public void addTest() {
        int[][] mat1 = {{2, 0, -1, 1}, {8, 1, -3, -2}, {0, 0, 0, 1}};
        int[][] mat2 = {{1, 5, 1, 3}, {0, 2, 0, -1}, {3, 1, 1, 0}};
        int[][] mat3 = {{3, 5, 0, 4}, {8, 3, -3, -3}, {3, 1, 1, 1}};
        assertArrayEquals(mat3,MatriceMath.add(mat1,mat2));
    }
    
    @Test
    public void subTest() {
        int[][] mat1 = {{2, 0, -1, 1}, {8, 1, -3, -2}, {0, 0, 0, 1}};
        int[][] mat2 = {{1, 5, 1, 3}, {0, 2, 0, -1}, {3, 1, 1, 0}};
        int[][] mat3 = {{1, -5, -2, -2}, {8, -1, -3, -1}, {-3, -1, -1, 1}};
        assertArrayEquals(mat3,MatriceMath.sub(mat1,mat2));
    }
}
