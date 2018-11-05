/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed3;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Everton
 */
public class SortGraph extends JPanel {

    static int[] myArray = {};
    static int[] myArraySorted = {};
    static long time;
    
    @Override
    public void paintComponent(Graphics g) {
        int x = 0;
        int y = 100;
        if (this.myArray.length > 0) {
            for (int i : this.myArray) {
                g.fillRect(x, 0, 10, i);
                x += 12;
            }
        }
        
        int x1 = 0;
        int y1 = 100;
        if (this.myArraySorted.length > 0) {
            for (int i : this.myArraySorted) {
                g.fillRect(x1, 120, 10, i);
                x1 += 12;
            }
        }
    }

}
