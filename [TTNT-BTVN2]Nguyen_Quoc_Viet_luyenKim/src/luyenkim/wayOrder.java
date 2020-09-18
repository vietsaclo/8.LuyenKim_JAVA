package luyenkim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import _modul._2D;
import _modul._Node;
import _modul.io;
import _ranDom._2so;

public class wayOrder {

    private ArrayList<_Node> way;
    private _2so so;
    public _2D swapIndex;

    public ArrayList<_Node> getWay() {
        return way;
    }

    public void setWay(ArrayList<_Node> way) {
        this.way = way;
    }

    public _2so getSo() {
        return so;
    }

    public void setSo(_2so so) {
        this.so = so;
    }

    public wayOrder() {
        way = new ArrayList<>();
        so = new _2so(10);
        swapIndex = new _2D();
    }

    public static double getEXP(double so) {
        return Math.exp(so);
    }

    public void scanWay() {
        int n = io.ScanInt("Nhập số đỉnh");
        for (int i = 0; i < n; i++) {
            System.out.println("--------Nhập đỉnh thứ: " + (i + 1) + "--------");
            _Node temp = new _Node();
            temp.scanNode();
            way.add(temp);
        }
        so = new _2so(way.size());
    }

    public void loadWay() {
        File file = new File("src/_modul/data.txt");
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bfr = new BufferedReader(isr);
                String line;
                String[] M;
                _Node temp;
                line = bfr.readLine();
                while (line != null) {
                    M = line.split(" ");
                    temp = new _Node(M[0], new _2D(Integer.parseInt(M[1]), Integer.parseInt(M[2])));
                    way.add(temp);
                    line = bfr.readLine();
                }
                bfr.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
            so = new _2so(way.size());
        } else {
            System.out.println("File không tồn tại!");
        }
    }

    private boolean twoIndex_bangNhau(_2D id1, _2D id2) {
        if ((id1.getX() == id2.getX() && id1.getY() == id2.getY())
                || (id1.getX() == id2.getY() && id1.getY() == id2.getX())) {
            return true;
        }
        return false;
    }

    public _2D getTwoIndex() {
        _2D idCurrent = swapIndex;
        swapIndex = new _2D();
        do {
            String temp = so.start();
            swapIndex.setX(temp.charAt(0) - '0');
            swapIndex.setY(temp.charAt(1) - '0');
        } while (twoIndex_bangNhau(idCurrent, swapIndex));
        return swapIndex;
    }

    private int getDistanceTwoPoint(int x, int y) {
        int result = 0;
        result
                = Math.abs(way.get(x).getToaDo().getX() - way.get(y).getToaDo().getX())
                + Math.abs(way.get(x).getToaDo().getY() - way.get(y).getToaDo().getY());
        return result;
    }

    public int getTotalDistance() {
        int total = 0;
        for (int i = 0; i < way.size() - 1; i++) {
            total += getDistanceTwoPoint(i, i + 1);
        }
        return total;
    }

    public void getTotalWay() {
        System.out.print("[ ");
        for (int i = 0; i < way.size(); i++) {
            System.out.print(way.get(i).getName() + "." + i + " -> ");
        }
        System.out.print(" ]= " + getTotalDistance() + "\n");
    }

    private void swapTwoIndexOfWay(wayOrder way, int x, int y) {
        _Node temp = way.getWay().get(x);
        way.getWay().set(x, way.getWay().get(y));
        way.getWay().set(y, temp);
    }

    public wayOrder getNetWayOrder() {
        wayOrder result = new wayOrder();
        result.getWay().addAll(0, this.way);
        getTwoIndex();
        //System.out.println("\nSẽ hoán vị ở vị trí: "+swapIndex.show());
        swapTwoIndexOfWay(result, swapIndex.getX(), swapIndex.getY());
        return result;
    }
}
