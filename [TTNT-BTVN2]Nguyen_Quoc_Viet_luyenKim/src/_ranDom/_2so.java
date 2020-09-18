package _ranDom;

import java.util.ArrayList;
import java.util.Random;

public class _2so {
    //////////////////////////// LƯU Ý ////////////////////////////

    /*
	 * CLASS NÀY CHỈ LÀM CÔNG VIỆC TÌM RA 2 VỊ TRÍ KHÁC NHAU VỚI HIỆU XUẤT LÀ TỐI ĐA.
	 * CÓ THỂ BỎ QUA LỚP NÀY NHƯNG HIỆU XUẤT KHÔNG TỐI ĐA
	 * 
     */
    boolean reset;
    int n, id1, id2, max;
    ArrayList<String> list;
    Random rd;
    String result, _result;

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public _2so(int n) {
        reset = false;
        this.n = n;
        max = toHop(2, n);
        list = new ArrayList<>();
        rd = new Random();
    }

    public void phatSinh() {
        id1 = rd.nextInt(n);
        id2 = rd.nextInt(n);
        while (id1 == id2) {
            id2 = rd.nextInt(n);
        }
        result = id1 + "" + id2;
        _result = id2 + "" + id1;
    }

    public String getIndex() {
        phatSinh();
        if (max > 0) {
            for (int i = 0; i < list.size(); i++) {
                String getI = list.get(i);
                if (getI.equals(result) || getI.equals(_result)) {
                    phatSinh();
                    i = -1;
                }
            }
            list.add(result);
            max--;
        }
        return result;
    }

    public String start() {
        if (reset) {
            max = toHop(2, n);
            list = new ArrayList<>();
            phatSinh();
            return result;
        } else {
            return getIndex();
        }
    }

    private int giaiThua(int n) {
        if (n == 0) {
            return 1;
        }
        return n * giaiThua(n - 1);
    }

    private int toHop(int k, int n) {
        int nGT = giaiThua(n);
        int kGT = giaiThua(k);
        int n_kGT = giaiThua(n - k);
        return nGT / (kGT * n_kGT);
    }
}
